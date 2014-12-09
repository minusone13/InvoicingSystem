package businesslogic.strategybl;

import java.util.ArrayList;
import java.util.Calendar;

import po.BarginStrategyPO;
import po.stockpo.CommodityPO;
import vo.BarginStrategyVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.StrategyStyle;
import businesslogic.commoditybl.MockCommodity;

public class StubBarginStrategy implements GetVOandPO{

	private StrategyStyle strategystyle=StrategyStyle.BarginStrategy;
	
	private String ID;
	private ArrayList<MockCommodity> alOfCommodity=new ArrayList<MockCommodity>();//赠品信息数组
	private double discount;//降价金额
	private int num;//特价包打包数量
	
	private String StartTime;//开始日期
	private int LastTime;//策略持续时间（天）
	/*构造方法*/
	public StubBarginStrategy(){
	     Calendar ca = Calendar.getInstance();
	     int year = ca.get(Calendar.YEAR);//获取年份
	     int month=ca.get(Calendar.MONTH);//获取月份 
	     int day=ca.get(Calendar.DATE);//获取日
	     int minute=ca.get(Calendar.MINUTE);//分 
	     int hour=ca.get(Calendar.HOUR);//小时 
	     int second=ca.get(Calendar.SECOND);//秒
	
	     setID(String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second));
	}
	public BarginStrategyVO getVO() {
		// TODO Auto-generated method stub
		BarginStrategyVO result=new BarginStrategyVO();
		result.setID(this.getID());
		ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toVO());
		}
		result.setAlOfCommodity(temp);
		result.setDiscount(this.getDiscount());
		result.setNum(this.getNum());
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		return result;
	}

	public BarginStrategyPO getPO() {
		// TODO Auto-generated method stub
		BarginStrategyPO result=new BarginStrategyPO();
		result.setID(this.getID());
		ArrayList<CommodityPO> temp=new ArrayList<CommodityPO>();//临时转换
		for(int i=0;i<this.getAlOfCommodity().size();i++){
			temp.add(this.getAlOfCommodity().get(i).toPO());
		}
		result.setAlOfCommodity(temp);
		result.setDiscount(this.getDiscount());
		result.setNum(this.getNum());
		result.setStartTime(this.getStartTime());
		result.setLastTime(this.getLastTime());
		return result;
	}
	
	/*成员变量的设置与获取*/

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
		ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();//用于临时转换
		for(int i=0;i<po.getAlOfCommodity().size();i++){
			temp.add(new MockCommodity(po.getAlOfCommodity().get(i)));
		}
		this.setAlOfCommodity(temp);
		this.setNum(po.getNum());
		this.setLastTime(po.getLastTime());
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
