package businesslogic.strategybl;

import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.ReachStrategyPO;
import businesslogic.StrategyStyle;
import businesslogic.commoditybl.MockCommodity;
import data.strategydata.StrategySaver;
import dataservice.strategydataservice.StrategySaverService;

public class StubStrategyPool {

	private ArrayList<StubLevelStrategy> alOfLevelStrategy=new ArrayList<StubLevelStrategy>();
	private ArrayList<StubBarginStrategy> alOfBarginStrategy=new ArrayList<StubBarginStrategy>();
	private ArrayList<StubReachStrategy> alOfReachStrategy=new ArrayList<StubReachStrategy>();
	/*构造函数*/
	public StubStrategyPool(){
		StrategySaverService ss=new StrategySaver();
		
		//将返回的PO对象的信息传入真正的策略对象
		//客户分层策略
		ArrayList<LevelStrategyPO> LevelStrategyPOList=ss.getLevelStrategy();
		if(LevelStrategyPOList!=null){
			for(LevelStrategyPO tempPO:LevelStrategyPOList){
				StubLevelStrategy ls=new StubLevelStrategy();
				ls.setPO(tempPO);
				alOfLevelStrategy.add(ls);
			}
		}
		//客户分层策略
		ArrayList<BarginStrategyPO> BarginStrategyPOList=ss.getBarginStrategy();
		if(BarginStrategyPOList!=null){
			for(BarginStrategyPO tempPO:BarginStrategyPOList){
				StubBarginStrategy bs=new StubBarginStrategy();
				bs.setPO(tempPO);
				alOfBarginStrategy.add(bs);
			}
		}
		//客户分层策略
		ArrayList<ReachStrategyPO> ReachStrategyPOList=ss.getReachStrategy();
		if(ReachStrategyPOList!=null){
			for(ReachStrategyPO tempPO:ReachStrategyPOList){
				StubReachStrategy rs=new StubReachStrategy();
				rs.setPO(tempPO);
				alOfReachStrategy.add(rs);
			}
		}
	}
	/*需要获取客户分层策略*/
	public ArrayList<StubLevelStrategy> getLevelStrategy (){
		return alOfLevelStrategy;
		
	}
	/*需要获取特价包策略*/
	public ArrayList<StubBarginStrategy> getBarginStrategy (){
		return alOfBarginStrategy;
		
	}
	/*需要获取满额促销策略*/
	public ArrayList<StubReachStrategy> getReachStrategy (){
		return alOfReachStrategy;
		
	}
	/*需要删除一条客户分层策略*/
	public void RemoveLevelStrategy (String ID){
		
	}
	/*需要删除一条特价包策略*/
	public void RemoveBarginStrategy (String ID){
		
	}
	/*需要删除一条满额促销策略*/
	public void RemoveReachStrategy (String ID){
		
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void addLevelStrategy (int level,int Limit,ArrayList<MockCommodity> gift,String StartTime,int LastTime){
		
	}
	/*需要制定一个折让客户分层策略*/
	public void addDiscountLevelStrategy (int level,double rate, String StartTime,int LastTime){
		
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public void addCouponLevelStrategy (int level,double rate, String StartTime,int LastTime){
		
	}
	/*需要制定一条特价包促销策略*/
	public void addBarginStrategy (ArrayList<MockCommodity> bargin,int discount,int num,String StartTime,int LastTime){
		
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void addReachStrategy (int Limit,ArrayList<MockCommodity> gift,String StartTime,int LastTime){
		
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public void addReachStrategy (int Limit,int rate,String StartTime,int LastTime){
		
	}
	/*实时保存池中数组对象*/
	public void save(StrategyStyle st){
		
	}
	

}
