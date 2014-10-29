package businesslogic.salebillbl;

import java.util.ArrayList;

import po.PO;
import vo.VO;
import businesslogic.GetVOandPO;
import businesslogic.customerbl.StubCustomer;
import businesslogic.examinebl.Bill;

public class StubPurBackSheet extends Bill implements GetVOandPO{
	StubCustomer customer;
	String id;
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
}
