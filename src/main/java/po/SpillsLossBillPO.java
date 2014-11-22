package po;

import java.io.Serializable;

import businesslogic.BillState;
import businesslogic.BillStyle;
import po.stockpo.CommodityPO;

public class SpillsLossBillPO extends PO implements Serializable{
	public enum Type
	{
		Spills,
		Loss
	}
	BillStyle style = BillStyle.SpillsLossBill;
	String ID;
	Type t;
	CommodityPO comPO;
	BillState state=BillState.DRAFT;
	public Type getT() {
		return t;
	}
	public void setT(Type t) {
		this.t = t;
	}
	public CommodityPO getComPO() {
		return comPO;
	}
	public void setComPO(CommodityPO comPO) {
		this.comPO = comPO;
	}
	public SpillsLossBillPO(String ID,Type t, CommodityPO comPO)
	{
		this.ID=ID;
		this.t=t;
		this.comPO=comPO;
	}
	public SpillsLossBillPO(String ID,Type t, CommodityPO comPO,BillState state)
	{
		this.ID=ID;
		this.t=t;
		this.comPO=comPO;
		this.state=state;
	}
	public BillStyle getStyle() {
		return style;
	}
	public void setStyle(BillStyle style) {
		this.style = style;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
}
