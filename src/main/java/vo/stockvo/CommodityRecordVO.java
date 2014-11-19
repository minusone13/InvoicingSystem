package vo.stockvo;

import java.util.Date;

public class CommodityRecordVO {
	//记录商品的进出记录
		Date date;//日期
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
}
