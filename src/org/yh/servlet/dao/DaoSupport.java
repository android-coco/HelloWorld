package org.yh.servlet.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yh.servlet.util.JdbcUtil;

/**
 * 实体主键名称必须为id.如果是int,则为自动增长.如果是String,则为UUID
 * 2017-05-08 23:00:08
 * @author <a href="mailto:gaollg@sina.com">Gaollg</a>
 *
 * @param <T>
 */
public class DaoSupport<T> implements Dao<T>{
	
	private static Log log = LogFactory.getLog(DaoSupport.class);
	protected Class<T> entityClass = null;
	protected List<Field> entityField = null;
	protected String tableName = "";
	protected Field idField;
	
	/**
	 * 空构造函数
	 * 设置 tableName,entityClass,entityField三个字段的值
	 */
	public DaoSupport() {
		this.entityClass = getEntityClass();
		this.tableName = this.getTableName();
		final List<String> dateColumns = new ArrayList<String>();
		JdbcUtil.query(new JdbcUtil.CallBack() {
			public void callback(ResultSet rs) throws SQLException {
				ResultSetMetaData data = rs.getMetaData();
				for(int i=0;i<data.getColumnCount();i++){
					dateColumns.add(data.getColumnName(i+1));
				}
			}
		},"select * from " + this.tableName + " where 1=2");//只查出列名
		this.entityField = JdbcUtil.getEntityField(this.entityClass, dateColumns);
		if(this.entityField.size()==0){
			log.error("空字段,无法与对应数据库映射!!!!");
			throw new RuntimeException("空字段,无法与对应数据库映射!!!!");
		}
		this.setIdField("id");
	}

	/**
	 * 如果主键对应字段名不为id,请调用此方法
	 * 很想使用和jpa一样的注解
	 * 但又觉的会臃肿
	 * @param idName
	 */
	public void setIdField(String idName){
		for(Field f : entityField){
			if(f.getName().equals(idName)){
				this.idField = f;
				break;
			}
		}
		if(!"id".equals(idName)){
			if(this.idField==null){
				String msg = "未能在实体中找到:"+idName+".主键字段为null";
				log.info(msg);
				throw new RuntimeException(msg);
			}
		}
	}
	
	/**
	 * 取得父类的 泛型类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class<T> getEntityClass(){
		Class<T> clazz = null;
		Type parentType = this.getClass().getGenericSuperclass();
		if(parentType instanceof ParameterizedType){
			ParameterizedType ptype = (ParameterizedType)parentType;
			Type[] types = ptype.getActualTypeArguments();
			clazz = (Class<T>) types[0];
		}
		return clazz;
	}
	
	/**
	 * 取得实体对象的表名
	 * @return
	 */
	public String getTableName(){
		return "" + this.entityClass.getSimpleName();
	}
	
