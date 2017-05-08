package org.yh.servlet.util;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcUtil
{
	private static Properties pro = new Properties();
	static
	{
		InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("env.properties");// src
		try
		{
			pro.load(in);
		} catch (IOException e)
		{
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);// 静态代码块中抛出的异常
		} finally
		{
			if (in != null)
				try
				{
					in.close();
				} catch (Exception e)
				{
				}
		}
	}
	// 配置数据写到jdbc.properties文件中
	private static ThreadLocal<Connection> td = new ThreadLocal<Connection>();// 多个线程所共享（不安全）

	/**
	 * 获取连接对象,连接为线程单例
	 * 
	 * @return
	 */
	public static Connection getConnection()
	{
		Connection conn = td.get();// 从当前线程取Connection
		try
		{
			if (conn == null)
			{
				// 1.加载驱动程序(什么是加载？加载到哪里？)
				Class.forName(pro.getProperty("driver"));// 这里的驱动程序其实就是一个类，这个类由mysql厂商提供。
				// 2.通过驱动程序建立连接(DriverManager用于管理驱动程序)
				conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"),
						pro.getProperty("password"));// null
				td.set(conn);// 将Connection绑定到当前线程
				System.out.println("数据库已经连接" + conn);
			}
			return conn;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param rs结果集
	 * @param stmt执行SQL语句对象
	 * @param conn
	 *            连接
	 */
	public static void close(ResultSet rs, Statement stmt, Connection conn)
	{
		if (stmt != null)
		{
			try
			{
				rs.close();
			} catch (Exception e)
			{
			}
		}
		if (stmt != null)
		{
			try
			{
				stmt.close();
			} catch (Exception e)
			{
			}
		}
		if (conn != null)
		{
			try
			{
				conn.close();
				td.remove();
			} catch (Exception e)
			{
			}
		}
	}

	/**
	 * 给PreparedStatement赋值
	 * 
	 * @param pstmt
	 * @param values
	 * @throws SQLException
	 */
	private static void setPstmtValues(PreparedStatement pstmt, Object... values) throws SQLException
	{
		if (pstmt != null & values != null)
		{
			for (int i = 0; i < values.length; i++)
			{
				pstmt.setObject(i + 1, values[i]);
			}
		}
	}

	/**
	 * 执行SQL语句(insert,update,delete)
	 * 
	 * @param callBack
	 *            回调函数中rs可获取[由于执行此 Statement 对象]而创建的所有自动生成的键
	 * @param sql
	 *            sql语句
	 * @param values
	 *            对就占位符的值
	 * @return 返回影响的行数
	 */
	public static int execute(JdbcUtil.CallBack callBack, String sql, Object... values)
	{
		int retVal = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			setPstmtValues(pstmt, values);
			retVal = pstmt.executeUpdate();
			if (callBack != null)
			{
				rs = pstmt.getGeneratedKeys();
				callBack.callback(rs);// 回调
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		} finally
		{
			JdbcUtil.close(rs, pstmt, conn);
		}
		return retVal;
	}

	/**
	 * 执行SQL语句(insert,update,delete)
	 * 
	 * @param sql
	 *            sql语句
	 * @param values
	 *            对就占位符的值
	 * @return 返回影响的行数
	 */
	public static int execute(String sql, Object... values)
	{
		return execute(null, sql, values);
	}

	/**
	 * 回调一次 未经过任何处理的ResultSet
	 * 
	 * @param callBack
	 * @param sql
	 * @param values
	 * @see JdbcUtils.query()
	 */
	public static void query(JdbcUtil.CallBack callBack, String sql, Object... values)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			setPstmtValues(pstmt, values);
			rs = pstmt.executeQuery();
			callBack.callback(rs);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally
		{
			JdbcUtil.close(rs, pstmt, conn);
		}
	}

	/**
	 * JdbcUtil回调接口 2017-05-08 23:00:08
	 * 
	 * @author YouHao</a>
	 *
	 */
	public static interface CallBack
	{
		/**
		 * 回调方法
		 * 
		 * @throws SQLException
		 */
		public void callback(ResultSet rs) throws SQLException;
	}

	/**
	 * 查询出相同名字的Field并返回
	 * 
	 * @param <T>
	 * @param clazz
	 *            实体类
	 * @param dateColumns
	 *            数据库中对应的列
	 * @return
	 */
	public static <T> List<Field> getEntityField(final Class<T> clazz, List<String> dateColumns)
	{
		/** 与实体对应的列 */
		List<Field> fields = new ArrayList<Field>();
		for (Field f : clazz.getDeclaredFields())
		{// 遍历field
			f.setAccessible(true);
			int mod = f.getModifiers();
			if ((mod & Modifier.FINAL) == 0)
			{// 没有final
				if ((mod & Modifier.STATIC) == 0)
				{// 没有static
					for (String c : dateColumns)
					{
						if (c.equalsIgnoreCase(f.getName()))
						{
							fields.add(f);
						}
					}
				}
			}
		}
		return fields;
	}

	/**
	 * 查询实体列表
	 * 
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param values
	 * @return
	 */
	public static <T> List<T> queryList(final Class<T> clazz, String sql, Object... values)
	{
		final List<T> list = new ArrayList<T>();
		JdbcUtil.query(new JdbcUtil.CallBack()
		{
			public void callback(ResultSet rs) throws SQLException
			{
				// 取得列名
				ResultSetMetaData data = rs.getMetaData();
				/** 数据库中的列 */
				List<String> dateColumns = new ArrayList<String>();
				for (int i = 0; i < data.getColumnCount(); i++)
				{
					dateColumns.add(data.getColumnName(i + 1));
				}
				List<Field> fields = JdbcUtil.getEntityField(clazz, dateColumns);
				// 循环并注入
				while (rs.next())
				{
					try
					{
						T t = (T) clazz.newInstance();
						JdbcUtil.injectByRs(rs, fields, t);// 往t中注入值
						list.add(t);
					} catch (Exception e)
					{
						throw new RuntimeException(e.getMessage());
					}
				}
			}

		}, sql, values);
		return list;
	}

	/**
	 * 查询实体
	 * 
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param values
	 * @return
	 */
	public static <T> T queryEntity(final Class<T> clazz, String sql, Object... values)
	{
		List<T> list = queryList(clazz, sql, values);
		if (list.size() == 0)
		{
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据rs在对象t中注入fields的值
	 * 
	 * @param <T>
	 * @param rs
	 * @param fields
	 * @param t
	 * @throws SQLException
	 * @throws IllegalAccessException
	 */
	private static <T> void injectByRs(ResultSet rs, List<Field> fields, T t)
			throws SQLException, IllegalAccessException
	{
		for (Field f : fields)
		{
			Object value = null;
			if (f.getType().toString().equals("byte") || f.getType() == Byte.class)
			{
				value = rs.getByte(f.getName());
			} else if (f.getType().toString().equals("boolean") || f.getType() == Boolean.class)
			{
				value = rs.getBoolean(f.getName());
			} else if (f.getType().toString().equals("double") || f.getType() == Double.class)
			{
				value = rs.getDouble(f.getName());
			} else if (f.getType().toString().equals("float") || f.getType() == Float.class)
			{
				value = rs.getFloat(f.getName());
			} else if (f.getType().toString().equals("int") || f.getType() == Integer.class)
			{
				value = rs.getInt(f.getName());
			} else if (f.getType().toString().equals("long") || f.getType() == Long.class)
			{
				value = rs.getInt(f.getName());
			} else if (f.getType().toString().equals("short") || f.getType() == Short.class)
			{
				value = rs.getInt(f.getName());
			} // 除 char 8种基本数据类型判断完毕
			else if (f.getType() == Timestamp.class)
			{
				value = rs.getTimestamp(f.getName());
			} else if (f.getType() == Date.class)
			{
				value = rs.getDate(f.getName());
			} else if (f.getType() == Time.class)
			{
				value = rs.getTime(f.getName());
			} else
			{
				value = rs.getObject(f.getName());
			}
			f.set(t, value);
		}
	}

	public static void main(String[] args)
	{
		Connection conn = JdbcUtil.getConnection();
		System.out.println("conn=" + conn);
	}

	/****
	 * 
	 * 两个线程共享一个连接（conn.commit） Thread A a1,a2,commit/rollback Thread B
	 * b1,b2,b3,b4,commit/rollback
	 * 
	 * a1,b1,a2,b2,A.commit,b3,b4,B.rollback 如何解决这个线程安全问题？
	 * 假如每个线程一个连接，还会出现此问题吗？不会 如何保证每个线程一个连接？ThreadLocal
	 * ThreadLocal提供了某种机制，能够将某个对象绑定到当前线程下。 我们要绑定谁？Connection 如何绑定？ set方法
	 */
}
