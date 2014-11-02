package data.commoditydata;

import java.io.*;
import java.util.*;
import po.*;

public class StubCommodityList implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<StubPackData> packs;
	public boolean initial()
	{
		cats=new ArrayList<StubCategoryData>();
		cats.add(new StubCategoryData("0","1"));
		packs=new ArrayList<StubPackData>();
		return true;
	}
	public boolean addCommodity(CommodityPO po)
	{
		String s=po.getParent();
		String a[]=s.split("\\");
		return true;
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
		
		return true;
	}
}
