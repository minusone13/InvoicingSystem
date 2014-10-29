package businesslogic.salebillbl;

import java.util.ArrayList;

import po.PO;
import vo.VO;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.StubCustomer;
import businesslogic.examinebl.Bill;

public class StubSaleSheet extends Bill implements GetVOandPO{
	/*String customer,
	 * String saler,
	 * ArrayList sheet,
	 * double money1,
	 * double money2,
	 * double discount,
	 * double pmoney, 
	 * String words*/
		String id;
		StubCustomer customer;
		ArrayList sheet;//销售单据，商品名，数量，单价
		double money1;//折前总金额
		double money2;//代金券金额
		double disconut;//折让金额；
		double pmoney;//最终金额
		String words;//备注
		public VO getVO() {
			// TODO Auto-generated method stub
			return null;
		}
		public PO getPO() {
			// TODO Auto-generated method stub
			return null;
		}
}
