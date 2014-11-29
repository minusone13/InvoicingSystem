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
	{//初始化方法，程序第一次运行或测试与调试阶段使用
		cats=new ArrayList<StubCategoryData>();
		cats.add(new StubCategoryData("0","1"));
		packs=new ArrayList<StubPackData>();
		cat=cats.get(0);
		cat.add(new StubCategoryData("1","default category"));
		flatlist=new ArrayList<MockCommodityData>();
		return true;
	}
	public RM insert(CommodityPO po)
	{//插入商品
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
	public StubCategoryData getFather(StubCategoryData c)
	{
		String s=c.getParent();
		String a[]=s.split("\\\\");
		if(!a[0].equals("1"))//default root is 1
			return null;
		StubCategoryData temp=cat.goThrow(a, 1);
		if(temp==null)
			return null;
		return temp;
	}
	public StubCategoryData getFather(MockCommodityData c)
	{
		String s=c.getParent();
		String a[]=s.split("\\\\");
		if(!a[0].equals("1"))//default root is 1
			return null;
		StubCategoryData temp=cat.goThrow(a, 1);
		if(temp==null)
			return null;
		return temp;
	}
	public StubCategoryData getFather(String id)
	{
		String a[]=id.split("\\\\");
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<a.length-2;i++)
			sb.append(a[i]+"\\");
		sb.append(a[a.length-1]);
		String s=sb.toString();
		String temp[]=s.split("\\\\");
		StubCategoryData result=cat.goThrow(temp, 1);
		return result;
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{//通过商品名称，查找一系列有相同名称的商品（型号不同）
		ArrayList<CommodityPO> result=new ArrayList<CommodityPO>();
		for(int i=0;i<flatlist.size();i++)
		{
			MockCommodityData com=flatlist.get(i);
			if(com.getName().equals(name))
				result.add(com.getPo());
		}
		return result;
	}
	public MockCommodityData findCommodity(String name, String model)
	{
		int i=searchCommodity(name,model);
		if(i==-1)
			return null;//not found;
		else
			return flatlist.get(i);
	}
	private int searchCommodity(String name,String model)
	{//Search in flatlist
		for(int i=0;i<flatlist.size();i++)
		{
			MockCommodityData com=flatlist.get(i);
			if(com.getName().equals(name) && com.getModel().equals(model))
				return i;
		}
		return -1;
	}
	public StubCategoryData findCategory(String id)
	{
		String a[]=id.split("\\\\");
		StubCategoryData result=cat.goThrow(a, 1);
		return result;
	}
	public RM deleteCommodity(String name, String model)
	{
		int i=searchCommodity(name,model);
		if(i==-1)
			return RM.notfound;
		MockCommodityData com = flatlist.get(i);
		String s=com.getParent();
		String a[]=s.split("\\\\");
		if(!a[0].equals("1"))//default root is 1
			return RM.unknownerror;
		StubCategoryData temp=cat.goThrow(a, 1);
		if(temp==null)
			return RM.unknownerror;
		RM result=temp.delete(name, model);
		if(result==RM.done)
			flatlist.remove(i);//i have 2 list here to manage commodity
		return result;
	}
	public RM deleteCategory(String id)
	{
		StubCategoryData cattemp=getFather(id);
		String a[]=id.split("\\\\");
		String name=a[a.length-1];
		RM result=cattemp.delete(name);
		return result;
	}
	public boolean update(CommodityPO po)
	{
		MockCommodityData com = findCommodity(po.getName(),po.getModel());
		if(com==null)
			return false;
		else
		{
			com.setPo(po);
			return true;
		}
	}
	public boolean update(CategoryPO po)
	{
		StubCategoryData cat = findCategory(po.getId());
		if(cat==null)
			return false;
		else
		{
			cat.update(po.getName());
			return true;
		}
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
