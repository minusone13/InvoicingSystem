package vo.financialBillVO;

import java.util.ArrayList;
import java.util.Date;

import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.TransferAccount;

public class ReceiptVO extends VO{
	private BillStyle billstyle=BillStyle.ReceiptBill;
	String ID;
	Role role;
	String customer;
	double total;
	ArrayList<Double> money;//转账金额
	ArrayList<String> accounts;
	ArrayList<String> remark;

	ArrayList<TransferAccount> transferlist;
	BillState state;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	Date date;
	public ReceiptVO() {
		
	}
	public ReceiptVO(String customer, double total, String[] account, double[] money, String[] remark) {
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<String> getAccounts() {
		return accounts;
	}
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	
	public void setAccounts(ArrayList<String> accounts) {		
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
	
	public ArrayList<TransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<TransferAccount> transferlist) {
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
	
	public void setMoney(ArrayList<Double> money) {
		this.money = money;
	}
	public void setAccount(ArrayList<String> account) {
		this.accounts = account;
	}
	public void setRemark(ArrayList<String> remark) {
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
	
	public ArrayList<Double> getMoney() {
		return money;
	}
	
	public ArrayList<String> getRemark() {
		return remark;
	}
	
}
