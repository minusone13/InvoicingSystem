package businesslogic.salebillbl;

import java.util.ArrayList;

import po.PO;
import po.PurSheetPO;
import vo.VO;
import businesslogic.BillStyle;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.StubCustomer;
import businesslogic.examinebl.Bill;

public class StubPurSheet extends Bill implements GetVOandPO{
	private BillStyle style=BillStyle.PurSheet;
		StubCustomer customer;
		private String ID;
		String commodity;//仓库？
		ArrayList sheet;//是不是应该是个arraylist<>?
		double money1;//总金额
		String words;//备注
		public VO getVO() {
			// TODO Auto-generated method stub
			return null;
		}
		public PO getPO() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void setPO(PurSheetPO po){
			this.customer=po.getcustomer();
			this.commodity=po.getcommodity();
			this.ID=po.getid();
			this.sheet=po.getsheet();
			this.money1=po.getmoney1();
			this.words=po.getwords();
		}
		
		
}
