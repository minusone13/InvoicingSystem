package businesslogic.financialbillbl;

import vo.CashPaymentVO;
import vo.PaymentVO;
import vo.ReceiptVO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;

public class StubFinancialBillList {
	
	public boolean creatReceiptBill(ReceiptVO vo) {		
		StubBillPool pool = new StubBillPool();
		if(vo==null) return false;
		StubReceiptBill receipt = new StubReceiptBill(vo);
		pool.add(receipt);	
		return true;
	}
	
	public boolean creatPaymentBill(PaymentVO vo) {		
		StubBillPool pool = new StubBillPool();
		if(vo==null) return false;
		StubPaymentBill payment = new StubPaymentBill(vo);
		pool.add(payment);	
		return true;
	}
	
	public boolean creatCashPaymentBill(CashPaymentVO vo) {		
		StubBillPool pool = new StubBillPool();
		if(vo==null) return false;
		StubCashPaymentBill cash = new StubCashPaymentBill(vo);
		pool.add(cash);
		return true;
	}
	
}
