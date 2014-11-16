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
	public Type getType()
	{
		return t;
	}
	public CommodityPO getCommodity()
	{
		return comPO;
	}
	public int getquantity()
	{
		return quantity;
	}
}
