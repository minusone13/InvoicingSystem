package businesslogic.commoditybl;

import java.util.ArrayList;

import po.*;
import po.stockpo.CommodityPO;
import businesslogic.stockmanagerbl.*;
import dataservice.commoditydataservice.*;
import vo.stockvo.*;
import vo.RM;

public class StubCommodityList {//商品列表 haha
	static StubCommodityDataService comdata;
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return null;
	}
	public boolean addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount)
	{
		return true;
	}
	public RM addCommodity(CommodityVO vo)
	{
		CommodityPO po=comdata.findCommodity(vo.getName(),vo.getModel());
		if(po!=null)
			return RM.redundance;
		else
		{
			MockCommodity com=new MockCommodity(vo);
			RM result = comdata.insert(com.toPO());
			return result;
		}
	}
	public RM addCategory(CategoryVO vo)
	{
		return comdata.insert(new StubCategory(vo).toPO());
	}
	public void setcomdata(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
	}
	public boolean checkIn(String name, String model, int quantity, double price)
	{//入库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return false;
		MockCommodity com=new MockCommodity(po);
		return true;
	}
	public boolean checkOut(String name, String model, int quantity, double price)
	{//出库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return false;
		MockCommodity com=new MockCommodity(po);
		return true;
	}
}
