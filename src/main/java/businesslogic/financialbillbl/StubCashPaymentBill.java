package businesslogic.financialbillbl;

import java.util.ArrayList;

import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import po.PO;
import vo.CashPaymentVO;
import vo.VO;

public class StubCashPaymentBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.CashPaymentBill;
	private String ID;
	String account;
	String operator;
	double total;
	BillState state;
	ArrayList<StubItem> itemList = new ArrayList<StubItem>();
	
	public boolean creatCashPayment(CashPaymentVO cpv) {
		StubItem i = new StubItem();
		new StubBillPool().add(new StubCashPaymentBill());
		return true;
	}
	
	public VO getVO() {
		return new VO();
	}
	
	public PO getPO() {
		return new PO();
	}
}
