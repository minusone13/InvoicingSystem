package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubItem;

public class CashPaymentPO extends PO implements Serializable{
	BillStyle style;
	double total;
	String account;//账户
	String ID;
	Role role;
	ArrayList<StubItem> itemList;
	BillState state;
	
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
	public ArrayList<StubItem> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<StubItem> itemList) {
		this.itemList = itemList;
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

}
