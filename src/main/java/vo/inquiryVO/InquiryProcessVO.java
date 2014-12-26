package vo.inquiryVO;

import po.BillStyle;

public class InquiryProcessVO {
	
	
	String timeBefore;
	String timeAfter;
	String customer;
	
	String stock;
	String deSaler;
	
	public String getDeSaler()
	{
		return deSaler;
	}

	public void setDeSaler(String deSaler)
	{
		this.deSaler = deSaler;
	}
	BillStyle billstyle;
	public BillStyle getBillstyle() {
		return billstyle;
	}
	
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public String getTimeBefore() {
		return timeBefore;
	}
	public void setTimeBefore(String timeBefore) {
		this.timeBefore = timeBefore;
	}
	public String getTimeAfter() {
		return timeAfter;
	}
	public void setTimeAfter(String timeAfter) {
		this.timeAfter = timeAfter;
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
}
