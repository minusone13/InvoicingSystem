package businesslogic.examinebl;

import java.util.ArrayList;

import businesslogic.BillState;
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

	private ArrayList<StubGiftBill> alOfGiftBill;
	private ArrayList<StubSpillsLossBill> alOfSpillsLossBill;
	private ArrayList<StubAlertBill> alOfAlertBill;
	private ArrayList<StubPurSheet> alOfPurSheet;
	private ArrayList<StubPurBackSheet> alOfPurBackSheet;
	private ArrayList<StubSaleSheet> alOfSaleSheet;
	private ArrayList<StubSaleBackSheet> alOfSaleBackSheet;
	private ArrayList<StubReceiptBill> alOfReceiptBill;
	private ArrayList<StubPaymentBill> alOfPaymentBill;
	private ArrayList<StubCashPaymentBill> alOfCashPaymentBill;
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
	public ArrayList<StubGiftBill> getGiftBill (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<StubPurSheet> getPurSheet (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<StubPurBackSheet> getPurBackSheet (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<StubSaleSheet> getSaleSheet (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<StubSaleBackSheet> getSaleBackSheet (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<StubReceiptBill> getReceiptBill (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<StubPaymentBill> getPaymentBill (BillState st){
		return null;
		
	}
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<StubCashPaymentBill> getCashPaymentBill (BillState st){
		return null;
		
	}
}
