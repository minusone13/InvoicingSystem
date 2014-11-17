package vo;

import po.SpillsLossBillPO.Type;
import vo.stockvo.CommodityVO;
import businesslogic.BillStyle;

public class SpillsLossBillVO extends VO{
	private BillStyle billstyle=BillStyle.SpillsLossBill;
	Type t;
	CommodityVO com;
	int quantity;
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
	public CommodityVO getCom() {
		return com;
	}
	public void setCom(CommodityVO com) {
		this.com = com;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
