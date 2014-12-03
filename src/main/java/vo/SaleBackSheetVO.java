package vo;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.BillStyle;
import businesslogic.customerbl.Customer;

public class SaleBackSheetVO extends VO{
	private BillStyle style=BillStyle.SaleBackSheet;
	Customer customer;
	String id;
	String userid;
	Date date;
	String commodity;//仓库？
	ArrayList sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	double money2;
	double discount;
	double pmoney;
	String words;//备注
	String stock;
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
	public double getmoney2(){
		return money2;
	}
	
	public void setmoney2(double money2){
		this.money2=money2;
	}
	
	public double getdiscount(){
		return discount;
	}
	
	public void setdiscount(double discount){
		this.discount=discount;
	}
	
	public double pmoney(){
		return pmoney;
	}
	
	public void  setpmoney(double pmoney){
		this.pmoney=pmoney;
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
	
	public String getcommodity(){
		return commodity;
	}
	
	public void setcommodity(String commodity){
		this.commodity=commodity;
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

	public void setstock(String stock) {
		this.stock=stock;
	}
	
	public String getstock(){
		return this.stock;
	}
		
}
