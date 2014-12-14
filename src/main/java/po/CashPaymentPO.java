package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.Item;

public class CashPaymentPO extends PO implements Serializable{
	BillStyle style;
	double total;
	String account;//账户
	String ID;
	Role role;
	
	ArrayList<String> items;
	ArrayList<String> remark;
	ArrayList<Double> money;
	
	BillState state;
	Date date;
	private String userID;
	private String userName;
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
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		this.role = r;
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
	public ArrayList<String> getItems() {
		return items;
	}
	public void setItems(ArrayList<String> items) {
		this.items = items;
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
