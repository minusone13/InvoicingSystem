package businesslogic.financialbillbl;

import java.util.ArrayList;

import vo.CrashPaymentVO;

public class StubCashPaymentBill {
	String billNumber;
	String account;
	//Operator op;
	double total;
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public boolean creatCrashPayment(CrashPaymentVO cpv) {
		Item i = new Item();
		//对信息处理，保存到数据层，返回结果
		return true;
	}
}
