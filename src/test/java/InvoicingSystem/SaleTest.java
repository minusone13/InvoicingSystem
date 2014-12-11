package InvoicingSystem;

import java.util.ArrayList;
import java.util.Date;

import vo.CustomerVO;
import vo.SaleSheetVO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;
import junit.framework.TestCase;

public class SaleTest extends TestCase{
		SaleBillBlService sbbs=new salebillController();
		public void testTrue(){//added by lhw
			assertTrue(true);
		}
		
		public void testCreatSaleSheet() {
			SaleSheetVO vo = new SaleSheetVO();
			Customer customer = new Customer();
			customer.setname("梅少");
			vo.setCustomer(customer);
			vo.setuserid("002");
			vo.setdate(new Date());
			vo.setdiscount(20.0);
			vo.setmoney1(100.0);
			vo.setmoney2(10.0);
			vo.setpmoney(70.0);
			vo.setstock("1");
			vo.setusername("学长");
			vo.setuserid("208");
			vo.setop("学长208");
			vo.setsheet(new ArrayList<MockCommodity>());
			vo.setwords("我是备注");
			salebillController controller = new salebillController();
			boolean result1 = controller.createSaleSheet(vo);
			
			assertTrue(result1);
		}
		
		
		/*
		public void testgetPurBackSheet(){
			boolean result3=sbbs.getPurBackSheet("131");
			assertTrue(result3);
		}
		
		public void testgetPurSheet(){
			boolean result4=sbbs.getPurSheet("131");
			assertTrue(result4);
		}
		
		public void testgetSaleBackSheet(){
			boolean result5=sbbs.getSaleBackSheet("131");
			assertTrue(result5);
		}
		
		public void testgetSaleSheet(){
			boolean result5=sbbs.getSaleSheet("131");
			assertTrue(result5);
		}
		*/
		
}
