package org.yh.servlet.entity;

/**
 * 2012-2-9 上午10:24:27
 * 
 * @author <a href="mailto:gaollg@sina.com">Gaollg</a>
 */
public class RecordInfo
{
	private Integer id;
	/** 名字 */
	private String name;
	/** 作者 */
	private String author;
	/** 简介 */
	private String intro;
	/** 售价 */
	private float price;
	/** 图片 */
	private String image;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getImagePath()
	{
		return "images/" + this.image;
	}

}
