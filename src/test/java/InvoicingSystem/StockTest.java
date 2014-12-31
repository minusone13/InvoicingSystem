package InvoicingSystem;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.*;

import po.BillState;
import po.BillStyle;
import po.RM;
import po.stockpo.*;
import po.stockpo.StockPO.Type;
import presentation.commodityui.StockManagerDriver;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.commoditybl.StubPack;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForFinancial;
import businesslogic.stockservice.StockBlForManager;
import businesslogic.stockservice.StockBlForSalesMen;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import data.commoditydata.*;
import data.initial.Initial;
import dataservice.commoditydataservice.StubCommodityDataService;
import vo.*;
import vo.stockvo.*;


public class StockTest{
	static StockManagerDriver smd=new StockManagerDriver();
	static StubStockDataController data;
	static StubCommodityBlService combl;
	static StubStockController controller;
	static StubBillPool pool;
	static
	{
		try
		{
			data=StubStockDataController.getInstance();
		}
		catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Initial initial=new Initial();
		initial.initialAll();
		controller = new StubStockController();
		pool = controller.getPool();
		smd.start(controller,data);
		combl=smd.getCombl();
	}
	
	@Before
	public void initial()
	{
		Initial initial=new Initial();
		initial.initialAll();
		smd.start(new StubStockController(),data);
			try
			{
				data.insert(new CategoryPO("1", "灯"));
				data.insert(new CategoryPO("1\\灯","日光灯"));
				data.insert(new CategoryPO("1\\灯\\日光灯","纯白日光灯"));
				data.insert(new CategoryPO("1", "门"));
			}
			catch (RemoteException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		controller.checkIn("JHD-20141204-00001", "好好防盗门", "fdm05", 50, 150);
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
	public void testaddCategoryRedundance() throws RemoteException
	{
		assertEquals(RM.redundance,data.insert(new CategoryPO("1", "灯")));
	}
	
	@Test
	public void testaddCategory() throws RemoteException
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
	public void testaddCategorytreeerror() throws RemoteException
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
	public void testUpdateCategory1()
	{
		CategoryVO vo = new CategoryVO("1\\灯\\日光灯","纯白日光灯");
		ArrayList<StockVO> vos = combl.openCategory("1\\灯\\日光灯");
		int oldSize = vos.size();
		combl.updateCategory(vo,"纯黑日光灯");
		vos = combl.openCategory("1\\灯\\日光灯");
		assertEquals("纯黑日光灯",vos.get(0).getCat().getName());
		assertEquals(oldSize,vos.size());
	}
	
	@Test
	public void testUpdateCategory2()
	{
		CategoryVO vo = new CategoryVO("1","门");
		ArrayList<StockVO> vos = combl.openCategory("1\\门");
		int oldSize = vos.size();
		vos = combl.openCategory("1");
		combl.updateCategory(vo, "大门");
		vos = combl.openCategory("1\\大门");
		for(int i=0;i<vos.size();i++)
		{
			String s = vos.get(i).getCom().getId();
			String a[] = s.split("\\\\");
			assertEquals("1",a[0]);
			assertEquals("大门",a[1]);
		}
		assertEquals(oldSize,vos.size());
		vos = combl.openCategory("1\\门");
		assertEquals(null,vos);
		if(vos != null)
			assertEquals(0,vos.size());
	}
	
	@Test
	public void testUpdateCategory3()
	{
		CategoryVO vo = new CategoryVO("1","灯");
		ArrayList<StockVO> vos = combl.openCategory("1\\灯");
		int oldSize = vos.size();
		vos = combl.openCategory("1");
		combl.updateCategory(vo, "闪光灯");
		vos = combl.openCategory("1\\闪光灯");

			String s = vos.get(0).getCat().getId();
			String a[] = s.split("\\\\");
			assertEquals("1",a[0]);
			assertEquals("闪光灯",a[1]);
			assertEquals("日光灯",a[2]);
			ArrayList<StockVO> vostemp = combl.openCategory(s);
			s = vostemp.get(0).getCat().getId();
			a = s.split("\\\\");
			assertEquals("1",a[0]);
			assertEquals("闪光灯",a[1]);
			assertEquals("日光灯",a[2]);
			assertEquals("纯白日光灯",a[3]);
		assertEquals(oldSize,vos.size());
		vos = combl.openCategory("1\\灯");
		assertEquals(null,vos);
		if(vos != null)
			assertEquals(0,vos.size());
	}
	
	@Test
	public void testdeleteCategory()
	{
		ArrayList<StockVO> vos = combl.openCategory("1\\灯\\日光灯");
		int oldSize = vos.size();
		RM result = combl.deleteCategory("1\\灯\\日光灯\\纯白日光灯");
		assertEquals(RM.done,result);
		vos = combl.openCategory("1\\灯\\日光灯");
		assertEquals(oldSize-1, vos.size());
	}
	
	@Test
	public void testdeleteCategoryAlreadyHave()
	{
		ArrayList<StockVO> vos = combl.openCategory("1");
		int oldSize = vos.size();
		RM result = combl.deleteCategory("1\\门");
		assertEquals(RM.alreadyHaveUnremoveableContents,result);
		vos = combl.openCategory("1");
		assertEquals(oldSize, vos.size());
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
	
	@Test
	public void teststockForSalesMenAlert()
	{
		int h1 = pool.getAlertBill().size();
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 41, 300);
		assertEquals(RM.done,result);
		ArrayList<StubAlertBill> h2 = pool.getAlertBill();
		assertEquals(h1+1,h2.size());
	}
	
	@Test
	public void testGiftBill() throws RemoteException
	{
		boolean b;
		GiftBillVO vo = new GiftBillVO();
		ArrayList<CommodityVO> coms = new ArrayList<CommodityVO>();
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		CommodityVO com = new MockCommodity(po).toVO();
		com.setNumber(10);
		coms.add(com);
		vo.setComs(coms);
		
		
		RM result = combl.creat(vo);
		assertEquals(RM.done,result);
		StockBlForSalesMen sc=new StubStockController();
		b = sc.isEnough("好好防盗门", "fdm05", 41);
		assertTrue(b);
		
		StubGiftBill gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		result = combl.submit(gb.getVO());
		assertEquals(RM.done,result);
		b = sc.isEnough("好好防盗门", "fdm05", 40);
		assertTrue(b);
		b = sc.isEnough("好好防盗门", "fdm05", 41);
		assertTrue(!b);
		
		gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		pool.transformState(BillStyle.GiftBill, gb.getID(), BillState.EXAMINED);
		result = combl.over(gb.getVO());
		assertEquals(RM.done,result);
		po = data.findCommodity("好好防盗门", "fdm05");
		assertEquals(40,po.getNumber());
	}
	
	@Test
	public void SpillsLossBillLoss() throws RemoteException
	{
		boolean b;
		SpillsLossBillVO vo = new SpillsLossBillVO();
		CommodityPO compo = data.findCommodity("好好防盗门", "fdm05");
		CommodityVO com = new MockCommodity(compo).toVO();
		com.setNumber(10);
		vo.setCom(com);
		vo.setT(po.SpillsLossBillPO.Type.Loss);
		
		
		RM result = combl.creat(vo);
		assertEquals(RM.done,result);
		StockBlForSalesMen sc=new StubStockController();
		b = sc.isEnough("好好防盗门", "fdm05", 41);
		assertTrue(b);
		
		StubSpillsLossBill gb = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		result = combl.submit(gb.getVO());
		assertEquals(RM.done,result);
		b = sc.isEnough("好好防盗门", "fdm05", 40);
		assertTrue(b);
		b = sc.isEnough("好好防盗门", "fdm05", 41);
		assertTrue(!b);
		
		gb = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		pool.transformState(BillStyle.SpillsLossBill, gb.getID(), BillState.EXAMINED);
		result = combl.over(gb.getVO());
		assertEquals(RM.done,result);
		CommodityPO compo1 = data.findCommodity("好好防盗门", "fdm05");
		assertEquals(40,compo1.getNumber());
		assertEquals(compo.getAlertLine(),compo1.getAlertLine());
		assertEquals(compo.getIn(),compo1.getIn(),0.001);
		assertEquals(compo.getOut(),compo1.getOut(),0.01);
		assertEquals(compo.getLastin(),compo1.getLastIn(),0.01);
		assertEquals(compo.getLastOut(),compo1.getLastOut(),0.01);
	}
	
	@Test
	public void SpillsLossBillSpills() throws RemoteException
	{
		boolean b;
		SpillsLossBillVO vo = new SpillsLossBillVO();
		CommodityPO compo = data.findCommodity("好好防盗门", "fdm05");
		CommodityVO com = new MockCommodity(compo).toVO();
		com.setNumber(20);
		vo.setCom(com);
		vo.setT(po.SpillsLossBillPO.Type.Spills);
		
		
		RM result = combl.creat(vo);
		assertEquals(RM.done,result);
		StockBlForSalesMen sc=new StubStockController();
		b = sc.isEnough("好好防盗门", "fdm05", 50);
		assertTrue(b);
		
		StubSpillsLossBill gb = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		result = combl.submit(gb.getVO());
		assertEquals(RM.done,result);
		b = sc.isEnough("好好防盗门", "fdm05", 50);
		assertTrue(b);
		b = sc.isEnough("好好防盗门", "fdm05", 60);
		assertTrue(!b);
		
		gb = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		pool.transformState(BillStyle.SpillsLossBill, gb.getID(), BillState.EXAMINED);
		result = combl.over(gb.getVO());
		assertEquals(RM.done,result);
		b = sc.isEnough("好好防盗门", "fdm05", 70);
		assertTrue(b);
		CommodityPO compo1 = data.findCommodity("好好防盗门", "fdm05");
		assertEquals(70,compo1.getNumber());
		assertEquals(compo.getAlertLine(),compo1.getAlertLine());
		assertEquals(compo.getIn(),compo1.getIn(),0.001);
		assertEquals(compo.getOut(),compo1.getOut(),0.01);
		assertEquals(compo.getLastin(),compo1.getLastIn(),0.01);
		assertEquals(compo.getLastOut(),compo1.getLastOut(),0.01);
	}
	
	@Test 
	public void testAlertBillID()
	{
		StockBlForSalesMen sc=new StubStockController();
		RM result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 41, 300);
		assertEquals(RM.done,result);
		result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 1, 300);
		assertEquals(RM.done,result);
		result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 1, 300);
		assertEquals(RM.done,result);
		result=sc.checkOut("XSD-20141206-00001", "好好防盗门", "fdm05", 1, 300);
		assertEquals(RM.done,result);
		ArrayList<StubAlertBill> h2 = pool.getAlertBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		for(int i=0; i<h2.size(); i++)
		{
			String s = h2.get(i).getID();
			String a[] = s.split("-");
			assertTrue(a[0].equals("BJD"));
			assertTrue(a[1].equals(currentTime));
			assertTrue(a[2].equals(String.format("%05d", i+1)));
		}
	}
	
	@Test
	public void testSpillsLossBillID() throws RemoteException
	{
		SpillsLossBillVO vo = new SpillsLossBillVO();
		CommodityPO compo = data.findCommodity("好好防盗门", "fdm05");
		CommodityVO com = new MockCommodity(compo).toVO();
		com.setNumber(20);
		vo.setCom(com);
		vo.setT(po.SpillsLossBillPO.Type.Spills);
		
		
		RM result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		
		ArrayList<StubSpillsLossBill> h2 = pool.getSpillsLossBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		for(int i=0; i<h2.size(); i++)
		{
			String s = h2.get(i).getID();
			String a[] = s.split("-");
			assertTrue(a[0].equals("YSD"));
			assertTrue(a[1].equals(currentTime));
			assertTrue(a[2].equals(String.format("%05d", i+1)));
		}
	}
	
	@Test
	public void testgiftBillID() throws RemoteException
	{
		GiftBillVO vo = new GiftBillVO();
		ArrayList<CommodityVO> coms = new ArrayList<CommodityVO>();
		CommodityPO po = data.findCommodity("好好防盗门", "fdm05");
		CommodityVO com = new MockCommodity(po).toVO();
		com.setNumber(10);
		coms.add(com);
		vo.setComs(coms);
		
		
		RM result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		result = combl.creat(vo);
		assertEquals(RM.done,result);
		
		ArrayList<StubGiftBill> h2 = pool.getGiftBill();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		for(int i=0; i<h2.size(); i++)
		{
			String s = h2.get(i).getID();
			String a[] = s.split("-");
			assertTrue(a[0].equals("ZSD"));
			assertTrue(a[1].equals(currentTime));
			assertTrue(a[2].equals(String.format("%05d", i+1)));
		}
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
	public void testaddPack() throws RemoteException
	{
		StockBlForSalesMen sc=new StubStockController();
		StockBlForManager m = new StubStockController();
		CommodityPO compo = data.findCommodity("好好防盗门", "fdm05");
		int oldNum = compo.getNumber();
		CommodityVO vo = combl.findCommodity("好好防盗门", "fdm05");
		MockCommodity com = new MockCommodity(vo);
		ArrayList<MockCommodity> h = new ArrayList<MockCommodity>();
		com.setNumber(2);
		h.add(com);
		//StubPack pack = new StubPack(h,10,300);
		RM rm = m.addPack(h,10,100);
		assertEquals(RM.done,rm);
		ArrayList<PackPO> packs = data.getAllPacks();
		PackPO packpo = packs.get(0);
		assertEquals(300,packpo.getPrice(),0.001);
		boolean result = sc.isEnough("好好防盗门", "fdm05", 30);
		assertTrue(result);
		result = sc.isEnough("好好防盗门", "fdm05", 31);
		assertFalse(result);
		
		result = sc.isEnough(packpo.getID(),10);
		assertTrue(result);
		result = sc.isEnough(packpo.getID(),11);
		assertFalse(result);
		rm = sc.readyForOut("XSD-20141206-00003", packpo.getID(), 8, 300);
		result = sc.isEnough(packpo.getID(),2);
		assertTrue(result);
		result = sc.isEnough(packpo.getID(),3);
		assertFalse(result);
		
		rm = sc.checkOut("XSD-20141206-00003", packpo.getID(), 2, 300);
		assertEquals(RM.done,rm);
		result = sc.isEnough("好好防盗门", "fdm05", 30);
		assertTrue(result);
		result = sc.isEnough("好好防盗门", "fdm05", 31);
		assertFalse(result);
		compo = data.findCommodity("好好防盗门", "fdm05");
		assertEquals(oldNum-4,compo.getNumber());
		result = sc.isEnough(packpo.getID(),8);
		assertTrue(result);
		result = sc.isEnough(packpo.getID(),9);
		assertFalse(result);
		packs = data.getAllPacks();
		packpo = packs.get(0);
		assertEquals(8,packpo.getQuantity());
	}
	
	@Test
	public void testLastOut() throws RemoteException
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
	public void testIn() throws RemoteException
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
	public void testOut() throws RemoteException
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
	public void testundoIn() throws RemoteException
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
	
	@Test
	public void testCount()
	{
		CountVO coms = combl.count();
		assertEquals(5,coms.getList().size());
		assertEquals(1,coms.getNo());
		coms = combl.count();
		assertEquals(2,coms.getNo());
		coms = combl.count();
		assertEquals(3,coms.getNo());
	}
	
	@Test
	public void testExportCount()
	{
		combl.ExportCount("testCount.xls",combl.count());
		assertTrue(true);
	}
	
	@Test
	public void testKuCunChaKan()
	{
		ArrayList<CommodityVO> coms = combl.getRecords(new Date(), new Date());
		assertEquals(5,coms.size());
		Date d1 = new Date(107,1,1);
		Date d2 = new Date(120,1,1);
		coms = combl.getRecords(d1, d2);
		CommodityVO com1 = coms.get(1);
		assertEquals(7500,com1.getRecord().get(0).getImportamount(),0.01);
		assertEquals(7500,com1.getRecord().get(0).getInamount(),0.01);
		assertEquals(50,com1.getRecord().get(0).getImportquantity());
		assertEquals(50,com1.getRecord().get(0).getInquantity());
		assertEquals(0,coms.get(0).getRecord().get(0).getInquantity());
		assertEquals(0,coms.get(0).getRecord().get(0).getOutquantity());
	}
	
	@AfterClass
	public static void end()
	{
		StockTest st = new StockTest();
		st.initial();
		controller.checkIn("JHD-20141204-00002","迪迪防盗门","dd02", 20, 500);
		
		//创建赠送单
		GiftBillVO vo = new GiftBillVO();
		ArrayList<CommodityVO> coms = new ArrayList<CommodityVO>();
		CommodityPO po = null;
		try
		{
			po = data.findCommodity("好好防盗门", "fdm05");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommodityVO com = new MockCommodity(po).toVO();
		com.setNumber(10);
		coms.add(com);
		try
		{
			po = data.findCommodity("迪迪防盗门","dd02");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		com = new MockCommodity(po).toVO();
		com.setNumber(5);
		coms.add(com);
		vo.setComs(coms);
		String remark[] = {"测试","未知"};
		vo.setRemark(remark);
		
		System.out.println("0"+pool.getAlertBill().size());
		combl.creat(vo);
		StockBlForSalesMen sc=new StubStockController();
		
		StubGiftBill gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		combl.submit(gb.getVO());
		
		gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		pool.transformState(BillStyle.GiftBill, gb.getID(), BillState.EXAMINED);
		combl.over(gb.getVO());
		
		//创建第二个赠送单，同时会产生一个报警单
		vo = new GiftBillVO();
		coms = new ArrayList<CommodityVO>();
		try
		{
			po = data.findCommodity("好好防盗门", "fdm05");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		com = new MockCommodity(po).toVO();
		com.setNumber(26);
		coms.add(com);
		vo.setComs(coms);
		vo.setRemark(remark);
		combl.creat(vo);
		
		gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		combl.submit(gb.getVO());
		
		gb = pool.getGiftBill().get(pool.getGiftBill().size()-1);
		pool.transformState(BillStyle.GiftBill, gb.getID(), BillState.EXAMINED);
		combl.over(gb.getVO());
		
		
		//创建一个报损单，这张报损单没有提交，如果提交了将产生一个报警单
		SpillsLossBillVO vo1 = new SpillsLossBillVO();
		CommodityPO compo = null;
		try
		{
			compo = data.findCommodity("好好防盗门", "fdm05");
		}
		catch (RemoteException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CommodityVO com1 = new MockCommodity(compo).toVO();
		com1.setNumber(5);
		vo1.setCom(com1);
		vo1.setT(vo1.getT().Loss);
		
		combl.creat(vo1);
		sc.isEnough("好好防盗门", "fdm05", 41);
		
		StubSpillsLossBill gb1 = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		combl.submit(gb1.getVO());
		gb1 = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		pool.transformState(BillStyle.SpillsLossBill, gb1.getID(), BillState.EXAMINED);
		//combl.over(gb1.getVO());
		
		
		//创建一个报溢单
		vo1 = new SpillsLossBillVO();
		try
		{
			compo = data.findCommodity("好好防盗门", "fdm05");
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		com1 = new MockCommodity(compo).toVO();
		com1.setNumber(1);
		vo1.setCom(com1);
		vo1.setT(vo1.getT().Spills);
		
		combl.creat(vo1);
		sc.isEnough("好好防盗门", "fdm05", 41);
		
		gb1 = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		combl.submit(gb1.getVO());
		
		gb1 = pool.getSpillsLossBill().get(pool.getSpillsLossBill().size()-1);
		pool.transformState(BillStyle.SpillsLossBill, gb1.getID(), BillState.EXAMINED);
		combl.over(gb1.getVO());
	}
}
