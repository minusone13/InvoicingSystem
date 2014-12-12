package po;

import java.io.Serializable;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.BillStyle;
import po.stockpo.CommodityPO;


public class AlertBillPO extends PO implements Serializable{
	private BillStyle style = BillStyle.AlertBill;
	private Date date;
	String operator;
	private String ID;
	private CommodityPO comPO;
	private int shortage;
	private BillState state=BillState.DRAFT;
	public AlertBillPO(){}
	
	public AlertBillPO(Date date,String userID,String ID,CommodityPO comPO, int shortage,BillState state)
	{
		this.date=date;
		this.operator=userID;
		this.ID=ID;
		this.comPO=comPO;
		this.shortage=shortage;
		this.state=state;
	}
	public AlertBillPO(String userID,String ID,CommodityPO comPO, int shortage,BillState state)
	{
		this.operator=userID;
		this.ID=ID;
		this.comPO=comPO;
		this.shortage=shortage;
		this.state=state;
	}
	public AlertBillPO(String userID,String ID, CommodityPO comPO, int shortage)
	{
		this.operator=userID;
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String userID) {
		this.operator = userID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
