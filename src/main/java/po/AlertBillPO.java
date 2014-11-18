package po;

import java.io.Serializable;

import po.stockpo.CommodityPO;


public class AlertBillPO extends PO implements Serializable{
	String ID;
	CommodityPO comPO;
	int shortage;
	public AlertBillPO(){
		
	}
	public AlertBillPO(String ID, CommodityPO comPO, int shortage)
	{
		this.ID=ID;
		this.comPO=comPO;
		this.shortage=shortage;
	}
	public AlertBillPO(CommodityPO comPO,int shortage)
	{
		this.comPO=comPO;
		this.shortage=shortage;
	}
	public CommodityPO getCommodity()
	{
		return comPO;
	}
	public int getshortage()
	{
		return shortage;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public CommodityPO getComPO() {
		return comPO;
	}
	public void setComPO(CommodityPO comPO) {
		this.comPO = comPO;
	}
	public int getShortage() {
		return shortage;
	}
	public void setShortage(int shortage) {
		this.shortage = shortage;
	}
}
