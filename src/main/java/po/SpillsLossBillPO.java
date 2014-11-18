package po;

import java.io.Serializable;

import po.stockpo.CommodityPO;

public class SpillsLossBillPO extends PO implements Serializable{
	public enum Type
	{
		Spills,
		Loss
	}
	String ID;
	Type t;
	CommodityPO comPO;
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
		this.t=t;
		this.comPO=comPO;
	}
}
