package vo;

import java.util.ArrayList;

import businesslogic.LevelStrategyStyle;
import businesslogic.StrategyStyle;

public class ReachStrategyVO extends VO{
	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private LevelStrategyStyle level_strategy_style;
	
	private double Limit;//消费金额下限
	
	private ArrayList< CommodityVO> alOfCommodityVo;//赠送赠品的商品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	
	public double getLimit() {
		return Limit;
	}
	public void setLimit(double limit) {
		Limit = limit;
	}
	public ArrayList< CommodityVO> getAlOfCommodityVo() {
		return alOfCommodityVo;
	}
	public void setAlOfCommodityVo(ArrayList< CommodityVO> alOfCommodityVo) {
		this.alOfCommodityVo = alOfCommodityVo;
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
}
