package businesslogicservice.customerblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RM;
import businesslogic.customerbl.Customer;
import vo.CustomerVO;

public interface CustomerBlService {
		/*
		 * 这是关于客户管理的一个接口
		 * 提供了一些客户管理方面的方法
		 * */
	
		public boolean addCustomer(CustomerVO newCustomer);
		public boolean updateCustomer(CustomerVO vo);
		public boolean deleteCustomer(String id);
		public CustomerVO findCustomer(String id);
		public ArrayList<CustomerVO> getAllCustomer(String address);
		
		//    saveAllCustomer 方法;
		/*
		 * 关于模糊查找我重新写个方法；
		 * */
}
