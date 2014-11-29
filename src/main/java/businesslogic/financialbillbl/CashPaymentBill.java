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
	private Role operator;
	private double total;
	private BillState state;
	private Date date;
	private String userID;
	private ArrayList<StubItem> itemList = new ArrayList<StubItem>();
	
	public CashPaymentBill() {}
	public CashPaymentBill(CashPaymentVO vo) {
		String account = vo.getAccount(); 
		double total = vo.getTotal();
		String[] item = vo.getItem();
		double[] money=vo.getMoney(); 
		String[] remark=vo.getRemark();
		    
		int length = item.length;
		for(int i=0;i<length;i++) {
			itemList.add(new StubItem(item[i], money[i], remark[i]));
		}
		this.account = account;
		this.total = total;
		state = BillState.DRAFT;
		this.operator = vo.getOperator();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<CashPaymentBill> list = pool.getCashPaymentBill();
		ID = "XJFYD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<StubItem> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<StubItem> itemList) {
		this.itemList = itemList;
	}
	public CashPaymentVO getVO() {
		CashPaymentVO vo = new CashPaymentVO();
		vo.setAccount(account);
		vo.setID(ID);
		vo.setTotal(total);
		vo.setItemList(itemList);
		vo.setOperator(operator);
		vo.setBillStyle(billstyle);
		vo.setBillState(state);		
		return vo;
	}
	
	public CashPaymentPO getPO() {
		CashPaymentPO po = new CashPaymentPO();
		po.setAccount(account);
		po.setID(ID);
		po.setItemList(itemList);
		po.setOperator(operator);
		po.setState(state);
		po.setStyle(billstyle);
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
