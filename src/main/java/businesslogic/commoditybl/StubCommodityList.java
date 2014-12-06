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
	User user=new User("I0001",Role.STOCK_STAFF,"default","default","default");
	public ArrayList<CommodityVO> findCommodity(String name)
	{
		ArrayList <CommodityPO> pos=comdata.findCommodity(name);
		ArrayList <MockCommodity> coms=posToCom(pos);
		ArrayList <CommodityVO> vos=toVOs(coms);
		return vos;
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
		com.setNumber(num+quantity);
		com.setLastin(price);
		//下面调整平均进价
		if(com.getRecord().size()==0)
			com.setIn(price);//如果没有记录，进价仍然是添加商品时填写的，此时失去意义
		else
		{
			double total=com.getIn()*com.getNumber();
			total+=quantity*price;
			int quantitytemp=com.getNumber();
			quantitytemp+=quantity;
			com.setIn(total/quantitytemp);
		}
		CommodityRecord r = new CommodityRecord(id,new Date(),0,quantity,0,price,0,quantity,0,price);
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
		com.setNumber(num-quantity);
		com.setLastout(price);
		//下面调整平均进价
		if(com.getRecord().size()==0)
			com.setOut(price);//如果没有记录，进价仍然是添加商品时填写的，此时失去意义
		else
		{
			double total=com.getIn()*com.getNumber();
			total-=quantity*price;
			int quantitytemp=com.getNumber();
			quantitytemp-=quantity;
			com.setIn(total/quantitytemp);
		}
		CommodityRecord r = new CommodityRecord(id,new Date(),quantity,0,price,0,quantity,0,price,0);
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
		CommodityRecord r = new CommodityRecord(id,new Date(),0,quantity,0,price,0,quantity,0,price);
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
		CommodityRecord r = new CommodityRecord(id,new Date(),quantity,0,price,0,quantity,0,price,0);
		com.prepareAdd(r);
		boolean result = comdata.update(com.toPO());
		if(result)
			return RM.done;
		else
			return RM.unknownerror;
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
		if(comdata.update(new MockCommodity(vo).toPO()))
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
}
