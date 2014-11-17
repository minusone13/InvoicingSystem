package vo;

import vo.stockvo.*;
import businesslogic.BillStyle;

public class AlertBillVO extends VO{
	String ID;
	private BillStyle billstyle=BillStyle.AlertBill;
	CommodityVO com;
	int shortage;
	public CommodityVO getCommodity()
	{
		return com;
	}
	public int getshortage()
	{
		return shortage;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public CommodityVO getCom() {
		return com;
	}
	public void setCom(CommodityVO com) {
		this.com = com;
	}
	public int getShortage() {
		return shortage;
	}
	public void setShortage(int shortage) {
		this.shortage = shortage;
	}
}
