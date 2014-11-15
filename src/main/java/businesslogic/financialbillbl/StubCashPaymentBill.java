package businesslogic.financialbillbl;

import java.util.ArrayList;

import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.Role;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import po.PO;
import vo.CashPaymentVO;
import vo.VO;

public class StubCashPaymentBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.CashPaymentBill;
	private String ID;
	String account;
	Role operator = Role.FINANTCIAL_STAFF;
	double total;
	BillState state;
	ArrayList<StubItem> itemList = new ArrayList<StubItem>();
	
	public StubCashPaymentBill() {}
	public StubCashPaymentBill(String account, double total, String[] item, double[] money, String[] remark) {
		int length = item.length;
		for(int i=0;i<length;i++) {
			itemList.add(new StubItem(item[i], money[i], remark[i]));
		}
		this.account = account;
		this.total = total;
		state = BillState.DRAFT;	
	}
	
	public VO getVO() {
		return new VO();
	}
	
	public PO getPO() {
		return new PO();
	}
}
