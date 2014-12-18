package vo.financialBillVO;

import java.util.ArrayList;
import java.util.Date;

import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.TransferAccount;

public class PaymentVO extends VO{
	private BillStyle billstyle=BillStyle.PaymentBill;
	//单据编号、操作员自动生成
	String ID;
	Role role;
	String customer;
	double total;
	ArrayList<Double> money = new ArrayList<Double>();//转账金额
	ArrayList<String> accounts = new ArrayList<String>();
	ArrayList<String> remark =new ArrayList<String>();
	private BillState state = BillState.DRAFT;
	
	String userID;
	String userName;
	String op;
	Date date;
	
	
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
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BillState getBillState() {
		return state;
	}
	public void setBillState(BillState state) {
		this.state = state;
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
	
	public void setMoney(ArrayList<Double> money) {
		this.money = money;
	}
	public void setAccounts(ArrayList<String> accounts) {
		this.accounts = accounts;
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
		public ArrayList<String> getAccounts() {
			return accounts;
		}
		
		public ArrayList<Double> getMoney() {
			return money;
		}
		public ArrayList<String> getRemark() {
			return remark;
		}
}
