package businesslogic.managerbl;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.CommodityVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.strategybl.BarginStrategy;
import businesslogic.strategybl.LevelStrategy;
import businesslogic.strategybl.ReachStrategy;

public class Manager {

	/*构造方法*/
	public Manager(){
		
	}
	/*需要查看已提交单据*/
	public ArrayList<VO> getHandedBill (){
		return null;	
	}
	/*修改密码*/
	public void modifyPassword (String newpassword){
		
	}
    /*修改单据信息*/
	public void changeImformationOfBill(VO billvo){
		
	}
	/*通过数组中对应的单据*/
	public void PassBill(ArrayList<VO> billvo){
		
	}
	/*返回所有客户分层策略信息*/
	public ArrayList<LevelStrategyVO> ShowLevelStrategy (){
		return null;
	}
	/*返回所有特价包策略信息*/
	public ArrayList<BarginStrategyVO> ShowBarginStrategy (){
		return null;
	}
	/*返回所有满额促销策略信息*/
	public ArrayList<ReachStrategyVO> ShowReachStrategy  (){
		return null;
	}
	/*需要删除一条客户分层策略*/
	public void Remove (LevelStrategy ls){
		
	}
	/*需要删除一条特价包策略*/
	public void Remove (BarginStrategy bs){
		
	}
	/*需要删除一条满额促销策略*/
	public void Remove (ReachStrategy rs){
		
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void addGiftLevelStrategy (int level,int Limit,ArrayList<CommodityVO> alOfCommodityVo,String StartTime,int LastTime){
		
	}
	/*需要制定一个折让客户分层策略*/
	public void addDiscountLevelStrategy (int level,double rate, String StartTime,int LastTime){
		
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public void addCouponLevelStrategy (int level,double rate, String StartTime,int LastTime){
	
	}
	/*需要制定一条特价包促销策略*/
	public void addBarginStrategy (ArrayList<CommodityVO> alOfCommodityVo,int discount,int num,String StartTime,int LastTime){
		
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void addReachStrategy (int Limit,ArrayList< CommodityVO> alOfCommodityVo,String StartTime,int LastTime){
		
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public void addReachStrategy (int Limit,int rate,String StartTime,int LastTime){
		
	}
	/*需要查看经营历程*/
	public ArrayList<VO> showBusinessProgress(String client,String operater,String warehouse,BillStyle billStyle, String StartTime,String LastTime){
		return null;
		
	}
	/*需要查看销售明细*/
	public ArrayList<VO> showSaleDetail(String client,String operater,String warehouse,String commodity, String StartTime,String LastTime){
		return null;
		
	}
	/*需要查看经营情况*/
	public BusinessSituationVO showBusinessSituation (String StartTime,String LastTime){
		return null;
	
	}

}
