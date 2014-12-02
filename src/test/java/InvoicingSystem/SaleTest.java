package InvoicingSystem;

import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.StubCustomerBlService;
import businesslogicservice.salebillblservice.StubSaleBillBlService;
import junit.framework.TestCase;

public class SaleTest extends TestCase{
		StubSaleBillBlService sbbs=new salebillController();
		
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
		
		
}
