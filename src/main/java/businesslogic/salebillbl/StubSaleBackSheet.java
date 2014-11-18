package businesslogic.salebillbl;

import java.util.ArrayList;

import po.SaleBackSheetPO;
import vo.SaleBackSheetVO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.StubCustomer;
import businesslogic.examinebl.Bill;

public class StubSaleBackSheet extends Bill implements GetVOandPO{
	private String ID;
	private BillStyle style=BillStyle.SaleBackSheet;
	StubCustomer customer;
	ArrayList sheet;//销售单据，商品名，数量，单价
	double money1;//折前总金额
	double money2;//代金券金额
	double disconut;//折让金额；
	double pmoney;//最终金额，代金券不退还。
	String words;//备注
	public SaleBackSheetVO getVO() {
		// TODO Auto-generated method stub
		return null;
	}
	public SaleBackSheetPO getPO() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPO(SaleBackSheetPO po){
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

