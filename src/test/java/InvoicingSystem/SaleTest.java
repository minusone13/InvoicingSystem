package InvoicingSystem;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.LevelStrategyStyle;
import po.ReachStrategyStyle;
import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.customerbl.CustomerList;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;
import junit.framework.TestCase;

public class SaleTest extends TestCase{
		//SaleBillBlService sbbs=new salebillController();
		public void testTrue(){//added by lhw
			assertTrue(true);
		}
		
		/*public void testCreateSaleSheet() {
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
			assertTrue(result1);
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
			assertTrue(result2);
		}*/
		
		/*public void testCreatePurSheet(){
			PurSheetVO vo = new PurSheetVO();
			salebillController controller = new salebillController();
			Customer customer = new Customer("CC"); 
			vo.setCustomer(customer.getVO());
			vo.setdate(new Date());
			vo.setstock("1");
			//vo.setusername("学长");
			//vo.setuserid("208");
			//vo.setop("学长208");
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
			assertTrue(result3);
		}*/
		
		
		/*public void testCreatePurBackSheet(){
			PurBackSheetVO vo = new PurBackSheetVO();
			salebillController controller = new salebillController();
			Customer customer = new Customer("CC"); 
			vo.setCustomer(customer.getVO());
			vo.setdate(new Date());
		//	vo.setid("JHTHD-2014-12-14-00009");
			vo.setstock("1");
			//vo.setusername("学长");
			//vo.setuserid("208");
			//vo.setop("学长208");
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
			assertTrue(result3);
		}*/
		
		public void testgetPurSheet(){
			salebillController controller = new salebillController();
			boolean result5 = controller.getPurSheet("JHD-20141230-00001");
			System.out.println(controller.findPurSheet("JHD-20141230-00001").getcustomer().getname());
			assertTrue(result5);
		}
		
	/*	
		public void testgetPurBackSheet(){
			salebillController controller = new salebillController();
			ArrayList<PurBackSheetVO> list = controller.getAllPurBackSheet();
			System.out.println(list.size());
			System.out.println(controller.findPurBackSheet("JHTHD-20141230-00001").getcustomer().getname());
			boolean result6 = controller.getPurBackSheet("JHTHD-20141230-00001");
			assertTrue(result6);
		}
		
		/*
		public void testgetSaleSheet(){
			salebillController controller = new salebillController();
			boolean result7 = controller.getSaleSheet("XSD-2014-12-14-00009");
			assertTrue(result7);
		}
	
		public void testgetSaleBackSheet(){
			salebillController controller = new salebillController();
			boolean result8 = controller.getSaleBackSheet("XSTHD-2014-12-14-00009");
			assertTrue(result8);
		}*/
				
		/*public void testaddCustomer(){
			CustomerList customerlist = new CustomerList();
			Customer customer = new Customer("正中"); 
			boolean result9 = customerlist.addCustomer(customer.getVO());
			assertTrue(result9);
		}*/
		
		/*public void testaddCustomer(){
			CustomerList customerlist = new CustomerList();
			Customer customer = new Customer(); 
			customer.settype(1);
			customer.setname("小虎");
			customer.setid("customer22");
			customer.setaddress("南通市海门中学");
			customer.setphonenumber("136666");
			customer.setpostcode("226300");
			customer.setmaxOwe(5000.0);
			customer.setShouldGive(1000.0);
			customer.setShouldPay(200.0);
			customer.setdeSaler("学长");
			customer.setlevel(2);
			customer.setemail("xxh13@software.nju.edu.cn");
			boolean result9 = customerlist.addCustomer(customer);
			assertTrue(result9);
		}*/
		
		/*public void testdeleteCustomer(){
			CustomerList customerlist = new CustomerList();
			boolean result10=customerlist.deleteCustomer("小虎");
			assertTrue(result10);
		}*/
		
//		public void testfindCustomer(){
//			CustomerList customerlist = new CustomerList();
//			CustomerVO tempvo = null;
//			tempvo = customerlist.findCustomer("4");
//			System.out.println(tempvo.getname()+tempvo.getid());
//			
//			boolean result11=true;
//			tempvo.setShouldTake(100.0);
//			customerlist.updateCustomer(tempvo);
//			tempvo = customerlist.findCustomer("1");
//			System.out.println(tempvo.getShouldTake());
//			assertTrue(result11);
//		}

		/*public void testsureReachStrategy(){
			salebillController controller = new salebillController();
			String words = controller.sureLevelStrategy(5, 10000, "208", LevelStrategyStyle.Discount);
			System.out.println(words);
			boolean result12=false;
			assertTrue(result12);
		}*/
		
		
		
}
