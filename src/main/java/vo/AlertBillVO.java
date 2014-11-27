package vo;


import vo.stockvo.*;
import businesslogic.*;

public class AlertBillVO extends VO{
	private String ID;//订单编号
	private BillStyle billstyle=BillStyle.AlertBill;//订单种类
	private CommodityVO com;//需要报警的商品信息
	private int shortage;//短缺数量
	private BillState state = BillState.DRAFT;//订单状态，默认为草稿
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
	public AlertBillVO(String ID, CommodityVO com, int shortage)
	{
		this.ID=ID;
		this.com=com;
		this.shortage=shortage;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
}
