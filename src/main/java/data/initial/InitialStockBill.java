package data.initial;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.AlertBillPO;
import po.GiftBillPO;
import po.SpillsLossBillPO;

public class InitialStockBill {
	public InitialStockBill()
	{
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
			oos.writeObject(new ArrayList<GiftBillPO>());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		filename = "SpillsLossBillPO.txt";
		oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(new ArrayList<SpillsLossBillPO>());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		 filename = "AlertBillPO.txt";
		 oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(new ArrayList<AlertBillPO>());
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
