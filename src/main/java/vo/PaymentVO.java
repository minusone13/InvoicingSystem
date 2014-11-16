package vo;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubTransferAccount;

public class PaymentVO extends VO{
	private BillStyle style=BillStyle.PaymentBill;
	//单据编号、操作员自动生成
	String ID;
	Role operator;
	String customer;
	double total;
	double[] money;//转账金额
	String[] accounts;
	String[] remark;	
	BillState state;
	ArrayList<StubTransferAccount> transferlist;
	public ArrayList<StubTransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<StubTransferAccount> transferlist) {
		this.transferlist = transferlist;
	}
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Role getOperator() {
		return operator;
	}
	public void setOperator(Role operator) {
		this.operator = operator;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
	public void setMoney(double[] money) {
		this.money = money;
	}
	public void setAccount(String[] account) {
		this.accounts = account;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
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
			return accounts;
		}
		
		public double[] getMoney() {
			return money;
		}
		public String[] getRemark() {
			return remark;
		}
}
