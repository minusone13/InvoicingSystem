package po;

import java.io.Serializable;

import businesslogic.BillState;
import businesslogic.BillStyle;
import po.stockpo.CommodityPO;


public class AlertBillPO extends PO implements Serializable{
	BillStyle style = BillStyle.AlertBill;
	String ID;
	CommodityPO comPO;
	int shortage;
	BillState state=BillState.DRAFT;
	public AlertBillPO(){}
	
	public AlertBillPO(String ID,CommodityPO comPO, int shortage,BillState state)
	{
		this.ID=ID;
		this.comPO=comPO;
		this.shortage=shortage;
		this.state=state;
	}
	public AlertBillPO(String ID, CommodityPO comPO, int shortage)
	{
		this.ID=ID;
		this.comPO=comPO;
		this.shortage=shortage;
	}
	public AlertBillPO(CommodityPO comPO,int shortage)
	{
		this.comPO=comPO;
		this.shortage=shortage;
	}
	public CommodityPO getCommodity()
	{
		return comPO;
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
	public CommodityPO getComPO() {
		return comPO;
	}
	public void setComPO(CommodityPO comPO) {
		this.comPO = comPO;
	}
	public int getShortage() {
		return shortage;
	}
	public void setShortage(int shortage) {
		this.shortage = shortage;
	}

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
}
