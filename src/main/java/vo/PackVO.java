package vo;

import java.util.ArrayList;

import businesslogic.commoditybl.CommodityRecord;
import vo.stockvo.CommodityRecordVO;
import vo.stockvo.CommodityVO;

public class PackVO
{
	public PackVO(String iD, ArrayList<CommodityVO> coms, int quantity,
			double price, ArrayList<CommodityRecordVO> record,
			ArrayList<CommodityRecordVO> prepareRecord)
	{
		super();
		ID = iD;
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
		this.record = record;
		this.prepareRecord = prepareRecord;
	}

	public PackVO()
	{}

	String ID;
	ArrayList<CommodityVO> coms = new ArrayList<CommodityVO>();
	int quantity;
	double price;// price = total-discount
	ArrayList<CommodityRecordVO> record = new ArrayList<CommodityRecordVO>();
	ArrayList<CommodityRecordVO> prepareRecord = new ArrayList<CommodityRecordVO>();

	public ArrayList<CommodityVO> getComs()
	{
		return coms;
	}

	public void setComs(ArrayList<CommodityVO> coms)
	{
		this.coms = coms;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String getID()
	{
		return ID;
	}

	public void setID(String iD)
	{
		ID = iD;
	}

	public ArrayList<CommodityRecordVO> getRecord()
	{
		return record;
	}

	public void setRecord(ArrayList<CommodityRecordVO> record)
	{
		this.record = record;
	}

	public ArrayList<CommodityRecordVO> getPrepareRecord()
	{
		return prepareRecord;
	}

	public void setPrepareRecord(ArrayList<CommodityRecordVO> prepareRecord)
	{
		this.prepareRecord = prepareRecord;
	}
}
