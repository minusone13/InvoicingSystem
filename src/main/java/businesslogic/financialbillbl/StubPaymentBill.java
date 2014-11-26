package businesslogic.financialbillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.PO;
import po.PaymentPO;
import po.ReceiptPO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.Role;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import vo.PaymentVO;
import vo.VO;

public class StubPaymentBill extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.PaymentBill;
	private String ID;
	String customer;
	Role operator;
	double total;
	BillState state;
	ArrayList<StubTransferAccount> transferlist = new ArrayList<StubTransferAccount>();
	public StubPaymentBill() {
		
	}
	public StubPaymentBill(PaymentVO vo) {
		String customer=vo.getCustomer(); 
		double total=vo.getTotal(); 
		String[] account=vo.getAccount(); 
		double[] money=vo.getMoney(); 
		String[] remark=vo.getRemark();
		 
		int length = account.length;
		for(int i=0;i<length;i++) {
			transferlist.add(new StubTransferAccount(account[i], money[i], remark[i]));
		}
		this.customer = customer;
		this.total = total;
		this.operator = vo.getOperator();
		state = BillState.DRAFT;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		
		StubBillPool pool = new StubBillPool();
		ArrayList<StubPaymentBill> list = pool.getPaymentBill();
		ID = "FKD-"+currentTime+"-"+String.format("%05d", list.size()+1);
	}

	
	public PaymentVO getVO() {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer(customer);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setOperator(operator);
		vo.setState(state);
		vo.setTransferlist(transferlist);
		vo.setBillStyle(style);
		return vo;
	}

	public PaymentPO getPO() {
		PaymentPO po = new PaymentPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setOperator(operator);
		po.setState(state);
		po.setTotal(total);
		po.setTransferlist(transferlist);
		po.setStyle(style);
		return po;
	}
	public void setPO (PaymentPO po) {
		ID = po.getID();
		customer = po.getCustomer();
		total = po.getTotal();
		state = po.getState();
		transferlist = po.getTransferlist();
	}
}
