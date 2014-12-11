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
import businesslogic.stockservice.StockBlForFinancial;
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
		CommodityVO mockvo2=new CommodityVO("1\\门","迪迪防盗门","dd02",100,200,15);
		CommodityVO mockvo3=new CommodityVO("1\\门","迪迪防盗门","dd05",100,200,15);
		CommodityVO mockvo4=new CommodityVO("1\\门","防火门","fire05",100,200,15);
		StubCommodityBlService combl=smd.getCombl();
		combl.addCommodity(mockvo);
		combl.addCommodity(mockvo1);
		combl.addCommodity(mockvo2);
		combl.addCommodity(mockvo3);
		combl.addCommodity(mockvo4);
		StubStockController contro=new StubStockController();
		contro.checkIn("JHD-20141204-00001", "好好防盗门", "fdm05", 50, 150);
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
		StubCommodityBlService combl=smd.getCombl();
		ArrayList<StockVO> vos=combl.openCategory("1");
		vos=combl.openCategory(vos.get(2).getCat().getId());
		int oldsize = vos.size();
		RM result=combl.deleteCommodity("好好防盗门","fdm02");
		assertEquals(RM.done,result);
		vos=combl.openCategory("1");
		vos=combl.openCategory(vos.get(2).getCat().getId());
		assertEquals(oldsize-1,vos.size());
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
		RM result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 41, 300);
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
		RM result = sc.readyForOut("XSD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 10, 200);
		assertEquals(RM.done,result);
		boolean b = sc.isEnough("好好防盗门", "fdm05", 31);
		assertTrue(b);
		result = sc.readyForOut("XSD-20141206-00002", "好好防盗门", "fdm05", 35, 200);
		assertEquals(RM.done,result);
		result = sc.readyForOut("XSD-20141206-00003", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.insufficient,result);
	}
	
	@Test
	public void testLastOut()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.readyForOut("XSD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		double lastout = po.getLastOut();
		assertEquals(300,(int)lastout);
		assertEquals(RM.done,result);
		boolean b = sc.isEnough("好好防盗门", "fdm05", 31);
		assertTrue(b);
		result = sc.readyForOut("XSD-20141206-00002", "好好防盗门", "fdm05", 35, 200);
		assertEquals(RM.done,result);
		result = sc.readyForOut("XSD-20141206-00003", "好好防盗门", "fdm05", 30, 200);
		assertEquals(RM.insufficient,result);
	}
	
	@Test
	public void testIn()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.readyForOut("XSD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		result = sc.checkIn("JHD-20141206-00002", "好好防盗门", "fdm05", 40, 50);
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		double in = po.getIn();
		assertEquals(100,(int)in);
		assertEquals(RM.done,result);
	}
	
	@Test
	public void testOut()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 20, 20);
		assertEquals(RM.done,result);
		result = sc.checkOut("XSD-20141206-00002", "好好防盗门", "fdm05", 20, 40);
		assertEquals(RM.done,result);
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		double out = po.getOut();
		assertEquals(30,(int)out);
	}
	
	@Test
	public void testundoIn()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result = sc.checkOut("XSD-20141206-00000", "好好防盗门", "fdm05", 10, 300);
		assertEquals(RM.done,result);
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		result = sc.readyForOut("XSD-20141206-00001", "好好防盗门", "fdm05", 20, 200);
		assertEquals(RM.done,result);
		result = sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		assertEquals(RM.done,result);
		sc.undoCheckOut("XSTHD-20141206-00001", "好好防盗门", "fdm05", 10, 300);
		result = sc.checkIn("JHD-20141206-00002", "好好防盗门", "fdm05", 40, 50);
		assertEquals(RM.done,result);
		result = sc.undoCheckIn("JHTHD-20141206-00002", "好好防盗门", "fdm05", 40, 50);
		assertEquals(RM.done,result);
		CommodityPO po1 = data.findCommodity("好好防盗门", "fdm05");
		assertEquals(po.getAlertLine(),po1.getAlertLine());
		assertEquals(po.getId(),po1.getId());
		assertEquals(po.getIn(),po1.getIn(),0.01);
		assertEquals(po.getOut(),po1.getOut(),0.01);
		assertEquals(po.getNumber(),po1.getNumber());
	}
	
	@Test
	public void testStockForFinancial()
	{
		StockBlForFinancial sf=new StubStockController();
		StubStockController sc=new StubStockController();
		ArrayList<CommodityVO> coms = sc.findCommodity("好好防盗门");
		CommodityVO com = coms.get(1);
		com.setIn(160);
		sc.updateCommodity(com);
		Date d1 = new Date();
		d1.setYear(100);
		Date d2 = new Date();
		d2.setYear(200);
		double result = sf.getAdjustmentTotal(d1, d2);
		assertEquals(500,(int)result);
	}
	
	@Test
	public void testStockForFinancialComplex()
	{
		StockBlForFinancial sf=new StubStockController();
		StubStockController sc=new StubStockController();
		ArrayList<CommodityVO> coms = sc.findCommodity("好好防盗门");
		CommodityVO com = coms.get(1);
		com.setIn(160);
		sc.updateCommodity(com);
		com.setIn(140);
		sc.updateCommodity(com);
		Date d1 = new Date();
		d1.setYear(100);
		Date d2 = new Date();
		d2.setYear(200);
		double result = sf.getAdjustmentTotal(d1, d2);
		assertEquals(-500,(int)result);
	}
	
	@Test
	public void testFuzzyFind()
	{
		ArrayList<CommodityVO> h = combl.fuzzyFindCommodity("好好门fd", 1);
		assertEquals(2,h.size());
		h = combl.fuzzyFindCommodity("门", 1);
		assertEquals(5,h.size());
		h = combl.fuzzyFindCommodity("15", 1);
		assertEquals(3,h.size());
		h = combl.fuzzyFindCommodity("防盗门", 1);
		assertEquals(4,h.size());
		h = combl.fuzzyFindCommodity("日光灯", 1);
		assertEquals(0,h.size());
		h = combl.fuzzyFindCommodity("好好防盗门fdm05", 1);
		assertEquals(1,h.size());
	}
}
