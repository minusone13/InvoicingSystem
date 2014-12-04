package vo.financialBillVO;

import java.util.ArrayList;

import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubTransferAccount;

public class ReceiptVO extends VO{
	private BillStyle billstyle=BillStyle.ReceiptBill;
	String ID;
	Role role;
	String customer;
	double total;
	double[] money;//转账金额
	String[] accounts;
	String[] remark;	
	BillState state;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public String[] getAccounts() {
		return accounts;
	}
	public void setAccounts(String[] accounts) {
		this.accounts = accounts;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
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
	public BillState getBillState() {
		return state;
	}
	public void setBillState(BillState state) {
		this.state = state;
	}

	ArrayList<StubTransferAccount> transferlist;
	
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
	public void setID(String ID) {
		ID = ID;
	}
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role r) {
		this.role = r;
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
		return accounts;
	}
	
	public double[] getMoney() {
		return money;
	}
	
	public String[] getRemark() {
		return remark;
	}
	
}
