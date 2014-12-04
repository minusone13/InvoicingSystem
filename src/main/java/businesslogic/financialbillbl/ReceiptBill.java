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
import vo.VO;
import vo.financialBillVO.ReceiptVO;

public class ReceiptBill extends Bill implements GetVOandPO{
	private BillStyle billstyle=BillStyle.ReceiptBill;
	
	private String ID;//单据编号
	private Role role;//权限
	private double total;//总额
	private BillState state;//单据状态
	private Date date;
	private String customer;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	
	
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
		this.role = vo.getRole();
		
		state = BillState.DRAFT;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		
		StubBillPool pool = new StubBillPool();
		ArrayList<ReceiptBill> list = pool.getReceiptBill();
		ID = "SKD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
		op = getUserName()+" "+getUserID();
	}
	
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	
	public String getOperator() {
		return this.op;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role r) {
		this.role = r;
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
		vo.setRole(role);
		vo.setTotal(total);
		vo.setTransferlist(transferlist);
		vo.setBillState(state);		
		return vo;
	}

	public ReceiptPO getPO() {
		ReceiptPO po = new ReceiptPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setRole(role);
		po.setState(state);
		po.setTotal(total);
		po.setTransferlist(transferlist);
		po.setStyle(billstyle);
		po.setOp(op);
		po.setUserID(userID);
		po.setUserName(userName);
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
