package businesslogic.commoditybl;

import java.util.Date;

import po.stockpo.CommodityRecordPO;
import vo.stockvo.CommodityRecordVO;

public class CommodityRecord{
	public CommodityRecord(String id,Date date, int outquantity, int inquantity,
			double outamount, double inamount, int salequantity,
			int importquantity, double saleamount, double importamount) {
		this.id=id;
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
	public CommodityRecord(String id,Date date, int outquantity, int inquantity,
			double outamount, double inamount) {
		this.id=id;
		this.date = date;
		this.outquantity = outquantity;
		this.inquantity = inquantity;
		this.outamount = outamount;
		this.inamount = inamount;
		this.salequantity = outquantity;
		this.importquantity = inquantity;
		this.saleamount = outamount;
		this.importamount = inamount;
	}
	public CommodityRecord(int outquantity, int inquantity,
			double outamount, double inamount) {
		this.outquantity = outquantity;
		this.inquantity = inquantity;
		this.outamount = outamount;
		this.inamount = inamount;
		this.salequantity = outquantity;
		this.importquantity = inquantity;
		this.saleamount = outamount;
		this.importamount = inamount;
	}
	public CommodityRecord(CommodityRecordPO po) {
		this.id = po.getId();
		this.date = po.getD();
		this.outquantity = po.getOutquantity();
		this.inquantity = po.getInquantity();
		this.outamount = po.getOutamount();
		this.inamount = po.getInamount();
		this.salequantity = po.getSalequantity();
		this.importquantity = po.getImportquantity();
		this.saleamount = po.getSaleamount();
		this.importamount = po.getImportamount();
	}
	public CommodityRecord(CommodityRecordVO vo) {
		this.id = vo.getId();
		this.date = vo.getD();
		this.outquantity = vo.getOutquantity();
		this.inquantity = vo.getInquantity();
		this.outamount = vo.getOutamount();
		this.inamount = vo.getInamount();
		this.salequantity = vo.getSalequantity();
		this.importquantity = vo.getImportquantity();
		this.saleamount = vo.getSaleamount();
		this.importamount = vo.getImportamount();
	}
//记录商品的进出记录
	Date date;//日期
	String id;
	int outquantity;//出库数量
	int inquantity;//入库数量
	double outamount;//相应金额
	double inamount;
	
	int salequantity;//销售数量
	int importquantity;//进货数量
	double saleamount;//相应金额
	double importamount;
	

	public Date getD() {
		return date;
	}
	public void setD(Date d) {
		this.date = d;
	}
	public int getOutquantity() {
		return outquantity;
	}
	public void setOutquantity(int outquantity) {
		this.outquantity = outquantity;
	}
	public int getInquantity() {
		return inquantity;
	}
	public void setInquantity(int inquantity) {
		this.inquantity = inquantity;
	}
	public double getOutamount() {
		return outamount;
	}
	public void setOutamount(double outamount) {
		this.outamount = outamount;
	}
	public double getInamount() {
		return inamount;
	}
	public void setInamount(double inamount) {
		this.inamount = inamount;
	}
	public int getSalequantity() {
		return salequantity;
	}
	public void setSalequantity(int salequantity) {
		this.salequantity = salequantity;
	}
	public int getImportquantity() {
		return importquantity;
	}
	public void setImportquantity(int importquantity) {
		this.importquantity = importquantity;
	}
	public double getSaleamount() {
		return saleamount;
	}
	public void setSaleamount(double saleamount) {
		this.saleamount = saleamount;
	}
	public double getImportamount() {
		return importamount;
	}
	public void setImportamount(double importamount) {
		this.importamount = importamount;
	}
	public CommodityRecordPO toPO()
	{
		return new CommodityRecordPO(id,date, outquantity, inquantity,
				outamount, inamount, salequantity,
				importquantity, saleamount, importamount);
	}
	public CommodityRecordVO toVO()
	{
		return new CommodityRecordVO(id,date, outquantity, inquantity,
				outamount, inamount, salequantity,
				importquantity, saleamount, importamount);
	}
	public boolean equals(CommodityRecord r)
	{
		return (id.equals(r.getId()));
	}
	public void plus(CommodityRecord r)
	{
		outquantity+=r.getOutquantity();
		inquantity+=r.getInquantity();
		outamount+=r.getOutamount();
		inamount+=r.getInamount();
		salequantity+=r.getSalequantity();
		importquantity+=r.getImportquantity();
		saleamount+=r.getSaleamount();
		importamount+=r.getImportamount();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
