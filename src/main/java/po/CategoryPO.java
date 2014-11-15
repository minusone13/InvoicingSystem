package po;

import java.io.Serializable;

public class CategoryPO implements Serializable, Cloneable{
	String parent;
	String name;
	public CategoryPO(String parent, String name)
	{
		this.parent=parent;
		this.name=name;
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
}
