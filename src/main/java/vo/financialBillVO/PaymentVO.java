package vo.financialBillVO;

import java.util.ArrayList;

import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubTransferAccount;

public class PaymentVO extends VO{
	private BillStyle billstyle=BillStyle.PaymentBill;
	//单据编号、操作员自动生成
	String ID;
	Role role;
	String customer;
	double total;
	double[] money;//转账金额
	String[] accounts;
	String[] remark;	
	private BillState state;
	ArrayList<StubTransferAccount> transferlist;
	public BillState getBillState() {
		return state;
	}
	public void setBillState(BillState state) {
		this.state = state;
	}
	public ArrayList<StubTransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<StubTransferAccount> transferlist) {
		this.transferlist = transferlist;
	}
	public BillStyle getBillStyle() {
		return billstyle;
	}
	public void setBillStyle(BillStyle style) {
		this.billstyle = style;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		this.role = r;
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
