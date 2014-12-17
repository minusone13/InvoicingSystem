package businesslogic.strategybl;

import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.ReachStrategyPO;
import businesslogic.LevelStrategyStyle;
import businesslogic.ReachStrategyStyle;
import businesslogic.commoditybl.MockCommodity;
import data.strategydata.StrategySaver;
import dataservice.strategydataservice.StrategySaverService;

public class StubStrategyPool {

	private ArrayList<StubLevelStrategy> alOfLevelStrategy=new ArrayList<StubLevelStrategy>();
	private ArrayList<StubBarginStrategy> alOfBarginStrategy=new ArrayList<StubBarginStrategy>();
	private ArrayList<StubReachStrategy> alOfReachStrategy=new ArrayList<StubReachStrategy>();
	StrategySaverService ss=new StrategySaver();
	/*构造函数*/
	public StubStrategyPool(){
	
//		//清除保存的记录
//		save();

		read();
	}
	/*需要获取客户分层策略*/
	public ArrayList<StubLevelStrategy> getLevelStrategy (){
		read();
		return alOfLevelStrategy;
		
	}
	/*需要获取特价包策略*/
	public ArrayList<StubBarginStrategy> getBarginStrategy (){
		read();
		return alOfBarginStrategy;
		
	}
	/*需要获取满额促销策略*/
	public ArrayList<StubReachStrategy> getReachStrategy (){
		read();
		return alOfReachStrategy;
		
	}
	/*需要删除一条客户分层策略*/
	public void RemoveLevelStrategy (String ID){
		read();
		for(int i=0;i<alOfLevelStrategy.size();i++){
			if(alOfLevelStrategy.get(i).getID().equals(ID)){
				alOfLevelStrategy.remove(i);
				System.out.println("已删除这条客户策略");
				break;
			}
		}
		//保存
		this.save();
	}
	/*需要删除一条特价包策略*/
	public void RemoveBarginStrategy (String ID){
		read();
		for(int i=0;i<alOfBarginStrategy.size();i++){
			if(alOfBarginStrategy.get(i).getID().equals(ID)){
				alOfBarginStrategy.remove(i);
				System.out.println("已删除这条特价包策略");
				break;
			}
		}
		//保存
		this.save();
	}
	/*需要删除一条满额促销策略*/
	public void RemoveReachStrategy (String ID){
		read();
		for(int i=0;i<alOfReachStrategy.size();i++){
			if(alOfReachStrategy.get(i).getID().equals(ID)){
				alOfReachStrategy.remove(i);
				System.out.println("已删除这条满额促销策略");
				break;
			}
		}
		//保存
		this.save();
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void addGiftLevelStrategy (int level,double Limit,ArrayList<MockCommodity> gift,String StartTime,int LastTime){
		read();
		StubLevelStrategy ls=new StubLevelStrategy();
		ls.setLevel_strategy_style(LevelStrategyStyle.Gift);
		ls.setLevel(level);
		ls.setLimit(Limit);
		ls.setAlOfCommodity(gift);
		ls.setStartTime(StartTime);
		ls.setLastTime(LastTime);
		alOfLevelStrategy.add(ls);
		//保存
		this.save();
	}
	/*需要制定一个折让客户分层策略*/
	public void addDiscountLevelStrategy (int level,double rate, String StartTime,int LastTime){
		read();
		StubLevelStrategy ls=new StubLevelStrategy();
		ls.setLevel_strategy_style(LevelStrategyStyle.Discount);
		ls.setLevel(level);
		ls.setDiscountrate(rate);
		ls.setStartTime(StartTime);
		ls.setLastTime(LastTime);
		alOfLevelStrategy.add(ls);
		//保存
		this.save();
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public void addCouponLevelStrategy (int level,double rate, String StartTime,int LastTime){
		read();
		StubLevelStrategy ls=new StubLevelStrategy();
		ls.setLevel_strategy_style(LevelStrategyStyle.Coupon);
		ls.setLevel(level);
		ls.setCouponrate(rate);
		ls.setStartTime(StartTime);
		ls.setLastTime(LastTime);
		alOfLevelStrategy.add(ls);
		//保存
		this.save();
	}
	/*需要制定一条特价包促销策略*/
	public void addBarginStrategy (ArrayList<MockCommodity> bargin,double discount,int num,String StartTime,int LastTime){
		read();
		StubBarginStrategy bs=new StubBarginStrategy();
		bs.setAlOfCommodity(bargin);
		bs.setDiscount(discount);
		bs.setNum(num);
		bs.setStartTime(StartTime);
		bs.setLastTime(LastTime);
		alOfBarginStrategy.add(bs);
		//保存
		this.save();
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void addReachStrategy (double Limit,ArrayList<MockCommodity> gift,String StartTime,int LastTime){
		read();
		StubReachStrategy rs=new StubReachStrategy();
		rs.setReach_strategy_style(ReachStrategyStyle.Gift);
		rs.setLimit(Limit);
		rs.setAlOfCommodity(gift);
		rs.setStartTime(StartTime);
		rs.setLastTime(LastTime);
		alOfReachStrategy.add(rs);
		//保存
		this.save();
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public void addReachStrategy (double Limit,double rate,String StartTime,int LastTime){
		read();
		StubReachStrategy rs=new StubReachStrategy();
		rs.setReach_strategy_style(ReachStrategyStyle.Coupon);
		rs.setLimit(Limit);
		rs.setCouponrate(rate);
		rs.setStartTime(StartTime);
		rs.setLastTime(LastTime);
		alOfReachStrategy.add(rs);
		//保存
		this.save();
	}
	public void read(){
		alOfLevelStrategy.clear();
		alOfBarginStrategy.clear();
		alOfReachStrategy.clear();
		//将返回的PO对象的信息传入真正的策略对象
		//客户分层策略
		ArrayList<LevelStrategyPO> LevelStrategyPOList=ss.getLevelStrategy();
		if(LevelStrategyPOList!=null){
			for(int i=0;i<LevelStrategyPOList.size();i++){
				StubLevelStrategy ls=new StubLevelStrategy();
				ls.setPO(LevelStrategyPOList.get(i));
				alOfLevelStrategy.add(ls);
			}
		}
		//特价包策略
		ArrayList<BarginStrategyPO> BarginStrategyPOList=ss.getBarginStrategy();
		if(BarginStrategyPOList!=null){
			for(BarginStrategyPO tempPO:BarginStrategyPOList){
				StubBarginStrategy bs=new StubBarginStrategy();

				bs.setPO(tempPO);
				alOfBarginStrategy.add(bs);
			}
		}
		//满额促销策略
		ArrayList<ReachStrategyPO> ReachStrategyPOList=ss.getReachStrategy();
		if(ReachStrategyPOList!=null){
			for(ReachStrategyPO tempPO:ReachStrategyPOList){
				StubReachStrategy rs=new StubReachStrategy();
				rs.setPO(tempPO);
				alOfReachStrategy.add(rs);
			}
		}
	}
	/*实时保存池中数组对象*/
	public void save(){
		StrategySaverService ss=new StrategySaver();
		
		//客户分层策略
		ArrayList<LevelStrategyPO> LevelStrategyPO=new ArrayList<LevelStrategyPO>();
		for(StubLevelStrategy temp:alOfLevelStrategy){//遍历数组，将对应PO对象加到新数组中
			LevelStrategyPO.add(temp.getPO());
		}
		ss.saveLevelStrategy(LevelStrategyPO);//保存PO数组到txt
		//特价包策略
		ArrayList<BarginStrategyPO> BarginStrategyPO=new ArrayList<BarginStrategyPO>();
		for(StubBarginStrategy temp:alOfBarginStrategy){//遍历数组，将对应PO对象加到新数组中
			BarginStrategyPO.add(temp.getPO());
		}
		ss.saveBarginStrategy(BarginStrategyPO);//保存PO数组到txt
		//满额促销策略
		ArrayList<ReachStrategyPO> ReachStrategyPO=new ArrayList<ReachStrategyPO>();
		for(StubReachStrategy temp:alOfReachStrategy){//遍历数组，将对应PO对象加到新数组中
			ReachStrategyPO.add(temp.getPO());
		}
		ss.saveReachStrategy(ReachStrategyPO);//保存PO数组到txt
	}
	

}
