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
import vo.AlertBillVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.commoditybillbl.StubAlertBill;
import businesslogic.commoditybillbl.StubGiftBill;
import businesslogic.commoditybillbl.StubSpillsLossBill;
import businesslogic.commoditybl.MockCommodity;
import businesslogic.financialbillbl.CashPaymentBill;
import businesslogic.financialbillbl.Item;
import businesslogic.financialbillbl.PaymentBill;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.financialbillbl.TransferAccount;
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


	private ArrayList<StubGiftBill> alOfGiftBill=new ArrayList<StubGiftBill>();
	private ArrayList<StubSpillsLossBill> alOfSpillsLossBill=new ArrayList<StubSpillsLossBill>();
	private ArrayList<StubAlertBill> alOfAlertBill=new ArrayList<StubAlertBill>();
	private ArrayList<StubPurSheet> alOfPurSheet=new ArrayList<StubPurSheet>();
	private ArrayList<StubPurBackSheet> alOfPurBackSheet=new ArrayList<StubPurBackSheet>();
	private ArrayList<StubSaleSheet> alOfSaleSheet=new ArrayList<StubSaleSheet>();
	private ArrayList<StubSaleBackSheet> alOfSaleBackSheet=new ArrayList<StubSaleBackSheet>();
	private ArrayList<ReceiptBill> alOfReceiptBill=new ArrayList<ReceiptBill>();
	private ArrayList<PaymentBill> alOfPaymentBill=new ArrayList<PaymentBill>();
	private ArrayList<CashPaymentBill> alOfCashPaymentBill=new ArrayList<CashPaymentBill>();
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
				ReceiptBill rcb=new ReceiptBill();
				rcb.setPO(tempPO);
				alOfReceiptBill.add(rcb);
			}
		}
		//付款单
		ArrayList<PaymentPO> PaymentBillListPO=fbs.getPayment();
		if(PaymentBillListPO!=null){
			for(PaymentPO tempPO:PaymentBillListPO){
				PaymentBill pmb=new PaymentBill();
				pmb.setPO(tempPO);
				alOfPaymentBill.add(pmb);
			}
		}
		//赠送单
		ArrayList<CashPaymentPO> CashPaymentBillListPO=fbs.getCashPayment();
		if(CashPaymentBillListPO!=null){
			for(CashPaymentPO tempPO:CashPaymentBillListPO){
				CashPaymentBill cpb=new CashPaymentBill();
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
	public void add (ReceiptBill rb){
		alOfReceiptBill.add(rb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张付款单*/
	public void add (PaymentBill pb){
		alOfPaymentBill.add(pb);
		//保存
		this.save();
	}
	/*需要向单据池中加入一张现金费用单*/
	public void add (CashPaymentBill cpb){
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
	public ArrayList<ReceiptBill> getReceiptBill (BillState st){
		ArrayList<ReceiptBill> result=new ArrayList<ReceiptBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(ReceiptBill temp:alOfReceiptBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		
		return result;	
	}
	/*需要从单据池筛选指定状态的所有付款单*/
	public ArrayList<PaymentBill> getPaymentBill (BillState st){
		ArrayList<PaymentBill> result=new ArrayList<PaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(PaymentBill temp:alOfPaymentBill){
			if(temp.getState()==st){//如果单据状态符合筛选状态
				result.add(temp);
			}
		}
		return result;
	}
	/*需要从单据池筛选指定状态的所有现金费用单*/
	public ArrayList<CashPaymentBill> getCashPaymentBill (BillState st){
		ArrayList<CashPaymentBill> result=new ArrayList<CashPaymentBill>();//用于储存返回的单据
		//遍历池中制定单据数组
		for(CashPaymentBill temp:alOfCashPaymentBill){
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
	public ArrayList<ReceiptBill> getReceiptBill (){
		return alOfReceiptBill;	
	}
	/*获取单据池的所有付款单*/
	public ArrayList<PaymentBill> getPaymentBill (){
		return alOfPaymentBill;
	}
	/*获取单据池的所有现金费用单*/
	public ArrayList<CashPaymentBill> getCashPaymentBill (){
		return alOfCashPaymentBill;
	}
   /*修改单据信息*/
	public void change(GiftBillVO gb){
	
		for(int i=0;i<alOfGiftBill.size();i++){
			if(alOfGiftBill.get(i).getID().equals(gb.getID())){//寻找相同编号
				//进行修改
				//修改赠品
				//转换vo成商品数组
				ArrayList<MockCommodity> gift=new ArrayList<MockCommodity>();
				for(int j=0;j<gb.getComs().size();j++){
					gift.add(new MockCommodity(gb.getComs().get(j)));
				}
				//进行修改
				alOfGiftBill.get(i).setComs(gift);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SpillsLossBillVO slb){
		for(int i=0;i<alOfSpillsLossBill.size();i++){
			if(alOfSpillsLossBill.get(i).getID().equals(slb.getID())){//寻找相同编号
				//进行修改
				//修改报溢报损的商品数量
				alOfSpillsLossBill.get(i).setCom(new MockCommodity(slb.getCom()));
				//修改操作员
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(AlertBillVO ab){
		for(int i=0;i<alOfAlertBill.size();i++){
			if(alOfAlertBill.get(i).getID().equals(ab.getID())){//寻找相同编号
				//进行修改
				//暂定不能修改
			}
		}
		//保存
		this.save();
	}
	public void change(PurSheetVO ps){
		for(int i=0;i<alOfPurSheet.size();i++){
			if(alOfPurSheet.get(i).getID().equals(ps.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPurSheet.get(i).setCustomer(ps.getcustomer());
				//修改仓库
				alOfPurSheet.get(i).setstock(ps.getstock());
				//修改操作员
				//修改商品清单
				
				//修改总金额
				alOfPurSheet.get(i).setmoney1(ps.getmoney1());
				//修改备注
				alOfPurSheet.get(i).setwords(ps.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(PurBackSheetVO pbs){
		for(int i=0;i<alOfPurBackSheet.size();i++){
			if(alOfPurBackSheet.get(i).getID().equals(pbs.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPurBackSheet.get(i).setCustomer(pbs.getcustomer());
				//修改仓库
				alOfPurBackSheet.get(i).setstock(pbs.getstock());
				//修改操作员
				//修改商品清单
				
				//修改总金额
				alOfPurBackSheet.get(i).setmoney1(pbs.getmoney1());
				//修改备注
				alOfPurBackSheet.get(i).setwords(pbs.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SaleSheetVO ss){
		for(int i=0;i<alOfSaleSheet.size();i++){
			if(alOfSaleSheet.get(i).getID().equals(ss.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfSaleSheet.get(i).setCustomer(ss.getcustomer());
				//修改仓库
				alOfSaleSheet.get(i).setstock(ss.getstock());
				//修改操作员
				//修改商品清单
				//修改总金额
				alOfSaleSheet.get(i).setmoney1(ss.getmoney1());
				//修改使用代金券
				alOfSaleSheet.get(i).setpmoney(ss.pmoney());
				//修改折让金额
				alOfSaleSheet.get(i).setdiscount(ss.getdiscount());
				//修改最终金额
				alOfSaleSheet.get(i).setmoney2(ss.getmoney2());
				//修改备注
				alOfSaleSheet.get(i).setwords(ss.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(SaleBackSheetVO sbs){
		for(int i=0;i<alOfSaleBackSheet.size();i++){
			if(alOfSaleBackSheet.get(i).getID().equals(sbs.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfSaleBackSheet.get(i).setCustomer(sbs.getcustomer());
				//修改仓库
				alOfSaleBackSheet.get(i).setstock(sbs.getstock());
				//修改操作员
				//修改商品清单
				//修改总金额
				alOfSaleBackSheet.get(i).setmoney1(sbs.getmoney1());
				//修改使用代金券
				alOfSaleBackSheet.get(i).setpmoney(sbs.pmoney());
				//修改折让金额
				alOfSaleBackSheet.get(i).setdiscount(sbs.getdiscount());
				//修改最终金额
				alOfSaleBackSheet.get(i).setmoney2(sbs.getmoney2());
				//修改备注
				alOfSaleBackSheet.get(i).setwords(sbs.getwords());
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(ReceiptVO rb){
		for(int i=0;i<alOfReceiptBill.size();i++){
			if(alOfReceiptBill.get(i).getID().equals(rb.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfReceiptBill.get(i).setCustomer(rb.getCustomer());
				//修改操作员
				alOfReceiptBill.get(i).setOp(rb.getOp());
				//修改总额
				alOfReceiptBill.get(i).setTotal(rb.getTotal());
				//修改转账列表
				ArrayList<String> account = rb.getAccounts();
				ArrayList<Double> money = rb.getMoney();
				ArrayList<String> remark = rb.getRemark();
				ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
				int length = account.size();
				for(int j=0;j<length;j++) {
					transferlist.add(new TransferAccount(account.get(j), money.get(j), remark.get(j)));
				}
				alOfReceiptBill.get(i).setTransferlist(transferlist);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(PaymentVO pb){
		for(int i=0;i<alOfPaymentBill.size();i++){
			if(alOfPaymentBill.get(i).getID().equals(pb.getID())){//寻找相同编号
				//进行修改
				//修改客户
				alOfPaymentBill.get(i).setCustomer(pb.getCustomer());
				//修改操作员
				alOfPaymentBill.get(i).setOp(pb.getOp());
				//修改总额
				alOfPaymentBill.get(i).setTotal(pb.getTotal());
				//修改转账列表
				ArrayList<String> account = pb.getAccounts();
				ArrayList<Double> money = pb.getMoney();
				ArrayList<String> remark = pb.getRemark();
				ArrayList<TransferAccount> transferlist = new ArrayList<TransferAccount>();
				int length = account.size();
				for(int j=0;j<length;j++) {
					transferlist.add(new TransferAccount(account.get(j), money.get(j), remark.get(j)));
				}
				alOfReceiptBill.get(i).setTransferlist(transferlist);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	public void change(CashPaymentVO cb){
		for(int i=0;i<alOfCashPaymentBill.size();i++){
			if(alOfCashPaymentBill.get(i).getID().equals(cb.getID())){//寻找相同编号
				//进行修改
				//修改银行账户
				alOfCashPaymentBill.get(i).setAccount(cb.getAccount());
				//修改操作员
				alOfCashPaymentBill.get(i).setOp(cb.getOp());
				//修改总额
				alOfCashPaymentBill.get(i).setTotal(cb.getTotal());
				//修改条目清单
				ArrayList<String> item = cb.getItem();
				ArrayList<Double> money=cb.getMoney(); 
				ArrayList<String> remark=cb.getRemark();
				ArrayList<Item> itemList = new ArrayList<Item>();
				int length = item.size();
				for(int j=0;j<length;j++) {
					itemList.add(new Item(item.get(j), money.get(j), remark.get(j)));
				}
				alOfCashPaymentBill.get(i).setItemList(itemList);
				//修改完毕
				break;
			}
		}
		//保存
		this.save();
	}
	/*改单据状态*/
	public void transformState(BillStyle style,String ID,BillState state){
		switch(style){
		case GiftBill:
			for(int i=0;i<alOfGiftBill.size();i++){
				if(alOfGiftBill.get(i).getID().equals(ID)){
					alOfGiftBill.get(i).setState(state);
				}
			}
			break;
		case SpillsLossBill:
			for(int i=0;i<alOfSpillsLossBill.size();i++){
				if(alOfSpillsLossBill.get(i).getID().equals(ID)){
					alOfSpillsLossBill.get(i).setState(state);
				}
			}
			break;
		case AlertBill:
			for(int i=0;i<alOfAlertBill.size();i++){
				if(alOfAlertBill.get(i).getID().equals(ID)){
					alOfAlertBill.get(i).setState(state);
				}
			}
			break;
		case PurSheet:
			for(int i=0;i<alOfPurSheet.size();i++){
				if(alOfPurSheet.get(i).getID().equals(ID)){
					alOfPurSheet.get(i).setState(state);
				}
			}
			break;
		case PurBackSheet:
			for(int i=0;i<alOfPurBackSheet.size();i++){
				if(alOfPurBackSheet.get(i).getID().equals(ID)){
					alOfPurBackSheet.get(i).setState(state);
				}
			}
			break;
		case SaleSheet:
			for(int i=0;i<alOfSaleSheet.size();i++){
				if(alOfSaleSheet.get(i).getID().equals(ID)){
					alOfSaleSheet.get(i).setState(state);
				}
			}
			break;
		case SaleBackSheet:
			for(int i=0;i<alOfSaleBackSheet.size();i++){
				if(alOfSaleBackSheet.get(i).getID().equals(ID)){
					alOfSaleBackSheet.get(i).setState(state);
				}
			}
			break;
		case ReceiptBill:
			for(int i=0;i<alOfReceiptBill.size();i++){
				if(alOfReceiptBill.get(i).getID().equals(ID)){
					alOfReceiptBill.get(i).setState(state);
				}
			}
			break;
		case PaymentBill:
			for(int i=0;i<alOfPaymentBill.size();i++){
				if(alOfPaymentBill.get(i).getID().equals(ID)){
					alOfPaymentBill.get(i).setState(state);
				}
			}
			break;
		case CashPaymentBill:
			for(int i=0;i<alOfCashPaymentBill.size();i++){
				if(alOfCashPaymentBill.get(i).getID().equals(ID)){
					alOfCashPaymentBill.get(i).setState(state);
				}
			}
			break;
			
		}
		//保存
		save();
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
		for(ReceiptBill temp:alOfReceiptBill){//遍历数组，将对应PO对象加到新数组中
			ReceiptBillPO.add(temp.getPO());
		}
		fbs.saveReceipt(ReceiptBillPO);//保存PO数组到txt
		//收款单
		ArrayList<PaymentPO> PaymentBillPO=new ArrayList<PaymentPO>();
		for(PaymentBill temp:alOfPaymentBill){//遍历数组，将对应PO对象加到新数组中
			PaymentBillPO.add(temp.getPO());
		}
		fbs.savePayment(PaymentBillPO);//保存PO数组到txt
		//收款单
		ArrayList<CashPaymentPO> CashPaymentBillPO=new ArrayList<CashPaymentPO>();
		for(CashPaymentBill temp:alOfCashPaymentBill){//遍历数组，将对应PO对象加到新数组中
			CashPaymentBillPO.add(temp.getPO());
		}
		fbs.saveCashPayment(CashPaymentBillPO);//保存PO数组到txt
	}
}
