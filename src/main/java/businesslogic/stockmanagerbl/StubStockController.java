package businesslogic.stockmanagerbl;

import java.util.*;

import dataservice.commoditydataservice.StubCommodityDataService;
import businesslogic.commoditybillbl.*;
import businesslogic.commoditybl.*;
import businesslogicservice.commodityblservice.*;
import vo.*;

public class StubStockController implements StubCommodityBlService
{//负责与界面及其他程序员的交互
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
	
	public boolean checkIn(String name, String model, int quantity, double price)
	{
		return l.checkIn(name, model, quantity, price);
	}
	public boolean checkOut(String name, String model, int quantity, double price)
	{
		return l.checkOut(name, model, quantity, price);
	}
	
}