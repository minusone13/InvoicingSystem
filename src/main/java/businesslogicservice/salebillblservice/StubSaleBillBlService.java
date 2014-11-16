package businesslogicservice.salebillblservice;

import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;

public interface StubSaleBillBlService {
		/*
		 *这个接口包含了进货销售人员的任务
		 *分别是客户管理和进货和销售单据的增删改查
		 * */
	
		/*
		 *客户管理
		 * */
		public void createPurSheet();
		public void createPurBackSheet();
		public void createSaleSheet();
		public void createSaleBackSheet();
		
		//修改单据的状态
		public void changeState();
		
		public boolean getPurSheet(String id);
		public boolean getPurBackSheet(String id);
		public boolean getSaleSheet(String id);
		public boolean getSaleBackSheet(String id);
		
		
		
}
