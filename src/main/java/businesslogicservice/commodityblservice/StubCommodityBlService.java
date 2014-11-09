package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import vo.MockCommodityVO;
import vo.RM;
public interface StubCommodityBlService {
	public ArrayList<MockCommodityVO> findCommodity(String name);
	public RM addCommodity(MockCommodityVO vo);
	public void setdataobject(StubCommodityDataService comdata);
}
