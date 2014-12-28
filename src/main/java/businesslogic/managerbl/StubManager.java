package businesslogic.managerbl;

import java.util.ArrayList;

import po.BillState;
import po.BillStyle;
import vo.AlertBillVO;
import vo.BarginStrategyVO;
import vo.GiftBillVO;
import vo.LevelStrategyVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReachStrategyVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.VO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import vo.inquiryVO.BusinessSituationVO;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillbl.PurBackSheet;
import businesslogic.salebillbl.PurSheet;
import businesslogic.salebillbl.SaleBackSheet;
import businesslogic.salebillbl.SaleSheet;
import businesslogic.strategybl.StubBarginStrategy;
import businesslogic.strategybl.StubLevelStrategy;
import businesslogic.strategybl.StubReachStrategy;
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
		ArrayList<PurSheet> billList=billPool.getPurSheet(st);
		for(PurSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet (BillState st){
		ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
		ArrayList<PurBackSheet> billList=billPool.getPurBackSheet(st);
		for(PurBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet (BillState st){
		ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
		ArrayList<SaleSheet> billList=billPool.getSaleSheet(st);
		for(SaleSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet (BillState st){
		ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
		ArrayList<SaleBackSheet> billList=billPool.getSaleBackSheet(st);
		for(SaleBackSheet temp: billList){
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
		ArrayList<PurSheet> billList=billPool.getPurSheet();
		for(PurSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet (){
		ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
		ArrayList<PurBackSheet> billList=billPool.getPurBackSheet();
		for(PurBackSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;

	}
	/*获取单据池的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet (){
		ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
		ArrayList<SaleSheet> billList=billPool.getSaleSheet();
		for(SaleSheet temp: billList){
			result.add(temp.getVO());
		}
		
		return result;
	}
	/*获取单据池的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet (){
		ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
		ArrayList<SaleBackSheet> billList=billPool.getSaleBackSheet();
		for(SaleBackSheet temp: billList){
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

	/*修改密码（未实现）*/
	public boolean modifyPassword (String newpassword){
		return true;
		
	}
    /*修改单据信息*/
	public boolean change(GiftBillVO gb){
		billPool.change(gb);
		return true;
	}
	public boolean change(SpillsLossBillVO slb){
		billPool.change(slb);
		return true;
	}
	public boolean change(AlertBillVO ab){
		billPool.change(ab);
		return true;
	}
	public boolean change(PurSheetVO ps){
		billPool.change(ps);
		return true;
	}
	public boolean change(PurBackSheetVO pbs){
		billPool.change(pbs);
		return true;
	}
	public boolean change(SaleSheetVO ss){
		billPool.change(ss);
		return true;
	}
	public boolean change(SaleBackSheetVO sbs){
		billPool.change(sbs);
		return true;
	}
	public boolean change(ReceiptVO rb){
		billPool.change(rb);
		return true;
	}
	public boolean change(PaymentVO pb){
		billPool.change(pb);
		return true;
	}
	public boolean change(CashPaymentVO cb){
		billPool.change(cb);
		return true;
	}
	
	/*改单据状态*/
	public void transformState(BillStyle style,String ID,BillState state){
		billPool.transformState(style, ID, state);
	}
	
	/*返回所有客户分层策略信息*/
	public ArrayList<LevelStrategyVO> ShowLevelStrategy (){
		ArrayList<LevelStrategyVO> result=new ArrayList<LevelStrategyVO>();
		ArrayList<StubLevelStrategy> alOfLS=strategyPool.getLevelStrategy();
		for(int i=0;i<alOfLS.size();i++){
			result.add(alOfLS.get(i).getVO());
		}
		return result;
	}
	/*返回所有特价包策略信息*/
	public ArrayList<BarginStrategyVO> ShowBarginStrategy (){
		ArrayList<BarginStrategyVO> result=new ArrayList<BarginStrategyVO>();
		ArrayList<StubBarginStrategy> alOfBS=strategyPool.getBarginStrategy();
		for(int i=0;i<alOfBS.size();i++){
			result.add(alOfBS.get(i).getVO());
		}
		return result;
	}
	/*返回所有满额促销策略信息*/
	public ArrayList<ReachStrategyVO> ShowReachStrategy  (){
		ArrayList<ReachStrategyVO> result=new ArrayList<ReachStrategyVO>();
		ArrayList<StubReachStrategy> alOfRS=strategyPool.getReachStrategy();
		for(int i=0;i<alOfRS.size();i++){
			result.add(alOfRS.get(i).getVO());
		}
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
		ArrayList<MockCommodity> gift=new ArrayList<MockCommodity>();
		for(int i=0;i<lsvo.getAlOfCommodity().size();i++){
			MockCommodity temp=new MockCommodity(lsvo.getAlOfCommodity().get(i));
			gift.add(temp);
		}
		strategyPool.addGiftLevelStrategy(lsvo.getLevel(), lsvo.getLimit(),gift , lsvo.getStartTime(), lsvo.getLastTime());
		return true;
	}
	/*需要制定一个折让客户分层策略*/
	public boolean addDiscountLevelStrategy (LevelStrategyVO lsvo){
		strategyPool.addDiscountLevelStrategy(lsvo.getLevel(), lsvo.getDiscountrate(), lsvo.getStartTime(), lsvo.getLastTime());
		return true;
	}
	/*需要制定一个赠送代金券客户分层策略*/
	public boolean addCouponLevelStrategy (LevelStrategyVO lsvo){
		strategyPool.addCouponLevelStrategy(lsvo.getLevel(), lsvo.getCouponrate(),lsvo.getStartTime(), lsvo.getLastTime());
		return true;
	
	}
	/*需要制定一条特价包促销策略*/
	public boolean addBarginStrategy (BarginStrategyVO bsvo){
		ArrayList<MockCommodity> pack=new ArrayList<MockCommodity>();
		for(int i=0;i<bsvo.getAlOfCommodity().size();i++){
			MockCommodity temp=new MockCommodity(bsvo.getAlOfCommodity().get(i));
			pack.add(temp);
		}
		strategyPool.addBarginStrategy(pack,bsvo.getDiscount(), bsvo.getNum(), bsvo.getStartTime(), bsvo.getLastTime());
		return true;
		
	}
	/*需要制定一条赠送赠品的满额促销策略*/
	public boolean addGiftReachStrategy (ReachStrategyVO rsvo){
		ArrayList<MockCommodity> gift=new ArrayList<MockCommodity>();
		for(int i=0;i<rsvo.getAlOfCommodity().size();i++){
			MockCommodity temp=new MockCommodity(rsvo.getAlOfCommodity().get(i));
			gift.add(temp);
		}
		strategyPool.addReachStrategy(rsvo.getLimit(), gift, rsvo.getStartTime(),rsvo.getLastTime());
		return true;
		
	}
	/*需要制定一条赠送代金券的满额促销策略*/
	public boolean addCouponReachStrategy (ReachStrategyVO rsvo){
		strategyPool.addReachStrategy(rsvo.getLimit(), rsvo.getCouponrate(), rsvo.getStartTime(), rsvo.getLastTime());
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
	public LevelStrategyVO findLevelStrategy(String id)
	{
		// TODO Auto-generated method stub
		
		return strategyPool.findLevelStrategy(id).getVO();
	}
	public BarginStrategyVO findBarginStrategy(String id)
	{
		// TODO Auto-generated method stub
		
		return strategyPool.findBarginStrategy(id).getVO();
	}
	public ReachStrategyVO findReachStrategy(String id)
	{
		// TODO Auto-generated method stub
		
		return strategyPool.findReachStrategy(id).getVO();
	}

}
