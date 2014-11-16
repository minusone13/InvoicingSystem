package vo;

import businesslogic.BillStyle;
import businesslogic.Role;

public class PaymentVO extends VO{
	private BillStyle style=BillStyle.PaymentBill;
	//单据编号、操作员自动生成
		String ID;
		Role operator;
		String customer;
		double total;
		String[] account;//账户
		double[] money;//转账金额
		String[] remark;
		public String getCustomer() {
			return customer;
		}
		public void setCustomer(String customer) {
			this.customer = customer;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String[] getAccount() {
			return account;
		}
		
		public double[] getMoney() {
			return money;
		}
		public String[] getRemark() {
			return remark;
		}
}
