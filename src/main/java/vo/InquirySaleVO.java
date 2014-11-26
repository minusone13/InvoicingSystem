package vo;

public class InquirySaleVO {
	
	String commodityName;
	String customer;
	String operator;
	String stock;
	String timeBefore;
	String timeAfter;
	
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
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
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
