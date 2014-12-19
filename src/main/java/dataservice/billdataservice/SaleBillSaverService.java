package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PurBackSheetPO;
import po.PurSheetPO;
import po.SaleBackSheetPO;
import po.SaleSheetPO;

public interface SaleBillSaverService extends Remote{
	/*保存进货单*/
	public void savePurSheet(ArrayList<PurSheetPO> ps)throws RemoteException;
	/*保存进货退货单*/
	public void savePurBackSheet(ArrayList<PurBackSheetPO> pbs)throws RemoteException;
	/*保存销售单*/
	public void saveSaleSheet(ArrayList<SaleSheetPO> ss)throws RemoteException;
	/*保存销售退货单*/
	public void saveSaleBackSheet(ArrayList<SaleBackSheetPO> sbs)throws RemoteException;
	/*获取进货单*/
	public ArrayList<PurSheetPO> getPurSheet()throws RemoteException;
	/*获取进货退货单*/
	public ArrayList<PurBackSheetPO> getPurBackSheet()throws RemoteException;
	/*获取销售单*/
	public ArrayList<SaleSheetPO> getSaleSheet()throws RemoteException;
	/*获取销售退货单*/
	public ArrayList<SaleBackSheetPO> getSaleBackSheet()throws RemoteException;
}
