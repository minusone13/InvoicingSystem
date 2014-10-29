package businesslogic.managerbl;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.CommodityVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogic.BillState;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.salebillbl.StubPurBackSheet;
import businesslogic.salebillbl.StubPurSheet;
import businesslogic.salebillbl.StubSaleBackSheet;
import businesslogic.salebillbl.StubSaleSheet;
import businesslogic.strategybl.StubBarginStrategy;
import businesslogic.strategybl.StubLevelStrategy;
import businesslogic.strategybl.StubReachStrategy;
import businesslogic.strategybl.StubStrategyPool;

public class StubManager {

	private String ID;
	private String name;
	private StubBillPool billPool;
	private StubStrategyPool strategyPool;
	
	/*构造方法*/
	public StubManager(){
		
	}
	/*需要查看已提交单据*/
	public ArrayList<VO> getHandedBill (){
		ArrayList<VO> result=new ArrayList<VO>();
		//搜索单据池，寻找已提交状态的单据
		ArrayList<StubGiftBill> alOfGB=billPool.getGiftBill(BillState.SUBMITED);
		ArrayList<StubSpillsLossBill> alOfSLB=billPool.getSpillsLossBill(BillState.SUBMITED);
		ArrayList<StubAlertBill> alOfAB=billPool.getAlertBill(BillState.SUBMITED);
		ArrayList<StubPurSheet> alOfPS=billPool.getPurSheet(BillState.SUBMITED);
		ArrayList<StubPurBackSheet> alOfPBS=billPool.getPurBackSheet(BillState.SUBMITED);
		ArrayList<StubSaleSheet> alOfSS=billPool.getSaleSheet(BillState.SUBMITED);
		ArrayList<StubSaleBackSheet> alOfSBS=billPool.getSaleBackSheet(BillState.SUBMITED);
		ArrayList<StubReceiptBill> alOfRB=billPool.getReceiptBill(BillState.SUBMITED);
		ArrayList<StubPaymentBill> alOfPB=billPool.getPaymentBill(BillState.SUBMITED);
		ArrayList<StubCashPaymentBill> alOfCPB=billPool.getCashPaymentBill(BillState.SUBMITED);
		//进行逐个大遍历，返回符合条件单据对应的VO
		for(StubGiftBill temp:alOfGB){
			result.add(temp.getVO());
		}
		return result;	
	}
	/*修改密码*/
	public void modifyPassword (String newpassword){
		
	}
    /*修改单据信息*/
	public void changeImformationOfBill(VO billvo){
		//通过新VO修改对应单据对象的信息
		//保存单据信息
		//保存操作
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
	public void Remove (StubLevelStrategy ls){
		
	}
	/*需要删除一条特价包策略*/
	public void Remove (StubBarginStrategy bs){
		
	}
	/*需要删除一条满额促销策略*/
	public void Remove (StubReachStrategy rs){
		
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
	public ArrayList<VO> showBusinessProgress(String client,String operater,String warehouse,BillState billStyle, String StartTime,String LastTime){
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
