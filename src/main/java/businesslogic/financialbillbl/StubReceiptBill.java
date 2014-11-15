package businesslogic.financialbillbl;

import java.util.ArrayList;

import po.PO;
import po.ReceiptPO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.Role;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import vo.ReceiptVO;
import vo.VO;

public class StubReceiptBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.ReceiptBill;
	private String ID;
	String customer;
	Role operator = Role.FINANTCIAL_STAFF;
	double total;
	BillState state;
	ArrayList<StubTransferAccount> transferlist = new ArrayList<StubTransferAccount>();
	public StubReceiptBill() {
		
	}
	public StubReceiptBill(String customer, double total, String[] account, double[] money, String[] remark) {
		int length = account.length;
		for(int i=0;i<length;i++) {
			transferlist.add(new StubTransferAccount(account[i], money[i], remark[i]));
		}
		this.customer = customer;
		this.total = total;
		state = BillState.DRAFT;	
	}

	public VO getVO() {
		return null;
	}

	public PO getPO() {
		ReceiptPO po = new ReceiptPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setOperator(operator);
		po.setState(state);
		po.setTotal(total);
		po.setTransferlist(transferlist);
		po.setStyle(style);
		return po;
	}
	public void setPO (ReceiptPO po) {
		ID = po.getID();
		customer = po.getCustomer();
		total = po.getTotal();
		state = po.getState();
		transferlist = po.getTransferlist();
	}
}
