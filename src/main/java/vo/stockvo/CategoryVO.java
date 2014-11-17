package vo.stockvo;

public class CategoryVO {
	String parent;
	String name;
	public CategoryVO(String parent, String name)
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
}
