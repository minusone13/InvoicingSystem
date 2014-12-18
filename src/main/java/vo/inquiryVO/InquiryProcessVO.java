package vo.inquiryVO;

import po.BillStyle;

public class InquiryProcessVO {
	
	
	String timeBefore;
	String timeAfter;
	String customer;
	String operator;
	String stock;
	String userID;
	
	BillStyle billstyle;
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
}
