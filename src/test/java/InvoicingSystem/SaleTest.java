package InvoicingSystem;

import businesslogic.customerbl.CustomerController;
import businesslogic.salebillbl.salebillController;
import businesslogicservice.customerblservice.StubCustomerBlService;
import businesslogicservice.salebillblservice.StubSaleBillBlService;
import junit.framework.TestCase;

public class SaleTest extends TestCase{
		StubCustomerBlService sbs=new CustomerController();
		StubSaleBillBlService sbbs=new salebillController();
		
		public void testaddCustomer(){
			boolean result1=sbs.addCustomer("csc");
			assertTrue(result1);
		}
		
		public void testdeleteCustomer(){
			boolean result2=sbs.deleteCustomer("131");
			assertTrue(result2);
		}
		
		public void getPurBackSheet(){
			boolean result3=sbbs.getPurBackSheet("131");
			assertTrue(result3);
		}
		
		public void getPurSheet(){
			boolean result4=sbbs.getPurSheet("131");
			assertTrue(result4);
		}
		
		public void getSaleBackSheet(){
			boolean result5=sbbs.getSaleBackSheet("131");
			assertTrue(result5);
		}
		
		public void getSaleSheet(){
			boolean result5=sbbs.getSaleSheet("131");
			assertTrue(result5);
		}
		
		
}
