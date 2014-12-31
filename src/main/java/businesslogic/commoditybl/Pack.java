package businesslogic.commoditybl;

import java.util.ArrayList;

import po.stockpo.*;
import vo.PackVO;
import vo.stockvo.CommodityVO;

public class Pack
{// 特价包类
	public Pack(String ID, ArrayList<Commodity> coms, int quantity,
			double price)
	{
		this.ID = ID;
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
	}

	public Pack(ArrayList<Commodity> coms, int quantity, double price)
	{// 总经理请用
		this.coms = coms;
		this.quantity = quantity;
		this.price = price;
	}

	public Pack(PackVO vo)
	{
		this.ID = vo.getID();
		coms = new ArrayList<Commodity>();
		for (int i = 0; i < vo.getComs().size(); i++)
			coms.add(new Commodity(vo.getComs().get(i)));
		quantity = vo.getQuantity();
		price = vo.getPrice();
		Commodity com = new Commodity();
		record = com.vosToCom(vo.getRecord());
		prepareRecord = com.vosToCom(vo.getPrepareRecord());
	}

	public Pack(PackPO po)
	{
		this.ID = po.getID();
		coms = new ArrayList<Commodity>();
		for (int i = 0; i < po.getComs().size(); i++)
			coms.add(new Commodity(po.getComs().get(i)));
		quantity = po.getQuantity();
		price = po.getPrice();
		Commodity com = new Commodity();
		record = com.posToCom(po.getRecord());
		prepareRecord = com.posToCom(po.getPrepareRecord());
	}

	public PackPO toPO()
	{
		ArrayList<CommodityPO> compos = new ArrayList<CommodityPO>();
		Commodity com = new Commodity();
		for (int i = 0; i < coms.size(); i++)
			compos.add(coms.get(i).toPO());
		return new PackPO(ID, compos, quantity, price, com.toRecordPOs(record),
				com.toRecordPOs(prepareRecord));
	}

	public PackVO toVO()
	{
		ArrayList<CommodityVO> comvos = new ArrayList<CommodityVO>();
		Commodity com = new Commodity();
		for (int i = 0; i < coms.size(); i++)
			comvos.add(coms.get(i).toVO());
		return new PackVO(ID, comvos, quantity, price, com.toRecordVOs(record),
				com.toRecordVOs(prepareRecord));
	}

	String ID;//特价包有ID，唯一确定确定一个特价包
	ArrayList<Commodity> coms;//coms中的number是本类商品在特价包中的数量
	int quantity;//下面几个参数类似businesslogic/commoditybl/Commodity.java
	double price;// 总价，通过total-discount得出
	ArrayList<CommodityRecord> record = new ArrayList<CommodityRecord>();
	ArrayList<CommodityRecord> prepareRecord = new ArrayList<CommodityRecord>();

	public int getPotential()
	{
		int potential = quantity;
		for (int i = 0; i < prepareRecord.size(); i++)
			potential -= prepareRecord.get(i).getOutquantity();
		return potential;
	}

	public void add(CommodityRecord r)
	{
		record.add(r);
	}

	public void prepareDelete(CommodityRecord r)
	{
		for (int i = 0; i < prepareRecord.size(); i++)
			if (prepareRecord.get(i).equals(r))
				prepareRecord.remove(i);
	}

	public void prepareAdd(CommodityRecord r)
	{
		prepareRecord.add(r);
	}

	public ArrayList<Commodity> getComs()
	{
		return coms;
	}

	public void setComs(ArrayList<Commodity> coms)
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

	public void setID(String ID)
	{
		this.ID = ID;
	}

	public ArrayList<CommodityRecord> getRecord()
	{
		return record;
	}

	public void setRecord(ArrayList<CommodityRecord> record)
	{
		this.record = record;
	}

	public ArrayList<CommodityRecord> getPrepareRecord()
	{
		return prepareRecord;
	}

	public void setPrepareRecord(ArrayList<CommodityRecord> prepareRecord)
	{
		this.prepareRecord = prepareRecord;
	}
}