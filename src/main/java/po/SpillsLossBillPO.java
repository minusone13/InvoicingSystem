package po;

import java.io.Serializable;

import po.stockpo.CommodityPO;

public class SpillsLossBillPO extends PO implements Serializable{
	public enum Type
	{
		Spills,
		Loss
	}
	Type t;
	CommodityPO comPO;
	int quantity;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
