package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillStyle;
import businesslogic.customerbl.Customer;
import businesslogic.salebillbl.commodity;

public class PurBackSheetVO extends VO{
	private BillStyle style=BillStyle.PurBackSheet;
	Customer customer;
	String id;
	String userid;
	Date date;
	String stock;//仓库？
	ArrayList<commodity> sheet;//是不是应该是个arraylist<>?
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
	public String getuserid(){
		return userid;
	}
	
	public void setuserid(String userid){
		this.userid=userid;
	}
	
	public Date getdate(){
		return date;
	}
	
	public void setdate(Date date){
		this.date=date;
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
	
	public ArrayList<commodity> getsheet(){
		return sheet;
	}
	
	public void setsheet(ArrayList<commodity> sheet){
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
