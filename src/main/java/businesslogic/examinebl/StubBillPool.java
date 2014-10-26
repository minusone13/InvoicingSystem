package businesslogic.examinebl;

import java.util.ArrayList;

import businesslogic.State;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.financialbillbl.CrashPayment;
import businesslogic.financialbillbl.Payment;
import businesslogic.financialbillbl.Receipt;
import businesslogic.salebillbl.PurBackSheet;
import businesslogic.salebillbl.PurSheet;
import businesslogic.salebillbl.SaleBackSheet;
import businesslogic.salebillbl.SaleSheet;

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
	public void add (PurSheet ps){
		
	}
	/*需要向单据池中加入一张进货退货单*/
	public void add (PurBackSheet pbs){
		
	}
	/*需要向单据池中加入一张销售单*/
	public void add (SaleSheet ss){
		
	}
	/*需要向单据池中加入一张销售退货单*/
	public void add (SaleBackSheet sbs){
		
	}
	/*需要向单据池中加入一张收款单*/
	public void add (Receipt rb){
		
	}
	/*需要向单据池中加入一张付款单*/
	public void add (Payment pb){
		
	}
	/*需要向单据池中加入一张现金费用单*/
	public void add (CrashPayment cpb){
		
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
	public ArrayList<PurSheet> getPurSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<PurBackSheet> getPurBackSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<SaleSheet> getSaleSheet (State st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<SaleBackSheet> getSaleBackSheet (State st){
		return null;
		
	}
	
}
