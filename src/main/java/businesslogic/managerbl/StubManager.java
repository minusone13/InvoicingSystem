package businesslogic.managerbl;

import java.util.ArrayList;

import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.LevelStrategyVO;
import vo.ReachStrategyVO;
import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
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
import businesslogicservice.managerblservice.StubManagerBlService;

public class StubManager implements StubManagerBlService{

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
		switch(billvo.getBillStyle()){
		case GiftBill:
		    //获取对应类型的数组
			ArrayList<StubGiftBill> alOfGB=billPool.getGiftBill(BillState.SUBMITED);
			for(StubGiftBill temp:alOfGB){
				if(temp.getID()==billvo.getID()){
				//将vo中的信息覆盖真实单据对象的信息
				}
			}
			//保存单据信息
			billPool.save(billvo.getBillStyle());
			break;
		case SpillsLossBill:
			break;
		case AlertBill:
			break;
		case PurSheet:
			break;
		case PurBackSheet:
			break;
		case SaleSheet:
			break;
		case SaleBackSheet:
			break;
		case ReceiptBill:
			break;
		case PaymentBill:
			break;
		case CashPaymentBill:
			break;
		}
		
		//保存操作
		
	}
	/*通过数组中对应的单据*/
	public void PassBill(ArrayList<VO> billvo){
		for(VO tempOfVO:billvo){
			switch(tempOfVO.getBillStyle()){
			case GiftBill:
				//获取对应类型的数组
				ArrayList<StubGiftBill> alOfGB=billPool.getGiftBill(BillState.SUBMITED);
				for(int i=0;i<alOfGB.size();i++){
					if(alOfGB.get(i).getID()==tempOfVO.getID()){
					//将vo对应的真实单据对象的状态改为已审批
						alOfGB.get(i).setState(BillState.EXAMINED);
					}
				}
				//保存单据信息
				billPool.save(tempOfVO.getBillStyle());
				break;
			case SpillsLossBill:
				break;
			case AlertBill:
				break;
			case PurSheet:
				break;
			case PurBackSheet:
				break;
			case SaleSheet:
				break;
			case SaleBackSheet:
				break;
			case ReceiptBill:
				break;
			case PaymentBill:
				break;
			case CashPaymentBill:
				break;
			}
		}
	}
	/*返回所有客户分层策略信息*/
	public ArrayList<VO> ShowLevelStrategy (){
		ArrayList<VO> result=new ArrayList<VO>();
		ArrayList<StubLevelStrategy> alOfLS=strategyPool.getLevelStrategy();
		for(int i=0;i<alOfLS.size();i++){
			result.add(alOfLS.get(i).getVO());
		}
		return result;
	}
	/*返回所有特价包策略信息*/
	public ArrayList<VO> ShowBarginStrategy (){
		ArrayList<VO> result=new ArrayList<VO>();
		ArrayList<StubBarginStrategy> alOfBS=strategyPool.getBarginStrategy();
		for(int i=0;i<alOfBS.size();i++){
			result.add(alOfBS.get(i).getVO());
		}
		return result;
	}
	/*返回所有满额促销策略信息*/
	public ArrayList<VO> ShowReachStrategy  (){
		ArrayList<VO> result=new ArrayList<VO>();
		ArrayList<StubReachStrategy> alOfRS=strategyPool.getReachStrategy();
		for(int i=0;i<alOfRS.size();i++){
			result.add(alOfRS.get(i).getVO());
		}
		return result;
	}
	/*需要删除一条客户分层策略*/
	public void Remove (LevelStrategyVO ls){
		strategyPool.RemoveLevelStrategy(ls.getID());
	}
	/*需要删除一条特价包策略*/
	public void Remove (BarginStrategyVO bs){
		strategyPool.RemoveBarginStrategy(bs.getID());
	}
	/*需要删除一条满额促销策略*/
	public void Remove (ReachStrategyVO rs){
		strategyPool.RemoveReachStrategy(rs.getID());
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public void addGiftLevelStrategy (LevelStrategyVO lsvo){
		
	}
	/*需要制定一个折让客户分层策略*/
	public void addDiscountLevelStrategy (LevelStrategyVO lsvo){
		
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public void addCouponLevelStrategy (LevelStrategyVO lsvo){
	
	}
	/*需要制定一条特价包促销策略*/
	public void addBarginStrategy (BarginStrategyVO bsvo){
		
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public void addGiftReachStrategy (ReachStrategyVO rsvo){
		
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public void addCouponReachStrategy (ReachStrategyVO rsvo){
		
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
