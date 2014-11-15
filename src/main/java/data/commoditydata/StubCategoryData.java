package data.commoditydata;

import java.io.Serializable;
import java.util.*;

import po.*;
import po.CommodityPO.*;
import vo.RM;

public class StubCategoryData implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<MockCommodityData> coms;
	CategoryPO po;
	public StubCategoryData(String parent,String name)
	{
		po=new CategoryPO(parent,name);
	}
	public boolean canAddCategory()
	{
		if(!coms.isEmpty())
			return false;
		else 
			return true;
	}
	public boolean canAddCommodity()
	{
		if(!cats.isEmpty())
			return false;
		else 
			return true;
	}
	public ArrayList<StockPO> open()
	{
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
		else 
			return null;
		return result;
	}
	public StubCategoryData findSubCat(String name)
	{
		if(cats==null || cats.size()==0)
			return null;//does not have any sub category
		for(int i=0;i<cats.size();i++)
		{
			if(cats.get(i).getName()==name)
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
	{
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
	{
		if(canAddCommodity())
		{
			coms.add(com);
			return RM.done;
		}
		else
			return RM.treeerror;//已有分类，不能添加商品
	}
	public boolean add(StubCategoryData cat)
	{
		if(canAddCategory())
		{
			cats.add(cat);
			return true;
		}
		else
			return false;//已有商品，不能添加分类
	}
	public ArrayList<StubCategoryData> getCats() {
		return cats;
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
		po.setParent(parent);;
	}
	public String getName() {
		return po.getName();
	}
	public void setName(String name) {
		po.setName(name);;
	}
	public CategoryPO getPo() {
		return po;
	}
	public void setPo(CategoryPO po) {
		this.po = po;
	}
}
