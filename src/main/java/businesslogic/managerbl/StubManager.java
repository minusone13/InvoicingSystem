package businesslogic.managerbl;

import java.util.ArrayList;

import vo.AlertBillVO;
import vo.BarginStrategyVO;
import vo.BusinessSituationVO;
import vo.CashPaymentVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.PaymentVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.ReceiptVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.VO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillbl.StubPurBackSheet;
import businesslogic.salebillbl.StubPurSheet;
import businesslogic.salebillbl.StubSaleBackSheet;
import businesslogic.salebillbl.StubSaleSheet;
import businesslogic.strategybl.StubStrategyPool;
import businesslogicservice.managerblservice.StubManagerBlService;

public class StubManager implements StubManagerBlService{

	private String ID;
	private String name;
	private StubBillPool billPool=new StubBillPool();
	private StubStrategyPool strategyPool=new StubStrategyPool();
	
	/*构造方法*/
	public StubManager(){
		
	}
	/*需要从单据池筛选指定状态的所有赠送单*/
	public ArrayList<GiftBillVO> getGiftBill (BillState st){
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		ArrayList<StubGiftBill> billList=billPool.getGiftBill(st);
		for(StubGiftBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<SpillsLossBillVO> getSpillsLossBill (BillState st){
		ArrayList<SpillsLossBillVO> result=new ArrayList<SpillsLossBillVO>();
		ArrayList<StubSpillsLossBill> billList=billPool.getSpillsLossBill(st);
		for(StubSpillsLossBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

		
	}
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<AlertBillVO> getAlertBill (BillState st){
		ArrayList<AlertBillVO> result=new ArrayList<AlertBillVO>();
		ArrayList<StubAlertBill> billList=billPool.getAlertBill(st);
		for(StubAlertBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<PurSheetVO> getPurSheet (BillState st){
		ArrayList<PurSheetVO> result=new ArrayList<PurSheetVO>();
		ArrayList<StubPurSheet> billList=billPool.getPurSheet(st);
		for(StubPurSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet (BillState st){
		ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
		ArrayList<StubPurBackSheet> billList=billPool.getPurBackSheet(st);
		for(StubPurBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet (BillState st){
		ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
		ArrayList<StubSaleSheet> billList=billPool.getSaleSheet(st);
		for(StubSaleSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet (BillState st){
		ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
		ArrayList<StubSaleBackSheet> billList=billPool.getSaleBackSheet(st);
		for(StubSaleBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptVO> getReceiptBill (BillState st){
		ArrayList<ReceiptVO> result=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptBill> billList=billPool.getReceiptBill(st);
		for(ReceiptBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentVO> getPaymentBill (BillState st){
		ArrayList<PaymentVO> result=new ArrayList<PaymentVO>();
		ArrayList<PaymentBill> billList=billPool.getPaymentBill(st);
		for(PaymentBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentVO> getCashPaymentBill (BillState st){
		ArrayList<CashPaymentVO> result=new ArrayList<CashPaymentVO>();
		ArrayList<CashPaymentBill> billList=billPool.getCashPaymentBill(st);
		for(CashPaymentBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*获取单据池所有赠送单*/
	public ArrayList<GiftBillVO> getGiftBill (){
		ArrayList<GiftBillVO> result=new ArrayList<GiftBillVO>();
		ArrayList<StubGiftBill> billList=billPool.getGiftBill();
		for(StubGiftBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	
	}
	/*获取单据池的所有报溢/报损单*/
	public ArrayList<SpillsLossBillVO> getSpillsLossBill (){
		ArrayList<SpillsLossBillVO> result=new ArrayList<SpillsLossBillVO>();
		ArrayList<StubSpillsLossBill> billList=billPool.getSpillsLossBill();
		for(StubSpillsLossBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有库存报警单*/
	public ArrayList<AlertBillVO> getAlertBill (){
		ArrayList<AlertBillVO> result=new ArrayList<AlertBillVO>();
		ArrayList<StubAlertBill> billList=billPool.getAlertBill();
		for(StubAlertBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*获取单据池的所有进货单*/
	public ArrayList<PurSheetVO> getPurSheet (){
		ArrayList<PurSheetVO> result=new ArrayList<PurSheetVO>();
		ArrayList<StubPurSheet> billList=billPool.getPurSheet();
		for(StubPurSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet (){
		ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
		ArrayList<StubPurBackSheet> billList=billPool.getPurBackSheet();
		for(StubPurBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*获取单据池的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet (){
		ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
		ArrayList<StubSaleSheet> billList=billPool.getSaleSheet();
		for(StubSaleSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet (){
		ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
		ArrayList<StubSaleBackSheet> billList=billPool.getSaleBackSheet();
		for(StubSaleBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*获取单据池的所有收款单*/
	public ArrayList<ReceiptVO> getReceiptBill (){
		ArrayList<ReceiptVO> result=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptBill> billList=billPool.getReceiptBill();
		for(ReceiptBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有付款单*/
	public ArrayList<PaymentVO> getPaymentBill (){
		ArrayList<PaymentVO> result=new ArrayList<PaymentVO>();
		ArrayList<PaymentBill> billList=billPool.getPaymentBill();
		for(PaymentBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有现金费用单*/
	public ArrayList<CashPaymentVO> getCashPaymentBill (){
		ArrayList<CashPaymentVO> result=new ArrayList<CashPaymentVO>();
		ArrayList<CashPaymentBill> billList=billPool.getCashPaymentBill();
		for(CashPaymentBill temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

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
		ArrayList<ReceiptBill> alOfRB=billPool.getReceiptBill(BillState.SUBMITED);
		ArrayList<PaymentBill> alOfPB=billPool.getPaymentBill(BillState.SUBMITED);
		ArrayList<CashPaymentBill> alOfCPB=billPool.getCashPaymentBill(BillState.SUBMITED);

		//进行逐个大遍历，返回符合条件单据对应的VO
		//赠送单
		if(alOfGB!=null){
			for(StubGiftBill temp:alOfGB){
				result.add(temp.getVO());
			}
		}
		//报溢报损单
		if(alOfSLB!=null){
			for(StubSpillsLossBill temp:alOfSLB){
				result.add(temp.getVO());
			}
		}
		//报警单
		if(alOfAB!=null){
			for(StubAlertBill temp:alOfAB){
				result.add(temp.getVO());
			}
		}
		//进货单
		if(alOfPS!=null){
			for(StubPurSheet temp:alOfPS){
				result.add(temp.getVO());
			}
		}
		//进货退货单
		if(alOfPBS!=null){
			for(StubPurBackSheet temp:alOfPBS){
				result.add(temp.getVO());
			}
		}
		//销售单
		if(alOfSS!=null){
			for(StubSaleSheet temp:alOfSS){
				result.add(temp.getVO());
			}
		}
		//销售退货单
		if(alOfSBS!=null){
			for(StubSaleBackSheet temp:alOfSBS){
				result.add(temp.getVO());
			}
		}
		//收款单
		if(alOfRB!=null){
			for(ReceiptBill temp:alOfRB){
				result.add(temp.getVO());
			}
		}
		//付款单
		if(alOfPB!=null){
			for(PaymentBill temp:alOfPB){
				result.add(temp.getVO());
			}
		}
		//现金费用单
		if(alOfCPB!=null){
			for(CashPaymentBill temp:alOfCPB){
				result.add(temp.getVO());
			}
		}
		return result;	
	}
	/*修改密码*/
	public boolean modifyPassword (String newpassword){
		return true;
		
	}
    /*修改单据信息*/
	public boolean changeImformationOfBill(VO billvo){
		//通过新VO修改对应单据对象的信息
		if(billvo!=null){
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
				billPool.save();
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

		
		return true;
	}
	/*通过数组中对应的单据*/
	public boolean PassBill(ArrayList<VO> billvo){
		if(billvo!=null){
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
					billPool.save();
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

		return true;
	}
	/*返回所有客户分层策略信息*/
	public ArrayList<VO> ShowLevelStrategy (){
		ArrayList<VO> result=new ArrayList<VO>();
//		ArrayList<StubLevelStrategy> alOfLS=strategyPool.getLevelStrategy();
//		for(int i=0;i<alOfLS.size();i++){
//			result.add(alOfLS.get(i).getVO());
//		}
		return result;
	}
	/*返回所有特价包策略信息*/
	public ArrayList<VO> ShowBarginStrategy (){
		ArrayList<VO> result=new ArrayList<VO>();
//		ArrayList<StubBarginStrategy> alOfBS=strategyPool.getBarginStrategy();
//		for(int i=0;i<alOfBS.size();i++){
//			result.add(alOfBS.get(i).getVO());
//		}
		return result;
	}
	/*返回所有满额促销策略信息*/
	public ArrayList<VO> ShowReachStrategy  (){
		ArrayList<VO> result=new ArrayList<VO>();
//		ArrayList<StubReachStrategy> alOfRS=strategyPool.getReachStrategy();
//		for(int i=0;i<alOfRS.size();i++){
//			result.add(alOfRS.get(i).getVO());
//		}
		return result;
	}
	/*需要删除一条客户分层策略*/
	public boolean Remove (LevelStrategyVO ls){
		String ID=ls.getID();
		strategyPool.RemoveLevelStrategy(ID);
		return true;
	}
	/*需要删除一条特价包策略*/
	public boolean Remove (BarginStrategyVO bs){
		strategyPool.RemoveBarginStrategy(bs.getID());
		return true;
	}
	/*需要删除一条满额促销策略*/
	public boolean Remove (ReachStrategyVO rs){
		strategyPool.RemoveReachStrategy(rs.getID());
		return true;
	}
	/*需要制定一个赠送赠品的客户分层策略*/
	public boolean addGiftLevelStrategy (LevelStrategyVO lsvo){
		return true;
		
	}
	/*需要制定一个折让客户分层策略*/
	public boolean addDiscountLevelStrategy (LevelStrategyVO lsvo){
		return true;
		
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public boolean addCouponLevelStrategy (LevelStrategyVO lsvo){
		return true;
	
	}
	/*需要制定一条特价包促销策略*/
	public boolean addBarginStrategy (BarginStrategyVO bsvo){
		return true;
		
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public boolean addGiftReachStrategy (ReachStrategyVO rsvo){
		return true;
		
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public boolean addCouponReachStrategy (ReachStrategyVO rsvo){
		return true;
		
	}
	/*需要查看经营历程*/
	public ArrayList<VO> showBusinessProgress(String client,String operater,String warehouse,BillStyle billStyle, String StartTime,String LastTime){
		return new ArrayList<VO>();
		
	}
	/*需要查看销售明细*/
	public ArrayList<VO> showSaleDetail(String client,String operater,String warehouse,String commodity, String StartTime,String LastTime){
		return new ArrayList<VO>();
		
	}
	/*需要查看经营情况*/
	public BusinessSituationVO showBusinessSituation (String StartTime,String LastTime){
		return new BusinessSituationVO();
	
	}

}
