package po;

import java.io.Serializable;
import java.util.*;

import businesslogic.BillState;
import businesslogic.BillStyle;
import po.stockpo.CommodityPO;

public class GiftBillPO extends PO implements Serializable{
	BillStyle style = BillStyle.GiftBill;
	String ID;
	String[] remark;
	ArrayList<CommodityPO> coms;
	BillState state=BillState.DRAFT;
	public ArrayList<CommodityPO> getComs()
	{
		return coms;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setComs(ArrayList<CommodityPO> coms) {
		this.coms = coms;
	}
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
	public GiftBillPO(){}
	public GiftBillPO(String ID, ArrayList<CommodityPO> coms, String[] remark)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
	}
	public GiftBillPO(String ID, ArrayList<CommodityPO> coms, String[] remark,BillState state)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
		this.state=state;
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
