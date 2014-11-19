package vo;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;
import businesslogic.ReachStrategyStyle;
import businesslogic.StrategyStyle;
import businesslogic.commoditybl.MockCommodity;

public class ReachStrategyVO extends VO{
	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style;
	
	private String ID="0000";
	private double Limit;//消费金额下限
	
	private ArrayList<MockCommodity> alOfCommodity;//赠品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	
	public double getLimit() {
		return Limit;
	}
	public void setLimit(double limit) {
		Limit = limit;
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
	public double getCouponrate() {
		return couponrate;
	}
	public void setCouponrate(double couponrate) {
		this.couponrate = couponrate;
	}
	public ArrayList<MockCommodity> getAlOfCommodity() {
		return alOfCommodity;
	}
	public void setAlOfCommodity(ArrayList<MockCommodity> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
}
