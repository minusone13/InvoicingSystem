package businesslogic.strategybl;

import java.util.ArrayList;

import po.ReachStrategyPO;
import vo.ReachStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.ReachStrategyStyle;
import businesslogic.StrategyStyle;

public class StubReachStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style;
	
	private double Limit;//消费金额下限
	
	private ArrayList< CommodityVO> alOfCommodityVo;//赠送赠品的商品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	/*构造方法*/
	public StubReachStrategy(){
		
	}
	
	public ReachStrategyVO getVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public ReachStrategyPO getPO() {
		// TODO Auto-generated method stub
		return null;
	}

	/*成员变量的设置与获取*/
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

	public ReachStrategyStyle getReach_strategy_style() {
		return reach_strategy_style;
	}

	public void setReach_strategy_style(ReachStrategyStyle reach_strategy_style) {
		this.reach_strategy_style = reach_strategy_style;
	}

	public void setPO(ReachStrategyPO po){
		this.setAlOfCommodityVo(po.getAlOfCommodityVo());
		this.setCouponrate(po.getCouponrate());
		this.setLastTime(po.getLastTime());
		this.setLimit(po.getLimit());
		this.setReach_strategy_style(po.getReach_strategy_style());
		this.setStartTime(po.getStartTime());
	}
}
