package vo.stockvo;

public class CategoryVO
{
	String id;// id恒等于parent+"\\"+name
	String parent;// 父分类的ID
	String name;

	public CategoryVO(String parent, String name)
	{
		this.parent = parent;
		this.name = name;
		id = parent + "\\" + name;
	}

	public String getParent()
	{
		return parent;
	}

	public void setParent(String parent)
	{
		this.parent = parent;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
