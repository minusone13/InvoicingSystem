package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import vo.RM;
import vo.stockpo.MockCommodityVO;
public interface StubCommodityBlService {
	public ArrayList<MockCommodityVO> findCommodity(String name);
	public RM addCommodity(MockCommodityVO vo);
	public void setdataobject(StubCommodityDataService comdata);
}
