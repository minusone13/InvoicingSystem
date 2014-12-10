package businesslogicservice.commodityblservice;
import java.util.ArrayList;

import po.stockpo.CommodityPO;
import dataservice.commoditydataservice.*;
import vo.*;
import vo.stockvo.*;
import vo.uservo.UserVO;
public interface StubCommodityBlService {
	public ArrayList<CommodityVO> findCommodity(String name);//输入商品名称，返回一系列具有同样名称的商品 need to be changed to mohuchazhao
	public ArrayList<CommodityVO> fuzzyFindCommodity(String s, int precision);
	//precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
	
	
	public RM addCommodity(CommodityVO vo);
	public RM addCategory(CategoryVO vo);
	public RM updateCommodity(CommodityVO vo);//只有进价和售价是可以更改的
	public RM updateCategory(CategoryVO vo);//只有名称可更改
	public void setdataobject(StubCommodityDataService comdata);
	public ArrayList<StockVO> openCategory(String id);//root category's ID is"1"。
	public RM deleteCommodity(String name,String model);//有可能返回RM。done，若已有进出记录，返回alreadyHaveUnremoveableContents
	public RM deleteCategory(String id);//有可能返回RM。done，若已有子分类或商品，返回alreadyHaveUnremoveableContents
	public void setUser(UserVO vo);//告诉代码此时操作的User
	
	
	public RM creat(GiftBillVO vo);
	public RM creat(SpillsLossBillVO vo);
	
	public RM update(GiftBillVO vo);
	public RM update(SpillsLossBillVO vo);
	
	public RM submit(GiftBillVO vo);
	public RM submit(SpillsLossBillVO vo);
	public RM submit(AlertBillVO vo);
}
