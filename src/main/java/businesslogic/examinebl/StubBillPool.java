package businesslogic.examinebl;

import java.util.ArrayList;

import po.AlertBillPO;
import po.CashPaymentPO;
import po.GiftBillPO;
import po.PaymentPO;
import po.PurBackSheetPO;
import po.PurSheetPO;
import po.ReceiptPO;
import po.SaleBackSheetPO;
import po.SaleSheetPO;
import po.SpillsLossBillPO;
import businesslogic.BillState;
import businesslogic.BillStyle;
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
import data.billdata.CommodityBillSaver;
import data.billdata.FinancialBillSaver;
import data.billdata.SaleBillSaver;
import dataservice.billdataservice.CommodityBillSaverService;
import dataservice.billdataservice.FinancialBillSaverService;
import dataservice.billdataservice.SaleBillSaverService;

public class StubBillPool {

	//暂时用新new的对象
	//待对象序列化写好后，都用从txt读取的对象
	private ArrayList<StubGiftBill> alOfGiftBill=new ArrayList<StubGiftBill>();
	private ArrayList<StubSpillsLossBill> alOfSpillsLossBill=new ArrayList<StubSpillsLossBill>();
	private ArrayList<StubAlertBill> alOfAlertBill=new ArrayList<StubAlertBill>();
	private ArrayList<StubPurSheet> alOfPurSheet=new ArrayList<StubPurSheet>();
	private ArrayList<StubPurBackSheet> alOfPurBackSheet=new ArrayList<StubPurBackSheet>();
	private ArrayList<StubSaleSheet> alOfSaleSheet=new ArrayList<StubSaleSheet>();
	private ArrayList<StubSaleBackSheet> alOfSaleBackSheet=new ArrayList<StubSaleBackSheet>();
	private ArrayList<StubReceiptBill> alOfReceiptBill=new ArrayList<StubReceiptBill>();
	private ArrayList<StubPaymentBill> alOfPaymentBill=new ArrayList<StubPaymentBill>();
	private ArrayList<StubCashPaymentBill> alOfCashPaymentBill=new ArrayList<StubCashPaymentBill>();
	/*构造函数*/
	public StubBillPool(){
		//读取文档中的对象
		SaleBillSaverService sbs=new SaleBillSaver();
		FinancialBillSaverService fbs=new FinancialBillSaver();
		CommodityBillSaverService cbs=new CommodityBillSaver();
		
		//将返回的PO对象的信息传入真正的单据对象
		//赠送单
		ArrayList<GiftBillPO> GiftBillListPO=cbs.getGiftBill();
		if(GiftBillListPO!=null){
			for(GiftBillPO tempPO:GiftBillListPO){
				StubGiftBill gb=new StubGiftBill();
				gb.setPO(tempPO);
				alOfGiftBill.add(gb);
			}
		}
		//报警单
		ArrayList<AlertBillPO> AlertBillListPO=cbs.getAlertBill();
		if(AlertBillListPO!=null){
			for(AlertBillPO tempPO:AlertBillListPO){
				StubAlertBill ab=new StubAlertBill();
				ab.setPO(tempPO);
				alOfAlertBill.add(ab);
			}
		}
		//报溢报损单
		ArrayList<SpillsLossBillPO> SpillsLossBillListPO=cbs.getSpillsLossBill();
		if(SpillsLossBillListPO!=null){
			for(SpillsLossBillPO tempPO:SpillsLossBillListPO){
				StubSpillsLossBill slb=new StubSpillsLossBill();
				slb.setPO(tempPO);
				alOfSpillsLossBill.add(slb);
			}
		}
		//进货单
		ArrayList<PurSheetPO> PurSheetListPO=sbs.getPurSheet();
		if(PurSheetListPO!=null){
			for(PurSheetPO tempPO:PurSheetListPO){
				StubPurSheet ps=new StubPurSheet();
				ps.setPO(tempPO);
				alOfPurSheet.add(ps);
			}
		}
		//进货退货单
		ArrayList<PurBackSheetPO> PurBackSheetListPO=sbs.getPurBackSheet();
		if(PurBackSheetListPO!=null){
			for(PurBackSheetPO tempPO:PurBackSheetListPO){
				StubPurBackSheet pbs=new StubPurBackSheet();
				pbs.setPO(tempPO);
				alOfPurBackSheet.add(pbs);
			}
		}
		//销售单
		ArrayList<SaleSheetPO> SaleSheetListPO=sbs.getSaleSheet();
		if(SaleSheetListPO!=null){
			for(SaleSheetPO tempPO:SaleSheetListPO){
				StubSaleSheet ss=new StubSaleSheet();
				ss.setPO(tempPO);
				alOfSaleSheet.add(ss);
			}
		}
		//销售退货单
		ArrayList<SaleBackSheetPO> SaleBackSheetListPO=sbs.getSaleBackSheet();
		if(SaleBackSheetListPO!=null){
			for(SaleBackSheetPO tempPO:SaleBackSheetListPO){
				StubSaleBackSheet salebs=new StubSaleBackSheet();
				salebs.setPO(tempPO);
				alOfSaleBackSheet.add(salebs);
			}
		}
		//收款单
		ArrayList<ReceiptPO> ReceiptBillListPO=fbs.getReceipt();
		if(ReceiptBillListPO!=null){
			for(ReceiptPO tempPO:ReceiptBillListPO){
				StubReceiptBill rcb=new StubReceiptBill();
				rcb.setPO(tempPO);
				alOfReceiptBill.add(rcb);
			}
		}
		//付款单
		ArrayList<PaymentPO> PaymentBillListPO=fbs.getPayment();
		if(PaymentBillListPO!=null){
			for(PaymentPO tempPO:PaymentBillListPO){
				StubPaymentBill pmb=new StubPaymentBill();
				pmb.setPO(tempPO);
				alOfPaymentBill.add(pmb);
			}
		}
		//赠送单
		ArrayList<CashPaymentPO> CashPaymentBillListPO=fbs.getCashPayment();
		if(CashPaymentBillListPO!=null){
			for(CashPaymentPO tempPO:CashPaymentBillListPO){
				StubCashPaymentBill cpb=new StubCashPaymentBill();
				cpb.setPO(tempPO);
				alOfCashPaymentBill.add(cpb);
			}
		}

		
	}
	/*需要向单据池中加入一张库存赠送单*/
	public void add (StubGiftBill gb){
		alOfGiftBill.add(gb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张报溢/报损单*/
	public void add (StubSpillsLossBill spb){
		alOfSpillsLossBill.add(spb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张库存报警单*/
	public void add (StubAlertBill ab){
		alOfAlertBill.add(ab);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张进货单*/
	public void add (StubPurSheet ps){
		alOfPurSheet.add(ps);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张进货退货单*/
	public void add (StubPurBackSheet pbs){
		alOfPurBackSheet.add(pbs);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张销售单*/
	public void add (StubSaleSheet ss){
		alOfSaleSheet.add(ss);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张销售退货单*/
	public void add (StubSaleBackSheet sbs){
		alOfSaleBackSheet.add(sbs);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张收款单*/
	public void add (StubReceiptBill rb){
		alOfReceiptBill.add(rb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张付款单*/
	public void add (StubPaymentBill pb){
		alOfPaymentBill.add(pb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张现金费用单*/
	public void add (StubCashPaymentBill cpb){
		alOfCashPaymentBill.add(cpb);
		//保存
		this.save();
	}
	/*需要从单据池筛选指定状态的所有赠送单*/
	public ArrayList<StubGiftBill> getGiftBill (BillState st){
		ArrayList<StubGiftBill> result=new ArrayList<StubGiftBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubGiftBill temp:alOfGiftBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		return result;	
	}
	/*需要从单据池筛选指定状态的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (BillState st){
		ArrayList<StubSpillsLossBill> result=new ArrayList<StubSpillsLossBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubSpillsLossBill temp:alOfSpillsLossBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (BillState st){
		ArrayList<StubAlertBill> result=new ArrayList<StubAlertBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubAlertBill temp:alOfAlertBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有进货单*/
	public ArrayList<StubPurSheet> getPurSheet (BillState st){
		ArrayList<StubPurSheet> result=new ArrayList<StubPurSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubPurSheet temp:alOfPurSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有进货退货单*/
	public ArrayList<StubPurBackSheet> getPurBackSheet (BillState st){
		ArrayList<StubPurBackSheet> result=new ArrayList<StubPurBackSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubPurBackSheet temp:alOfPurBackSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有销售单*/
	public ArrayList<StubSaleSheet> getSaleSheet (BillState st){
		ArrayList<StubSaleSheet> result=new ArrayList<StubSaleSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubSaleSheet temp:alOfSaleSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有销售退货单*/
	public ArrayList<StubSaleBackSheet> getSaleBackSheet (BillState st){
		ArrayList<StubSaleBackSheet> result=new ArrayList<StubSaleBackSheet>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubSaleBackSheet temp:alOfSaleBackSheet){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;
		
	}
	/*需要从单据池筛选指定状态的所有收款单*/
	public ArrayList<StubReceiptBill> getReceiptBill (BillState st){
		ArrayList<StubReceiptBill> result=new ArrayList<StubReceiptBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubReceiptBill temp:alOfReceiptBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;	
	}
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<StubPaymentBill> getPaymentBill (BillState st){
		ArrayList<StubPaymentBill> result=new ArrayList<StubPaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubPaymentBill temp:alOfPaymentBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		return result;
	}
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<StubCashPaymentBill> getCashPaymentBill (BillState st){
		ArrayList<StubCashPaymentBill> result=new ArrayList<StubCashPaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(StubCashPaymentBill temp:alOfCashPaymentBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}	
		return result;
	}
	/*获取单据池所有赠送单*/
	public ArrayList<StubGiftBill> getGiftBill (){
		return alOfGiftBill;	
	}
	/*获取单据池的所有报溢/报损单*/
	public ArrayList<StubSpillsLossBill> getSpillsLossBill (){
		return alOfSpillsLossBill;
	}
	/*获取单据池的所有库存报警单*/
	public ArrayList<StubAlertBill> getAlertBill (){
		return alOfAlertBill;
	}
	/*获取单据池的所有进货单*/
	public ArrayList<StubPurSheet> getPurSheet (){
		return alOfPurSheet;
	}
	/*获取单据池的所有进货退货单*/
	public ArrayList<StubPurBackSheet> getPurBackSheet (){
		return alOfPurBackSheet;
	}
	/*获取单据池的所有销售单*/
	public ArrayList<StubSaleSheet> getSaleSheet (){
		return alOfSaleSheet;
	}
	/*获取单据池的所有销售退货单*/
	public ArrayList<StubSaleBackSheet> getSaleBackSheet (){
		return alOfSaleBackSheet;
	}
	/*获取单据池的所有收款单*/
	public ArrayList<StubReceiptBill> getReceiptBill (){
		return alOfReceiptBill;	
	}
	/*获取单据池的所有付款单*/
	public ArrayList<StubPaymentBill> getPaymentBill (){
		return alOfPaymentBill;
	}
	/*获取单据池的所有现金费用单*/
	public ArrayList<StubCashPaymentBill> getCashPaymentBill (){
		return alOfCashPaymentBill;
	}
	/*实时保存池中数组对象*/
	public void save(){
		//保存文档中的对象
		SaleBillSaverService sbs=new SaleBillSaver();
		FinancialBillSaverService fbs=new FinancialBillSaver();
		CommodityBillSaverService cbs=new CommodityBillSaver();
		
		//赠送单
		ArrayList<GiftBillPO> GiftBillPO=new ArrayList<GiftBillPO>();
		for(StubGiftBill temp:alOfGiftBill){//遍历数组，将对应PO对象加到新数组中
			GiftBillPO.add(temp.getPO());
		}
		cbs.saveGiftBill(GiftBillPO);//保存PO数组到txt
		//报溢报损单
		ArrayList<SpillsLossBillPO> SpillsLossBillPO=new ArrayList<SpillsLossBillPO>();
		for(StubSpillsLossBill temp:alOfSpillsLossBill){//遍历数组，将对应PO对象加到新数组中
			SpillsLossBillPO.add(temp.getPO());
		}
		cbs.saveSpillsLossBill(SpillsLossBillPO);//保存PO数组到txt
		//报警单
		ArrayList<AlertBillPO> AlertBillPO=new ArrayList<AlertBillPO>();
		for(StubAlertBill temp:alOfAlertBill){//遍历数组，将对应PO对象加到新数组中
			AlertBillPO.add(temp.getPO());
		}
		cbs.saveAlertBill(AlertBillPO);;//保存PO数组到txt
		//进货单
		ArrayList<PurSheetPO> PurSheetPO=new ArrayList<PurSheetPO>();
		for(StubPurSheet temp:alOfPurSheet){//遍历数组，将对应PO对象加到新数组中
			PurSheetPO.add(temp.getPO());
		}
		sbs.savePurSheet(PurSheetPO);//保存PO数组到txt
		//进货退货单
		ArrayList<PurBackSheetPO> PurBackSheetPO=new ArrayList<PurBackSheetPO>();
		for(StubPurBackSheet temp:alOfPurBackSheet){//遍历数组，将对应PO对象加到新数组中
			PurBackSheetPO.add(temp.getPO());
		}
		sbs.savePurBackSheet(PurBackSheetPO);//保存PO数组到txt

		//销售单
		ArrayList<SaleSheetPO> SaleSheetPO=new ArrayList<SaleSheetPO>();
		for(StubSaleSheet temp:alOfSaleSheet){//遍历数组，将对应PO对象加到新数组中
			SaleSheetPO.add(temp.getPO());
		}
		sbs.saveSaleSheet(SaleSheetPO);//保存PO数组到txt
		//销售退货单
		ArrayList<SaleBackSheetPO> SaleBackSheetPO=new ArrayList<SaleBackSheetPO>();
		for(StubSaleBackSheet temp:alOfSaleBackSheet){//遍历数组，将对应PO对象加到新数组中
			SaleBackSheetPO.add(temp.getPO());
		}
		sbs.saveSaleBackSheet(SaleBackSheetPO);//保存PO数组到txt
		//收款单
		ArrayList<ReceiptPO> ReceiptBillPO=new ArrayList<ReceiptPO>();
		for(StubReceiptBill temp:alOfReceiptBill){//遍历数组，将对应PO对象加到新数组中
			ReceiptBillPO.add(temp.getPO());
		}
		fbs.saveReceipt(ReceiptBillPO);//保存PO数组到txt
		//收款单
		ArrayList<PaymentPO> PaymentBillPO=new ArrayList<PaymentPO>();
		for(StubPaymentBill temp:alOfPaymentBill){//遍历数组，将对应PO对象加到新数组中
			PaymentBillPO.add(temp.getPO());
		}
		fbs.savePayment(PaymentBillPO);//保存PO数组到txt
		//收款单
		ArrayList<CashPaymentPO> CashPaymentBillPO=new ArrayList<CashPaymentPO>();
		for(StubCashPaymentBill temp:alOfCashPaymentBill){//遍历数组，将对应PO对象加到新数组中
			CashPaymentBillPO.add(temp.getPO());
		}
		fbs.saveCashPayment(CashPaymentBillPO);//保存PO数组到txt
	}
}
