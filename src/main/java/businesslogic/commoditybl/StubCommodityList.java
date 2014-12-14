package businesslogic.commoditybl;

import java.util.*;

import po.*;
import po.stockpo.*;
import businesslogic.Role;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubCommodityBill;
import businesslogic.stockmanagerbl.*;
import businesslogic.userbl.User;
import dataservice.commoditydataservice.*;
import vo.stockvo.*;
import vo.RM;

public class StubCommodityList {//商品列表 haha
	static StubCommodityDataService comdata;
	User user;
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		ArrayList <CommodityPO> pos=comdata.findCommodity(name);
		ArrayList <MockCommodity> coms=posToCom(pos);
		ArrayList <CommodityVO> vos=toVOs(coms);
		return vos;
	}
	public ArrayList<CommodityVO> fuzzyFindCommodity(String s, int precision)
	{//precision 先默认给1，可以达到王雨城所说的算法。若取数字越高，精确度越高，搜索结果数量也就越少
		ArrayList<CommodityPO> pos = comdata.fuzzyFindCommodity(s,precision);
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for(int i=0;i<pos.size();i++)
			result.add(new MockCommodity(pos.get(i)).toVO());
		return result;
	}
	public boolean addPack(ArrayList<MockCommodity> commodityarray,int quantity, double discount)
	{
		//comdata.a
		return true;
	}
	public RM addCommodity(CommodityVO vo)
	{
		CommodityPO po=comdata.findCommodity(vo.getName(),vo.getModel());
		if(po!=null)
			return RM.redundance;
		else
		{
			MockCommodity com=new MockCommodity(vo);
			com.setNumber(0);
			com.setLastin(-1);
			com.setLastout(-1);
			RM result = comdata.insert(com.toPO());
			return result;
		}
	}
	public RM addCategory(CategoryVO vo)
	{
		return comdata.insert(new StubCategory(vo).toPO());
	}
	public void setcomdata(StubCommodityDataService comdata)
	{
		this.comdata=comdata;
	}
	public RM checkIn(String id, String name, String model, int quantity, double price)
	{//入库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		int num = com.getNumber();
		CommodityRecord r;
		if(price!=0)
		{
			com.setLastin(price);
			//下面调整平均进价
			if(!com.hasIn())
				com.setIn(price);//如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total=com.getIn()*com.getNumber();
				total+=quantity*price;
				int quantitytemp=com.getNumber();
				quantitytemp+=quantity;
				com.setIn(total/quantitytemp);
			}
			r = new CommodityRecord(id,new Date(),0,quantity,0,quantity*price,0,quantity,0,quantity*price);
		}
		else
			r = new CommodityRecord(id,new Date(),0,quantity,0,0,0,0,0,0);
		com.setNumber(num+quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = comdata.update(com.toPO());
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM checkOut(String id, String name, String model, int quantity, double price)
	{//出库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		int num = com.getNumber();
		if(num<quantity)
			return RM.insufficient;
		CommodityRecord r;
		if(price!=0)
		{
			com.setLastout(price);
			//下面调整平均进价
			if(!com.hasOut())
				com.setOut(price);//如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total=com.outTotal();
				total+=quantity*price;
				int quantitytemp=com.outQuantity();
				quantitytemp+=quantity;
				com.setOut(total/quantitytemp);
			}
			r = new CommodityRecord(id,new Date(),quantity,0,quantity*price,0,quantity,0,quantity*price,0);
		}
		else
			r = new CommodityRecord(id,new Date(),quantity,0,0,0,0,0,0,0);//报损不改变销售数量和金额
		com.setNumber(num-quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = comdata.update(com.toPO());
		int shortage = com.checkAlert();
		if(shortage>0)
		{
			StubAlertBill ab = new StubAlertBill(user.getID(),com,shortage);
			StubCommodityBill cb = new StubCommodityBill();
			cb.add(ab);
		}
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM readyForIn(String id,String name, String model, int quantity, double price)
	{//当进货单或销售退货单提交后，请调用
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		int num = com.getPotential();
		if(num<quantity)
			return RM.insufficient;
		CommodityRecord r = new CommodityRecord(id,new Date(),0,quantity,0,quantity*price,0,quantity,0,quantity*price);
		com.prepareAdd(r);
		boolean result = comdata.update(com.toPO());
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM readyForOut(String id,String name, String model, int quantity, double price)
	{//当销售单或进货退货单被提交后，请调用
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		if(com.getPotential()<quantity)
			return RM.insufficient;
		CommodityRecord r = new CommodityRecord(id,new Date(),quantity,0,quantity*price,0,quantity,0,quantity*price,0);
		com.prepareAdd(r);
		boolean result = comdata.update(com.toPO());
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM undoCheckIn(String id,String name, String model, int quantity, double price)
	{//当进货退货单被审批后，请调用
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		int num = com.getNumber();
		if(num<quantity)
			return RM.insufficient;
		//下面调整平均进价
		double total=com.getIn()*com.getNumber();
		total-=quantity*price;
		int quantitytemp=com.getNumber();
		quantitytemp-=quantity;
		if(quantitytemp!=0)
			com.setIn(total/quantitytemp);
		CommodityRecord r = new CommodityRecord(id,new Date(),0,quantity,0,quantity*price,0,quantity,0,quantity*price);
		com.setNumber(num-quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = comdata.update(com.toPO());
		int shortage = com.checkAlert();
		if(shortage>0)
		{
			StubAlertBill ab = new StubAlertBill(user.getID(),com,shortage);
			StubCommodityBill cb = new StubCommodityBill();
			cb.add(ab);
		}
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM undoCheckOut(String id,String name, String model, int quantity, double price)
	{//当销售退货单被审批后，请调用
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		int num = com.getNumber();
		CommodityRecord r;
		if(price!=0)
		{
			//下面调整平均进价
			if(!com.hasOut())
				com.setOut(price);//如果没有记录，进价仍然是添加商品时填写的，此时失去意义
			else
			{
				double total=com.outTotal();
				total-=quantity*price;
				int quantitytemp=com.outQuantity();
				quantitytemp-=quantity;
				if(quantitytemp!=0)
					com.setOut(total/quantitytemp);
			}
			r = new CommodityRecord(id,new Date(),quantity,0,quantity*price,0,quantity,0,quantity*price,0);
		}
		else
			r = new CommodityRecord(id,new Date(),quantity,0,0,0,0,0,0,0);
		com.setNumber(num+quantity);
		com.add(r);
		com.prepareDelete(r);
		boolean result = comdata.update(com.toPO());
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
	}
	public boolean isEnough(String name,String model,int n)
	{//在填写单据时检查，给出的是潜在库存最小值，也就是最保险的值
		CommodityPO po=comdata.findCommodity(name, model);
		MockCommodity com=new MockCommodity(po);
		int potential = com.getPotential();
		return(n<=potential);
	}
	public ArrayList<MockCommodity> posToCom(ArrayList<CommodityPO> h)
	{
		ArrayList<MockCommodity> result = new ArrayList<MockCommodity>();
		for(int i=0;i<h.size();i++)
		{
			result.add(new MockCommodity(h.get(i)));
		}
		return result;
	}
	public ArrayList<CommodityVO> toVOs(ArrayList<MockCommodity> h)
	{
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for(int i=0;i<h.size();i++)
		{
			result.add(h.get(i).toVO());
		}
		return result;
	}
	public ArrayList<StockVO> openCategory(String id)
	{
		ArrayList<StockPO> pos=comdata.openCategory(id);
		ArrayList<StockVO> vos=new ArrayList<StockVO>();
		for(int i=0;i<pos.size();i++)
		{
			StockPO stockpo=pos.get(i);
			if(stockpo.getT()==StockPO.Type.Category)
				vos.add(new StockVO(new StubCategory(stockpo.getCat()).toVO()));
			else
				vos.add(new StockVO(new MockCommodity(stockpo.getCom()).toVO()));
		}
		return vos;
	}
	public RM deleteCommodity(String name,String model)
	{
		RM result=comdata.deleteCommodity(name, model);
		return result;
	}
	public RM deleteCategory(String id)
	{
		RM result=comdata.deleteCategory(id);
		return result;
	}
	public RM updateCommodity(CommodityVO vo)
	{
		CommodityPO po=comdata.findCommodity(vo.getName(),vo.getModel());
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com = new MockCommodity(vo);
		double income = (com.getIn()-po.getIn())*com.getNumber();
		comdata.insert(new AdjustmentRecordPO(income));
		if(comdata.update(com.toPO()))
			return RM.done;
		else
			return RM.unknownerror;
	}
	public RM updateCategory(CategoryVO vo)
	{
		if(comdata.update(new StubCategory(vo).toPO()))
			return RM.done;
		else
			return RM.unknownerror;
	}
	public static StubCommodityDataService getComdata() {
		return comdata;
	}
	public static void setComdata(StubCommodityDataService comdata) {
		StubCommodityList.comdata = comdata;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getAdjustmentTotal(Date d1, Date d2)
	{//商品调价。这个返回值可能为正，也可能为负
		ArrayList<AdjustmentRecordPO> h = comdata.getAdjustmentRecords();
		double income=0;
		for(int i=0;i<h.size();i++)
		{
			AdjustmentRecordPO po = h.get(i);
			Date d = po.getDate();
			if(d.after(d1) && d.before(d2))
				income+=po.getIncome();
		}
		return income;
	}
	public CountVO count()
	{//库存盘点
		ArrayList<CommodityPO> temp = comdata.getAllCommodity();
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		for(int i=0;i<temp.size();i++)
			result.add(new MockCommodity(temp.get(i)).toVO());
		return new CountVO(result,new Date(),comdata.getCountNo());
	}
	
	public ArrayList<CommodityVO> getRecords(Date d1, Date d2)
	{//库存查看
		ArrayList<CommodityVO> result = new ArrayList<CommodityVO>();
		ArrayList<CommodityPO> temp = comdata.getAllCommodity();
		for(int i=0; i<temp.size();i++)
		{
			MockCommodity com = new MockCommodity(temp.get(i));
			com.computeRecordsTotal(d1, d2);
			result.add(com.toVO());
		}
		return result;
	}
}
