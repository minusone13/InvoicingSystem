package businesslogic.financialbillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	private BillStyle billstyle=BillStyle.ReceiptBill;
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
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		ID = "SKD-"+currentTime;
	}

	public ReceiptVO getVO() {
		ReceiptVO vo = new ReceiptVO();
		vo.setCustomer(customer);
		vo.setID(ID);
		vo.setBillStyle(billstyle);
		vo.setOperator(operator);
		vo.setTotal(total);
		vo.setTransferlist(transferlist);
		vo.setBillState(state);		
		return vo;
	}

	public ReceiptPO getPO() {
		ReceiptPO po = new ReceiptPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setOperator(operator);
		po.setState(state);
		po.setTotal(total);
		po.setTransferlist(transferlist);
		po.setStyle(billstyle);
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
