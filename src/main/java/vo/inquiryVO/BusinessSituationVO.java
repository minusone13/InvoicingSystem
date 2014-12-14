package vo.inquiryVO;

public class BusinessSituationVO {
	
	private double adjustmentTotal;//商品调价收入
	private double giftTotal;//商品赠出
	private double spillsTotal;//商品报溢收入
	private double lossTotal;//商品报损
	private double bonusTotal;//代金券与实际收款差额收入
	private double saleTotal;//折让后收入
	private double discount;//折让
	private double cost;//销售成本
	
	private double profit;//利润

	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public double getBonusTotal() {
		return bonusTotal;
	}
	public void setBonusTotal(double bonusTotal) {
		this.bonusTotal = bonusTotal;
	}
	public double getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(double saleTotal) {
		this.saleTotal = saleTotal;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
	public double getAdjustmentTotal() {
		return adjustmentTotal;
	}
	public void setAdjustmentTotal(double adjustmentTotal) {
		this.adjustmentTotal = adjustmentTotal;
	}
	public double getGiftTotal() {
		return giftTotal;
	}
	public void setGiftTotal(double giftTotal) {
		this.giftTotal = giftTotal;
	}
	public double getSpillsTotal() {
		return spillsTotal;
	}
	public void setSpillsTotal(double spillsTotal) {
		this.spillsTotal = spillsTotal;
	}
	public double getLossTotal() {
		return lossTotal;
	}
	public void setLossTotal(double lossTotal) {
		this.lossTotal = lossTotal;
	}
	
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
}
