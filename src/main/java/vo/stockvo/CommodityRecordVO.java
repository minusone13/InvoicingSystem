package vo.stockvo;

import java.util.Date;

public class CommodityRecordVO
{
	public CommodityRecordVO(String id, Date date, int outquantity,
			int inquantity, double outamount, double inamount,
			int salequantity, int importquantity, double saleamount,
			double importamount)
	{
		this.id = id;
		this.date = date;
		this.outquantity = outquantity;
		this.inquantity = inquantity;
		this.outamount = outamount;
		this.inamount = inamount;
		this.salequantity = salequantity;
		this.importquantity = importquantity;
		this.saleamount = saleamount;
		this.importamount = importamount;
	}

	// 记录商品的进出记录,库存查看、管理商品时都会用到
	Date date;// 日期
	String id;
	int outquantity;// 出库数量
	int inquantity;// 入库数量
	double outamount;// 相应金额
	double inamount;

	int salequantity;// 销售数量
	int importquantity;// 进货数量
	double saleamount;// 相应金额
	double importamount;

	public Date getD()
	{
		return date;
	}

	public void setD(Date d)
	{
		this.date = d;
	}

	public int getOutquantity()
	{
		return outquantity;
	}

	public void setOutquantity(int outquantity)
	{
		this.outquantity = outquantity;
	}

	public int getInquantity()
	{
		return inquantity;
	}

	public void setInquantity(int inquantity)
	{
		this.inquantity = inquantity;
	}

	public double getOutamount()
	{
		return outamount;
	}

	public void setOutamount(double outamount)
	{
		this.outamount = outamount;
	}

	public double getInamount()
	{
		return inamount;
	}

	public void setInamount(double inamount)
	{
		this.inamount = inamount;
	}

	public int getSalequantity()
	{
		return salequantity;
	}

	public void setSalequantity(int salequantity)
	{
		this.salequantity = salequantity;
	}

	public int getImportquantity()
	{
		return importquantity;
	}

	public void setImportquantity(int importquantity)
	{
		this.importquantity = importquantity;
	}

	public double getSaleamount()
	{
		return saleamount;
	}

	public void setSaleamount(double saleamount)
	{
		this.saleamount = saleamount;
	}

	public double getImportamount()
	{
		return importamount;
	}

	public void setImportamount(double importamount)
	{
		this.importamount = importamount;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
