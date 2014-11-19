package businesslogic.strategybl;

import java.util.ArrayList;
import java.util.Calendar;

import po.ReachStrategyPO;
import vo.ReachStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.ReachStrategyStyle;
import businesslogic.StrategyStyle;
import businesslogic.commoditybl.MockCommodity;

public class StubReachStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style;
	
	private String ID;
	private double Limit;//消费金额下限
	
	private ArrayList<MockCommodity> alOfCommodity;//赠品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	/*构造方法*/
	public StubReachStrategy(){
	     Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
	     int month=ca.get(Calendar.MONTH);//获取月份 
	     int day=ca.get(Calendar.DATE);//获取日
	     int minute=ca.get(Calendar.MINUTE);//分 
	     int hour=ca.get(Calendar.HOUR);//小时 
	     int second=ca.get(Calendar.SECOND);//秒
	
	     setID(String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second));
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
		this.setAlOfCommodity(po.getAlOfCommodity());
		this.setCouponrate(po.getCouponrate());
		this.setLastTime(po.getLastTime());
		this.setLimit(po.getLimit());
		this.setReach_strategy_style(po.getReach_strategy_style());
		this.setStartTime(po.getStartTime());
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public ArrayList<MockCommodity> getAlOfCommodity() {
		return alOfCommodity;
	}

	public void setAlOfCommodity(ArrayList<MockCommodity> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
}
