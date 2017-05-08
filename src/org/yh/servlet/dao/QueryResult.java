package org.yh.servlet.dao;

import java.util.List;

public class QueryResult<T>
{

	/** 记录集 */
	private List<T> resultlist;
	/** 总记录数 */
	private long recordtotal;

	public List<T> getResultlist()
	{
		return resultlist;
	}

	public void setResultlist(List<T> resultlist)
	{
		this.resultlist = resultlist;
	}

	public long getRecordtotal()
	{
		return recordtotal;
	}

	public void setRecordtotal(long recordtotal)
	{
		this.recordtotal = recordtotal;
	}
}
