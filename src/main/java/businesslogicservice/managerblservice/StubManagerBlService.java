package businesslogicservice.managerblservice;

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
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.salebillbl.StubPurBackSheet;
import businesslogic.salebillbl.StubPurSheet;
import businesslogic.salebillbl.StubSaleBackSheet;
import businesslogic.salebillbl.StubSaleSheet;

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

	/*需要查看已提交单据*/
	public ArrayList<VO> getHandedBill ();
	/*修改密码*/
	public boolean modifyPassword (String newpassword);
    /*修改单据信息*/
	public boolean changeImformationOfBill(VO billvo);
	/*通过数组中对应的单据*/
	public boolean PassBill(ArrayList<VO> billvo);
	/*返回所有客户分层策略信息*/
	public ArrayList<VO> ShowLevelStrategy ();
	/*返回所有特价包策略信息*/
	public ArrayList<VO> ShowBarginStrategy ();
	/*返回所有满额促销策略信息*/
	public ArrayList<VO> ShowReachStrategy  ();
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
