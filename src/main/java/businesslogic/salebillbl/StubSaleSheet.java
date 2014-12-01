package businesslogic.salebillbl;

import java.util.ArrayList;
import java.util.Date;

import po.SaleSheetPO;
import vo.SaleSheetVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.Customer;
import businesslogic.examinebl.Bill;

public class StubSaleSheet extends Bill implements GetVOandPO{

	private String ID;
	private String userID;
	private BillStyle billstyle=BillStyle.SaleSheet;
		
		Date date;
		
		Customer customer;
		ArrayList sheet;//销售单据，商品名，数量，单价//ArrayList<>在写一个类；
		double money1;//折前总金额
		double money2;//代金券金额
		double disconut;//折让金额；
		double pmoney;//最终金额
		String words;//备注
		
		public Customer getCustomer() {
			return customer;
		}
		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
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

		public SaleSheetVO getVO() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public SaleSheetPO getPO() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void setPO(SaleSheetPO po){
			this.ID=po.getid();
			this.customer=po.getcustomer();
			this.sheet=po.getsheet();
			this.disconut=po.getdiscount();
			this.money1=po.getmoney1();
			this.money2=po.getmoney2();
			this.pmoney=po.getpmoney();
			this.words=po.getwords();
		}
}
