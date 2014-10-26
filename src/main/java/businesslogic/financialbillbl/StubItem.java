package businesslogic.financialbillbl;

public class StubItem {

	String itemName;
	double money;
	String remark;
	
	public StubItem() {
		this(null,0.0,null);
	}
	
	public StubItem(String itemName, double money, String remark) {
		this.itemName = itemName;
		this.money = money;
		this.remark = remark;
	}
}
