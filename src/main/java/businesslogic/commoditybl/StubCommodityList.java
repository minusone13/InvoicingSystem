package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.CommodityVO;

public class StubCommodityList {
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return null;
	}
	public boolean addPack(ArrayList<StubCommodity> commodityarray,int quantity, double discount)
	{
		return true;
	}
}
