package po;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;
import businesslogic.ReachStrategyStyle;
import businesslogic.StrategyStyle;
import businesslogic.commoditybl.MockCommodity;

public class ReachStrategyPO extends PO{
	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style;
	
	private double Limit;//消费金额下限
	
	private ArrayList<MockCommodity> alOfCommodity;//赠品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
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
	public ArrayList<MockCommodity> getAlOfCommodity() {
		return alOfCommodity;
	}
	public void setAlOfCommodity(ArrayList<MockCommodity> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
}
