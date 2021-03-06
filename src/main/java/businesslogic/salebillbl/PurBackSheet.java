package businesslogic.salebillbl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.BillState;
import po.BillStyle;
import po.PurBackSheetPO;
import po.stockpo.CommodityPO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.stockvo.CommodityVO;
import businesslogic.GetVOandPO;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.customerbl.Customer;
import businesslogic.customerbl.CustomerList;
import businesslogic.examinebl.Bill;
import businesslogic.examinebl.StubBillPool;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogic.stockservice.StockBlForSalesMen;

public class PurBackSheet extends Bill implements GetVOandPO{
	Customer customer;
	private String ID;
	private String userID;
	private BillStyle billstyle=BillStyle.PurBackSheet;
	private BillState billstate=BillState.DRAFT;
	Date date;
	String stock;//仓库？
	ArrayList<MockCommodity> sheet;//写了一个commodityInSheet类。
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
	
	public PurBackSheet(){};
	public PurBackSheet(PurBackSheetVO vo){
		this.customer=new Customer(vo.getcustomer());
		this.userID=vo.getuserid();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentTime = format.format(new Date());
		this.date = new Date();
		StubBillPool pool = new StubBillPool();
		ArrayList<PurBackSheet> list = pool.getPurBackSheet();
		this.ID = "JHTHD-"+currentTime+"-"+String.format("%05d", list.size()+1);
		this.stock=vo.getstock();
		//转换成VO数组
		ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
		for(int i=0;i<vo.getsheet().size();i++){
			temp.add(new MockCommodity(vo.getsheet().get(i)));
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
		PurBackSheetVO vo = this.getVO();
		switch(billstate){
			case SUBMITED : 
				for(CommodityVO tempvo:vo.getsheet()){
					stockservice.readyForOut(tempvo.getId(), tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
				}
				break;
			case EXAMINED : 
				
				break;
			case OVER     :
				for(CommodityVO tempvo:vo.getsheet()){
					stockservice.undoCheckOut(tempvo.getId(),  tempvo.getName(), tempvo.getModel(), tempvo.getNumber(), tempvo.getOut());
				}
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
	
	public BillStyle getBillstyle() {
		return billstyle;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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
	
	public PurBackSheetVO getVO() {
		PurBackSheetVO vo = new PurBackSheetVO();
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
	
	public PurBackSheetPO getPO() {
		PurBackSheetPO po= new PurBackSheetPO();
		po.setCustomer(customer.getPO());
		po.setdate(date);
		po.setid(ID);
		po.setuserid(userID);
		po.setmoney1(money1);
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
		return po;
	}
	
	public void setPO(PurBackSheetPO po){
		this.customer=new Customer(po.getcustomer());
		this.userID=po.getuserid();
		this.date=po.getdate();
		this.stock=po.getstock();
		this.ID=po.getid();
		ArrayList<MockCommodity> temp=new ArrayList<MockCommodity>();
		for(int i=0;i<po.getsheet().size();i++){
			temp.add(new MockCommodity(po.getsheet().get(i)));
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
