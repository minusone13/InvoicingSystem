package businesslogicservice.commodityblservice;

import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.RM;
import po.stockpo.CommodityPO;
import dataservice.commoditydataservice.*;
import vo.*;
import vo.stockvo.*;
import vo.uservo.UserVO;

public interface StubCommodityBlService
{
	public ArrayList<CommodityVO> findCommodity(String name);// 输入商品名称，返回一系列具有同样名称的商品
																// need to be
																// changed to
																// mohuchazhao

	public ArrayList<CommodityVO> fuzzyFindCommodity(String s, int precision);

	// precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少

	public CommodityVO findCommodity(String name, String model);// 返回结果为null为没找到

	public CommodityVO findCommodity(CommodityVO vo);// 返回结果为null为没找到

	public RM addCommodity(CommodityVO vo);

	public RM addCategory(CategoryVO vo);

	public RM updateCommodity(CommodityVO vo);// 只有进价和售价是可以更改的

	public RM updateCategory(CategoryVO vo);// 此接口有误，作废，见下面一个接口

	public RM updateCategory(CategoryVO vo, String newName);// 分类只可修改名称

	public void setdataobject(StubCommodityDataService comdata);

	public ArrayList<StockVO> openCategory(String id);// root category's ID
														// is"1"。

	public RM deleteCommodity(String name, String model);// 有可能返回RM。done，若已有进出记录，返回alreadyHaveUnremoveableContents

	public RM deleteCategory(String id);// 有可能返回RM。done，若已有子分类或商品，返回alreadyHaveUnremoveableContents

	public void setFilePath(String s);// 用于期初建账查看商品信息

	public void setUser(UserVO vo);// 告诉代码此时操作的User

	public RM creat(GiftBillVO vo);

	public RM creat(SpillsLossBillVO vo);

	public RM update(GiftBillVO vo);

	public RM update(SpillsLossBillVO vo);

	public RM submit(GiftBillVO vo);

	public RM submit(SpillsLossBillVO vo);

	public RM submit(AlertBillVO vo);

	public RM over(GiftBillVO vo);

	public RM over(SpillsLossBillVO vo);

	public ArrayList<GiftBillVO> showGiftBills();

	public ArrayList<SpillsLossBillVO> showSpillsLossBills();

	public ArrayList<AlertBillVO> showAlertBills();

	public CountVO count();// 库存盘点

	public ArrayList<CommodityVO> getRecords(Date d1, Date d2);// 库存查看,当中的ArrayList<CommodityRecordVO>
																// 只有第零项有值，是查看的数据

	public void ExportCount(String FilePath, CountVO vo);// 导出excel
}
