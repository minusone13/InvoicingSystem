package businesslogic.commoditybl;

import po.stockpo.*;
import vo.stockvo.*;

public class StubCategory {
	String parent;//the ID of parent Category
	String name;
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
	public StubCategory(){}
	public StubCategory(CategoryVO vo)
	{
		parent=vo.getParent();
		name=vo.getName();
	}
	public CategoryPO toPO()
	{
		CategoryPO po= new CategoryPO(parent,name);
		return po;
	}
}
