package dataservice.billdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AlertBillPO;
import po.GiftBillPO;
import po.SpillsLossBillPO;

public interface CommodityBillSaverService extends Remote{

	/*保存库存赠送单*/
	public void saveGiftBill(ArrayList<GiftBillPO> sgb)throws RemoteException;
	/*保存报溢报损单*/
	public void saveSpillsLossBill(ArrayList<SpillsLossBillPO> slb)throws RemoteException;
	/*保存库存报警单*/
	public void saveAlertBill(ArrayList<AlertBillPO> sab)throws RemoteException;
	/*获取库存赠送单*/
	public ArrayList<GiftBillPO> getGiftBill()throws RemoteException;
	/*获取报溢报损单*/
	public ArrayList<SpillsLossBillPO> getSpillsLossBill()throws RemoteException;
	/*获取库存报警单*/
	public ArrayList<AlertBillPO> getAlertBill()throws RemoteException;
}
