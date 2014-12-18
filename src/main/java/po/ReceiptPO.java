package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.Role;
import businesslogic.financialbillbl.TransferAccount;

public class ReceiptPO extends PO implements Serializable{
	String ID;
	Role role;
	String customer;
	double total;
	BillState state;
	ArrayList<String> accounts;
	ArrayList<String> remark;
	ArrayList<Double> money;
	
	BillStyle style;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	Date date;
	
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
	public ArrayList<String> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
	}
	public ArrayList<String> getRemark() {
		return remark;
	}
	public void setRemark(ArrayList<String> remark) {
		this.remark = remark;
	}
	public ArrayList<Double> getMoney() {
		return money;
	}
	public void setMoney(ArrayList<Double> money) {
		this.money = money;
	}
}
