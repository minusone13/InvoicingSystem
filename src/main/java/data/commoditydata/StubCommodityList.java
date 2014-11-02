package data.commoditydata;

import java.io.*;
import java.util.*;
import po.*;

public class StubCommodityList implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<StubPackData> packs;
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
		return true;
	}
}
