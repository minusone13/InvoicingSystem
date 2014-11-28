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

public class PaymentBill extends Bill implements GetVOandPO{
	
	private BillStyle billstyle=BillStyle.PaymentBill;
	private String ID;
	private String customer;
	private Role operator;
	private double total;
	private BillState state;
	private String date;
	private ArrayList<StubTransferAccount> transferlist = new ArrayList<StubTransferAccount>();
	public PaymentBill() {
		
	}
	public PaymentBill(PaymentVO vo) {
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
		this.date = currentTime;
		StubBillPool pool = new StubBillPool();
		ArrayList<PaymentBill> list = pool.getPaymentBill();
		ID = "FKD-"+currentTime+"-"+String.format("%05d", list.size()+1);
	}
	
	public BillStyle getBillStyle() {
		return billstyle;
	}
	public void setBillStyle(BillStyle style) {
		this.billstyle = style;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public Role getOperator() {
		return operator;
	}
	public void setOperator(Role operator) {
		this.operator = operator;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public BillState getState() {
		return state;
	}
	public void setState(BillState state) {
		this.state = state;
	}
	public ArrayList<StubTransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<StubTransferAccount> transferlist) {
		this.transferlist = transferlist;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public PaymentVO getVO() {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer(customer);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setOperator(operator);
		vo.setState(state);
		vo.setTransferlist(transferlist);
		vo.setBillStyle(billstyle);
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
		po.setStyle(billstyle);
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
