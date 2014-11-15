package data.billdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import po.CashPaymentPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.SpillsLossBillPO;
import data.commoditydata.StubStockDataController;
import dataservice.billdataservice.FinancialBillSaverService;


public class FinancialBillSaver implements FinancialBillSaverService{

	/*构造函数*/
	public FinancialBillSaver(){
		
	}
	/*保存付款单*/
	public void savePayment(ArrayList<PaymentPO> pb){
		String filename = "PaymentPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(pb);
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
	/*保存收款单*/
	public void saveReceipt(ArrayList<ReceiptPO> rb){
		String filename = "ReceiptPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(rb);
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
	/*保存现金费用单*/
	public void saveCashPayment(ArrayList<CashPaymentPO> cpb){
		String filename = "CashPaymentPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(cpb);
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
	/*获取付款单*/
	public ArrayList<PaymentPO> getPayment(){
		File filename = StubStockDataController.Opendoc("PaymentPO.txt");
		
		ArrayList<PaymentPO> paymentbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			paymentbillList = (ArrayList<PaymentPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(paymentbillList!=null) return paymentbillList;
		else return null;
		
		
	}
	/*获取收款单*/
	public ArrayList<ReceiptPO> getReceipt(){
		File filename = StubStockDataController.Opendoc("ReceiptPO.txt");
		
		ArrayList<ReceiptPO> receiptbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			receiptbillList = (ArrayList<ReceiptPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(receiptbillList!=null) return receiptbillList;
		else return null;
		
		
	}
	/*获取现金费用单*/
	public ArrayList<CashPaymentPO> getCashPayment(){
		File filename = StubStockDataController.Opendoc("CashPaymentPO.txt");
		
		ArrayList<CashPaymentPO> cashpaymentbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			cashpaymentbillList = (ArrayList<CashPaymentPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(cashpaymentbillList!=null) return cashpaymentbillList;
		else return null;
		
		
	}
	
	
}
