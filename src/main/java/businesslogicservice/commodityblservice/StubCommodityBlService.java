package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import vo.RM;
import vo.stockvo.CommodityVO;
import vo.stockvo.StockVO;
public interface StubCommodityBlService {
	public ArrayList<CommodityVO> findCommodity(String name);
	public RM addCommodity(CommodityVO vo);
	public void setdataobject(StubCommodityDataService comdata);
	public ArrayList<StockVO> openCategory(String id);
}
