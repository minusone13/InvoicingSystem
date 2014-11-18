package businesslogic.strategybl;

import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import vo.BarginStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.StrategyStyle;

public class StubBarginStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.BarginStrategy;
	
	private ArrayList<CommodityVO> alOfCommodityVo;//特价包商品信息数组
	private double discount;//降价金额
	private int num;//特价包打包数量
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	/*构造方法*/
	public StubBarginStrategy(){
		
	}
	public BarginStrategyVO getVO() {
		// TODO Auto-generated method stub
		return null;
	}

	public BarginStrategyPO getPO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*成员变量的设置与获取*/
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
	public void setPO(BarginStrategyPO po){
		this.setDiscount(po.getDiscount());
		this.setAlOfCommodityVo(po.getAlOfCommodityVo());
		this.setNum(po.getNum());
		this.setLastTime(po.getLastTime());
		this.setStartTime(po.getStartTime());
	}

}
