package businesslogic.stockmanagerbl;

import java.util.*;

import po.BillState;
import po.RM;
import po.Role;
import po.Tool;
import po.stockpo.PackPO;
import presentation.userui.Login;
import data.commoditydata.StubStockDataController;
import dataservice.commoditydataservice.*;
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
	StubCommodityBill bl=new StubCommodityBill();
	UserService us=new UserController();
	static StubCommodityDataService comdata;
	static StubBillPool pool = new StubBillPool();
	User user=new User("I0000",Role.STOCK_STAFF,"DefaultStock","default","Liu");
	public StubStockController()
	{
		UserVO temp = Login.user;
		if(temp!=null)
		{
			user = new User(temp);
		}
		l.setUser(user);
		bl.setUser(user);
		bl.setPool(pool);
	}
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
	public CommodityVO findCommodity(String name, String model)
	{
		return l.findCommodity(name, model);
	}
	
	public CommodityVO findCommodity(CommodityVO vo)
	{
		return l.findCommodity(vo);
	}
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		return l.findCommodity(name);
	}
	public ArrayList<CommodityVO> fuzzyFindCommodity(String s, int precision)
	{//precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		return l.fuzzyFindCommodity(s, precision);
	}
	public RM addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount)
	{
		return l.addPack(commodityarray, quantity, discount);
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
		return l.undoCheckIn(id, name, model, quantity, price);
	}
	public RM undoCheckOut(String id,String name, String model, int quantity, double price)
	{//当销售退货单被审批后，请调用
		return l.undoCheckOut(id, name, model, quantity, price);
	}
	public RM checkIn(String id, String name, String model, int quantity, double price)
	{
		return l.checkIn(id, name, model, quantity, price);
	}
	public RM checkOut(String id, String name, String model, int quantity, double price)
	{
		RM result = l.checkOut(id, name, model, quantity, price);
		return result;
	}
	public RM readyForIn(String id,String name, String model, int quantity, double price)
	{//当进货单或销售退货单提交后，请调用
		RM result = l.readyForIn(id, name, model, quantity, price);
		return result;
	}
	public RM readyForOut(String id,String name, String model, int quantity, double price)
	{//当销售单或进货退货单被提交后，请调用
		RM result = l.readyForOut(id, name, model, quantity, price);
		return result;
	}
	public RM checkOut(String id, String packID, int quantity, double price)
	{//出库
		return l.checkOut(id, packID, quantity, price);
	}
	public RM readyForOut(String id,String packID, int quantity, double price)
	{//当销售单或进货退货单被提交后，请调用
		return l.readyForOut(id, packID, quantity, price);
	}
	public RM undoCheckOut(String id,String packID, int quantity, double price)
	{//当销售退货单被审批后，请调用
		return l.undoCheckOut(id, packID, quantity, price);
	}
	public boolean isEnough(String name,String model,int n)
	{//在填写单据时检查，给出的是潜在库存最小值，也就是最保险的值
		return l.isEnough(name, model, n);
	}
	public boolean isEnough(String PackID,int n)
	{
		return l.isEnough(PackID, n);
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
		return l.getAdjustmentTotal(d1, d2);
	}
	public double getGiftBillTotal(Date d1, Date d2)
	{//赠送单支出。这个返回值可能为非负
		StubCommodityBill cb=new StubCommodityBill();
		return cb.getGiftBillTotal(d1, d2);
	}
	
	public RM updateCommodity(CommodityVO vo)
	{
		RM result = l.updateCommodity(vo);
		us.addRecord(new OperationRecord(user,"updateCommodity",result));
		return result;
	}
	public RM updateCommodity(CommodityVO vo, String newName)
	{
		RM result = l.updateCommodity(vo);
		us.addRecord(new OperationRecord(user,"updateCommodity",result));
		return result;
	}
	public RM updateCategory(CategoryVO vo)
	{
		return RM.unknownerror;
	}
	public RM updateCategory(CategoryVO vo, String newName)
	{
		return l.updateCategory(vo, newName);
	}
	
	
	
	//单据方法
	public RM creat(GiftBillVO vo)
	{
		StubGiftBill gb=new StubGiftBill();
		gb.setVO(vo);
		RM result = bl.add(gb);
		return result;
	}
	public RM creat(SpillsLossBillVO vo)
	{
		StubSpillsLossBill gb=new StubSpillsLossBill();
		gb.setVO(vo);
		RM result = bl.add(gb);
		return result;
	}
	public RM creat(AlertBillVO vo)
	{
		StubAlertBill gb=new StubAlertBill();
		gb.setVO(vo);
		RM result = bl.add(gb);
		return result;
	}
	
	public RM update(GiftBillVO vo)
	{
		pool.change(vo);
		return RM.done;
	}
	public RM update(SpillsLossBillVO vo)
	{
		pool.change(vo);
		return RM.done;
	}
	public RM update(AlertBillVO vo)
	{
		pool.change(vo);
		return RM.done;
	}
	
	public RM submit(GiftBillVO vo)
	{
		for(int i=0;i<vo.getComs().size();i++)
		{
			MockCommodity com = new MockCommodity(vo.getComs().get(i));
			if(!isEnough(com.getName(), com.getModel(),com.getNumber()))
				return RM.insufficient;
		}
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		return RM.done;
	}
	public RM submit(SpillsLossBillVO vo)
	{
		MockCommodity com = new MockCommodity(vo.getCom());
		if(!isEnough(com.getName(), com.getModel(),com.getNumber()))
			return RM.insufficient;
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		return RM.done;
	}
	public RM submit(AlertBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		return RM.done;
	}
	
	public RM over(GiftBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.OVER);
		return RM.done;
	}
	
	public RM over(SpillsLossBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.OVER);
		return RM.done;
	}
	public ArrayList<GiftBillVO> showGiftBills()
	{
		ArrayList<StubGiftBill> h = pool.getGiftBill();
		ArrayList<GiftBillVO> result = new ArrayList<GiftBillVO>();
		for(int i=0; i<h.size();i++)
			result.add(h.get(i).getVO());
		return result;
	}
	public ArrayList<SpillsLossBillVO> showSpillsLossBills()
	{
		ArrayList<StubSpillsLossBill> h = pool.getSpillsLossBill();
		ArrayList<SpillsLossBillVO> result = new ArrayList<SpillsLossBillVO>();
		for(int i=0; i<h.size();i++)
			result.add(h.get(i).getVO());
		return result;
	}
	public ArrayList<AlertBillVO> showAlertBills()
	{
		ArrayList<StubAlertBill> h = pool.getAlertBill();
		ArrayList<AlertBillVO> result = new ArrayList<AlertBillVO>();
		for(int i=0; i<h.size();i++)
			result.add(h.get(i).getVO());
		return result;
	}
	
	
	//库存查看，库存盘点
	public CountVO count()
	{//库存盘点
		return l.count();
	}
	public void ExportCount(String FilePath,CountVO vo)
	{
		l.ExportCount(FilePath,vo);
	}
	
	public ArrayList<CommodityVO> getRecords(Date d1, Date d2)
	{//库存查看
		return l.getRecords(d1, d2);
	}
	public StubBillPool getPool() {
		return pool;
	}
	public void setPool(StubBillPool pool) {
		this.pool = pool;
	}
	
    public void setFilePath(String s)
    {//用于期初建账查看商品信息
    	comdata.setFilePath(s);
    }
}
