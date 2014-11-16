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
		StubReceiptBill receipt = new StubReceiptBill(vo.getCustomer(), vo.getTotal(), vo.getAccount(), vo.getMoney(), vo.getRemark());
		pool.add(receipt);	
		return true;
	}
	
	public boolean creatPaymentBill(PaymentVO vo) {		
		StubBillPool pool = new StubBillPool();
		StubPaymentBill payment = new StubPaymentBill(vo.getCustomer(), vo.getTotal(), vo.getAccount(), vo.getMoney(), vo.getRemark());
		pool.add(payment);	
		return true;
	}
	
	public boolean creatCashPaymentBill(CashPaymentVO vo) {		
		StubBillPool pool = new StubBillPool();
		StubCashPaymentBill cash = new StubCashPaymentBill(vo.getAccount(), vo.getTotal(), vo.getItem(), vo.getMoney(), vo.getRemark());
		pool.add(cash);
		return true;
	}
	
}
