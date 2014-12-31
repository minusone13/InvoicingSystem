package businesslogic.strategybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.LevelStrategyStyle;
import po.RM;
import po.ReachStrategyPO;
import po.ReachStrategyStyle;
import presentation.userui.Login;
import businesslogic.commoditybl.Commodity;
import businesslogic.commoditybl.StubCommodityList;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForManager;
import businesslogic.userbl.OperationRecord;
import businesslogic.userbl.User;
import businesslogic.userbl.UserController;
import businesslogic.userservice.UserService;
import dataservice.strategydataservice.StrategySaverService;

public class StubStrategyPool {

	private ArrayList<StubLevelStrategy> alOfLevelStrategy=new ArrayList<StubLevelStrategy>();
	private ArrayList<StubBarginStrategy> alOfBarginStrategy=new ArrayList<StubBarginStrategy>();
	private ArrayList<StubReachStrategy> alOfReachStrategy=new ArrayList<StubReachStrategy>();
	//StrategySaverService ss=new StrategySaver();
	//需要用到记录操作的接口
	UserService userService=new UserController();
	//新增特价包的接口
	StockBlForManager stockbl=new StubStockController();
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
	/*通过id找策略*/
	public StubLevelStrategy findLevelStrategy(String id){
		read();
		for(int i=0;i<alOfLevelStrategy.size();i++){
			if(alOfLevelStrategy.get(i).getID().equals(id)){
				return alOfLevelStrategy.get(i);
			}
		}
		return null;
		
	}
	/*通过id找策略*/
	public StubBarginStrategy findBarginStrategy(String id){
		read();
		for(int i=0;i<alOfBarginStrategy.size();i++){
			if(alOfBarginStrategy.get(i).getID().equals(id)){
				return alOfBarginStrategy.get(i);
			}
		}
		return null;
		
	}
	/*通过id找策略*/
	public StubReachStrategy findReachStrategy(String id){
		read();
		for(int i=0;i<alOfReachStrategy.size();i++){
			if(alOfReachStrategy.get(i).getID().equals(id)){
				return alOfReachStrategy.get(i);
			}
		}
		return null;
		
	}
	/*需要删除一条客户分层策略*/
	public void RemoveLevelStrategy (String ID){
		read();
		for(int i=0;i<alOfLevelStrategy.size();i++){
			if(alOfLevelStrategy.get(i).getID().equals(ID)){
				//保存记录
				userService.addRecord(new OperationRecord(StubCommodityList.user,"删除客户策略:"+ID,RM.done));
				alOfLevelStrategy.remove(i);
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
				//保存记录
				userService.addRecord(new OperationRecord(StubCommodityList.user,"删除特价包策略:"+ID,RM.done));
				alOfBarginStrategy.remove(i);
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
				//保存记录
				userService.addRecord(new OperationRecord(StubCommodityList.user,"删除满额促销策略:"+ID,RM.done));
				alOfReachStrategy.remove(i);
				break;
			}
		}

		//保存
		this.save();
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void addGiftLevelStrategy (int level,double Limit,ArrayList<Commodity> gift,String StartTime,int LastTime){
		read();
		StubLevelStrategy ls=new StubLevelStrategy();
		ls.setLevel_strategy_style(LevelStrategyStyle.Gift);
		ls.setLevel(level);
		ls.setLimit(Limit);
		ls.setAlOfCommodity(gift);
		ls.setStartTime(StartTime);
		ls.setLastTime(LastTime);
		alOfLevelStrategy.add(ls);
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增客户策略:"+ls.getID(),RM.done));
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
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增客户策略:"+ls.getID(),RM.done));
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
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增客户策略:"+ls.getID(),RM.done));
		//保存
		this.save();
	}
	/*需要制定一条特价包促销策略*/
	public void addBarginStrategy (ArrayList<Commodity> bargin,double discount,String StartTime,int LastTime){
		read();
		StubBarginStrategy bs=new StubBarginStrategy();
		bs.setAlOfCommodity(bargin);
		bs.setDiscount(discount);
//		bs.setNum(num);
		bs.setStartTime(StartTime);
		bs.setLastTime(LastTime);
		alOfBarginStrategy.add(bs);
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增特价包策略:"+bs.getID(),RM.done));
		//保存
		this.save();
//		//同时生成特价包
//		stockbl.addPack(bargin, num, discount);
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void addReachStrategy (double Limit,ArrayList<Commodity> gift,String StartTime,int LastTime){
		read();
		StubReachStrategy rs=new StubReachStrategy();
		rs.setReach_strategy_style(ReachStrategyStyle.Gift);
		rs.setLimit(Limit);
		rs.setAlOfCommodity(gift);
		rs.setStartTime(StartTime);
		rs.setLastTime(LastTime);
		alOfReachStrategy.add(rs);
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增满额促销策略:"+rs.getID(),RM.done));
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
		//保存记录
		userService.addRecord(new OperationRecord(StubCommodityList.user,"新增满额促销策略:"+rs.getID(),RM.done));
		//保存
		this.save();
	}
	public void read(){
		alOfLevelStrategy.clear();
		alOfBarginStrategy.clear();
		alOfReachStrategy.clear();
		//将返回的PO对象的信息传入真正的策略对象
		//客户分层策略
		ArrayList<LevelStrategyPO> LevelStrategyPOList = null;
		try {
			StrategySaverService ss = null;
			try
			{
				ss = (StrategySaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/StrategySaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			LevelStrategyPOList = ss.getLevelStrategy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(LevelStrategyPOList!=null){
			for(int i=0;i<LevelStrategyPOList.size();i++){
				StubLevelStrategy ls=new StubLevelStrategy();
				ls.setPO(LevelStrategyPOList.get(i));
				alOfLevelStrategy.add(ls);
			}
		}
		//特价包策略
		ArrayList<BarginStrategyPO> BarginStrategyPOList = null;
		try {
			StrategySaverService ss = null;
			try
			{
				ss = (StrategySaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/StrategySaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			BarginStrategyPOList = ss.getBarginStrategy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(BarginStrategyPOList!=null){
			for(BarginStrategyPO tempPO:BarginStrategyPOList){
				StubBarginStrategy bs=new StubBarginStrategy();

				bs.setPO(tempPO);
				alOfBarginStrategy.add(bs);
			}
		}
		//满额促销策略
		ArrayList<ReachStrategyPO> ReachStrategyPOList = null;
		try {
			StrategySaverService ss = null;
			try
			{
				ss = (StrategySaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/StrategySaver");
			}
			catch (MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch (NotBoundException e)
			{
				e.printStackTrace();
			}
			ReachStrategyPOList = ss.getReachStrategy();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
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
		//StrategySaverService ss=new StrategySaver();
		StrategySaverService ss = null;
		try
		{
			ss = (StrategySaverService)Naming.lookup("rmi://"+entrance.Test.ipOfServer+"/StrategySaver");
		}
		catch (MalformedURLException e1)
		{
			e1.printStackTrace();
		}
		catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
		catch (NotBoundException e1)
		{
			e1.printStackTrace();
		}
		//客户分层策略
		ArrayList<LevelStrategyPO> LevelStrategyPO=new ArrayList<LevelStrategyPO>();
		for(StubLevelStrategy temp:alOfLevelStrategy){//遍历数组，将对应PO对象加到新数组中
			LevelStrategyPO.add(temp.getPO());
		}
		try {
			ss.saveLevelStrategy(LevelStrategyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//特价包策略
		ArrayList<BarginStrategyPO> BarginStrategyPO=new ArrayList<BarginStrategyPO>();
		for(StubBarginStrategy temp:alOfBarginStrategy){//遍历数组，将对应PO对象加到新数组中
			BarginStrategyPO.add(temp.getPO());
		}
		try {
			ss.saveBarginStrategy(BarginStrategyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
		//满额促销策略
		ArrayList<ReachStrategyPO> ReachStrategyPO=new ArrayList<ReachStrategyPO>();
		for(StubReachStrategy temp:alOfReachStrategy){//遍历数组，将对应PO对象加到新数组中
			ReachStrategyPO.add(temp.getPO());
		}
		try {
			ss.saveReachStrategy(ReachStrategyPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}//保存PO数组到txt
	}
	

}
