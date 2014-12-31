package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import po.stockpo.CommodityPO;
import businesslogic.commoditybl.Commodity;
import businesslogic.customerbl.Customer;


public class SaleBackSheetPO extends PO implements Serializable{
	CustomerPO customer;
	String id;
	String userid;
	Date date;
	String stock;//仓库？
	ArrayList<CommodityPO> sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	double money2;
	double discount;
	double pmoney;
	String words;//备注
	String username;
	String op;
	private BillState billstate=BillState.DRAFT;
	ArrayList<String> commoditywords;//每项商品的备注;
	
	public ArrayList<String> getcommoditywords(){
		return this.commoditywords;
	}
	
	public void setcommoditywords(ArrayList<String> words){
		this.commoditywords=words;
	}
	
	
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
	
	public double getpmoney(){
		return pmoney;
	}
	
	public void  setpmoney(double pmoney){
		this.pmoney=pmoney;
	}
	
	public CustomerPO getcustomer(){
		return customer;
	}
	
	public void setCustomer(CustomerPO customer){
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
	
	public ArrayList<CommodityPO> getsheet(){
		return sheet;
	}
	
	public void setsheet(ArrayList<CommodityPO> sheet){
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
