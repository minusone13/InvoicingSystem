package businesslogic.commoditybl;

import po.stockpo.*;
import vo.stockvo.*;

public class StubCategory {
	String id;
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
		id=parent+"\\"+name;
	}
	public StubCategory(CategoryPO po)
	{
		parent=po.getParent();
		name=po.getName();
		id=parent+"\\"+name;
	}
	public CategoryPO toPO()
	{
		CategoryPO po= new CategoryPO(parent,name);
		return po;
	}
	public CategoryVO toVO()
	{
		CategoryVO vo=new CategoryVO(parent,name);
		return vo;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
}
