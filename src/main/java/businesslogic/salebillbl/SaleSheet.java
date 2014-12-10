package businesslogic.salebillbl;

import java.util.ArrayList;
import java.util.Date;

import po.SaleSheetPO;
import vo.SaleSheetVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.examinebl.Bill;

public class SaleSheet extends Bill implements GetVOandPO{

		private String ID;
		private String userID;
		private BillStyle billstyle=BillStyle.SaleSheet;
		Date date;
		Customer customer;
		ArrayList<MockCommodity> sheet;//销售单据，商品名，数量，单价//ArrayList<>在写一个类；
		double money1;//折前总金额
		double money2;//代金券金额
		String stock;
		double discount;//折让金额；
		double pmoney;//最终金额
		String words;//备注
		String username;
		String op;
		
		public SaleSheet(){};
		public SaleSheet(SaleSheetVO vo){
			this.ID=vo.getid();
			this.customer=vo.getcustomer();
			this.sheet=vo.getsheet();
			this.discount=vo.getdiscount();
			this.money1=vo.getmoney1();
			this.money2=vo.getmoney2();
			this.pmoney=vo.getpmoney();
			this.words=vo.getwords();
			this.userID=vo.getuserid();
			this.username=vo.getusername();
			this.op=vo.getop();
			this.date=vo.getdate();
		};
		
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
		
		public String getUserID() {
			return userID;
		}
		public void setUserID(String userID) {
			this.userID = userID;
		}
		
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}

		public BillStyle getBillstyle() {
			return billstyle;
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
		
		public Customer getcustomer(){
			return customer;
		}
		
		public void setCustomer(Customer customer){
			this.customer=customer;
		}
		
		public String getid(){
			return ID;
		}
		
		public void setid(String id){
			this.ID=id;
		}
		
		public String getcommodity(){
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
		

		public SaleSheetVO getVO() {
			SaleSheetVO vo = new SaleSheetVO();
			vo.setCustomer(customer);
			vo.setdate(date);
			vo.setid(ID);
			vo.setuserid(userID);
			vo.setmoney1(money1);
			vo.setmoney2(money2);
			vo.setsheet(sheet);
			vo.setstock(stock);
			vo.setwords(words);
			vo.setop(op);
			vo.setusername(username);
			return vo;
		}
		
		public SaleSheetPO getPO() {
			SaleSheetPO po =new SaleSheetPO();
			po.setCustomer(customer);
			po.setdate(date);
			po.setid(ID);
			po.setuserid(userID);
			po.setmoney1(money1);
			po.setmoney2(money2);
			po.setsheet(sheet);
			po.setstock(stock);
			po.setwords(words);
			po.setop(op);
			po.setusername(username);
			return po;
		}
		
		public void setPO(SaleSheetPO po){
			this.ID=po.getid();
			this.customer=po.getcustomer();
			this.sheet=po.getsheet();
			this.discount=po.getdiscount();
			this.money1=po.getmoney1();
			this.money2=po.getmoney2();
			this.pmoney=po.getpmoney();
			this.words=po.getwords();
			this.userID=po.getuserid();
			this.username=po.getusername();
			this.op=po.getop();
			this.date=po.getdate();
		}
}
