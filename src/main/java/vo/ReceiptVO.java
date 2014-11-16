package vo;

import businesslogic.BillStyle;
import businesslogic.Role;

public class ReceiptVO extends VO{
	private BillStyle style=BillStyle.ReceiptBill;
	String ID;
	Role operator ;
	String customer;
	double total;
	double[] money;//转账金额
	String[] account;
	String[] remark;	
	public ReceiptVO() {
		
	}
	public ReceiptVO(String customer, double total, String[] account, double[] money, String[] remark) {
		
	}
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
