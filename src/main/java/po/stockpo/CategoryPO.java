package po.stockpo;

import java.io.Serializable;

public class CategoryPO implements Serializable, Cloneable{
	String id;//id恒等于parent+"\\"+name
	String parent;//父分类的ID
	String name;
	public CategoryPO(String parent, String name)
	{
		this.parent=parent;
		this.name=name;
		id=parent+"\\"+name;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CategoryPO clone()
	{
		CategoryPO cloned = null;
		try {
			cloned=(CategoryPO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
