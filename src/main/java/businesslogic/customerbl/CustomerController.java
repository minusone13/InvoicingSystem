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
	
	//获得所有客户
	public customerList getAllCustomer(){
		return null;
	}
	
	//用来返回以';'分界的一串符合模糊条件的数据；
	public String  fuzzySearch(String info){
		return null;
	}
	
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
