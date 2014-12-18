package businesslogic.financialbillbl;

import java.util.ArrayList;

import po.BillState;
import po.BillStyle;
import vo.VO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;

public class FinancialBillList {
	StubBillPool pool = new StubBillPool();
	public boolean creatReceiptBill(ReceiptVO vo) {		
		
		if(vo==null) return false;
		ReceiptBill receipt = new ReceiptBill(vo);
		pool.add(receipt);	
		return true;
	}
	
	public void updateReceiptBill(ReceiptVO vo) {
		if(vo==null) return;
		pool.change(vo);
	}
	
	
	
	public boolean creatPaymentBill(PaymentVO vo) {		
		if(vo==null) return false;
		PaymentBill payment = new PaymentBill(vo);
		pool.add(payment);	
		return true;
	}
	
	public void updatePaymentBill(PaymentVO vo) {
		if(vo==null) return;
		pool.change(vo);
	}
	
	public boolean creatCashPaymentBill(CashPaymentVO vo) {		
		if(vo==null) return false;
		CashPaymentBill cash = new CashPaymentBill(vo);
		pool.add(cash);
		return true;
	}
	
	public void updateCashPaymentBill(CashPaymentVO vo) {
		if(vo==null) return;
		pool.change(vo);
	}
	
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<ReceiptVO> getAllOfReceiptBills (){
		ArrayList<ReceiptVO> result=new ArrayList<ReceiptVO>();
		ArrayList<ReceiptBill> billList=pool.getReceiptBill();
		for(ReceiptBill temp: billList){
			result.add(temp.getVO());
		}	
		return result;
	}
	
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentVO> getAllOfPaymentBills (){
		ArrayList<PaymentVO> result=new ArrayList<PaymentVO>();
		ArrayList<PaymentBill> billList=pool.getPaymentBill();
		for(PaymentBill temp: billList){
			result.add(temp.getVO());
		}
		return result;
	}
	
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentVO> getAllOfCashPaymentBills (){
		ArrayList<CashPaymentVO> result=new ArrayList<CashPaymentVO>();
		ArrayList<CashPaymentBill> billList=pool.getCashPaymentBill();
		for(CashPaymentBill temp: billList){
			result.add(temp.getVO());
		}	
		return result;
	}
	
	
}
