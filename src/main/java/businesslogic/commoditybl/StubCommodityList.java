package businesslogic.commoditybl;

import java.util.ArrayList;

import businesslogic.stockmanagerbl.StubStockController;
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
		StubCommodity com=new StubCommodity();
		comdata.addCommodity(com.toPO());
		return new RM();
	}
	public void setcomdata(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
	}
}
