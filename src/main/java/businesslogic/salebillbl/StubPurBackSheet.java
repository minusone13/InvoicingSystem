package businesslogic.salebillbl;

import java.util.ArrayList;
import java.util.Date;

import po.PurBackSheetPO;
import vo.PurBackSheetVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.StubCustomer;
import businesslogic.examinebl.Bill;

public class StubPurBackSheet extends Bill implements GetVOandPO{
	StubCustomer customer;
	private String ID;
	private String userID;
	
	private BillStyle billstyle=BillStyle.PurBackSheet;
	
	Date date;
	
	String commodity;//仓库？
	ArrayList sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	String words;//备注
	
	public BillStyle getBillstyle() {
		return billstyle;
	}
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public PurBackSheetVO getVO() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPO(PurBackSheetPO po){
		this.customer=po.getcustomer();
		this.commodity=po.getcommodity();
		this.ID=po.getid();
		this.sheet=po.getsheet();
		this.money1=po.getmoney1();
		this.words=po.getwords();
	}
	
	public PurBackSheetPO getPO() {
		// TODO Auto-generated method stub
		return null;
	}
}
