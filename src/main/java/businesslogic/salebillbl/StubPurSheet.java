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
	String username;
	String op;
	
	public String getop(){
		return this.op;
	}
	
	public void setop(String op){
		this.op=op;
	}
	
	public String getusername(){
		return this.username;
	}
	
	public void setusername(String username){
		this.username=username;
	}
	
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
			PurSheetVO vo = new PurSheetVO();
			vo.setCustomer(customer);
			vo.setdate(date);
			vo.setid(ID);
			vo.setuserid(userID);
			vo.setmoney1(money1);
			vo.setsheet(sheet);
			vo.setstock(stock);
			vo.setwords(words);
			vo.setop(op);
			vo.setusername(username);
			return vo;
		}
		
		public PurSheetPO getPO() {
			PurSheetPO po = new PurSheetPO();
			po.setCustomer(customer);
			po.setdate(date);
			po.setid(ID);
			po.setuserid(userID);
			po.setmoney1(money1);
			po.setsheet(sheet);
			po.setstock(stock);
			po.setwords(words);
			po.setop(op);
			po.setusername(username);
			return po;
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
			this.op=po.getop();
			this.username=po.getusername();
		}
		
		
}
