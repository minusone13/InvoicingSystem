package businesslogic.financialbillbl;

import java.util.ArrayList;

import po.PO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import vo.ReceiptVO;
import vo.VO;

public class StubReceiptBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.ReceiptBill;
	private String ID;
	String customer ;
	String operator;
	double total;
	BillState state;
	ArrayList<StubTransferAccount> talist = new ArrayList<StubTransferAccount>();
	
	public boolean creatReceipt(ReceiptVO rv) {
		StubTransferAccount ta = new StubTransferAccount();
		new StubBillPool().add(new StubReceiptBill());
		return true;
	}

	public VO getVO() {
		return null;
	}

	public PO getPO() {
		return null;
	}
	
}
