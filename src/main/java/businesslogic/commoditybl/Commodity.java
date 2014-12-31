package businesslogic.commoditybl;

import java.util.ArrayList;
import java.util.Date;

import po.stockpo.CommodityPO;
import po.stockpo.CommodityRecordPO;
import vo.stockvo.CommodityRecordVO;
import vo.stockvo.CommodityVO;

public class Commodity
{
	String id;//id==parent+"\\"+name
	String parent;// the ID of parent Category
	String name;//名称和型号唯一确定一个商品
	String model;
	int number;
	double in;//增加商品时有一个默认进出价，之后随商品进销为平均进出价，下同
	double out;
	double lastin;
	double lastout;
	int alertLine;//库存报警，当小于AlertLine会报警
	ArrayList<CommodityRecord> record = new ArrayList<CommodityRecord>();//进出记录，用于库存查看
	ArrayList<CommodityRecord> prepareRecord = new ArrayList<CommodityRecord>();//备货记录

	public void computeRecordsTotal(Date d1, Date d2)
	{// 用于库存查看
		ArrayList<CommodityRecord> result = new ArrayList<CommodityRecord>();
		CommodityRecord temp = new CommodityRecord(0, 0, 0, 0);
		for (int i = 0; i < record.size(); i++)
		{
			CommodityRecord r = record.get(i);
			if (r.getDate().after(d1) && r.getDate().before(d2))
				temp.plus(r);
		}
		result.add(temp);
		record = result;
	}

	public int checkAlert()
	{
		return alertLine - number;
	}

	public boolean hasIn()
	{
		return (inQuantity() != 0);
	}

	public boolean hasOut()
	{
		return (outQuantity() != 0);
	}

	public int inQuantity()
	{
		int temp = 0;
		for (int i = 0; i < record.size(); i++)
			temp += record.get(i).getInquantity();
		return temp;
	}

	public int outQuantity()
	{
		int temp = 0;
		for (int i = 0; i < record.size(); i++)
			temp += record.get(i).getOutquantity();
		return temp;
	}

	public double outTotal()
	{
		double temp = 0;
		for (int i = 0; i < record.size(); i++)
			temp += record.get(i).getOutamount();
		return temp;
	}

	public Commodity()
	{}

	public Commodity(CommodityPO po)
	{
		if (po != null)
		{
			parent = po.getParent();
			name = po.getName();
			model = po.getModel();
			id = parent + "\\" + name + "-" + model;
			number = po.getNumber();
			in = po.getIn();
			out = po.getOut();
			lastin = po.getLastIn();
			lastout = po.getLastOut();
			alertLine = po.getAlertLine();
			record = posToCom(po.getRecord());
			prepareRecord = posToCom(po.getPrepareRecord());
		}
	}

	public Commodity(CommodityVO vo)
	{
		parent = vo.getParent();
		name = vo.getName();
		model = vo.getModel();
		id = parent + "\\" + name + "-" + model;
		number = vo.getNumber();
		in = vo.getIn();
		out = vo.getOut();
		lastin = vo.getLastin();
		lastout = vo.getLastout();
		alertLine = vo.getAlertLine();
		if (vo.getRecord() != null)
		{
			record = vosToCom(vo.getRecord());
		}
		prepareRecord = vosToCom(vo.getPrepareRecord());
	}

	public int getPotential()
	{
		int potential = number;
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

	public CommodityPO toPO()
	{
		return new CommodityPO(parent, name, model, number, in, out, lastin,
				lastout, alertLine, toRecordPOs(record),
				toRecordPOs(prepareRecord));
	}

	public CommodityVO toVO()
	{

		return new CommodityVO(parent, name, model, number, in, out, lastin,
				lastout, alertLine, toRecordVOs(record),
				toRecordVOs(prepareRecord));
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getParent()
	{
		return parent;
	}

	public void setParent(String parent)
	{
		this.parent = parent;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public double getIn()
	{
		return in;
	}

	public void setIn(double in)
	{
		this.in = in;
	}

	public double getOut()
	{
		return out;
	}

	public void setOut(double out)
	{
		this.out = out;
	}

	public double getLastin()
	{
		return lastin;
	}

	public void setLastin(double lastin)
	{
		this.lastin = lastin;
	}

	public double getLastout()
	{
		return lastout;
	}

	public void setLastout(double lastout)
	{
		this.lastout = lastout;
	}

	public int getAlertLine()
	{
		return alertLine;
	}

	public void setAlertLine(int alertLine)
	{
		this.alertLine = alertLine;
	}

	public ArrayList<CommodityRecord> getRecord()
	{
		return record;
	}

	public void setRecord(ArrayList<CommodityRecord> record)
	{
		this.record = record;
	}

	protected ArrayList<CommodityRecordPO> toRecordPOs(
			ArrayList<CommodityRecord> h)
	{
		ArrayList<CommodityRecordPO> result = null;
		if (h != null)
		{
			result = new ArrayList<CommodityRecordPO>();
			for (int i = 0; i < h.size(); i++)
				result.add(h.get(i).toPO());
		}
		return result;
	}

	protected ArrayList<CommodityRecordVO> toRecordVOs(
			ArrayList<CommodityRecord> h)
	{
		ArrayList<CommodityRecordVO> result = null;
		if (h != null)
		{
			result = new ArrayList<CommodityRecordVO>();
			for (int i = 0; i < h.size(); i++)
				result.add(h.get(i).toVO());
		}
		return result;
	}

	protected ArrayList<CommodityRecord> posToCom(ArrayList<CommodityRecordPO> h)
	{
		ArrayList<CommodityRecord> result = null;
		if (h != null)
		{
			result = new ArrayList<CommodityRecord>();
			for (int i = 0; i < h.size(); i++)
				result.add(new CommodityRecord(h.get(i)));
		}
		return result;
	}

	protected ArrayList<CommodityRecord> vosToCom(ArrayList<CommodityRecordVO> h)
	{
		ArrayList<CommodityRecord> result = null;
		if (h != null)
		{
			result = new ArrayList<CommodityRecord>();
			for (int i = 0; i < h.size(); i++)
				result.add(new CommodityRecord(h.get(i)));
		}
		return result;
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
