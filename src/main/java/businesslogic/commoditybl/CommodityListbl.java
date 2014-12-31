package businesslogic.commoditybl;

import java.io.File;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.*;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import po.*;
import po.stockpo.*;
import po.stockpo.StockPO.Type;
import businesslogic.commoditybillbl.AlertBill;
import businesslogic.commoditybillbl.CommodityBill;
import businesslogic.stockmanagerbl.*;
import businesslogic.userbl.User;
import dataservice.commoditydataservice.*;
import vo.stockvo.*;

public class CommodityListbl
{// 商品列表 haha
	static CommodityDataService comdata;
	public static User user;//王雨城加了public  此变量用于逻辑层调用来记录系统日志，有问题联系我

	public CommodityVO findCommodity(String name, String model)
	{
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return null;
		Commodity com = new Commodity(po);
		return com.toVO();
	}

	public CommodityVO findCommodity(CommodityVO vo)
	{//调用CommodityVO findCommodity(String name, String model)
		return findCommodity(vo.getName(), vo.getModel());
	}

	public ArrayList<CommodityVO> findCommodity(String name)
	{//对同一名称的商品返回一系列不同型号的商品
		ArrayList<CommodityPO> pos = null;
		try
		{
			pos = comdata.findCommodity(name);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Commodity> coms = posToCom(pos);
		ArrayList<CommodityVO> vos = toVOs(coms);
		return vos;
	}

	public ArrayList<CommodityVO> fuzzyFindCommodity(String s, int precision)
	{// precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		ArrayList<CommodityPO> pos = null;
		try
		{
			pos = comdata.fuzzyFindCommodity(s, precision);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for (int i = 0; i < pos.size(); i++)
			result.add(new Commodity(pos.get(i)).toVO());
		return result;
	}

	public RM addPack(ArrayList<Commodity> commodityarray, int quantity,
			double discount)
	{//特价包中每个商品的数量在商品 number属性中,RM可能返回done insufficient unknownerror notfound
		SimpleDateFormat dateformat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		String ID = dateformat.format(new Date());
		ID = "PACK-" + ID;
		double total = 0;
		for (int i = 0; i < commodityarray.size(); i++)
			total += commodityarray.get(i).getOut()
					* commodityarray.get(i).getNumber();
		total -= discount;
		ArrayList<CommodityPO> compos = new ArrayList<CommodityPO>();
		for (int i = 0; i < commodityarray.size(); i++)
		{// 加入特价包时给定了特价包的数量，响应商品要预留数量，如不足将报不足错误
			Commodity com = commodityarray.get(i);
			CommodityPO po = null;
			try
			{
				po = comdata.findCommodity(com.getName(),
						com.getModel());
			}
			catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (po == null)
				return RM.notfound;
		}
		for (int i = 0; i < commodityarray.size(); i++)
		{// 加入特价包时给定了特价包的数量，响应商品要预留数量，如不足将报不足错误
			Commodity com = commodityarray.get(i);
			if (!isEnough(com.getName(), com.getModel(), com.getNumber()
					* quantity))
				return RM.insufficient;
		}
		for (int i = 0; i < commodityarray.size(); i++)
		{// 准备相应商品数量
			Commodity com = commodityarray.get(i);
			readyForOut(ID, com.getName(), com.getModel(), com.getNumber()
					* quantity, 0);
			compos.add(com.toPO());
		}
		try
		{
			return comdata.insert(new PackPO(ID, compos, quantity, total));
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RM.RMIError;
	}

	public RM addCommodity(CommodityVO vo)
	{
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(vo.getName(), vo.getModel());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po != null)
			return RM.redundance;
		else
		{
			Commodity com = new Commodity(vo);
			com.setNumber(0);
			com.setLastin(-1);
			com.setLastout(-1);
			RM result = RM.unknownerror;
			try
			{
				result = comdata.insert(com.toPO());
			}
			catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	}

	public RM addCategory(CategoryVO vo)
	{
		try
		{
			return comdata.insert(new Category(vo).toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RM.RMIError;
	}

	public void setcomdata(CommodityDataService comdata)
	{//原用于启动程序
		this.comdata = comdata;
	}

	public RM checkIn(String id, String name, String model, int quantity,
			double price)
	{//第一个参数id是进货销售单的ID，下同。
		// 入库 ，可能返回done notfound unknownerror 只有done时表示成功
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		int num = com.getNumber();
		CommodityRecord r;
		if (price != 0)
		{
			com.setLastin(price);
			// 下面调整平均进价
			if (!com.hasIn())
				com.setIn(price);// 如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total = com.getIn() * com.getNumber();
				total += quantity * price;
				int quantitytemp = com.getNumber();
				quantitytemp += quantity;
				com.setIn(total / quantitytemp);
			}
			r = new CommodityRecord(id, new Date(), 0, quantity, 0, quantity
					* price, 0, quantity, 0, quantity * price);
		}
		else
			r = new CommodityRecord(id, new Date(), 0, quantity, 0, 0, 0, 0, 0,
					0);
		com.setNumber(num + quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM checkOut(String id, String name, String model, int quantity,
			double price)
	{// 出库，可能返回done insufficient notfound unknownerror 只有done时表示成功
		CommodityPO po;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RM.RMIError;
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		int num = com.getNumber();
		if (num < quantity)
			return RM.insufficient;
		CommodityRecord r;
		if (price != 0)
		{
			com.setLastout(price);
			// 下面调整平均进价
			if (!com.hasOut())
				com.setOut(price);// 如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total = com.outTotal();
				total += quantity * price;
				int quantitytemp = com.outQuantity();
				quantitytemp += quantity;
				com.setOut(total / quantitytemp);
			}
			r = new CommodityRecord(id, new Date(), quantity, 0, quantity
					* price, 0, quantity, 0, quantity * price, 0);
		}
		else
			r = new CommodityRecord(id, new Date(), quantity, 0, 0, 0, 0, 0, 0,
					0);// 报损不改变销售数量和金额
		com.setNumber(num - quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int shortage = com.checkAlert();
		if (shortage > 0)
		{
			AlertBill ab = new AlertBill(user.getID(), com, shortage);
			CommodityBill cb = new CommodityBill();
			cb.add(ab);
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM readyForIn(String id, String name, String model, int quantity,
			double price)
	{// 当进货单或销售退货单提交后，请调用，可能返回done notfound unknownerror 只有done时表示成功
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		int num = com.getPotential();
		if (num < quantity)
			return RM.insufficient;
		CommodityRecord r = new CommodityRecord(id, new Date(), 0, quantity, 0,
				quantity * price, 0, quantity, 0, quantity * price);
		com.prepareAdd(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM readyForOut(String id, String name, String model, int quantity,
			double price)
	{// 当销售单或进货退货单被提交后，请调用，可能返回done insufficient notfound unknownerror 只有done时表示成功
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		if (com.getPotential() < quantity)
			return RM.insufficient;
		CommodityRecord r = new CommodityRecord(id, new Date(), quantity, 0,
				quantity * price, 0, quantity, 0, quantity * price, 0);
		com.prepareAdd(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM undoCheckIn(String id, String name, String model, int quantity,
			double price)
	{// 当进货退货单被审批后，请调用，可能返回done insufficient notfound unknownerror 只有done时表示成功
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		int num = com.getNumber();
		if (num < quantity)
			return RM.insufficient;
		// 下面调整平均进价
		double total = com.getIn() * com.getNumber();
		total -= quantity * price;
		int quantitytemp = com.getNumber();
		quantitytemp -= quantity;
		if (quantitytemp != 0)
			com.setIn(total / quantitytemp);
		CommodityRecord r = new CommodityRecord(id, new Date(), 0, quantity, 0,
				quantity * price, 0, quantity, 0, quantity * price);
		com.setNumber(num - quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int shortage = com.checkAlert();
		if (shortage > 0)
		{
			AlertBill ab = new AlertBill(user.getID(), com, shortage);
			CommodityBill cb = new CommodityBill();
			cb.add(ab);
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM undoCheckOut(String id, String name, String model, int quantity,
			double price)
	{// 当销售退货单被审批后，请调用，可能返回done notfound unknownerror 只有done时表示成功
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(po);
		int num = com.getNumber();
		CommodityRecord r;
		if (price != 0)
		{
			// 下面调整平均进价
			if (!com.hasOut())
				com.setOut(price);// 如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total = com.outTotal();
				total -= quantity * price;
				int quantitytemp = com.outQuantity();
				quantitytemp -= quantity;
				if (quantitytemp != 0)
					com.setOut(total / quantitytemp);
			}
			r = new CommodityRecord(id, new Date(), quantity, 0, quantity
					* price, 0, quantity, 0, quantity * price, 0);
		}
		else
			r = new CommodityRecord(id, new Date(), quantity, 0, 0, 0, 0, 0, 0,
					0);
		com.setNumber(num + quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = false;
		try
		{
			result = comdata.update(com.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result)
			return RM.done;
		else
			return RM.unknownerror;
	}

	public RM checkOut(String id, String packID, int quantity, double price)
	{// 出库特价包，可能返回done insufficient notfound unknownerror 只有done时表示成功
		PackPO po = null;
		try
		{
			po = comdata.findPack(packID);
		}
		catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Pack pack = new Pack(po);
		int num = pack.getQuantity();
		if (num < quantity)
			return RM.insufficient;
		for (int i = 0; i < pack.getComs().size(); i++)
		{
			Commodity com = pack.getComs().get(i);
			checkOut(pack.getID(), com.getName(), com.getModel(), 0, 0);
			checkOut(id, com.getName(), com.getModel(),
					quantity * com.getNumber(), 0);
			readyForOut(pack.getID(), com.getName(), com.getModel(),
					(num - quantity) * com.getNumber(), 0);
		}
		CommodityRecord r;
		r = new CommodityRecord(id, new Date(), quantity, 0, price * quantity,
				0, quantity, 0, price * quantity, 0);
		pack.setQuantity(num - quantity);
		pack.add(r);
		pack.prepareDelete(r);
		RM result = null;
		try
		{
			result = comdata.update(pack.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM readyForOut(String id, String packID, int quantity, double price)
	{// 特价包，当销售单或进货退货单被提交后，请调用，可能返回done insufficient notfound unknownerror 只有done时表示成功
		PackPO po = null;
		try
		{
			po = comdata.findPack(packID);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Pack pack = new Pack(po);
		if (pack.getPotential() < quantity)
			return RM.insufficient;
		CommodityRecord r = new CommodityRecord(id, new Date(), quantity, 0,
				price * quantity, 0, quantity, 0, price * quantity, 0);
		pack.prepareAdd(r);
		RM result = null;
		try
		{
			result = comdata.update(pack.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM undoCheckOut(String id, String packID, int quantity, double price)
	{// 当销售退货单被审批后，请调用
		PackPO po = null;
		try
		{
			po = comdata.findPack(packID);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Pack pack = new Pack(po);
		int num = pack.getQuantity();
		for (int i = 0; i < pack.getComs().size(); i++)
		{
			Commodity com = pack.getComs().get(i);
			checkOut(pack.getID(), com.getName(), com.getModel(), 0, 0);
			checkIn(id, com.getName(), com.getModel(),
					quantity * com.getNumber(), 0);
			readyForOut(pack.getID(), com.getName(), com.getModel(),
					(num + quantity) * com.getNumber(), 0);
		}
		CommodityRecord r;
		r = new CommodityRecord(id, new Date(), quantity, 0, price * quantity,
				0, 0, 0, 0, 0);
		pack.setQuantity(num + quantity);
		pack.add(r);
		pack.prepareDelete(r);
		RM result = null;
		try
		{
			result = comdata.update(pack.toPO());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean isEnough(String name, String model, int n)
	{// 在填写单据时检查，给出的是潜在库存最小值，也就是最保险的值
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return false;
		Commodity com = new Commodity(po);
		int potential = com.getPotential();
		return (n <= potential);
	}

	public boolean isEnough(String PackID, int n)
	{// 同上，判断特价包
		PackPO po = null;
		try
		{
			po = comdata.findPack(PackID);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)
			return false;
		Pack pack = new Pack(po);
		int potential = pack.getPotential();
		return (n <= potential);
	}

	private ArrayList<Commodity> posToCom(ArrayList<CommodityPO> h)
	{
		ArrayList<Commodity> result = new ArrayList<Commodity>();
		for (int i = 0; i < h.size(); i++)
		{
			result.add(new Commodity(h.get(i)));
		}
		return result;
	}

	private ArrayList<CommodityVO> toVOs(ArrayList<Commodity> h)
	{
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for (int i = 0; i < h.size(); i++)
		{
			result.add(h.get(i).toVO());
		}
		return result;
	}

	public ArrayList<StockVO> openCategory(String id)
	{//打开一个分类，StockVO里面有一个参数Type，表示类型（商品or分类）
		ArrayList<StockPO> pos = null;
		try
		{
			pos = comdata.openCategory(id);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pos == null)
			return null;
		ArrayList<StockVO> vos = new ArrayList<StockVO>();
		for (int i = 0; i < pos.size(); i++)
		{
			StockPO stockpo = pos.get(i);
			if (stockpo.getT() == StockPO.Type.Category)
				vos.add(new StockVO(new Category(stockpo.getCat()).toVO()));
			else
				vos.add(new StockVO(new Commodity(stockpo.getCom()).toVO()));
		}
		return vos;
	}

	//下面的方法请看BLService的说明
	public RM deleteCommodity(String name, String model)
	{
		RM result = RM.RMIError;
		try
		{
			result = comdata.deleteCommodity(name, model);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM deleteCategory(String id)
	{
		RM result = RM.RMIError;
		try
		{
			result = comdata.deleteCategory(id);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public RM updateCommodity(CommodityVO vo)
	{
		CommodityPO po = null;
		try
		{
			po = comdata.findCommodity(vo.getName(), vo.getModel());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (po == null)// not found
			return RM.notfound;
		Commodity com = new Commodity(vo);
		double income = (com.getIn() - po.getIn()) * com.getNumber();
		try
		{
			comdata.insert(new AdjustmentRecordPO(income));
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			if (comdata.update(com.toPO()))
				return RM.done;
			else
				return RM.unknownerror;
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RM.RMIError;
	}

	public RM updateCategory(CategoryVO vo, String newName)
	{
		ArrayList<StockPO> pos = new ArrayList<StockPO>(); 
		try 
		{ 
			pos = comdata.openCategory(vo.getParent()); 
		} 
		catch (RemoteException e1) 
		{ 
			e1.printStackTrace(); 
		 	return RM.RMIError; 
		}
		for(int i = 0; i<pos.size(); i++) 
			if(pos.get(i).getT() != Type.Category) 
			 	return RM.unknownerror; 
		for(int i = 0; i<pos.size(); i++) 
			if(pos.get(i).getCat().getName().equals(newName)) 
				return RM.redundance;
		try
		{
			return comdata.update(new Category(vo).toPO(), newName);
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return RM.RMIError;
	}

	public static CommodityDataService getComdata()
	{
		return comdata;
	}

	public static void setComdata(CommodityDataService comdata)
	{
		CommodityListbl.comdata = comdata;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public double getAdjustmentTotal(Date d1, Date d2)
	{// 商品调价。这个返回值可能为正，也可能为负
		ArrayList<AdjustmentRecordPO> h = null;
		try
		{
			h = comdata.getAdjustmentRecords();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		double income = 0;
		for (int i = 0; i < h.size(); i++)
		{
			AdjustmentRecordPO po = h.get(i);
			Date d = po.getDate();
			if (d.after(d1) && d.before(d2))
				income += po.getIncome();
		}
		return income;
	}

	public CountVO count()
	{// 库存盘点
		ArrayList<CommodityPO> temp = null;
		try
		{
			temp = comdata.getAllCommodity();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for (int i = 0; i < temp.size(); i++)
			result.add(new Commodity(temp.get(i)).toVO());
		try
		{
			return new CountVO(result, new Date(), comdata.getCountNo());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void ExportCount(String FilePath, CountVO vo)
	{
		ArrayList<CommodityPO> temp = null;
		try
		{
			temp = comdata.getAllCommodity();
		}
		catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try
		{
			File f = po.Tool.Opendoc(FilePath);
			WritableWorkbook book = Workbook.createWorkbook(f);
			WritableSheet sheet = book.createSheet("第一页", 0);
			Label label = new Label(0, 0, "库存盘点");
			sheet.addCell(label);
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String currentTime = format.format(new Date());
			label = new Label(1, 0, "批次：" + currentTime);
			sheet.addCell(label);
			label = new Label(2, 0, "批号：" + vo.getNo());
			sheet.addCell(label);
			label = new Label(0, 1, "行号");
			sheet.addCell(label);
			label = new Label(1, 1, "名称");
			sheet.addCell(label);
			label = new Label(2, 1, "型号");
			sheet.addCell(label);
			label = new Label(3, 1, "库存数量");
			sheet.addCell(label);
			label = new Label(4, 1, "库存均价");
			sheet.addCell(label);
			for (int i = 2; i <= temp.size() + 1; i++)
			{
				label = new Label(0, i, Integer.toString(i - 1));
				sheet.addCell(label);
				CommodityVO comvo = vo.getList().get(i - 2);
				label = new Label(1, i, comvo.getName());
				sheet.addCell(label);
				label = new Label(2, i, comvo.getModel());
				sheet.addCell(label);
				label = new Label(3, i, Integer.toString(comvo.getNumber()));
				sheet.addCell(label);
				label = new Label(4, i, Double.toString(comvo.getIn()));
				sheet.addCell(label);
			}
			book.write();
			book.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ArrayList<CommodityVO> getRecords(Date d1, Date d2)
	{// 库存查看
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> temp = null;
		try
		{
			temp = comdata.getAllCommodity();
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < temp.size(); i++)
		{
			Commodity com = new Commodity(temp.get(i));
			com.computeRecordsTotal(d1, d2);
			result.add(com.toVO());
		}
		return result;
	}
}
