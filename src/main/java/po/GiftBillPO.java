package po;

import java.io.Serializable;
import java.util.*;

import po.stockpo.CommodityPO;

public class GiftBillPO extends PO implements Serializable{
	String ID;
	String[] remark;
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
	public String[] getRemark() {
		return remark;
	}
	public void setRemark(String[] remark) {
		this.remark = remark;
	}
	public GiftBillPO(String ID, ArrayList<CommodityPO> coms, String[] remark)
	{
		this.ID=ID;
		this.coms=coms;
		this.remark=remark;
	}
}
