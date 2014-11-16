package businesslogic.financialbillbl;

import java.util.ArrayList;

import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.Role;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import po.CashPaymentPO;
import po.PO;
import po.ReceiptPO;
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
	
	public CashPaymentVO getVO() {
		CashPaymentVO vo = new CashPaymentVO();
		vo.setAccount(account);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setItemList(itemList);
		vo.setOperator(operator);
		vo.setStyle(style);
		vo.setState(state);		
		return vo;
	}
	
	public CashPaymentPO getPO() {
		CashPaymentPO po = new CashPaymentPO();
		po.setAccount(account);
		po.setID(ID);
		po.setItemList(itemList);
		po.setOperator(operator);
		po.setState(state);
		po.setStyle(style);
		po.setTotal(total);
		return po;
	}
	
	public void setPO (CashPaymentPO po) {
		ID = po.getID();
		account = po.getAccount();
		total = po.getTotal();
		state = po.getState();
		itemList = po.getItemList();		
	}
}
