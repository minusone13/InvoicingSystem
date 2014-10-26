package businesslogic.financialbillbl;

import java.util.ArrayList;

import vo.ReceiptVO;

public class StubReceiptBill {
	String billNumber;
	//Customer c;
	//Operator op;
	double total;
	ArrayList<TransferAccount> talist = new ArrayList<TransferAccount>();
	
	public boolean creatReceipt(ReceiptVO rv) {
		TransferAccount ta = new TransferAccount();
		//对信息处理，保存到数据层，返回结果
		return true;
	}
	
}
