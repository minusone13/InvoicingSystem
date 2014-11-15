package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubTransferAccount;

public class PaymentPO extends PO implements Serializable{
	String ID;
	Role operator;
	String customer;
	double total;
	String account;//账户
	double money;//转账金额
	BillStyle style;
	ArrayList<StubTransferAccount> transferlist;
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public ArrayList<StubTransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<StubTransferAccount> transferlist) {
		this.transferlist = transferlist;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public Role getOperator() {
		return operator;
	}
	public void setOperator(Role operator) {
		this.operator = operator;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