	public void save(T entity,boolean isSavaNull) {
		/** 组并SQL语句 */
		StringBuffer sb = new StringBuffer();
		/** 组并?的SQL语句部分*/
		StringBuffer param = new StringBuffer();
		/** 对应的value值 */
		List<Object> list = new ArrayList<Object>();
		
		sb.append("insert into ").append(this.tableName).append("(");
		for(Field f : this.entityField){
			f.setAccessible(true);
			try {
				Object obj = f.get(entity);
				if(isSavaNull || obj!=null){
					list.add(obj);
					sb.append(f.getName()).append(",");
					param.append("?,");
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		sb.deleteCharAt(sb.length()-1);
		param.deleteCharAt(param.length()-1);
		sb.append(") values (").append(param).append(")");
		System.out.println(sb.toString());
		log.debug(sb.toString() + "|" + list.toString());
		JdbcUtil.execute(sb.toString(), list.toArray());
	}

	
	public void update(T entity, boolean isSavaNull) {
		// 组并SQL语句
		StringBuffer sb = new StringBuffer();
		// 对应的value值
		List<Object> list = new ArrayList<Object>();
		Object idVal = null;//id的值
		try {
			idVal = this.idField.get(entity);
			if(idVal==null){
				throw new RuntimeException("主键值不能为null");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		sb.append("update ").append(this.tableName).append(" set ");
		for(Field f : entityField){
			try {
				Object obj = f.get(entity);
				if(f!=this.idField){//不能更新主键
					if(isSavaNull || obj!=null){
						sb.append(f.getName()).append("=?,");
						list.add(obj);
					}
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(" where ").append(this.idField.getName()).append("=").append("?");
		list.add(idVal);
		
		log.debug(sb.toString() + "|" + list.toString());
		JdbcUtil.execute(sb.toString(), list.toArray());
	}
	
	
	public void delete(Serializable... entityIds) {
		if(entityIds.length==0){
			return ;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("delete ").append(this.tableName).append(" where ").append(this.idField.getName()).append(" in(");
		for (int i = 0; i < entityIds.length; i++) {
			sb.append("?,");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(")");
		log.debug(sb.toString() + "|" + Arrays.toString(entityIds));
		JdbcUtil.execute(sb.toString(),(Object[])entityIds);
	}

	
	public T find(Serializable entityId) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ").append(this.tableName).append(" where ").append(this.idField.getName()).append("=?");
		log.debug(sb.toString() + "|" + entityId);
		return JdbcUtil.queryEntity(this.entityClass, sb.toString(), entityId);
	}

	
	public long getCount() {
		return getCount(null);
	}

	
	public long getCount(String where, Object... params) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from ").append(this.tableName).append(" ");
		if(where!=null && !where.equals("")) {
			sb.append(" where ").append(where).append(" ");
		}
		final List<Integer> list = new ArrayList<Integer>();
		log.debug(sb.toString() + "|" + Arrays.toString(params));
		JdbcUtil.query(new JdbcUtil.CallBack() {
			
			public void callback(ResultSet rs) throws SQLException {
				if(rs.next()){
					list.add(rs.getInt(1));
				}
			}
		}, sb.toString(), params);
		return list.get(0);
	}

	
	public QueryResult<T> getScrollData() {
		return getScrollData(-1,-1,(LinkedHashMap<String, Boolean>)null,(String)null);
	}

	
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, Boolean> orderBy,
			String where, Object... params) {
		//------查询的sql语句 开始------
		StringBuffer coreSql = new StringBuffer();
		coreSql.append("select * from ").append(this.tableName).append(" ");
		if(where!=null && !where.equals("")) {
			coreSql.append(" where ").append(where).append(" ");
		}
		coreSql.append(buildOrderBy(orderBy));
		//------分页----
		if(firstResult!=-1 && maxResult!=-1){
			coreSql.append(" limit ").append(firstResult).append(",").append(maxResult);
		}
		log.debug(coreSql.toString() + "|" + Arrays.toString(params));
		QueryResult<T> queryResult = new QueryResult<T>();
		queryResult.setResultlist(JdbcUtil.queryList(this.entityClass, coreSql.toString(), params));
		queryResult.setRecordtotal(this.getCount(where, params));
		return queryResult;
	}

	/**
	 * asc 升序 desc 降序
	 * @param orderBy LinkedHashMap<String, Boolean> Key为属性,Value为true时,表示升序(asc),反之为降序(desc)
	 * @return
	 */
	private static String buildOrderBy(LinkedHashMap<String, Boolean> orderBy){
		StringBuilder sb = new StringBuilder();
		if(orderBy!=null && !orderBy.isEmpty()){
			sb.append(" order by ");
			for(Map.Entry<String, Boolean> entry : orderBy.entrySet()){
				sb.append(entry.getKey());
				if(entry.getValue()){
					//升序  可以省略
					sb.append(" asc");
				}else{
					//降序
					sb.append(" desc");
				}
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

	
	public QueryResult<T> getScrollData(LinkedHashMap<String, Boolean> orderBy) {
		return getScrollData(-1,-1,orderBy,(String)null);
	}

	
	public QueryResult<T> getScrollData(int firstResult, int maxResult) {
		return getScrollData(firstResult,maxResult,(LinkedHashMap<String, Boolean>)null,(String)null);
	}

	
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			LinkedHashMap<String, Boolean> orderBy) {
		return getScrollData(firstResult,maxResult,orderBy,(String)null);
	}

	
	public QueryResult<T> getScrollData(int firstResult, int maxResult,
			String where, Object... params) {
		return getScrollData(firstResult,maxResult,(LinkedHashMap<String, Boolean>)null,where,params);
	}

	
	public QueryResult<T> getScrollData(LinkedHashMap<String, Boolean> orderBy, String where, Object... params) {
		return getScrollData(-1,-1,orderBy,where,params);
	}

	public PageView<T> getPageData(int maxresult, int currentpage,
			LinkedHashMap<String, Boolean> orderBy,
			String where, Object... params){
		PageView<T> pageView = new PageView<T>(maxresult, currentpage);
		pageView.setQueryResult(this.getScrollData(pageView.getFirstResult(), pageView.getMaxresult(), orderBy, where, params));
		return pageView;
	}
	
	public PageView<T> getPageData(int maxresult, int currentpage,
			LinkedHashMap<String, Boolean> orderBy){
		return getPageData(maxresult, currentpage, orderBy,null);
	}
	
	public PageView<T> getPageData(int maxresult, int currentpage,
			String where, Object... params){
		return getPageData(maxresult, currentpage, (LinkedHashMap<String, Boolean>)null, where, params);
	}
}
