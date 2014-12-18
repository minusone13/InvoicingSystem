package businesslogicservice.managerblservice;

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
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillbl.PurBackSheet;
import businesslogic.salebillbl.PurSheet;
import businesslogic.salebillbl.SaleBackSheet;
import businesslogic.salebillbl.SaleSheet;

public interface StubManagerBlService {
	/*需要从单据池筛选指定状态的所有赠送单*/
	public ArrayList<GiftBillVO> getGiftBill (BillState st);
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<SpillsLossBillVO> getSpillsLossBill (BillState st);
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<AlertBillVO> getAlertBill (BillState st);
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<PurSheetVO> getPurSheet (BillState st);
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet (BillState st);
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet (BillState st);
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet (BillState st);
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptVO> getReceiptBill (BillState st);
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentVO> getPaymentBill (BillState st);
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentVO> getCashPaymentBill (BillState st);
	/*获取单据池所有赠送单*/
	public ArrayList<GiftBillVO> getGiftBill ();
	
	/*获取单据池的所有报溢/报损单*/
	public ArrayList<SpillsLossBillVO> getSpillsLossBill ();

	/*获取单据池的所有库存报警单*/
	public ArrayList<AlertBillVO> getAlertBill ();

	/*获取单据池的所有进货单*/
	public ArrayList<PurSheetVO> getPurSheet ();

	/*获取单据池的所有进货退货单*/
	public ArrayList<PurBackSheetVO> getPurBackSheet ();

	/*获取单据池的所有销售单*/
	public ArrayList<SaleSheetVO> getSaleSheet ();

	/*获取单据池的所有销售退货单*/
	public ArrayList<SaleBackSheetVO> getSaleBackSheet ();

	/*获取单据池的所有收款单*/
	public ArrayList<ReceiptVO> getReceiptBill ();

	/*获取单据池的所有付款单*/
	public ArrayList<PaymentVO> getPaymentBill ();

	/*获取单据池的所有现金费用单*/
	public ArrayList<CashPaymentVO> getCashPaymentBill ();

	/*修改密码*/
	public boolean modifyPassword (String newpassword);
    /*修改单据信息*/
	public boolean change(GiftBillVO gb);
	public boolean change(SpillsLossBillVO slb);
	public boolean change(AlertBillVO ab);
	public boolean change(PurSheetVO ps);
	public boolean change(PurBackSheetVO pbs);
	public boolean change(SaleSheetVO ss);
	public boolean change(SaleBackSheetVO sbs);
	public boolean change(ReceiptVO rb);
	public boolean change(PaymentVO pb);
	public boolean change(CashPaymentVO cb);
	/*改变单据状态*/
	public void transformState(BillStyle style,String ID,BillState state);
	/*返回所有客户分层策略信息*/
	public ArrayList<LevelStrategyVO> ShowLevelStrategy ();
	/*返回所有特价包策略信息*/
	public ArrayList<BarginStrategyVO> ShowBarginStrategy ();
	/*返回所有满额促销策略信息*/
	public ArrayList<ReachStrategyVO> ShowReachStrategy  ();
	/*需要删除一条客户分层策略*/
	public boolean Remove (LevelStrategyVO ls);
	/*需要删除一条特价包策略*/
	public boolean Remove (BarginStrategyVO bs);
	/*需要删除一条满额促销策略*/
	public boolean Remove (ReachStrategyVO rs);
	/*需要制定一个赠送赠品的客户分层策略*/
	public boolean addGiftLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一个折让客户分层策略*/
	public boolean addDiscountLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一个赠送代金券客户分层策略*/
	public boolean addCouponLevelStrategy (LevelStrategyVO lsvo);
	/*需要制定一条特价包促销策略*/
	public boolean addBarginStrategy (BarginStrategyVO bsvo);
	/*需要制定一条赠送赠品的满额促销策略*/
	public boolean addGiftReachStrategy (ReachStrategyVO rsvo);
	/*需要制定一条赠送代金券的满额促销策略*/
	public boolean addCouponReachStrategy (ReachStrategyVO rsvo);
	/*需要查看经营历程*/
	public ArrayList<VO> showBusinessProgress(String client,String operater,String warehouse,BillStyle billStyle, String StartTime,String LastTime);
	/*需要查看销售明细*/
	public ArrayList<VO> showSaleDetail(String client,String operater,String warehouse,String commodity, String StartTime,String LastTime);
	/*需要查看经营情况*/
	public BusinessSituationVO showBusinessSituation (String StartTime,String LastTime);

}
