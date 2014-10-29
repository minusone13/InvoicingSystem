package businesslogic.examinebl;

import businesslogic.BillState;
import businesslogic.BillStyle;

public class Bill {
	private BillStyle style;//单据类型
	private String ID;//单据编号
	private BillState state;//单据状态
	/*设置单据状态*/
	public void setState(BillState st){
		state=st;
	}
	
	/*设置单据编号*/
	public  void setID(String s){
		ID=s;
	}
	
	/*获取单据状态*/
	public BillState getState(){
		return state;
		
	}
	/*获取单据编号*/
	public String getID(){
		return ID;	
	}
	/*获取单据类型*/
	public BillStyle getStyle(){
		return style;
		
	}
}
