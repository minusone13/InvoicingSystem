package po.stockpo;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.commoditybl.CommodityRecord;

public class PackPO implements Serializable, Cloneable{
	public PackPO(String iD, ArrayList<CommodityPO> coms, int quantity,
			double price, ArrayList<CommodityRecordPO> record,
			ArrayList<CommodityRecordPO> prepareRecord) {
		super();
		ID = iD;
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
		this.record = record;
		this.prepareRecord = prepareRecord;
	}
	public PackPO(String iD, ArrayList<CommodityPO> coms, int quantity,
			double price) {
		super();
		ID = iD;
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
	}
	public PackPO(){}
	String ID;
	ArrayList<CommodityPO> coms = new ArrayList<CommodityPO>();
	int quantity;
	double price;
	ArrayList<CommodityRecordPO> record=new ArrayList<CommodityRecordPO>();
	ArrayList<CommodityRecordPO> prepareRecord=new ArrayList<CommodityRecordPO>();
	public ArrayList<CommodityPO> getComs() {
		return coms;
	}
	public void setComs(ArrayList<CommodityPO> coms) {
		this.coms = coms;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getID() {
		return ID;
	}
	public void setID(String name) {
		this.ID = name;
	}
	public ArrayList<CommodityRecordPO> getRecord() {
		return record;
	}
	public void setRecord(ArrayList<CommodityRecordPO> record) {
		this.record = record;
	}
	public ArrayList<CommodityRecordPO> getPrepareRecord() {
		return prepareRecord;
	}
	public void setPrepareRecord(ArrayList<CommodityRecordPO> prepareRecord) {
		this.prepareRecord = prepareRecord;
	}
	public PackPO clone()
	{
		PackPO cloned = null;
		try {
			cloned=(PackPO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cloned;
	}
}
