package po;

import java.io.Serializable;
import java.util.*;

import po.stockpo.CommodityPO;

public class GiftBillPO extends PO implements Serializable{
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
