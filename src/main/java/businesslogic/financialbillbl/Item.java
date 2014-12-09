package businesslogic.financialbillbl;

import java.io.Serializable;

public class Item implements Serializable{

	String itemName;
	double money;
	String remark;
	
	public Item() {
		this(null,0.0,null);
	}
	
	public Item(String itemName, double money, String remark) {
		this.itemName = itemName;
		this.money = money;
		this.remark = remark;
	}
}
