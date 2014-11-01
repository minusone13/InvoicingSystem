package businesslogic.stockmanagerbl;

import java.util.*;

import dataservice.commoditydataservice.StubCommodityDataService;
import businesslogic.commoditybillbl.*;
import businesslogic.commoditybl.*;
import businesslogicservice.commodityblservice.*;
import vo.*;

public class StubStockController implements StubCommodityBlService{
	StubCommodityList l=new StubCommodityList();
	static StubCommodityDataService comdata;
	public StubCommodityList getCommodityList ()
	{
		return l;
	}
	public RM addCommodity(CommodityVO vo)
	{
		return l.addCommodity(vo);
	}
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return l.findCommodity(name);
	}
	public boolean addPack(ArrayList<StubCommodity> commodityarray,int quantity, double discount)
	{
		return l.addPack(commodityarray, quantity, discount);
	}
	
	public void setdataobject(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
		l.setcomdata(comdata);
	}
	

	
}
