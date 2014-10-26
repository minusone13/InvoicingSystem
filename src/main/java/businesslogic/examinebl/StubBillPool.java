package businesslogic.examinebl;

import java.util.ArrayList;

import businesslogic.State;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.financialbillbl.StubCashPaymentBill;
import businesslogic.financialbillbl.StubPaymentBill;
import businesslogic.financialbillbl.StubReceiptBill;
import businesslogic.salebillbl.StubPurBackSheet;
import businesslogic.salebillbl.StubPurSheet;
import businesslogic.salebillbl.StubSaleBackSheet;
import businesslogic.salebillbl.StubSaleSheet;

public class StubBillPool {

	/*构造函数*/
	public StubBillPool(){
		
	}
	/*需要向单据池中加入一张库存赠送单*/
	public void add (StubGiftBill gb){
		
	}
	/*需要向单据池中加入一张报溢/报损单*/
	public void add (StubSpillsLossBill spb){
		
	}
	/*需要向单据池中加入一张库存报警单*/
	public void add (StubAlertBill ab){
		
	}
	/*需要向单据池中加入一张进货单*/
	public void add (StubPurSheet ps){
		
	}
	/*需要向单据池中加入一张进货退货单*/
	public void add (StubPurBackSheet pbs){
		
	}
	/*需要向单据池中加入一张销售单*/
	public void add (StubSaleSheet ss){
		
	}
	/*需要向单据池中加入一张销售退货单*/
	public void add (StubSaleBackSheet sbs){
		
	}
	/*需要向单据池中加入一张收款单*/
	public void add (StubReceiptBill rb){
		
	}
	/*需要向单据池中加入一张付款单*/
	public void add (StubPaymentBill pb){
		
	}
	/*需要向单据池中加入一张现金费用单*/
	public void add (StubCashPaymentBill cpb){
		
	}
	/*需要从单据池筛选指定状态的所有赠送单*/
	public ArrayList<StubGiftBill> getGiftBill (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<StubPurSheet> getPurSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<StubPurBackSheet> getPurBackSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<StubSaleSheet> getSaleSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<StubSaleBackSheet> getSaleBackSheet (State st){
		return null;
		
	}
	
}
