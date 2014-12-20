package presentation.saleui;

import java.rmi.RemoteException;

import businesslogicservice.customerblservice.CustomerBlService;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class CustomerDriver {
		CustomerBlService cbs;
		SaleBillBlService sbbs;
		
		public CustomerDriver(CustomerBlService cbs,SaleBillBlService sbbs){
			this.cbs=cbs;
			this.sbbs=sbbs;
		}
		
		public void drive(){
			//boolean result1=cbs.addCustomer("csc");
			//if(result1==true) System.out.println("addCustomer success!"); 
			boolean result2 = false;
			result2 = cbs.deleteCustomer("131");
			if(result2==true) System.out.println("deleteCustomer success!"); 
			boolean result3=sbbs.getPurBackSheet("131");
			if(result3==true) System.out.println("getPurBackSheet success!"); 
			boolean result4=sbbs.getPurSheet("131");
			if(result4==true) System.out.println("getPurSheet success!"); 
			boolean result5=sbbs.getSaleBackSheet("131");
			if(result5==true) System.out.println("getSaleBackSheet success!"); 
			boolean result6=sbbs.getSaleSheet("131");
			if(result6==true) System.out.println("getSaleSheet success!"); 
		}
}
