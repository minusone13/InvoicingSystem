package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.TransferAccount;

public class PaymentPO extends PO implements Serializable{
	String ID;
	Role role;
	String customer;
	double total;
	String account;//账户
	double money;//转账金额
	BillStyle style;
	ArrayList<TransferAccount> transferlist;
	Date date;
	String userID;
	String userName;
	String op;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
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
	public ArrayList<TransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<TransferAccount> transferlist) {
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
