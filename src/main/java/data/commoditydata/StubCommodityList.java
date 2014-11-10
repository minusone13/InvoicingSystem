package data.commoditydata;

import java.io.*;
import java.util.*;
import po.*;

public class StubCommodityList implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<StubPackData> packs;
	StubCategoryData cat;
	public boolean initial()
	{
		cats=new ArrayList<StubCategoryData>();
		cats.add(new StubCategoryData("0","1"));
		packs=new ArrayList<StubPackData>();
		cat=cats.get(0);
		return true;
	}
	public boolean addCommodity(CommodityPO po)
	{
		if(po.getType()!=CommodityPO.Type.Commodity)
			return false;
		String s=po.getParent();
		String a[]=s.split("\\");
		if(!a[0].equals("1"))//default root is 1
			return false;
		StubCategoryData temp=cat.goThrow(a, 1);
		return temp.add(new MockCommodityData(po));
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{
		return new ArrayList<CommodityPO>();
	}
	public CommodityPO findCommodity(String name, String model)
	{
		return new CommodityPO();
	}
	public boolean deleteCommodity(String name, String model)
	{
		return true;
	}
	public boolean updateCommodity(CommodityPO po)
	{
		return true;
	}
	public boolean addCategory(String parent, String name)
	{
		String a[]=parent.split("\\");
		if(!a[0].equals("1"))//default root is 1
			return false;
		StubCategoryData temp=cat.goThrow(a, 1);
		temp.add(new StubCategoryData(parent,name));
		return true;
	}
}
