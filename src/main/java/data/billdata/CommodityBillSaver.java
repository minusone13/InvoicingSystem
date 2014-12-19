package data.billdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.AccountPO;
import po.AlertBillPO;
import po.GiftBillPO;
import po.SpillsLossBillPO;
import po.Tool;
import data.commoditydata.StubStockDataController;
import dataservice.billdataservice.CommodityBillSaverService;

public class CommodityBillSaver implements CommodityBillSaverService{

	/*构造函数*/
	public CommodityBillSaver(){
		
	}
	/*保存库存赠送单*/
	public void saveGiftBill(ArrayList<GiftBillPO> sgb){
		String filename = "GiftBillPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(sgb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*保存报溢报损单*/
	public void saveSpillsLossBill(ArrayList<SpillsLossBillPO> slb){
		String filename = "SpillsLossBillPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(slb);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*保存库存报警单*/
	public void saveAlertBill(ArrayList<AlertBillPO> sab){
		String filename = "AlertBillPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(sab);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/*获取库存赠送单*/
	public ArrayList<GiftBillPO> getGiftBill(){
		File filename = Tool.Opendoc("GiftBillPO.txt");
		
		ArrayList<GiftBillPO> giftbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			giftbillList = (ArrayList<GiftBillPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(giftbillList!=null) return giftbillList;
		else return null;
		
	}
	/*获取报溢报损单*/
	public ArrayList<SpillsLossBillPO> getSpillsLossBill(){
		File filename = Tool.Opendoc("SpillsLossBillPO.txt");
		
		ArrayList<SpillsLossBillPO> spillsLossbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			spillsLossbillList = (ArrayList<SpillsLossBillPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(spillsLossbillList!=null) return spillsLossbillList;
		else return null;
		
	}
	/*获取库存报警单*/
	public ArrayList<AlertBillPO> getAlertBill(){
		File filename = Tool.Opendoc("AlertBillPO.txt");
		
		ArrayList<AlertBillPO> alertbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			alertbillList = (ArrayList<AlertBillPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(alertbillList!=null) return alertbillList;
		else return null;
		
	}
	
}
