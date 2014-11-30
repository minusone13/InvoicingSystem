package InvoicingSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

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
	static StubCommodityBlService combl;
	static
	{
		smd.start(new StubStockController(),data);
		combl=smd.getCombl();
	}
	
	@Before
	public void initial()
	{
		Initial initial=new Initial();
		initial.initialStock();
		smd.start(new StubStockController(),data);
		data.insert(new CategoryPO("1", "灯"));
		data.insert(new CategoryPO("1\\灯","日光灯"));
		data.insert(new CategoryPO("1\\灯\\日光灯","纯白日光灯"));
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
		assertEquals(RM.treeerror,result);
		//if unknown error happended,it fails. details are in enum RM
	}
	
	@Test
	public void testaddCategorytreeerror()
	{
		assertEquals(RM.treeerror,data.insert(new CategoryPO("1\\门", "高级防盗门")));
	}
	
	@Test
	public void testopenCategory1()
	{
		StubCommodityBlService combl=smd.getCombl();
		ArrayList<StockVO> pos=combl.openCategory("1");
		assertEquals("1\\灯",pos.get(1).getCat().getId());
	}
	
	private CommodityVO testopenCategory()
	{
		StubCommodityBlService combl=smd.getCombl();
		ArrayList<StockVO> pos=combl.openCategory("1");
		pos=combl.openCategory(pos.get(2).getCat().getId());
		return pos.get(0).getCom();
	}
	
	@Test
	public void testopenCategory2()
	{
		CommodityVO com=testopenCategory();
		assertEquals("好好防盗门",com.getName());
		assertEquals("fdm02",com.getModel());
		//assertEquals(-1,com.getLastin(),0.1);
		//assertEquals(-1,com.getLastout(),0.1);
		assertEquals(200,com.getIn(),0.1);
		assertEquals(300,com.getOut(),0.1);
	}
	
	@Test
	public void testdeleteCommodity()
	{
		RM result=combl.deleteCommodity("好好防盗门","fdm02");
		assertEquals(RM.done,result);
	}
	
	@Test
	public void testdeleteCommodityNotFount()
	{
		RM result=combl.deleteCommodity("好好防盗门1","fdm02");
		assertEquals(RM.notfound,result);
	}
	
	@Test
	public void testdeleteCommodity2()
	{
		RM result=combl.deleteCommodity("好好防盗门","fdm02");
		StubCommodityBlService combl=smd.getCombl();
		ArrayList<StockVO> vos=combl.openCategory("1");
		vos=combl.openCategory(vos.get(2).getCat().getId());
		assertEquals(0,vos.size());
	}
	
	@Test
	public void teststockForFinancial()
	{
		StubStockController sc=new StubStockController();
		Date d1=new Date();
		Date d2=new Date();
		sc.getLossTotal(d1, d2);
		sc.getSpillsTotal(d1, d2);
		assertTrue(true);
	}
}
