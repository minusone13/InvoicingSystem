package businesslogic.stockmanagerbl;

import java.util.*;
import businesslogic.commoditybillbl.*;
import businesslogic.commoditybl.*;
import businesslogicservice.commodityblservice.*;
import vo.*;

public class StubStockManager implements StubCommodityBlService{
	StubCommodityList l;
	public StubCommodityList getCommodityList ()
	{
		return l;
	}
	public ArrayList<CommodityVo> findCommodity(String name)
	{
		return l.findCommodity(name);
	}
	public boolean addPack(ArrayList<StubCommodity> commodityarray,int quantity, double discount)
	{
		return l.addPack(commodityarray, quantity, discount);
	}
}
