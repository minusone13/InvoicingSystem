package InvoicingSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.*;

import po.stockpo.*;
import presentation.commodityui.StockManagerDriver;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForSalesMen;
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
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300,10);
		CommodityVO mockvo1=new CommodityVO("1\\门","好好防盗门","fdm05",100,200,15);
		StubCommodityBlService combl=smd.getCombl();
		combl.addCommodity(mockvo);
		combl.addCommodity(mockvo1);
		StubStockController contro=new StubStockController();
		contro.checkIn("JHD-20141206-00001", "好好防盗门", "fdm05", 50, 150);
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
		assertEquals(1,vos.size());
	}
	
	@Test
	public void testdeleteCommodityHasRecord()
	{
		RM result=combl.deleteCommodity("好好防盗门","fdm05");
		assertEquals(RM.alreadyHaveUnremoveableContents,result);
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
	
	@Test
	public void teststockForSalesMen()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		assertEquals(RM.done,result);
	}
	
	@Test
	public void teststockForSalesMenInsufficient()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 51, 300);
		assertEquals(RM.insufficient,result);
	}
	
	@Test
	public void teststockForSalesMenNotFound()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkIn("JHD-20141206-00001", "好好防盗门1", "fdm05", 50, 150);
		assertEquals(RM.notfound,result);
	}
	
	@Ignore
	public void teststockForSalesMenAlert()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkIn("JHD-20141206-00001", "好好防盗门", "fdm05", 50, 150);
		assertEquals(RM.done,result);
		//result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 41, 300);
		assertEquals(RM.done,result);
		StubBillPool pool = new StubBillPool();
		ArrayList<StubAlertBill> h = pool.getAlertBill();
		assertEquals(1,h.size());
	}
	
	@Test
	public void testreadyForCheckOut()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.readyForOut("JHD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		boolean b = sc.isEnough("好好防盗门", "fdm05", 31);
		assertTrue(!b);
		result = sc.readyForOut("JHD-20141206-00002", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.done,result);
		result = sc.readyForOut("JHD-20141206-00003", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.insufficient,result);
	}
	
	@Test
	public void testreadyForCheckOutComplex()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.readyForOut("JHD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("JHD-20141206-00001", "好好防盗门", "fdm05", 10, 200);
		assertEquals(RM.done,result);
		boolean b = sc.isEnough("好好防盗门", "fdm05", 31);
		assertTrue(b);
		result = sc.readyForOut("JHD-20141206-00002", "好好防盗门", "fdm05", 35, 200);
		assertEquals(RM.done,result);
		result = sc.readyForOut("JHD-20141206-00003", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.insufficient,result);
	}
	
	@Test
	public void testLastOut()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.readyForOut("JHD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("JHD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		double lastout = po.getLastOut();
		assertEquals(300,(int)lastout);
		assertEquals(RM.done,result);
		boolean b = sc.isEnough("好好防盗门", "fdm05", 31);
		assertTrue(b);
		result = sc.readyForOut("JHD-20141206-00002", "好好防盗门", "fdm05", 35, 200);
		assertEquals(RM.done,result);
		result = sc.readyForOut("JHD-20141206-00003", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.insufficient,result);
	}
}
