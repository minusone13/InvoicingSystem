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
	//userVO修改的
		private String userID = "001";
		private String userName = "梅杰";
		private Role role = Role.FINANCIAL_MANAGER;//权限
	
	
	private BillStyle billstyle=BillStyle.ReceiptBill;
	private String ID;//单据编号	
	private double total;//总额
	private BillState state;//单据状态
	private Date date;
	private String customer;
	private String op;//操作员 userName+userID
	ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
	
	public ReceiptBill() {
		
	}
	public ReceiptBill(ReceiptVO vo) {
		ArrayList<String> account = vo.getAccounts();
		ArrayList<Double> money = vo.getMoney();
		ArrayList<String> remark = vo.getRemark();
		int length = account.size();
		for(int i=0;i<length;i++) {
			transferlist.add(new TransferAccount(account.get(i), money.get(i), remark.get(i)));
		}
		this.date = new Date();
		this.customer = vo.getCustomer();
		this.total = vo.getTotal();
		state = vo.getBillState();
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
	public ArrayList<TransferAccount> getTransferlist() {
		return transferlist;
	}
	public void setTransferlist(ArrayList<TransferAccount> transferlist) {
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
		int size = transferlist.size();
		TransferAccount temp=null;
		ArrayList<String> accounts = vo.getAccounts();
		ArrayList<Double> money = vo.getMoney();
		ArrayList<String> remark = vo.getRemark();		
		for(int i=0;i<size;i++){
			temp = transferlist.get(i);
			accounts.add(temp.getAccount());
			money.add(temp.getMoney());
			remark.add(temp.getRemark());
		}
		vo.setAccounts(accounts);
		vo.setMoney(money);
		vo.setRemark(remark);
		vo.setBillState(state);
		vo.setOp(op);
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setDate(date);
		return vo;
	}

	public ReceiptPO getPO() {
		ReceiptPO po = new ReceiptPO();
		po.setCustomer(customer);
		po.setID(ID);
		po.setRole(role);
		po.setState(state);
		po.setTotal(total);
		int size = transferlist.size();
		TransferAccount temp=null;
		ArrayList<String> accounts = po.getAccounts();
		ArrayList<Double> money = po.getMoney();
		ArrayList<String> remark = po.getRemark();		
		for(int i=0;i<size;i++){
			temp = transferlist.get(i);
			accounts.add(temp.getAccount());
			money.add(temp.getMoney());
			remark.add(temp.getRemark());
		}
		po.setAccounts(accounts);
		po.setMoney(money);
		po.setRemark(remark);
		po.setStyle(billstyle);
		po.setOp(op);
		po.setUserID(userID);
		po.setUserName(userName);
		po.setDate(date);
		return po;
	}
	public void setPO (ReceiptPO po) {
		ID = po.getID();
		customer = po.getCustomer();
		total = po.getTotal();
		state = po.getState();
		ArrayList<String> account = po.getAccounts();
		ArrayList<Double> money = po.getMoney();
		ArrayList<String> remark = po.getRemark();
		int length = account.size();
		for(int i=0;i<length;i++) {
			transferlist.add(new TransferAccount(account.get(i), money.get(i), remark.get(i)));
		}
		role = po.getRole();
		billstyle = po.getStyle();
		op = po.getOp();
		userID = po.getUserID();
		userName = po.getUserName();
		date = po.getDate();
	}
}
