package businesslogic.salebillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.BillStyle;
import po.SaleSheetPO;
import po.stockpo.CommodityPO;
import vo.PurBackSheetVO;
import vo.SaleSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.customerbl.CustomerList;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForSalesMen;

public class SaleSheet extends Bill implements GetVOandPO{

		private String ID;
		private String userID;
		private BillStyle billstyle=BillStyle.SaleSheet;
		private BillState billstate=BillState.DRAFT;
		Date date;
		Customer customer;
		ArrayList<MockCommodity> sheet=new ArrayList<MockCommodity>();//销售单据，商品名，数量，单价//ArrayList<>在写一个类；
		double money1;//折前总金额
		double money2;//代金券金额
		String stock;//仓库；
		double discount;//折让金额；
		double pmoney;//最终金额
		String words;//备注
		String username;
		String op;
		ArrayList<String> commoditywords;//每项商品的备注;
		
		public ArrayList<String> getcommoditywords(){
			return this.commoditywords;
		}
		
		public void setcommoditywords(ArrayList<String> words){
			this.commoditywords=words;
		}
		
		
		public SaleSheet(){};
		public SaleSheet(SaleSheetVO vo){
			this.customer=new Customer(vo.getcustomer());//王雨城加
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String currentTime = format.format(new Date());
			this.date = new Date();
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> list = pool.getSaleSheet();
			this.ID = "XSD-"+currentTime+"-"+String.format("%05d", list.size()+1);
			
			
			ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
			for(int i=0;i<vo.getsheet().size();i++){
				temp.add(new MockCommodity(vo.getsheet().get(i)));
			}
			this.sheet=temp;
			this.stock=vo.getstock();
			this.discount=vo.getdiscount();
			this.money1=vo.getmoney1();
			this.money2=vo.getmoney2();
			this.pmoney=vo.getpmoney();
			this.words=vo.getwords();
			this.userID=vo.getuserid();
			this.username=vo.getusername();
			this.op=vo.getop();
			this.date=vo.getdate();
			this.billstate=vo.getState();
			this.commoditywords=vo.getcommoditywords();
		};
		
		public  BillState getState(){
			return this.billstate;
		}
		
		public  void setState(BillState billstate){
			StockBlForSalesMen stockservice = new StubStockController();
			CustomerList list = new CustomerList();
			SaleSheetVO vo = this.getVO();
			switch(billstate){
				case SUBMITED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.readyForOut(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case EXAMINED : 
					for(CommodityVO tempvo:vo.getsheet()){
						stockservice.checkOut(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
					}
					break;
				case OVER     : 
					list.changeShouldTake(this.getcustomer().getid(), -vo.getmoney1());
					break;
				
			}
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
			vo.setCustomer(customer.getVO());
			vo.setdate(date);
			vo.setid(ID);
			vo.setuserid(userID);
			vo.setmoney1(money1);
			vo.setmoney2(money2);
			//转换成VO数组
			ArrayList<CommodityVO> temp=new ArrayList<CommodityVO>();
			for(int i=0;i<sheet.size();i++){
				temp.add(sheet.get(i).toVO());
			}
			vo.setsheet(temp);
			vo.setstock(stock);
			vo.setwords(words);
			vo.setop(op);
			vo.setusername(username);
			vo.setState(billstate);
			vo.setcommoditywords(commoditywords);
			vo.setpmoney(pmoney);//王雨城加
			return vo;
		}
		
		public SaleSheetPO getPO() {
			SaleSheetPO po =new SaleSheetPO();
			po.setCustomer(customer.getPO());
			po.setdate(date);
			po.setid(ID);
			po.setuserid(userID);
			po.setmoney1(money1);
			po.setmoney2(money2);
			//转换成PO数组
			ArrayList<CommodityPO> temp=new ArrayList<CommodityPO>();
			for(int i=0;i<sheet.size();i++){
				temp.add(sheet.get(i).toPO());
			}
			po.setsheet(temp);
			po.setstock(stock);
			po.setwords(words);
			po.setop(op);
			po.setusername(username);
			po.setState(billstate);
			po.setcommoditywords(commoditywords);
			po.setpmoney(pmoney);//王雨城加
			return po;
		}
		
		public void setPO(SaleSheetPO po){
			this.ID=po.getid();
			this.customer=new Customer(po.getcustomer());
			ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
			for(int i=0;i<po.getsheet().size();i++){
				temp.add(new MockCommodity(po.getsheet().get(i)));
			}
			this.sheet=temp;
			this.stock=po.getstock();
			this.discount=po.getdiscount();
			this.money1=po.getmoney1();
			this.money2=po.getmoney2();
			this.pmoney=po.getpmoney();
			this.words=po.getwords();
			this.userID=po.getuserid();
			this.username=po.getusername();
			this.op=po.getop();
			this.date=po.getdate();
			this.billstate=po.getState();
			this.commoditywords=po.getcommoditywords();
		}
}
