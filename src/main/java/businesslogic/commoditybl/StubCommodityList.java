package businesslogic.commoditybl;

import java.util.*;
import java.util.ArrayList;

import po.*;
import po.stockpo.*;
import businesslogic.stockmanagerbl.*;
import dataservice.commoditydataservice.*;
import vo.stockvo.*;
import vo.RM;

public class StubCommodityList {//商品列表 haha
	static StubCommodityDataService comdata;
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
		com.add(new CommodityRecord(new Date(),0,quantity,0,price,0,quantity,0,price));
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
		com.add(new CommodityRecord(new Date(),quantity,0,price,0,quantity,0,price,0));
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
}
