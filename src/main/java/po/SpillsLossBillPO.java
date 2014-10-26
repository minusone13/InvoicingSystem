package po;

public class SpillsLossBillPO extends PO{
	enum Type
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
