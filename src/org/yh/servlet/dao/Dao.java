package org.yh.servlet.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;

public interface Dao<T>
{

	/**
	 * 保存 实体 如果主键类型为String,自动以UUID填充至对象 如果主键类型为整数自动增长,设置其插入数据库后的对应值
	 * 
	 * @param entity
	 *            要保存的实体
	 * @param isSavaNull
	 *            true表示保存 [参数entity] 中的null值,false不保存null值(如自动时间).
	 */
	public void save(T entity, boolean isSavaNull);

	/**
	 * 修改实体
	 * 
	 * @param entity
	 *            要保存的实体
	 * @param isSavaNull
	 *            true表示保存 [参数entity] 中的null值,false不保存null值(如自动时间).
	 */
	public void update(T entity, boolean isSavaNull);

	/**
	 * 删除
	 * 
	 * @param entityids
	 */
	public void delete(Serializable... entityids);

	/**
	 * 查找
	 * 
	 * @param entityId
	 * @return
	 */
	public T find(Serializable entityId);

	/**
	 * 取得所有记录数
	 * 
	 * @return
	 */
	public long getCount();

	/**
	 * 
	 * @param where
	 *            条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @return
	 */
	public long getCount(String where, Object... params);

	/**
	 * 分页获取记录
	 * 
	 * @return
	 */
	public QueryResult<T> getScrollData();

	/**
	 * 分页获取记录
	 * 
	 * @param orderBy
	 *            排序 LinkedHashMap<String,
	 *            Boolean>:Key为排序属性,Value控制升降序,为true时,表示升序(asc),反之为降序(desc)
	 * @return
	 */
	public QueryResult<T> getScrollData(LinkedHashMap<String, Boolean> orderBy);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param orderBy
	 *            排序 LinkedHashMap<String,
	 *            Boolean>:Key为排序属性,Value控制升降序,为true时,表示升序(asc),反之为降序(desc)
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, Boolean> orderBy);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param where
	 *            条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object... params);

	/**
	 * 分页获取记录
	 * 
	 * @param firstResult
	 *            开始索引,如果输入值为-1,即获取全部数据
	 * @param maxResult
	 *            每页获取的记录数,如果输入值为-1,即获取全部数据
	 * @param orderBy
	 *            排序 LinkedHashMap<String,
	 *            Boolean>:Key为排序属性,Value控制升降序,为true时,表示升序(asc),反之为降序(desc)
	 * @param where
	 *            条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @return
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, LinkedHashMap<String, Boolean> orderBy,
			String where, Object... params);

	/**
	 * 获取所有符合条件的记录
	 * 
	 * @param where
	 *            条件语句,不带where关键字,条件语句只能使用位置参数,位置参数的索引值以1开始,如:o.username=?1 and
	 *            o.password=?2
	 * @param params
	 *            条件语句出现的位置参数值
	 * @param orderBy
	 *            排序 LinkedHashMap<String,
	 *            Boolean>:Key为排序属性,Value控制升降序,为true时,表示升序(asc),反之为降序(desc)
	 * @return
	 */
	public QueryResult<T> getScrollData(LinkedHashMap<String, Boolean> orderBy, String where, Object... params);

}
