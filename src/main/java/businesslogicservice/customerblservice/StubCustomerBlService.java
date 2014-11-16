package businesslogicservice.customerblservice;

import vo.CustomerVo;
import vo.RM;

public interface StubCustomerBlService {
		/*
		 * 这是关于客户管理的一个接口
		 * 提供了一些客户管理方面的方法
		 * */
	
		public void addCustomer();
		public RM updateCustomer(CustomerVo vo);
		public boolean deleteCustomer(String id);
		public CustomerVo findCustomer(String id);
		//public customerList getAllCustomer();
		
		/*
		 * 关于模糊查找我重新写个方法；
		 * */
}
