package InvoicingSystem;

import vo.CustomerVO;
import vo.SaleSheetVO;
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
