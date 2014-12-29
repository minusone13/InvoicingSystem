package businesslogic.strategybl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import po.ReachStrategyPO;
import po.ReachStrategyStyle;
import po.StrategyStyle;
import po.stockpo.CommodityPO;
import vo.ReachStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;

public class StubReachStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.ReachStrategy;
	private ReachStrategyStyle reach_strategy_style=ReachStrategyStyle.Default;
	
	private String ID;
	private double Limit;//消费金额下限
	
	private ArrayList<MockCommodity> alOfCommodity=new ArrayList<MockCommodity>();//赠品信息数组
	private double couponrate;//赠送代金券的比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	/*构造方法*/
	public StubReachStrategy(){
	     Calendar ca = Calendar.getInstance();
	     int minute=ca.get(Calendar.MINUTE);//分 
	     int hour=ca.get(Calendar.HOUR);//小时 
	     int second=ca.get(Calendar.SECOND);//秒
	
	     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		 String currentTime = format.format(new Date());
	     setID("MECL-"+currentTime+"-"+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second));
	}
	
	public ReachStrategyVO getVO() {
		// TODO Auto-generated method stub
		ReachStrategyVO result=new ReachStrategyVO();
		result.setID(this.getID());
		result.setReach_strategy_style(this.getReach_strategy_style());
		result.setLimit(this.getLimit());
		result.setCouponrate(this.getCouponrate());
	
		ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toVO());
		}
		result.setAlOfCommodity(temp);
		
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		return result;
	}

	public ReachStrategyPO getPO() {
		// TODO Auto-generated method stub
		ReachStrategyPO result=new ReachStrategyPO();
		result.setID(this.getID());
		result.setReach_strategy_style(this.getReach_strategy_style());
		result.setLimit(this.getLimit());
		result.setCouponrate(this.getCouponrate());
	
		ArrayList<CommodityPO> temp=new ArrayList<CommodityPO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toPO());
		}
		result.setAlOfCommodity(temp);
		
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		return result;
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
		ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();//用于临时转换
		for(int i=0;i<po.getAlOfCommodity().size();i++){
			temp.add(new MockCommodity(po.getAlOfCommodity().get(i)));
		}
		this.setID(po.getID());
		this.setAlOfCommodity(temp);
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
