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
import vo.VO;
import vo.financialBillVO.PaymentVO;

public class PaymentBill extends Bill implements GetVOandPO{
	
	private BillStyle billstyle=BillStyle.PaymentBill;
	private String ID;
	private String customer;
	private Role role;
	private double total;
	private BillState state;
	private Date date;
	private String userID;
	private String userName;
	private String op;//操作员 userName+userID
	
	private ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
	public PaymentBill() {
		
	}
	public PaymentBill(PaymentVO vo) {
		String customer=vo.getCustomer(); 
		double total=vo.getTotal(); 
		ArrayList<String> account=vo.getAccounts(); 
		ArrayList<Double> money=vo.getMoney(); 
		ArrayList<String> remark=vo.getRemark();
		 
		int length = account.size();
		for(int i=0;i<length;i++) {
			transferlist.add(new TransferAccount(account.get(i), money.get(i), remark.get(i)));
		}
		this.customer = customer;
		this.total = total;
		this.role = vo.getRole();
		state = BillState.DRAFT;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<PaymentBill> list = pool.getPaymentBill();
		ID = "FKD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
		op = getUserName()+" "+getUserID();
	}
	
	public String getOperator() {
		return this.op;
	}
	public void setOp(String op) {
		this.op = op;
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
	public ArrayList<TransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<TransferAccount> transferlist) {
		this.transferlist = transferlist;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public PaymentVO getVO() {
		PaymentVO vo = new PaymentVO();
		vo.setCustomer(customer);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setRole(role);
		vo.setState(state);
		vo.setTransferlist(transferlist);
		vo.setBillStyle(billstyle);
		vo.setDate(date);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setOp(op);		
		return vo;
	}

	public PaymentPO getPO() {
		PaymentPO po = new PaymentPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setRole(role);
		po.setState(state);
		po.setTotal(total);
		po.setTransferlist(transferlist);
		po.setStyle(billstyle);
		po.setUserID(userID);
		po.setUserName(userName);
		po.setOp(op);
		po.setDate(date);
		return po;
	}
	public void setPO (PaymentPO po) {
		ID = po.getID();
		customer = po.getCustomer();
		total = po.getTotal();
		state = po.getState();
		transferlist = po.getTransferlist();
		role = po.getRole();
		billstyle = po.getStyle();
		userID = po.getUserID();
		userName = po.getUserName();
		op = po.getOp();
		date = po.getDate();
	}
}
