package vo.inquiryVO;

public class InquirySaleVO {
	
	private String commodityName;
	private String customer;
	private String stock;
	private String timeBefore;
	private String timeAfter;
	private String deSaler;//业务员
	
	
	public String getDeSaler()
	{
		return deSaler;
	}
	public void setDeSaler(String deSaler)
	{
		this.deSaler = deSaler;
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
	
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
}
