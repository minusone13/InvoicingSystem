package data.commoditydata;

import java.io.Serializable;
import java.util.*;

import po.*;
import po.stockpo.CategoryPO;
import po.stockpo.StockPO;
import po.stockpo.CommodityPO.*;

public class StubCategoryData implements Serializable{
	ArrayList<StubCategoryData> cats=new ArrayList<StubCategoryData>();
	ArrayList<MockCommodityData> coms=new ArrayList<MockCommodityData>();
	CategoryPO po;
	public StubCategoryData(String parent,String name)
	{
		po=new CategoryPO(parent,name);
	}
	public StubCategoryData(){}
	public StubCategoryData(CategoryPO po)
	{
		this.po=po;
	}
	public boolean canAddCategory()
	{//根据作业要求，分类和商品不能为树的兄弟关系
		if(!coms.isEmpty())
			return false;
		else 
			return true;
	}
	public boolean canAddCommodity()
	{//根据作业要求，分类和商品不能为树的兄弟关系
		if(!cats.isEmpty())
			return false;
		else 
			return true;
	}
	public boolean canBeDeleted()
	{//当已有子分类或商品时不能被删除
		return (cats.size()==0 && coms.size()==0);
	}
	public ArrayList<StockPO> open()
	{//打开一个分类，打开前不知道内容，所以返回了通用的StockPO
		ArrayList <StockPO> result=new ArrayList<StockPO>();
		if(!coms.isEmpty())
		{
			for(int i=0;i<coms.size();i++)
			{
				MockCommodityData com=coms.get(i);
				result.add(new StockPO(com.getPo().clone()));
			}
		}
		else if(!cats.isEmpty())
		{
			for(int i=0;i<cats.size();i++)
			{
				StubCategoryData cat=cats.get(i);
				result.add(new StockPO(cat.getPo().clone()));
			}
		}
		return result;//return a stockPO
	}
	public StubCategoryData findSubCat(String name)
	{//通过分类名查找子分类
		if(cats==null || cats.size()==0)
			return null;//does not have any sub category
		for(int i=0;i<cats.size();i++)
		{
			if(cats.get(i).getName().equals(name))
				return cats.get(i);
		}
		return null;//not found
	}
	public StubCategoryData goThrow(String[] nameOfParent, int layer)
	{//to gothrow all the parent directly to the last category
		//this method is used when deleting or adding a commodity. and many other inner uses
		if(nameOfParent.length<=layer)
			return this;//递归返回条件
		StubCategoryData cat = findSubCat(nameOfParent[layer]);
		if(cat==null)
			return null;//not found;
//		else if(++layer>=nameOfParent.length)
//			return cat;//递归的返回条件
		layer++;
		return cat.goThrow(nameOfParent, layer);
	}
	public MockCommodityData findCommodity(String name,String model)
	{//通过名称和型号（唯一确定一个商品）查找下一层的商品，没找到返回NULL
		if(coms==null || coms.size()==0)
			return null;//does not have any sub category
		for(int i=0;i<coms.size();i++)
		{
			if(coms.get(i).getName()==name && coms.get(i).getModel()==model)
				return coms.get(i);
		}
		return null;//not found
	}
	public RM add(MockCommodityData com)
	{//返回值参见RM中的说明
		if(canAddCommodity())
		{
			coms.add(com);
			return RM.done;
		}
		else
			return RM.treeerror;//已有分类，不能添加商品
	}
	public RM add(StubCategoryData cat)
	{//返回值参见RM中的说明
		if(canAddCategory())
		{
			cats.add(cat);
			return RM.done;
		}
		else
			return RM.treeerror;//已有商品，不能添加分类
	}
	public RM delete(String name,String model)
	{//delete Commodity in the Category
		if(canAddCommodity())
		{
			int i=search(name,model);
			if(coms.get(i).canBeDeleted())
			{
				coms.remove(i);
				return RM.done;
			}
			else
				return RM.alreadyHaveUnremoveableContents;
		}
		else 
			return RM.treeerror;
	}
	public RM delete(String name)
	{//delete Category in the Category
		if(canAddCategory())
		{
			int i=search(name);
			if(i==-1)
				return RM.notfound;
			if(cats.get(i).canBeDeleted())
			{
				cats.remove(i);
				return RM.done;
			}
			else
				return RM.alreadyHaveUnremoveableContents;
		}
		else 
			return RM.treeerror;
	}
	private int search(String name,String model)
	{//Search a Commodity, return the index. if not found return -1
		for(int i=0;i<coms.size();i++)
		{
			if(coms.get(i).equals(name, model))
				return i;
		}
		return -1;
	}
	private int search(String name)
	{//Search a Category, return the index. if not found return -1
		for(int i=0;i<cats.size();i++)
		{
			if(cats.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	public ArrayList<StubCategoryData> getCats() {
		return cats;
	}
	public void update(String name)
	{//更新姓名，同时会更新ID的子树当中的ID
		String oldname=getName();
		setName(name);
		for(int i=0;i<cats.size();i++)
		{//更新子分类
			StubCategoryData cat=cats.get(i);
			cat.updateParent(po.getId());
		}
		for(int i=0;i<coms.size();i++)
		{//更新子商品
			MockCommodityData com=coms.get(i);
			com.setParent(po.getId());
		}
	}
	private void updateParent(String parent)
	{//服务于update(String name)的辅助算法
		setParent(parent);
		for(int i=0;i<cats.size();i++)
		{
			StubCategoryData cat=cats.get(i);
			cat.updateParent(po.getId());
		}
	}
	public void setCats(ArrayList<StubCategoryData> cats) {
		this.cats = cats;
	}
	public ArrayList<MockCommodityData> getComs() {
		return coms;
	}
	public void setComs(ArrayList<MockCommodityData> coms) {
		this.coms = coms;
	}
	public String getParent() {
		return po.getParent();
	}
	public void setParent(String parent) {
		po.setParent(parent);
		po.setId(po.getParent()+"\\"+po.getName());//ID随所属路径发生变化
	}
	public String getName() {
		return po.getName();
	}
	public void setName(String name) {
		po.setName(name);
		po.setId(po.getParent()+"\\"+po.getName());//ID随所属路径发生变化
	}
	public CategoryPO getPo() {
		return po;
	}
	public void setPo(CategoryPO po) {
		this.po = po;
	}
}
