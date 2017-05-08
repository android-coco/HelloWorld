package org.yh.servlet.entity;

public class CartItem
{
	private RecordInfo recordInfo;
	/** 数量 */
	private int count;
	/** 销售时售价 */
	private float price;

	public CartItem()
	{
	}

	public CartItem(RecordInfo recordInfo, int count, float price)
	{
		this.recordInfo = recordInfo;
		this.count = count;
		this.price = price;
	}

	public RecordInfo getRecordInfo()
	{
		return recordInfo;
	}

	public void setRecordInfo(RecordInfo recordInfo)
	{
		this.recordInfo = recordInfo;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
}
