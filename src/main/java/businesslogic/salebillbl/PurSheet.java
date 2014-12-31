package businesslogic.salebillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.BillStyle;
import po.PurSheetPO;
import po.stockpo.CommodityPO;
import vo.PurSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.Commodity;
import businesslogic.customerbl.Customer;
import businesslogic.customerbl.CustomerList;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForSalesMen;

public class PurSheet extends Bill implements GetVOandPO{
	private BillStyle billstyle=BillStyle.PurSheet;
	private BillState billstate=BillState.DRAFT;
	Date date;
	Customer customer;
	private String ID;
	private String userID;
	String stock;//仓库？
	ArrayList<Commodity> sheet;//是不是应该是个arraylist<>?
	double money1;//总金额
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
	
	
	public PurSheet(){};
	public PurSheet(PurSheetVO vo){
		this.customer=new Customer(vo.getcustomer());
		this.userID=vo.getuserid();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<PurSheet> list = pool.getPurSheet();
		this.ID = "JHD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		
		this.stock=vo.getstock();

		ArrayList<Commodity> temp=new ArrayList<Commodity>();
		for(int i=0;i<vo.getsheet().size();i++){
			temp.add(new Commodity(vo.getsheet().get(i)));
		}
		this.sheet=temp;
		this.money1=vo.getmoney1();
		this.words=vo.getwords();
		this.op=vo.getop();
		this.username=vo.getusername();
		this.billstate=vo.getState();
		this.commoditywords=vo.getcommoditywords();
	}
	
	public  BillState getState(){
		return this.billstate;
	}
	
	public  void setState(BillState billstate){
		StockBlForSalesMen stockservice = new StubStockController();
		CustomerList list = new CustomerList();
		PurSheetVO vo = this.getVO();
		System.out.println(billstate+"i am here");
		switch(billstate){
			case SUBMITED : 
				//那个返回的结果有什么用？
				for(CommodityVO tempvo:vo.getsheet()){
					stockservice.readyForIn(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
				}
				break;
			case EXAMINED : 
				
				break;
			case OVER     : 
				for(CommodityVO tempvo:vo.getsheet()){
					stockservice.checkIn(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getIn());
				}
				//System.out.println(this.getcustomer().getid());
				list.changeShouldPay(this.getcustomer().getid(), -vo.getmoney1());
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
		
		public ArrayList<Commodity> getsheet(){
			return sheet;
		}
		
		public void setsheet(ArrayList<Commodity> sheet){
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
			vo.setCustomer(customer.getVO());
			vo.setdate(date);
			vo.setid(ID);
			vo.setuserid(userID);
			vo.setmoney1(money1);
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
			return vo;
		}
		
		public PurSheetPO getPO() {
			PurSheetPO po = new PurSheetPO();
			po.setCustomer(customer.getPO());
			//转换成PO数组
			ArrayList<CommodityPO> temp=new ArrayList<CommodityPO>();
			for(int i=0;i<sheet.size();i++){
				temp.add(sheet.get(i).toPO());
			}
			po.setsheet(temp);
			po.setdate(date);
			po.setid(ID);
			po.setuserid(userID);
			po.setmoney1(money1);
			po.setstock(stock);
			po.setwords(words);
			po.setop(op);
			po.setusername(username);
			po.setState(billstate);		
			po.setcommoditywords(commoditywords);
			return po;
		}
		
		public void setPO(PurSheetPO po){
			this.customer=new Customer(po.getcustomer());
			this.userID=po.getuserid();
			this.date=po.getdate();
			this.stock=po.getstock();
			this.ID=po.getid();
			ArrayList<Commodity> temp=new ArrayList<Commodity>();
			for(int i=0;i<po.getsheet().size();i++){
				temp.add(new Commodity(po.getsheet().get(i)));
			}
			this.sheet=temp;
			this.money1=po.getmoney1();
			this.words=po.getwords();
			this.op=po.getop();
			this.username=po.getusername();
			this.billstate=po.getState();
			this.commoditywords=po.getcommoditywords();
		}
		
		
}
