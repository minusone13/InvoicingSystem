package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.customerbl.StubCustomer;

public class SaleSheetPO extends PO implements Serializable{
	StubCustomer customer;
	String id;
	String commodity;//仓库？
	ArrayList sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	double money2;
	double discount;
	double pmoney;
	String words;//备注
	
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
	
	public StubCustomer getcustomer(){
		return customer;
	}
	
	public void setCustomer(StubCustomer customer){
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
		
		
}
