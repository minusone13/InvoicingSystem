package businesslogic.financialbillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.BillState;
import businesslogic.Role;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import po.CashPaymentPO;
import po.PO;
import po.ReceiptPO;
import vo.VO;
import vo.financialBillVO.CashPaymentVO;

public class CashPaymentBill extends Bill implements GetVOandPO{
	
	private BillStyle billstyle=BillStyle.CashPaymentBill;
	private String ID;
	private String account;
	private Role role;
	private double total;
	private BillState state;
	private Date date;
	private String userID;
	private String userName;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private String op;//操作员 userName+userID
	
	public CashPaymentBill() {}
	public CashPaymentBill(CashPaymentVO vo) {
		String account = vo.getAccount(); 
		double total = vo.getTotal();
		ArrayList<String> item = vo.getItem();
		ArrayList<Double> money=vo.getMoney(); 
		ArrayList<String> remark=vo.getRemark();
		    
		int length = item.size();
		for(int i=0;i<length;i++) {
			itemList.add(new Item(item.get(i), money.get(i), remark.get(i)));
		}
		this.account = account;
		this.total = total;
		state = BillState.DRAFT;
		this.role = vo.getRole();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<CashPaymentBill> list = pool.getCashPaymentBill();
		ID = "XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
		op = getUserName()+" "+getUserID();
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
	public void setBillstyle(BillStyle billstyle) {
		this.billstyle = billstyle;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	public CashPaymentVO getVO() {
		CashPaymentVO vo = new CashPaymentVO();
		vo.setAccount(account);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setItemList(itemList);
		vo.setRole(role);
		vo.setBillStyle(billstyle);
		vo.setBillState(state);	
		vo.setUserID(userID);
		vo.setUserName(userName);
		vo.setOp(op);
		vo.setDate(date);
		return vo;
	}
	
	public CashPaymentPO getPO() {
		CashPaymentPO po = new CashPaymentPO();
		po.setAccount(account);
		po.setID(ID);
		po.setItemList(itemList);
		po.setRole(role);
		po.setState(state);
		po.setStyle(billstyle);
		po.setTotal(total);
		po.setDate(date);
		po.setUserID(userID);
		po.setUserName(userName);
		po.setOp(op);
		return po;
	}
	
	public void setPO (CashPaymentPO po) {
		ID = po.getID();
		account = po.getAccount();
		total = po.getTotal();
		state = po.getState();
		billstyle = po.getStyle();
		itemList = po.getItemList();
		role = po.getRole();
		date = po.getDate();
		userID = po.getUserID();
		userName = po.getUserName();
		op = po.getOp();
	}
}
