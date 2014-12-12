package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;


public class PurSheetVO extends VO{
	//private BillStyle style=BillStyle.PurSheet;
	Customer customer;
	String id;
	String userid;
	Date date;
	String stock;//仓库？
	ArrayList<MockCommodity> sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	String words;//备注
	String username;
	String op;
	private BillState billstate=BillState.DRAFT;
	
	public  BillState getState(){
		return this.billstate;
	}
	
	public  void setState(BillState billstate){
		this.billstate= billstate;
	}
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
	
	public Date getdate(){
		return date;
	}
	
	public void setdate(Date date){
		this.date=date;
	}
	
	public String getuserid(){
		return userid;
	}
	
	public void setuserid(String userid){
		this.userid=userid;
	}
	
	public Customer getcustomer(){
		return customer;
	}
	
	public void setCustomer(Customer customer){
		this.customer=customer;
	}
	
	public String getid(){
		return id;
	}
	
	public void setid(String id){
		this.id=id;
	}
	
	public String getstock(){
		return stock;
	}
	
	public void setstock(String stock){
		this.stock=stock;
	}
	
	public ArrayList<MockCommodity> getsheet(){
		return sheet;
	}
	
	public void setsheet(ArrayList<MockCommodity> sheet){
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
	
}
