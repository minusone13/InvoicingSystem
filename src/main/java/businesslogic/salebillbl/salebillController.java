package businesslogic.salebillbl;

import java.util.ArrayList;
import java.util.Date;

import vo.CustomerVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.examinebl.StubBillPool;
import businesslogic.financialbillbl.ReceiptBill;
import businesslogic.salebillServicec.salebillForFinancial;
import businesslogicservice.salebillblservice.SaleBillBlService;

public class salebillController implements SaleBillBlService,salebillForFinancial{
		salebillList salebilllist;
		//我来试一试push;
		
		// salebillsaversevvice中有getall的方法；
		public salebillController(){
			System.out.println("salebillController success!");
		}

		public boolean createPurSheet(PurSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			PurSheet pursheet = new PurSheet(vo);
			pool.add(pursheet);
			//添加之后的保存是怎样的机制？
			return true;
		}

		public boolean createPurBackSheet(PurBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			PurBackSheet purbacksheet = new PurBackSheet(vo);
			pool.add(purbacksheet);
			return true;
		}

		public boolean createSaleSheet(SaleSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			SaleSheet salesheet = new SaleSheet(vo);
			pool.add(salesheet);
			return true;
		}

		public boolean createSaleBackSheet(SaleBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			if(vo==null) return false;
			SaleBackSheet salebacksheet = new SaleBackSheet(vo);
			pool.add(salebacksheet);
			return true;
		}

		
		//等等这边有个逻辑上的问题，我怎么得到的是个boolean型...
		public boolean getPurSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet= new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			boolean hasFind = false;
			for(PurSheet pursheet:listOfPurSheet){
				if(pursheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getPurBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurBackSheet> listOfPurBackSheet= new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			boolean hasFind = false;
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				if(purbacksheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getSaleSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			boolean hasFind = false;
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		public boolean getSaleBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			boolean hasFind = false;
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				if(salebacksheet.getid().equals(id)){
					hasFind=true;
					break;
				}
			}
			return hasFind;
		}

		/*获取所有的进货单*/
		public ArrayList<PurSheetVO> getAllPurSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<PurSheetVO> result=new ArrayList<PurSheetVO>();
			ArrayList<PurSheet> billList=billPool.getPurSheet();
			for(PurSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的进货退货单*/
		public ArrayList<PurBackSheetVO> getAllPurBackSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<PurBackSheetVO> result=new ArrayList<PurBackSheetVO>();
			ArrayList<PurBackSheet> billList=billPool.getPurBackSheet();
			for(PurBackSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的销售单*/
		public ArrayList<SaleSheetVO> getAllSaleSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<SaleSheetVO> result=new ArrayList<SaleSheetVO>();
			ArrayList<SaleSheet> billList=billPool.getSaleSheet();
			for(SaleSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		/*获取所有的销售退货单*/
		public ArrayList<SaleBackSheetVO> getAllSaleBackSheet (){
			StubBillPool billPool = new StubBillPool();
			ArrayList<SaleBackSheetVO> result=new ArrayList<SaleBackSheetVO>();
			ArrayList<SaleBackSheet> billList=billPool.getSaleBackSheet();
			for(SaleBackSheet temp: billList){
				result.add(temp.getVO());
			}	
			return result;
		}
		
		public void changeState_PurSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			pool.transformState(BillStyle.PurSheet, ID, state);
		}

		public void changeState_PurBackSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			pool.transformState(BillStyle.PurBackSheet, ID, state);
		}

		public void changeState_Salesheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			pool.transformState(BillStyle.SaleSheet, ID, state);
		}

		public void changeState_SaleBackSheet(String ID,BillState state) {
			StubBillPool pool = new StubBillPool();
			pool.transformState(BillStyle.SaleBackSheet, ID, state);
		}

		public void updatePurSheet(PurSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updatePurBackSheet(PurBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updateSaleSheet(SaleSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public void updateSaleBackSheet(SaleBackSheetVO vo) {
			StubBillPool pool = new StubBillPool();
			pool.change(vo);
		}

		public PurSheetVO findPurSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet= new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			PurSheetVO result = new PurSheetVO();
			for(PurSheet pursheet:listOfPurSheet){
				if(pursheet.getid().equals(id)){
					result=pursheet.getVO();
					break;
				}
			}
			return result;
		}

		public PurBackSheetVO findPurBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<PurBackSheet> listOfPurBackSheet= new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			PurBackSheetVO result = new PurBackSheetVO();
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				if(purbacksheet.getid().equals(id)){
					result=purbacksheet.getVO();
					break;
				}
			}
			return result;
		}

		public SaleSheetVO findSaleSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			SaleSheetVO result = new SaleSheetVO();
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getid().equals(id)){
					result=salesheet.getVO();
					break;
				}
			}
			return result;
		}

		public SaleBackSheetVO findSaleBackSheet(String id) {
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			SaleBackSheetVO result = new SaleBackSheetVO();
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				if(salebacksheet.getid().equals(id)){
					result=salebacksheet.getVO();
					break;
				}
			}
			return result;
		}

		
		//写下面四个函数时，注意要对时间进行判断，而且要筛选单据的状态；
		public int getAllVoucher(Date start, Date end) {
			int number=0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getmoney2();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getmoney2();
			}
			return number;
		}

		public double getAllVoucherBonus(Date start, Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				if(salesheet.getmoney1()<=salesheet.getmoney2()){
					number += (salesheet.getmoney2()-salesheet.getmoney1());
				}
			}
			return number;
		}

		public double getAllSalesIncome(Date start,Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getpmoney();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getpmoney();
			}
			return number;
		}

		public double getAllSalesDiscount(Date start,Date end) {
			double number=0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<SaleSheet> listOfSaleSheet= new ArrayList<SaleSheet>();
			listOfSaleSheet=pool.getSaleSheet();
			ArrayList<SaleBackSheet> listOfSaleBackSheet= new ArrayList<SaleBackSheet>();
			listOfSaleBackSheet=pool.getSaleBackSheet();
			for(SaleSheet salesheet:listOfSaleSheet){
				number += salesheet.getdiscount();
			}
			for(SaleBackSheet salebacksheet:listOfSaleBackSheet){
				number -= salebacksheet.getdiscount();
			}
			return number;
		}

		public double getAllPurMoney(Date start, Date end) {
			double number =0.0;
			StubBillPool pool = new StubBillPool();
			ArrayList<PurSheet> listOfPurSheet =new ArrayList<PurSheet>();
			listOfPurSheet=pool.getPurSheet();
			ArrayList<PurBackSheet> listOfPurBackSheet =new ArrayList<PurBackSheet>();
			listOfPurBackSheet=pool.getPurBackSheet();
			for(PurSheet pursheet:listOfPurSheet){
				number += pursheet.getmoney1();
			}
			for(PurBackSheet purbacksheet:listOfPurBackSheet){
				number -= purbacksheet.getmoney1();
			}
			return number;
		}
	
}
