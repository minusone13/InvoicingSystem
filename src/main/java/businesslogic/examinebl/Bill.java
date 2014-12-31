package businesslogic.examinebl;

import po.BillState;
import po.BillStyle;
import businesslogic.commoditybillbl.AlertBill;

public class Bill {
	private BillStyle billstyle;//单据类型
	private String ID;//单据编号
	private BillState state=BillState.DRAFT;//单据状态,初始状态为草稿
	/*设置单据状态*/
	public void setState(BillState st){
		state=st;
	}
	
	
	/*获取单据状态*/
	public BillState getState(){
		return state;
		
	}
	/*获取单据类型*/

	
	public BillStyle getBillstyle(){
		return billstyle;
	}	

}
