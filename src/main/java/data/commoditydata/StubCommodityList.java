package data.commoditydata;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import data.Tool;
import po.*;
import po.stockpo.*;
import vo.RM;

public class StubCommodityList implements Serializable{
	ArrayList<StubCategoryData> cats;
	ArrayList<PackPO> packs;
	ArrayList<AdjustmentRecordPO> adjusts;
	StubCategoryData cat;//=cats.get(0);
	ArrayList <MockCommodityData> flatlist;//平铺式的商品列表，便于搜索操作。注意商品增删时候的同步操作
	Date countDate = new Date();
	int countNo=0;
	public boolean initial()
	{//初始化方法，程序第一次运行或测试与调试阶段使用
		cats=new ArrayList<StubCategoryData>();
		cats.add(new StubCategoryData("0","1"));
		packs=new ArrayList<PackPO>();
		cat=cats.get(0);
		cat.add(new StubCategoryData("1","default category"));
		flatlist=new ArrayList<MockCommodityData>();
		adjusts=new ArrayList<AdjustmentRecordPO>();
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
	public boolean insert(AdjustmentRecordPO po)
	{
		adjusts.add(po);
		return true;
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
	public RM insert(PackPO po)
	{
		packs.add(po);
		return RM.done;
	}
	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords()
	{
		ArrayList<AdjustmentRecordPO> result = new ArrayList<AdjustmentRecordPO>();
		for(int i=0;i<adjusts.size();i++)
			result.add(adjusts.get(i));
		return result;
	}
	public boolean accountBuild()
	{
		for(int i=0;i<flatlist.size();i++)
		{
			flatlist.get(i).setLastin(-1);
			flatlist.get(i).setLastout(-1);
		}
		return true;
	}
	public ArrayList<CommodityPO> fuzzyFindCommodity(String s, int precision)
	{//precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		ArrayList<CommodityPO> result = new ArrayList<CommodityPO>();//CommodityPO is changeable
		ArrayList<Boolean> h = new ArrayList<Boolean>();
		if(precision>s.length())
			precision = s.length();
		for(int i=0;i<flatlist.size();i++)//flatlist is changeable
			h.add(true);
		for(int i=0;i<flatlist.size();i++)
			for(int j=0;j<=s.length()-precision;j++)
				if(!flatlist.get(i).contents(s.substring(j, j+precision)))//the elements in the list must implement function: boolean contents(s)
					h.set(i, false);
		for(int i=0;i<h.size();i++)
			if(h.get(i)==true)
				result.add(flatlist.get(i).po.clone());//here can also be change
		return result;
	}
	public ArrayList<CommodityPO> getAllCommodity()
	{
		//计算盘点序号
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		String lastCountTime = format.format(countDate);
		if(lastCountTime.equals(currentTime))
			countNo++;
		else
		{
			countDate = new Date();
			countNo=1;
		}
		ArrayList<CommodityPO> result = new ArrayList<CommodityPO>();
		for(int i=0;i<flatlist.size();i++)
			result.add(flatlist.get(i).getPo().clone());
		return result;
	}
	public int getCountNo() {
		return countNo;
	}
}
