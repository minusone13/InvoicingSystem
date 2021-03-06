package businesslogic.strategybl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import po.LevelStrategyPO;
import po.LevelStrategyStyle;
import po.StrategyStyle;
import po.stockpo.CommodityPO;
import vo.LevelStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;

public class StubLevelStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.LevelStrategy;
	private LevelStrategyStyle level_strategy_style=LevelStrategyStyle.Default;
	
	private String ID;
	private int level;//客户等级
	private double Limit;//消费金额下限
	
	private ArrayList<MockCommodity> alOfCommodity=new ArrayList<MockCommodity>();//赠品信息数组
	private double discountrate;//打折比例
	private double couponrate;//代金券赠送比例
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	private String operator;
	public StubLevelStrategy(){
	     Calendar ca = Calendar.getInstance();
	     int minute=ca.get(Calendar.MINUTE);//分 
	     int hour=ca.get(Calendar.HOUR);//小时 
	     int second=ca.get(Calendar.SECOND);//秒
	
	     SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		 String currentTime = format.format(new Date());
	     setID("KHCL-"+currentTime+"-"+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second));
	}
	public LevelStrategyVO getVO() {
		// TODO Auto-generated method stub
		LevelStrategyVO result=new LevelStrategyVO();
		result.setID(this.getID());
		result.setLevel_strategy_style(this.getLevel_strategy_style());
		result.setLevel(this.getLevel());
		result.setLimit(this.getLimit());
		
		ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toVO());
		}
		result.setAlOfCommodity(temp);
		
		result.setDiscountrate(this.getDiscountrate());
		result.setCouponrate(this.getCouponrate());
		
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		result.setOperator(this.getOperator());
		return result;
	}

	public LevelStrategyPO getPO() {
		// TODO Auto-generated method stub
		LevelStrategyPO result=new LevelStrategyPO();
		result.setID(this.getID());
		result.setLevel_strategy_style(this.getLevel_strategy_style());
		result.setLevel(this.getLevel());
		result.setLimit(this.getLimit());
		
		ArrayList<CommodityPO> temp=new ArrayList<CommodityPO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toPO());
		}
		result.setAlOfCommodity(temp);
		
		result.setDiscountrate(this.getDiscountrate());
		result.setCouponrate(this.getCouponrate());
		
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		result.setOperator(this.getOperator());
		return result;
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
	public ArrayList<MockCommodity> getAlOfCommodity() {
		return alOfCommodity;
	}
	public void setAlOfCommodity(ArrayList<MockCommodity> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
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

	public void setPO(LevelStrategyPO po){
	
		this.setLevel_strategy_style(po.getLevel_strategy_style());
		ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();//用于临时转换
		for(int i=0;i<po.getAlOfCommodity().size();i++){
			temp.add(new MockCommodity(po.getAlOfCommodity().get(i)));
		}
		this.setID(po.getID());
		this.setAlOfCommodity(temp);
		this.setCouponrate(po.getCouponrate());
		this.setLevel(po.getLevel());
		this.setLimit(po.getLimit());
		this.setDiscountrate(po.getDiscountrate());
		this.setLastTime(po.getLastTime());
		this.setStartTime(po.getStartTime());
		this.setOperator(po.getOperator());
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
