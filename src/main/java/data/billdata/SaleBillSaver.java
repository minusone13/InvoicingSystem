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

import po.PurBackSheetPO;
import po.PurSheetPO;
import po.SaleBackSheetPO;
import po.SaleSheetPO;
import po.Tool;
import dataservice.billdataservice.SaleBillSaverService;


public class SaleBillSaver extends UnicastRemoteObject  implements SaleBillSaverService{

	/*构造函数*/
	public SaleBillSaver()throws RemoteException{
		
	}


	/*保存进货单*/
	public void savePurSheet(ArrayList<PurSheetPO> ps)throws RemoteException{
		String filename = "PurSheetPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(ps);
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
	/*保存进货退货单*/
	public void savePurBackSheet(ArrayList<PurBackSheetPO> pbs)throws RemoteException{
		String filename = "PurBackSheetPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(pbs);
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
	/*保存销售单*/
	public void saveSaleSheet(ArrayList<SaleSheetPO> ss)throws RemoteException{
		String filename = "SaleSheetPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(ss);
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
	/*保存销售退货单*/
	public void saveSaleBackSheet(ArrayList<SaleBackSheetPO> sbs)throws RemoteException{
		String filename = "SaleBackSheetPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(sbs);
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
	/*获取进货单*/
	public ArrayList<PurSheetPO> getPurSheet()throws RemoteException{
	File filename = Tool.Opendoc("PurSheetPO.txt");
		
		ArrayList<PurSheetPO> purbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			purbillList = (ArrayList<PurSheetPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(purbillList!=null) return purbillList;
		else return null;
	
	}
	/*获取进货退货单*/
	public ArrayList<PurBackSheetPO> getPurBackSheet()throws RemoteException{
	File filename = Tool.Opendoc("PurBackSheetPO.txt");
		
		ArrayList<PurBackSheetPO> purbackbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			purbackbillList = (ArrayList<PurBackSheetPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(purbackbillList!=null) return purbackbillList;
		else return null;
	
	}
	/*获取销售单*/
	public ArrayList<SaleSheetPO> getSaleSheet()throws RemoteException{
	File filename = Tool.Opendoc("SaleSheetPO.txt");
		
		ArrayList<SaleSheetPO> salebillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			salebillList = (ArrayList<SaleSheetPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(salebillList!=null) return salebillList;
		else return null;
	
	}
	/*获取销售退货单*/
	public ArrayList<SaleBackSheetPO> getSaleBackSheet()throws RemoteException{
	File filename = Tool.Opendoc("SaleBackSheetPO.txt");
		
		ArrayList<SaleBackSheetPO> salebackbillList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			salebackbillList = (ArrayList<SaleBackSheetPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(salebackbillList!=null) return salebackbillList;
		else return null;
	
	}
}
