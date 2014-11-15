package data.billdata;

import java.util.ArrayList;

import po.PurBackSheetPO;
import po.PurSheetPO;
import po.SaleBackSheetPO;
import po.SaleSheetPO;
import dataservice.billdataservice.SaleBillSaverService;


public class SaleBillSaver implements SaleBillSaverService{

	/*构造函数*/
	public SaleBillSaver(){
		
	}


	/*保存进货单*/
	public void savePurSheet(ArrayList<PurSheetPO> ps){
		
	}
	/*保存进货退货单*/
	public void savePurBackSheet(ArrayList<PurBackSheetPO> pbs){
		
	}
	/*保存销售单*/
	public void saveSaleSheet(ArrayList<SaleSheetPO> ss){
		
	}
	/*保存销售退货单*/
	public void saveSaleBackSheet(ArrayList<SaleBackSheetPO> sbs){
	

	}
	/*获取进货单*/
	public ArrayList<PurSheetPO> getPurSheet(){
		return null;
	
	}
	/*获取进货退货单*/
	public ArrayList<PurBackSheetPO> getPurBackSheet(){
		return null;
	
	}
	/*获取销售单*/
	public ArrayList<SaleSheetPO> getSaleSheet(){
		return null;
	
	}
	/*获取销售退货单*/
	public ArrayList<SaleBackSheetPO> getSaleBackSheet(){
		return null;
	
	}
}
