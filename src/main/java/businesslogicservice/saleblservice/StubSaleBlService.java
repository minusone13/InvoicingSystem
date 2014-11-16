package businesslogicservice.saleblservice;

import vo.CustomerVo;

public interface StubSaleBlService {
		/*
		 *这个接口包含了进货销售人员的任务
		 *分别是客户管理和进货和销售单据的增删改查
		 * */
	
		/*
		 *客户管理
		 * */
		public void addCustomer();
		public CustomerVo findCustomer(String id);
		public void deleteCustomer(String id);
		public void updateCustomer(String id);
		
		
		
}
