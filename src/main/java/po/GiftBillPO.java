package po;

import java.io.Serializable;
import java.util.*;

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
