package po;

import java.io.Serializable;
import java.util.*;

import po.stockpo.CommodityPO;

public class GiftBillPO extends PO implements Serializable{
	String ID;
	ArrayList<CommodityPO> coms;
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
}
