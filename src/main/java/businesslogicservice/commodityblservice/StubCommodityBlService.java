package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import dataservice.commoditydataservice.*;
import vo.RM;
import vo.stockvo.CategoryVO;
import vo.stockvo.CommodityVO;
import vo.stockvo.StockVO;
public interface StubCommodityBlService {
	public ArrayList<CommodityVO> findCommodity(String name);//输入商品名称，返回一系列具有同样名称的商品 need to be changed to mohuchazhao
	//find by id
	public RM addCommodity(CommodityVO vo);
	public RM addCategory(CategoryVO vo);
	public void setdataobject(StubCommodityDataService comdata);
	public ArrayList<StockVO> openCategory(String id);//root category's ID is"1"
}
