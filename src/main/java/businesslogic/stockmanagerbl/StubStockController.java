package businesslogic.stockmanagerbl;

import java.util.*;

import dataservice.commoditydataservice.*;
import businesslogic.Role;
import businesslogic.commoditybillbl.*;
import businesslogic.commoditybl.*;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockservice.*;
import businesslogic.userbl.OperationRecord;
import businesslogic.userbl.User;
import businesslogic.userbl.UserController;
import businesslogic.userservice.UserService;
import businesslogicservice.commodityblservice.*;
import vo.*;
import vo.stockvo.*;
import vo.uservo.UserVO;

public class StubStockController implements StubCommodityBlService, StockBlForSalesMen, StockBlForManager,StockBlForFinancial
{//负责与界面及其他程序员的交互
	StubCommodityList l=new StubCommodityList();
	UserService us=new UserController();
	static StubCommodityDataService comdata;
	User user=new User("I0001",Role.STOCK_STAFF,"default","default","default");
	
	StubBillPool pool = new StubBillPool();
	public StubCommodityList getCommodityList ()
	{
		return l;
	}
	public RM addCommodity(CommodityVO vo)
	{
		RM result=l.addCommodity(vo);
		us.addRecord(new OperationRecord(user,"addCommodity",result));
		return result;
	}
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return l.findCommodity(name);
	}
	public boolean addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount)
	{
		return l.addPack(commodityarray, quantity, discount);
	}
	public RM addPack(StubPack p)
	{
		return RM.done;
	}
	public RM addCategory(CategoryVO vo)
	{
		RM result=l.addCategory(vo);
		us.addRecord(new OperationRecord(user,"addCategory",result));
		return result;
	}
	
	public void setdataobject(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
		l.setcomdata(comdata);
	}
	
	public RM undoCheckIn(String id,String name, String model, int quantity, double price)
	{//当进货退货单被审批后，请调用
		return RM.done;
	}
	public RM undoCheckOut(String id,String name, String model, int quantity, double price)
	{//当销售退货单被审批后，请调用
		return RM.done;
	}
	public RM checkIn(String id, String name, String model, int quantity, double price)
	{
		return l.checkIn(id, name, model, quantity, price);
	}
	public RM checkOut(String id, String name, String model, int quantity, double price)
	{
		return l.checkOut(id, name, model, quantity, price);
	}
	public RM readyForIn(String id,String name, String model, int quantity, double price)
	{//当进货单或销售退货单提交后，请调用
		return RM.done;
	}
	public RM readyForOut(String id,String name, String model, int quantity, double price)
	{//当销售单或进货退货单被提交后，请调用
		return RM.done;
	}
	public ArrayList<StockVO> openCategory(String id)
	{
		return l.openCategory(id);
	}
	public RM deleteCommodity(String name,String model)
	{//有可能返回RM。done，若已有进出记录，返回alreadyHaveUnremoveableContents
		RM result=l.deleteCommodity(name, model);
		us.addRecord(new OperationRecord(user,"deleteCommodity",result));
		return result;
	}
	public RM deleteCategory(String id)
	{//有可能返回RM。done，若已有子分类或商品，返回alreadyHaveUnremoveableContents
		RM result=l.deleteCategory(id);
		us.addRecord(new OperationRecord(user,"deleteCategory",result));
		return result;
	}
	public void setUser(UserVO vo)
	{
		user=new User(vo);
		l.setUser(user);
	}
	public double getSpillsTotal(Date d1, Date d2)
	{//including d1 and d2
		StubCommodityBill cb=new StubCommodityBill();
		return cb.getSpillsTotal(d1, d2);
	}
	public double getLossTotal(Date d1, Date d2)
	{//see above
		StubCommodityBill cb=new StubCommodityBill();
		return cb.getLossTotal(d1, d2);
	}
	public double getAdjustmentTotal(Date d1, Date d2)
	{//商品调价。这个返回值可能为正，也可能为负
		return 0;
	}
	public double getGiftBillTotal(Date d1, Date d2)
	{//赠送单支出。这个返回值可能为非负
		return 0;
	}
	
	public RM updateCommodity(CommodityVO vo)
	{
		return l.updateCommodity(vo);
	}
	public RM updateCategory(CategoryVO vo)
	{
		return l.updateCategory(vo);
	}
	
	StubCommodityBill bl=new StubCommodityBill();
	public RM creat(GiftBillVO vo)
	{
		StubGiftBill gb=new StubGiftBill();
		gb.setVO(vo);
		bl.add(gb);
		return RM.done;
	}
	public RM creat(SpillsLossBillVO vo)
	{
		StubSpillsLossBill gb=new StubSpillsLossBill();
		gb.setVO(vo);
		bl.add(gb);
		return RM.done;
	}
	public RM creat(AlertBillVO vo)
	{
		StubAlertBill gb=new StubAlertBill();
		gb.setVO(vo);
		bl.add(gb);
		return RM.done;
	}
	
	public RM update(GiftBillVO vo)
	{
		return RM.done;
	}
	public RM update(SpillsLossBillVO vo)
	{
		return RM.done;
	}
	public RM update(AlertBillVO vo)
	{
		return RM.done;
	}
	
	public RM submit(GiftBillVO vo)
	{
		return RM.done;
	}
	public RM submit(SpillsLossBillVO vo)
	{
		return RM.done;
	}
	public RM submit(AlertBillVO vo)
	{
		return RM.done;
	}
}
