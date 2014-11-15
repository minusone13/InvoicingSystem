package po;

import java.util.*;

import po.stockpo.CommodityPO;

public class GiftBillPO extends PO{
	ArrayList<CommodityPO> coms;
	int quantity;
	double total;
	public ArrayList<CommodityPO> getComs()
	{
		return coms;
	}
	public int getquantity()
	{
		return quantity;
	}
	public double gettotal()
	{
		return total;
	}
}
