package businesslogicservice.customerblservice;

import java.util.ArrayList;

import vo.CustomerVO;
import vo.RM;

public interface CustomerBlService {
		/*
		 * 这是关于客户管理的一个接口
		 * 提供了一些客户管理方面的方法
		 * */
	
		public boolean addCustomer(String name);
		public RM updateCustomer(CustomerVO vo);
		public boolean deleteCustomer(String id);
		public CustomerVO findCustomer(String id);
		public ArrayList<CustomerVO> getCustomer(String address);
		public void saveCustomer(String address);
		
		/*
		 * 关于模糊查找我重新写个方法；
		 * */
}
