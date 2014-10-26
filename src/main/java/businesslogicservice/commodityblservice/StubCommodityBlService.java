package businesslogicservice.commodityblservice;

import java.util.ArrayList;

import vo.CommodityVO;
import vo.RM;

public interface StubCommodityBlService {
	public ArrayList<CommodityVO> findCommodity(String name);
	public RM addCommodity(CommodityVO vo);
}
