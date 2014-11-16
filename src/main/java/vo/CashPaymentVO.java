package vo;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubItem;

public class CashPaymentVO extends VO{
	private BillStyle style=BillStyle.CashPaymentBill;
	//单据编号、操作员自动生成
	String ID;
	double total;
	String account;//账户
	double[] money;//金额
	String[] item;
	String[] remark;
	BillState state;
	Role operator;
	ArrayList<StubItem> itemList;
	
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

	public Role getOperator() {
		return operator;
	}

	public void setOperator(Role operator) {
		this.operator = operator;
	}

	public ArrayList<StubItem> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<StubItem> itemList) {
		this.itemList = itemList;
	}

	public void setMoney(double[] money) {
		this.money = money;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public void setRemark(String[] remark) {
		this.remark = remark;
	}

	public String[] getItem() {
		return item;
	}
	
	public String[] getRemark() {
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
	public double[] getMoney() {
		return money;
	}
	
}
