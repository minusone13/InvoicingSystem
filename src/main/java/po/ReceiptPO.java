package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubTransferAccount;

public class ReceiptPO extends PO implements Serializable{
	String ID;
	Role role;
	String customer;
	double total;
	BillState state;
	ArrayList<StubTransferAccount> transferlist;
	BillStyle style;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		this.role = r;
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
	
}
