package presentation.financialui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.stockpo.CategoryPO;
import presentation.commodityui.StockManagerDriver;
import dataservice.commoditydataservice.StubCommodityDataService;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.VO;
import vo.accountVO.AccountVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import vo.inquiryVO.InquiryProcessVO;
import vo.inquiryVO.InquirySaleVO;
import vo.stockvo.CommodityVO;
import businesslogic.customerbl.Customer;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillbl.salebillController;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import businesslogicservice.financialblservice.FinancialBlService;

public class FinancialBLDriver {
	FinancialBlService fbs;
	
	static StockManagerDriver smd=new StockManagerDriver();
	//static StubCommodityDataService data=(StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController.getInstance()");
	static StubCommodityBlService combl;
	static StubStockController controller;
	static StubBillPool pool;
	static
	{
		//Initial initial=new Initial();
		//initial.initialAll();
		controller = new StubStockController();
		pool = controller.getPool();
		StubCommodityDataService data = null;
		try
		{
			data = (StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		smd.start(controller,data);
		combl=smd.getCombl();
	}
	
	public FinancialBLDriver (FinancialBlService fbs) {
		this.fbs = fbs;
	}
	
	public void drive() {
		
//		boolean result2 = fbs.addAccount("ICBC", 100);
//		if(result2==true) System.out.println("ADD SUCCESS!");
//		
//		
//		
//		boolean result3 = fbs.addAccount("BC", 100);
//		if(result2==true) System.out.println("ADD SUCCESS!");
		
		//boolean result5 = fbs.updateAccount("00001", "00100");
		//if(result5==true) System.out.println("UPDATE SUCCESS!");
		
//		
//		test.initial();
//		test.testGiftBill();
//		test.initial();
//		test.SpillsLossBillLoss();
//		test.initial();
//		test.SpillsLossBillSpills();
//		test.initial();
//		test.testAlertBillID();
		
//		testcreatReceipt();
//		testcreatPayment("MAJOR") ;
//		testcreatPayment("M");
//		testcreatCashPayment();
//		
//		testCreateSaleSheet();
//		testCreateSaleBackSheet();
//		testCreatePurSheet();
//		testCreatePurBackSheet();
//		
		//fbs.buildAccount();
		
		/*
		testgetReceipt();
		testgetPayment();
		testgetCashPayment();
		*/
		//testInquiry01();
	}
	
	public void initial()
	{
		//Initial initial=new Initial();
		//initial.initialAll();
		StubCommodityDataService data = null;
		try
		{
			data = (StubCommodityDataService)Naming.lookup("rmi://127.0.0.1:1099/StubStockDataController.getInstance()");
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (NotBoundException e)
		{
			e.printStackTrace();
		}
		smd.start(new StubStockController(),data);
		try
		{
			data.insert(new CategoryPO("1", "灯"));
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		try
		{
			data.insert(new CategoryPO("1\\灯","日光灯"));
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		try
		{
			data.insert(new CategoryPO("1\\灯\\日光灯","纯白日光灯"));
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		try
		{
			data.insert(new CategoryPO("1", "门"));
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
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
	
	public void testCreateSaleSheet() {
		SaleSheetVO vo = new SaleSheetVO();
		Customer customer = new Customer(); 
		vo.setCustomer(customer.getVO());
		customer.setname("梅少");
		vo.setid("XSD-2014-12-14-00009");
		vo.setCustomer(customer.getVO());
		vo.setdate(new Date());
		vo.setdiscount(20.0);
		vo.setmoney1(100.0);
		vo.setmoney2(10.0);
		vo.setpmoney(70.0);
		vo.setstock("1");
		vo.setusername("学长");
		vo.setuserid("208");
		vo.setop("学长208");
		ArrayList<CommodityVO> sheet = new ArrayList<CommodityVO>();
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300,10);
		sheet.add(mockvo);
		vo.setsheet(sheet);
		ArrayList<String> wordslist = new ArrayList<String>();
		wordslist.add("aaa");
		vo.setcommoditywords(wordslist);
		vo.setwords("我是备注");
		salebillController controller = new salebillController();
		boolean result1 = controller.createSaleSheet(vo);
	}
	
	public void testCreateSaleBackSheet() {
		SaleBackSheetVO vo = new SaleBackSheetVO();
		Customer customer = new Customer(); 
		vo.setCustomer(customer.getVO());
		customer.setname("梅少");
		vo.setCustomer(customer.getVO());
		vo.setid("XSTHD-2014-12-14-00009");
		vo.setdate(new Date());
		vo.setdiscount(20.0);
		vo.setmoney1(100.0);
		vo.setmoney2(10.0);
		vo.setpmoney(70.0);
		vo.setstock("1");
		vo.setusername("学长");
		vo.setuserid("208");
		vo.setop("学长208");
		ArrayList<CommodityVO> sheet = new ArrayList<CommodityVO>();
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300,10);
		sheet.add(mockvo);
		vo.setsheet(sheet);
		ArrayList<String> wordslist = new ArrayList<String>();
		wordslist.add("aaa");
		vo.setcommoditywords(wordslist);
		vo.setwords("我是备注");
		salebillController controller = new salebillController();
		boolean result2 = controller.createSaleBackSheet(vo);
	}
	
	public void testCreatePurSheet(){
		PurSheetVO vo = new PurSheetVO();
		salebillController controller = new salebillController();
		Customer customer = new Customer("CC"); 
		vo.setCustomer(customer.getVO());
		vo.setdate(new Date());
		vo.setstock("1");
		vo.setusername("学长");
		vo.setid("JHD-2014-12-14-00009");
		vo.setuserid("208");
		vo.setop("学长208");
		ArrayList<CommodityVO> sheet = new ArrayList<CommodityVO>();
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300,10);
		sheet.add(mockvo);
		vo.setsheet(sheet);
		ArrayList<String> wordslist = new ArrayList<String>();
		wordslist.add("aaa");
		vo.setcommoditywords(wordslist);
		vo.setwords("我是备注");
		vo.setmoney1(100.0);
		boolean result3 = controller.createPurSheet(vo);
	}
	
	public void testCreatePurBackSheet(){
		PurBackSheetVO vo = new PurBackSheetVO();
		salebillController controller = new salebillController();
		Customer customer = new Customer("CC"); 
		vo.setCustomer(customer.getVO());
		vo.setdate(new Date());
		vo.setid("JHTHD-2014-12-14-00009");
		vo.setstock("1");
		vo.setusername("学长");
		vo.setuserid("208");
		vo.setop("学长208");
		ArrayList<CommodityVO> sheet = new ArrayList<CommodityVO>();
		CommodityVO mockvo=new CommodityVO("1\\门","好好防盗门","fdm02",200,300,10);
		sheet.add(mockvo);
		vo.setsheet(sheet);
		ArrayList<String> wordslist = new ArrayList<String>();
		wordslist.add("aaa");
		vo.setcommoditywords(wordslist);
		vo.setwords("我是备注");
		vo.setmoney1(100.0);
		boolean result3 = controller.createPurBackSheet(vo);
	}
	public void testInquiry01() {
		InquiryProcessVO ipv = new InquiryProcessVO();
		//ipv.setTimeBefore("2014/12/13");
		//ipv.setTimeAfter("2014/12/14");
		ipv.setCustomer("MAJOR");
		
		ArrayList<PaymentVO> cp = fbs.getProcessPayment(ipv);
		System.out.println("Inquiry-------------------------");
		System.out.println(cp.size());
		PaymentVO vo = cp.get(0);
		
		System.out.println("Payment:　"+vo.getID());
		System.out.println("Payment:　"+vo.getCustomer());
		System.out.println("Payment:　"+ vo.getOp());
				
		System.out.println("Payment:　"+vo.getTotal());
		System.out.println("Payment:　"+vo.getBillState());
	}
	public void testcreatReceipt() {
		ReceiptVO vo = new ReceiptVO();
		vo.setCustomer("MAJOR");
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> accounts = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		accounts.add("ICBC");  money.add(100.00);  remark.add("");
		accounts.add("BC");  money.add(500.00);  remark.add("dinner");
		vo.setAccounts(accounts);
		vo.setMoney(money);
		vo.setRemark(remark);
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.SUBMITED);
		boolean result5 = fbs.creatReceipt(vo);  
		
		
	}

	public void testgetReceipt() {
		ArrayList<ReceiptVO> receipts = fbs.getAllOfReceiptBills();
		ReceiptVO vo = receipts.get(0);
		System.out.println("Receipt: "+receipts.size());
		//assertEquals("SKD-20141209-00001", vo.getID());
		
		System.out.println("Receipt: "+vo.getCustomer());
		System.out.println("Receipt: "+vo.getOp());
		System.out.println("Receipt: "+vo.getTotal());
		System.out.println("Receipt: "+vo.getBillState());
	}
	
	
	public void testcreatPayment(String s) {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer(s);
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> accounts = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		accounts.add("ICBC");  money.add(100.00);  remark.add("");
		accounts.add("BC");  money.add(100.00);  remark.add("dinner");
		vo.setAccounts(accounts);
		vo.setMoney(money);
		vo.setRemark(remark);
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.DRAFT);
		boolean result6 = fbs.creatPayment(vo);  
		
	}
	
	public void testgetPayment() {
		ArrayList<PaymentVO> payments = fbs.getAllOfPaymentBills();	
		if(payments.size() == 0) return;
		PaymentVO vo = payments.get(0);
		
		
		//assertEquals(1,payments.size());
		System.out.println("Payment:　" +vo.getID());
		System.out.println("Payment:　"+payments.size());
		System.out.println("Payment:　"+vo.getID());
		System.out.println("Payment:　"+vo.getCustomer());
		System.out.println("Payment:　"+ vo.getOp());
				
		System.out.println("Payment:　"+vo.getTotal());
		System.out.println("Payment:　"+vo.getBillState());
		
	}
	
	public void testcreatCashPayment() {
		CashPaymentVO vo = new CashPaymentVO();
		
		ArrayList<Double> money = new ArrayList<Double>();//转账金额
		ArrayList<String> item = new ArrayList<String>();
		ArrayList<String> remark =new ArrayList<String>();
		
		item.add("dinner");  money.add(100.00);  remark.add("");
		
		vo.setItem(item);
		vo.setMoney(money);
		vo.setRemark(remark);
		vo.setAccount("ICBC");
		double total=0;
		for(int i=0;i<money.size();i++) total+=money.get(i);
		vo.setTotal(total);
		vo.setBillState(BillState.SUBMITED);
		boolean result6 = fbs.creatCashPayment(vo);  
		
	}
	
	public void testgetCashPayment() {
		ArrayList<CashPaymentVO> cashPayments = fbs.getAllOfCashPaymentBills();
		System.out.println(cashPayments.size());
		CashPaymentVO vo = cashPayments.get(0);
		//assertEquals(1,cashPayments.size());
	//	assertEquals("XJFYD-20141209-00001", vo.getID());
		
		System.out.println("CashPayment: "+vo.getID());
		System.out.println("CashPayment: "+vo.getAccount());
		System.out.println("CashPayment: "+vo.getItem());
		
		System.out.println("CashPayment: "+vo.getAccount());
		System.out.println("CashPayment: "+vo.getOp());
		//assertEquals(100.0,vo.getTotal());
		System.out.println("CashPayment: "+vo.getBillState());
	}
}
