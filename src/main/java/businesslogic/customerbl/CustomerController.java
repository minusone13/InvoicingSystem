package businesslogic.customerbl;

import java.util.ArrayList;

import vo.CustomerVo;
import vo.RM;
import businesslogicservice.customerblservice.StubCustomerBlService;

public class CustomerController implements StubCustomerBlService{
	/*
	 * 没错我就是有点懒；
	 * */
	
	customerList customerlist;
	
	public void addCustomer() {
		// TODO Auto-generated method stub
		
	}

	public RM updateCustomer(CustomerVo vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCustomer(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public CustomerVo findCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
