package businesslogic.commoditybl;

import java.util.ArrayList;

import po.*;
import po.stockpo.CommodityPO;
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
	public RM checkIn(String name, String model, int quantity, double price)
	{//入库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		return RM.done;
	}
	public RM checkOut(String name, String model, int quantity, double price)
	{//出库
		CommodityPO po=comdata.findCommodity(name,model);
		if(po==null)//not found
			return RM.notfound;
		MockCommodity com=new MockCommodity(po);
		return RM.done;
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
}
