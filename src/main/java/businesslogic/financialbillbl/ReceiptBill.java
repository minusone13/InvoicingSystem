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

public class ReceiptBill extends Bill implements GetVOandPO{
	private BillStyle billstyle=BillStyle.ReceiptBill;
	
	private String ID;
	private Role operator;
	private double total;
	private BillState state;
	private Date date;
	private String customer;
	
	
	ArrayList<StubTransferAccount> transferlist = new ArrayList<StubTransferAccount>();
	public ReceiptBill() {
		
	}
	public ReceiptBill(ReceiptVO vo) {
		String customer = vo.getCustomer();
		double total = vo.getTotal();
		String[] account = vo.getAccount();
		double[] money = vo.getMoney();
		String[] remark = vo.getRemark();
		int length = account.length;
		for(int i=0;i<length;i++) {
			transferlist.add(new StubTransferAccount(account[i], money[i], remark[i]));
		}
		this.date = new Date();
		this.customer = customer;
		this.total = total;
		this.operator = vo.getOperator();
		state = BillState.DRAFT;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		
		StubBillPool pool = new StubBillPool();
		ArrayList<ReceiptBill> list = pool.getReceiptBill();
		ID = "SKD-"+currentTime+"-"+String.format("%05d", list.size()+1);
	}
	
	public BillStyle getBillstyle() {
		return billstyle;
	}
	
	public Date getDate() {
		return date;
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
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	public void setDate(Date date) {
		this.date = date;
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
