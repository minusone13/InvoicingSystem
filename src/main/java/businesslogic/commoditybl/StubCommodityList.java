package businesslogic.commoditybl;

import java.util.ArrayList;

import po.*;
import businesslogic.stockmanagerbl.*;
import dataservice.commoditydataservice.*;
import vo.CommodityVO;
import vo.RM;

public class StubCommodityList {
	static StubCommodityDataService comdata;
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return null;
	}
	public boolean addPack(ArrayList<StubCommodity> commodityarray,int quantity, double discount)
	{
		return true;
	}
	public RM addCommodity(CommodityVO vo)
	{
		CommodityPO po=comdata.findCommodity(vo.getname(),vo.getmodel());
		if(po!=null)
			return RM.redundance;
		else
		{
			StubCommodity com=new StubCommodity(vo);
			comdata.addCommodity(com.toPO());
			return RM.done;
		}
	}
	public void setcomdata(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
	}
	public boolean checkIn(String name, String model, int quantity, double price)
	{
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return false;
		StubCommodity com=new StubCommodity(po);
		return true;
	}
	public boolean checkOut(String name, String model, int quantity, double price)
	{
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return false;
		StubCommodity com=new StubCommodity(po);
		return true;
	}
}
