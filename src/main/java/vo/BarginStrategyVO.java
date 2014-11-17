package vo;

import java.util.ArrayList;

import vo.stockvo.CommodityVO;
import businesslogic.LevelStrategyStyle;
import businesslogic.StrategyStyle;

public class BarginStrategyVO extends VO {
	private StrategyStyle strategystyle=StrategyStyle.BarginStrategy;
	
	private String ID="0000";
	private ArrayList<CommodityVO> alOfCommodityVo;//特价包商品信息数组
	private double discount;//降价金额
	private int num;//特价包打包数量
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	
	/*构造方法*/
	public BarginStrategyVO(){
		
	}
	
	public ArrayList<CommodityVO> getAlOfCommodityVo() {
		return alOfCommodityVo;
	}
	public void setAlOfCommodityVo(ArrayList<CommodityVO> alOfCommodityVo) {
		this.alOfCommodityVo = alOfCommodityVo;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
}
