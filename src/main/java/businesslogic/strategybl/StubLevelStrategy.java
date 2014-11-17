package businesslogic.strategybl;

import java.util.ArrayList;

import po.PO;
import vo.VO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.LevelStrategyStyle;
import businesslogic.StrategyStyle;

public class StubLevelStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.LevelStrategy;
	private LevelStrategyStyle level_strategy_style;
	
	private int level;//客户等级
	private double Limit;//消费金额下限
	
	private ArrayList<CommodityVO> alOfCommodityVo;//赠品信息数组
	private double discountrate;//打折比例
	private double couponrate;//代金券赠送比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	public StubLevelStrategy(){
		
	}
	public VO getVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public PO getPO() {
		// TODO Auto-generated method stub
		return null;
	}
	/*成员变量的设置与获取*/
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double getLimit() {
		return Limit;
	}
	public void setLimit(double limit) {
		Limit = limit;
	}
	public ArrayList<CommodityVO> getAlOfCommodityVo() {
		return alOfCommodityVo;
	}
	public void setAlOfCommodityVo(ArrayList<CommodityVO> alOfCommodityVo) {
		this.alOfCommodityVo = alOfCommodityVo;
	}
	public double getDiscountrate() {
		return discountrate;
	}
	public void setDiscountrate(double discountrate) {
		this.discountrate = discountrate;
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
	public LevelStrategyStyle getLevel_strategy_style() {
		return level_strategy_style;
	}
	public void setLevel_strategy_style(LevelStrategyStyle level_strategy_style) {
		this.level_strategy_style = level_strategy_style;
	}

}
