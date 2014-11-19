package InvoicingSystem;

import static org.junit.Assert.*;

import org.junit.*;

import po.stockpo.*;
import presentation.commodityui.StockManagerDriver;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.*;
import data.initial.Initial;
import dataservice.commoditydataservice.StubCommodityDataService;
import vo.*;
import vo.stockvo.*;


public class StockTest{
	static StockManagerDriver smd=new StockManagerDriver();
	static StubStockDataController data=StubStockDataController.getInstance();
	static
	{
		smd.start(new StubStockController(),data);
	}
	
	@Before
	public void initial()
	{
		Initial initial=new Initial();
		initial.initialStock();
		smd.start(new StubStockController(),data);
		data.insert(new CategoryPO("1", "灯"));
		data.insert(new CategoryPO("1\\灯","日光灯"));
		data.insert(new CategoryPO("1", "门"));
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300);
		StubCommodityBlService combl=smd.getCombl();
		combl.addCommodity(mockvo);
	}
	
	@Test
	public void testaddCommodity()
	{
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm01",200,300);
		StubCommodityBlService combl=smd.getCombl();
		RM result=combl.addCommodity(mockvo);
		System.out.println(result);
		assertEquals(RM.done,result);
		//if unknown error happended,it fails. details are in enum RM
	}
	
	@Test
	public void testaddCategoryRedundance()
	{
		assertEquals(RM.redundance,data.insert(new CategoryPO("1", "灯")));
	}
	
	@Test
	public void testaddCategory()
	{
		assertEquals(RM.done,data.insert(new CategoryPO("1\\灯","白炽灯")));
	}
	
	@Test
	public void testaddCommoditytreeerror()
	{
		CommodityVO mockvo=new CommodityVO("1\\灯","飞利浦日光灯","SR01",20,30);
		StubCommodityBlService combl=smd.getCombl();
		RM result=combl.addCommodity(mockvo);
		System.out.println(result);
		assertEquals(RM.treeerror,result);
		//if unknown error happended,it fails. details are in enum RM
	}
	
	@Test
	public void testaddCategorytreeerror()
	{
		assertEquals(RM.treeerror,data.insert(new CategoryPO("1\\门", "高级防盗门")));
	}
}
