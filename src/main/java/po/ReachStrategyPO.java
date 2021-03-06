package po;

import java.util.ArrayList;

import po.stockpo.CommodityPO;

public class ReachStrategyPO extends PO{
	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style=ReachStrategyStyle.Default;
	
	private String ID;
	private double Limit;//消费金额下限
	
	private ArrayList<CommodityPO> alOfCommodity=new ArrayList<CommodityPO>();//赠品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	private String operator;
	public ReachStrategyStyle getReach_strategy_style() {
		return reach_strategy_style;
	}
	public void setReach_strategy_style(ReachStrategyStyle reach_strategy_style) {
		this.reach_strategy_style = reach_strategy_style;
	}
	public double getLimit() {
		return Limit;
	}
	public void setLimit(double limit) {
		Limit = limit;
	}

	public double getCouponrate() {
		return couponrate;
	}
	public void setCouponrate(double couponrate) {
		this.couponrate = couponrate;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public int getLastTime() {
		return LastTime;
	}
	public void setLastTime(int lastTime) {
		LastTime = lastTime;
	}
	public ArrayList<CommodityPO> getAlOfCommodity() {
		return alOfCommodity;
	}
	public void setAlOfCommodity(ArrayList<CommodityPO> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getOperator()
	{
		return operator;
	}
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
}
