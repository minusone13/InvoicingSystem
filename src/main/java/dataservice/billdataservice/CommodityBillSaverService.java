package dataservice.billdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.AlertBillPO;
import po.GiftBillPO;
import po.SpillsLossBillPO;

public interface CommodityBillSaverService extends Remote{

	/*保存库存赠送单*/
	public void saveGiftBill(ArrayList<GiftBillPO> sgb);
	/*保存报溢报损单*/
	public void saveSpillsLossBill(ArrayList<SpillsLossBillPO> slb);
	/*保存库存报警单*/
	public void saveAlertBill(ArrayList<AlertBillPO> sab);
	/*获取库存赠送单*/
	public ArrayList<GiftBillPO> getGiftBill();
	/*获取报溢报损单*/
	public ArrayList<SpillsLossBillPO> getSpillsLossBill();
	/*获取库存报警单*/
	public ArrayList<AlertBillPO> getAlertBill();
}
