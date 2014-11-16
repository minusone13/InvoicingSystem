package businesslogic.customerbl;

import java.util.ArrayList;

import vo.CustomerVO;
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
	
	public boolean addCustomer(String name) {
		if(name=="csc")
			return true;
		else
			return false;
		// TODO Auto-generated method stub
		
	}

	public RM updateCustomer(CustomerVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteCustomer(String id) {
		if(id=="131")
			return true;
		else
			return false;
	}

	public CustomerVO findCustomer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
