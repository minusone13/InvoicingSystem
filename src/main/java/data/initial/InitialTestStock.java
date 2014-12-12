package data.initial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.AlertBillPO;
import po.GiftBillPO;
import po.SpillsLossBillPO;

public class InitialTestStock {
	public InitialTestStock()
	{
		saveGiftBill();
		saveSpillsLossBill();
		saveAlertBill();
	}
	/*保存库存赠送单*/
	public void saveGiftBill(){
		ArrayList<GiftBillPO> sgb = new ArrayList<GiftBillPO>();
		sgb.add(new GiftBillPO());
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
	public void saveSpillsLossBill(){
		String filename = "SpillsLossBillPO.txt";
		ArrayList<SpillsLossBillPO> slb = new ArrayList<SpillsLossBillPO>();
		slb.add(new SpillsLossBillPO());
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
	public void saveAlertBill(){
		String filename = "AlertBillPO.txt";
		ArrayList<AlertBillPO> sab = new ArrayList<AlertBillPO>();
		sab.add(new AlertBillPO());
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
}
