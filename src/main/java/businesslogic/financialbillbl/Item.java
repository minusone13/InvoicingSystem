package businesslogic.financialbillbl;

import java.io.Serializable;

public class Item implements Serializable{

	String itemName;
	double money;
	String remark;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Item() {
		this(null,0.0,null);
	}
	
	public Item(String itemName, double money, String remark) {
		this.itemName = itemName;
		this.money = money;
		this.remark = remark;
	}
}
