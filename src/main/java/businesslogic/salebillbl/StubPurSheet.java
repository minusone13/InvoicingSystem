package businesslogic.salebillbl;

import java.util.ArrayList;
import java.util.Date;

import po.PurSheetPO;
import vo.PurSheetVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.Customer;
import businesslogic.examinebl.Bill;

public class StubPurSheet extends Bill implements GetVOandPO{
	private BillStyle billstyle=BillStyle.PurSheet;
	private BillState billstate=BillState.DRAFT;
	Date date;
	Customer customer;
	private String ID;
	private String userID;
	String stock;//仓库？
	ArrayList sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	String words;//备注
		
		public Date getDate() {
			return date;
		}
		
		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public BillStyle getBillstyle() {
			return billstyle;
		}
		
		public Customer getcustomer(){
			return customer;
		}
		
		public void setCustomer(Customer customer){
			this.customer=customer;
		}
		
		public String getid(){
			return this.ID;
		}
		
		public void setid(String ID){
			this.ID=ID;
		}
		
		public String getstock(){
			return stock;
		}
		
		public void setstock(String stock){
			this.stock=stock;
		}
		
		public ArrayList getsheet(){
			return sheet;
		}
		
		public void setsheet(ArrayList sheet){
			this.sheet=sheet;
		}
		
		public double getmoney1(){
			return money1;
		}
		
		public void setmoney1(double money1){
			this.money1=money1;
		}
		
		public String getwords(){
			return words;
		}

		public void setwords(String words){
			this.words=words;
		}
		
		public PurSheetVO getVO() {
			// TODO Auto-generated method stub
			return null;
		}
		public PurSheetPO getPO() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void setPO(PurSheetPO po){
			this.customer=po.getcustomer();
			this.userID=po.getuserid();
			this.date=po.getdate();
			this.stock=po.getstock();
			this.ID=po.getid();
			this.sheet=po.getsheet();
			this.money1=po.getmoney1();
			this.words=po.getwords();
		}
		
		
}
