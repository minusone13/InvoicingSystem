package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import vo.CommodityVO;
import vo.RM;
public interface StubCommodityBlService {
	public ArrayList<CommodityVO> findCommodity(String name);
	public RM addCommodity(CommodityVO vo);
	public void setdataobject(StubCommodityDataService comdata);
}
