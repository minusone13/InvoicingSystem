package businesslogic.commoditybl;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.RM;

public class StubCommodityList {
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
		return new RM();
	}
}
