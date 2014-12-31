package vo;

import java.util.ArrayList;

import po.LevelStrategyStyle;
import po.StrategyStyle;
import vo.stockvo.CommodityVO;
import businesslogic.commoditybl.Commodity;

public class BarginStrategyVO extends VO {
	private StrategyStyle strategystyle=StrategyStyle.BarginStrategy;
	
	private String ID="0000";
	private ArrayList<CommodityVO> alOfCommodity=new ArrayList<CommodityVO>();;//赠品信息数组
	private double discount;//降价金额
//	private int num;//特价包打包数量
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	private String operator;
	/*构造方法*/
	public BarginStrategyVO(){
		
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
//	public int getNum() {
//		return num;
//	}
//	public void setNum(int num) {
//		this.num = num;
//	}
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

	public ArrayList<CommodityVO> getAlOfCommodity() {
		return alOfCommodity;
	}
	
	public void setAlOfCommodity(ArrayList<CommodityVO> alOfCommodity) {
		this.alOfCommodity = alOfCommodity;
	}
	public String getID()
	{
		return ID;
	}
	public void setID(String iD)
	{
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
