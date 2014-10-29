package businesslogic.financialbillbl;

import java.util.ArrayList;

import po.PO;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.examinebl.StubBillPool;
import vo.ReceiptVO;
import vo.VO;

public class StubReceiptBill implements GetVOandPO{
	String billNumber;
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
