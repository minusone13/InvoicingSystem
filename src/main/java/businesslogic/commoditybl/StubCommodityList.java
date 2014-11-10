package businesslogic.commoditybl;

import java.util.ArrayList;

import po.*;
import businesslogic.stockmanagerbl.*;
import dataservice.commoditydataservice.*;
import vo.MockCommodityVO;
import vo.RM;

public class StubCommodityList {
	static StubCommodityDataService comdata;
	public ArrayList<MockCommodityVO> findCommodity(String name)
	{
		return null;
	}
	public boolean addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount)
	{
		return true;
	}
	public RM addCommodity(MockCommodityVO vo)
	{
		CommodityPO po=comdata.findCommodity(vo.getname(),vo.getmodel());
		if(po!=null)
			return RM.redundance;
		else
		{
			MockCommodity com=new MockCommodity(vo);
			comdata.addCommodity(com.toPO());
			return RM.done;
		}
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
