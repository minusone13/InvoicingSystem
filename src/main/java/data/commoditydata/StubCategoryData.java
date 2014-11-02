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
}
