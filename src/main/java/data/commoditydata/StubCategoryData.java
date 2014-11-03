package data.commoditydata;

import java.io.Serializable;
import java.util.*;

import po.*;
import po.CommodityPO.*;

public class StubCategoryData implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<StubCommodityData> coms;
	String parent;
	String name;
	public StubCategoryData(String parent,String name)
	{
		this.parent=parent;
		this.name=name;
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
	public ArrayList<CommodityPO> open()
	{
		ArrayList <CommodityPO> result=new ArrayList<CommodityPO>();
		if(!coms.isEmpty())
		{
			for(int i=0;i<coms.size();i++)
			{
				StubCommodityData com=coms.get(i);
				result.add(new CommodityPO(Type.Commodity,com.parent,com.name,com.model,com.number,com.in,com.out,com.lastin,com.lastout,com.average));
			}
		}
		else if(!cats.isEmpty())
		{
			for(int i=0;i<cats.size();i++)
			{
				StubCategoryData cat=cats.get(i);
				result.add(new CommodityPO(Type.Category,cat.parent,cat.name));
			}
		}
		return result;
	}
	public StubCategoryData findSubCat(String name)
	{
		if(cats==null || cats.size()==0)
			return null;//does not have any sub category
		for(int i=0;i<cats.size();i++)
		{
			if(cats.get(i).name==name)
				return cats.get(i);
		}
		return null;//not found
	}
	public StubCategoryData goThrow(String[] nameOfParent, int layer)
	{//to gothrow all the parent directly to the last category
		//this method is used when deleting or adding a commodity. and many other inner uses
		StubCategoryData cat = findSubCat(nameOfParent[layer]);
		if(cat==null)
			return null;//not found;
		else if(++layer>=nameOfParent.length)
			return cat;//递归的返回条件
		return cat.goThrow(nameOfParent, layer);
	}
	public StubCommodityData findCommodity(String name,String model)
	{
		if(coms==null || coms.size()==0)
			return null;//does not have any sub category
		for(int i=0;i<coms.size();i++)
		{
			if(coms.get(i).name==name && coms.get(i).model==model)
				return coms.get(i);
		}
		return null;//not found
	}
	public ArrayList<StubCategoryData> getCats() {
		return cats;
	}
	public void setCats(ArrayList<StubCategoryData> cats) {
		this.cats = cats;
	}
	public ArrayList<StubCommodityData> getComs() {
		return coms;
	}
	public void setComs(ArrayList<StubCommodityData> coms) {
		this.coms = coms;
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
