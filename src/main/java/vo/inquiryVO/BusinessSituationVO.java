package vo.inquiryVO;

public class BusinessSituationVO {
	
	private double adjustmentTotal;//商品调价收入
	private double giftTotal;//商品赠出
	private double spillsTotal;//商品报溢收入
	private double lossTotal;//商品报损
	
	
	
	private double profit;//利润
	public int tempForTest=0;
	
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
