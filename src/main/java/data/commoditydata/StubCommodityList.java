package data.commoditydata;

import java.io.*;
import java.util.*;

import po.*;
import po.stockpo.*;
import vo.RM;

public class StubCommodityList implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<StubPackData> packs;
	StubCategoryData cat;//=cats.get(0);
	ArrayList <MockCommodityData> flatlist;//平铺式的商品列表，便于搜索操作。注意商品增删时候的同步操作
	public boolean initial()
	{
		cats=new ArrayList<StubCategoryData>();
		cats.add(new StubCategoryData("0","1"));
		packs=new ArrayList<StubPackData>();
		cat=cats.get(0);
		cat.add(new StubCategoryData("1","default category"));
		flatlist=new ArrayList<MockCommodityData>();
		return true;
	}
	public RM insert(CommodityPO po)
	{
		String s=po.getParent();
		String a[]=s.split("\\\\");
		if(!a[0].equals("1"))//default root is 1
			return RM.unknownerror;
		StubCategoryData temp=cat.goThrow(a, 1);
		if(temp==null)
			return RM.unknownerror;
		MockCommodityData com=new MockCommodityData(po);
		RM result=temp.add(com);
		flatlist.add(com);
		return result;
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{
		return new ArrayList<CommodityPO>();
	}
	public CommodityPO findCommodity(String name, String model)
	{
		for(int i=0;i<flatlist.size();i++)
		{
			MockCommodityData com=flatlist.get(i);
			if(com.getName().equals(name) && com.getModel().equals(model))
				return com.getPo();
		}
		return null;//not found;
	}

	public boolean deleteCommodity(String name, String model)
	{
		return true;
	}
	public boolean updateCommodity(CommodityPO po)
	{
		return true;
	}
	public RM insert(CategoryPO po)
	{
		String a[]=po.getParent().split("\\\\");
		if(!a[0].equals("1"))//default root is 1
			return RM.unknownerror;
		StubCategoryData temp=cat.goThrow(a, 1);
		if(temp==null)
			return RM.unknownerror;
		if(temp.findSubCat(po.getName())!=null)
			return RM.redundance;
		RM result = temp.add(new StubCategoryData(po));
		return result;
	}
}
