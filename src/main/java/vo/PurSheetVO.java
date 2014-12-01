package vo;

import java.util.ArrayList;

import businesslogic.BillStyle;
import businesslogic.customerbl.Customer;

public class PurSheetVO extends VO{
	private BillStyle style=BillStyle.PurSheet;
	Customer customer;
	String id;
	String commodity;//仓库？
	ArrayList sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
	String words;//备注
	
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
	
}
