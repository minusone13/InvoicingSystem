package po.stockpo;

import java.io.Serializable;
import java.util.*;

public class CommodityRecordPO implements Serializable, Cloneable
{
	// 记录商品的进出记录，库存查看和管理商品时都会用到
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
	public CommodityRecordPO(String id, Date date, int outquantity,
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

	public Date getD()
	{
		return date;
	}

	public Date getDate()
	{
		return date;
	}

	public String getId()
	{
		return id;
	}

	public double getImportamount()
	{
		return importamount;
	}

	public int getImportquantity()
	{
		return importquantity;
	}

	public double getInamount()
	{
		return inamount;
	}

	public int getInquantity()
	{
		return inquantity;
	}

	public double getOutamount()
	{
		return outamount;
	}

	public int getOutquantity()
	{
		return outquantity;
	}

	public double getSaleamount()
	{
		return saleamount;
	}

	public int getSalequantity()
	{
		return salequantity;
	}

	public void setD(Date d)
	{
		this.date = d;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setImportamount(double importamount)
	{
		this.importamount = importamount;
	}

	public void setImportquantity(int importquantity)
	{
		this.importquantity = importquantity;
	}

	public void setInamount(double inamount)
	{
		this.inamount = inamount;
	}

	public void setInquantity(int inquantity)
	{
		this.inquantity = inquantity;
	}

	public void setOutamount(double outamount)
	{
		this.outamount = outamount;
	}

	public void setOutquantity(int outquantity)
	{
		this.outquantity = outquantity;
	}

	public void setSaleamount(double saleamount)
	{
		this.saleamount = saleamount;
	}

	public void setSalequantity(int salequantity)
	{
		this.salequantity = salequantity;
	}
}
