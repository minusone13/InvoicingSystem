package vo.financialBillVO;

import java.util.ArrayList;
import java.util.Date;

import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.Item;

public class CashPaymentVO extends VO{
	private BillStyle billstyle=BillStyle.CashPaymentBill;
	//单据编号、操作员自动生成
	String ID;
	double total;
	String account;//账户
	ArrayList<Double> money=new ArrayList<Double>();//金额
	ArrayList<String> item=new ArrayList<String>();
	ArrayList<String> remark=new ArrayList<String>();
	BillState state=BillState.DRAFT;
	Role role;
	Date date;
	String userID;
	String userName;
	String op;
	public BillStyle getBillstyle() {
		return billstyle;
	}

	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public BillState getState() {
		return state;
	}

	public void setState(BillState state) {
		this.state = state;
	}

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

	public BillStyle getBillStyle() {
		return billstyle;
	}

	public void setBillStyle(BillStyle style) {
		this.billstyle = style;
	}

	public BillState getBillState() {
		return state;
	}

	public void setBillState(BillState state) {
		this.state = state;
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

	public void setItem(ArrayList<String> item) {
		this.item = item;
	}

	public void setRemark(ArrayList<String> remark) {
		this.remark = remark;
	}

	public ArrayList<String> getItem() {
		return item;
	}
	
	public ArrayList<String> getRemark() {
		return remark;
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
	public ArrayList<Double> getMoney() {
		return money;
	}
	
}
