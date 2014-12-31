package businesslogic.stockmanagerbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.*;

import po.BillState;
import po.RM;
import po.Role;
import po.Tool;
import po.stockpo.PackPO;
import presentation.userui.Login;
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

public class StubStockController implements StubCommodityBlService,
		StockBlForSalesMen, StockBlForManager, StockBlForFinancial
{// 负责与界面及其他程序员的交互
	CommodityListbl l = new CommodityListbl();
	CommodityBill bl = new CommodityBill();
	UserService us = new UserController();
	static CommodityDataService comdata = null;
	static StubBillPool pool = new StubBillPool();
	static User user = new User("D0000", Role.ADMINISTRATOR, "Default", "password",
			"Test");
	static
	{
		connect();
	}
	public static void connect()
	{
		try
		{
			comdata = (CommodityDataService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/StubStockDataController");
		}
		catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public StubStockController()
	{
		l.setUser(user);
		bl.setUser(user);
		bl.setPool(pool);
		l.setcomdata(comdata);
	}

	public CommodityListbl getCommodityList()
	{
		return l;
	}

	//没有注释的方法参见进一步调用的方法中的注释，并可参考BLservice中的注释
	public RM addCommodity(CommodityVO vo)
	{
		RM result = l.addCommodity(vo);
		us.addRecord(new OperationRecord(user, "addCommodity:"+vo.getName()+vo.getModel(), result));
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
	{// precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		return l.fuzzyFindCommodity(s, precision);
	}

	public RM addPack(ArrayList<Commodity> commodityarray, int quantity,
			double discount)
	{//增加特价包
		return l.addPack(commodityarray, quantity, discount);
	}

	public RM addCategory(CategoryVO vo)
	{
		RM result = l.addCategory(vo);
		us.addRecord(new OperationRecord(user, "addCategory:"+vo.getId(), result));
		return result;
	}

	public void setdataobject(CommodityDataService comdata)
	{
		this.comdata = comdata;
		l.setcomdata(comdata);
	}

	public RM undoCheckIn(String id, String name, String model, int quantity,
			double price)
	{// 当进货退货单被审批后，请调用
		return l.undoCheckIn(id, name, model, quantity, price);
	}

	public RM undoCheckOut(String id, String name, String model, int quantity,
			double price)
	{// 当销售退货单被审批后，请调用
		return l.undoCheckOut(id, name, model, quantity, price);
	}

	public RM checkIn(String id, String name, String model, int quantity,
			double price)
	{
		return l.checkIn(id, name, model, quantity, price);
	}

	public RM checkOut(String id, String name, String model, int quantity,
			double price)
	{
		RM result = l.checkOut(id, name, model, quantity, price);
		return result;
	}

	public RM readyForIn(String id, String name, String model, int quantity,
			double price)
	{// 当进货单或销售退货单提交后，请调用
		RM result = l.readyForIn(id, name, model, quantity, price);
		return result;
	}

	public RM readyForOut(String id, String name, String model, int quantity,
			double price)
	{// 当销售单或进货退货单被提交后，请调用
		RM result = l.readyForOut(id, name, model, quantity, price);
		return result;
	}

	public RM checkOut(String id, String packID, int quantity, double price)
	{// 出库
		return l.checkOut(id, packID, quantity, price);
	}

	public RM readyForOut(String id, String packID, int quantity, double price)
	{// 当销售单或进货退货单被提交后，请调用
		return l.readyForOut(id, packID, quantity, price);
	}

	public RM undoCheckOut(String id, String packID, int quantity, double price)
	{// 当销售退货单被审批后，请调用
		return l.undoCheckOut(id, packID, quantity, price);
	}

	public boolean isEnough(String name, String model, int n)
	{// 在填写单据时检查，给出的是潜在库存最小值，也就是最保险的值
		return l.isEnough(name, model, n);
	}

	public boolean isEnough(String PackID, int n)
	{
		return l.isEnough(PackID, n);
	}

	public ArrayList<StockVO> openCategory(String id)
	{
		return l.openCategory(id);
	}

	public RM deleteCommodity(String name, String model)
	{// 有可能返回RM。done，若已有进出记录，返回alreadyHaveUnremoveableContents
		RM result = l.deleteCommodity(name, model);
		us.addRecord(new OperationRecord(user, "deleteCommodity:"+name+model, result));
		return result;
	}

	public RM deleteCategory(String id)
	{// 有可能返回RM。done，若已有子分类或商品，返回alreadyHaveUnremoveableContents
		RM result = l.deleteCategory(id);
		us.addRecord(new OperationRecord(user, "deleteCategory:"+id, result));
		return result;
	}

	public void setUser(UserVO vo)
	{
		user = new User(vo);
		l.setUser(user);
		bl.setUser(user);
	}

	public double getSpillsTotal(Date d1, Date d2)
	{// including d1 and d2
		CommodityBill cb = new CommodityBill();
		return cb.getSpillsTotal(d1, d2);
	}

	public double getLossTotal(Date d1, Date d2)
	{// see above
		CommodityBill cb = new CommodityBill();
		return cb.getLossTotal(d1, d2);
	}

	public double getAdjustmentTotal(Date d1, Date d2)
	{// 商品调价。这个返回值可能为正，也可能为负
		return l.getAdjustmentTotal(d1, d2);
	}

	public double getGiftBillTotal(Date d1, Date d2)
	{// 赠送单支出。这个返回值可能为非负
		CommodityBill cb = new CommodityBill();
		return cb.getGiftBillTotal(d1, d2);
	}

	public RM updateCommodity(CommodityVO vo)
	{
		RM result = l.updateCommodity(vo);
		us.addRecord(new OperationRecord(user, "updateCommodity:"+vo.getName()+vo.getModel(), result));
		return result;
	}

	//public RM updateCommodity(CommodityVO vo, String newName)
	//{
		//RM result = l.updateCommodity(vo);
		//us.addRecord(new OperationRecord(user, "updateCommodity", result));
		//return result;
	//}

	public RM updateCategory(CategoryVO vo)
	{//此方法错掉了，所以一直返回未知错误
		return RM.unknownerror;
	}

	public RM updateCategory(CategoryVO vo, String newName)
	{
		RM result = l.updateCategory(vo, newName);
		us.addRecord(new OperationRecord(user, "updateCategory:"+newName, result));
		return result;
	}

	// 单据方法
	public RM creat(GiftBillVO vo)
	{
		GiftBill gb = new GiftBill();
		gb.setVO(vo);
		RM result = bl.add(gb);
		return result;
	}

	public RM creat(SpillsLossBillVO vo)
	{
		SpillsLossBill gb = new SpillsLossBill();
		gb.setVO(vo);
		RM result = bl.add(gb);
		return result;
	}

	public RM creat(AlertBillVO vo)
	{
		AlertBill gb = new AlertBill();
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
		for (int i = 0; i < vo.getComs().size(); i++)
		{
			Commodity com = new Commodity(vo.getComs().get(i));
			if (!isEnough(com.getName(), com.getModel(), com.getNumber()))
				return RM.insufficient;
		}
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		us.addRecord(new OperationRecord(user, "submit:"+vo.getID(), RM.done));
		return RM.done;
	}

	public RM submit(SpillsLossBillVO vo)
	{
		Commodity com = new Commodity(vo.getCom());
		if (!isEnough(com.getName(), com.getModel(), com.getNumber()))
			return RM.insufficient;
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		us.addRecord(new OperationRecord(user, "submit:"+vo.getID(), RM.done));
		return RM.done;
	}

	public RM submit(AlertBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.SUBMITED);
		us.addRecord(new OperationRecord(user, "submit:"+vo.getID(), RM.done));
		return RM.done;
	}

	public RM over(GiftBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.OVER);
		us.addRecord(new OperationRecord(user, "over:"+vo.getID(), RM.done));
		return RM.done;
	}

	public RM over(SpillsLossBillVO vo)
	{
		pool.transformState(vo.getBillstyle(), vo.getID(), BillState.OVER);
		us.addRecord(new OperationRecord(user, "over:"+vo.getID(), RM.done));
		return RM.done;
	}

	public ArrayList<GiftBillVO> showGiftBills()
	{
		ArrayList<GiftBill> h = pool.getGiftBill();
		ArrayList<GiftBillVO> result = new ArrayList<GiftBillVO>();
		for (int i = 0; i < h.size(); i++)
			result.add(h.get(i).getVO());
		return result;
	}

	public ArrayList<SpillsLossBillVO> showSpillsLossBills()
	{
		ArrayList<SpillsLossBill> h = pool.getSpillsLossBill();
		ArrayList<SpillsLossBillVO> result = new ArrayList<SpillsLossBillVO>();
		for (int i = 0; i < h.size(); i++)
			result.add(h.get(i).getVO());
		return result;
	}

	public ArrayList<AlertBillVO> showAlertBills()
	{
		ArrayList<AlertBill> h = pool.getAlertBill();
		ArrayList<AlertBillVO> result = new ArrayList<AlertBillVO>();
		for (int i = 0; i < h.size(); i++)
			result.add(h.get(i).getVO());
		return result;
	}

	// 库存查看，库存盘点
	public CountVO count()
	{// 库存盘点
		us.addRecord(new OperationRecord(user, "库存盘点", RM.done));
		return l.count();
	}

	public void ExportCount(String FilePath, CountVO vo)
	{
		l.ExportCount(FilePath, vo);
	}

	public ArrayList<CommodityVO> getRecords(Date d1, Date d2)
	{// 库存查看
		return l.getRecords(d1, d2);
	}

	public StubBillPool getPool()
	{
		return pool;
	}

	public void setPool(StubBillPool pool)
	{
		this.pool = pool;
	}

	public void setFilePath(String s)
	{// 用于期初建账查看商品信息
		try
		{
			comdata.setFilePath(s);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connect();
	}
	
	public ArrayList<PackVO> getAllPacks() throws RemoteException
	{
		ArrayList<PackPO> pos = comdata.getAllPacks();
		ArrayList<PackVO> vos = new ArrayList<PackVO>();
		for(int i=0;i<pos.size();i++)
		{
			vos.add(new Pack(pos.get(i)).toVO());
		}
		return vos;
	}
}
