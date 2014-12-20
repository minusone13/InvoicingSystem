package data.strategydata;

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

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.ReachStrategyPO;
import po.Tool;
import dataservice.strategydataservice.StrategySaverService;

public class StrategySaver extends UnicastRemoteObject implements StrategySaverService{

	public StrategySaver() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public void saveLevelStrategy(ArrayList<LevelStrategyPO> ls)throws RemoteException{
		String filename = "LevelStrategyPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(ls);
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
	public void saveReachStrategy(ArrayList<ReachStrategyPO> rs)throws RemoteException{
		String filename = "ReachStrategyPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(rs);
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
	public void saveBarginStrategy(ArrayList<BarginStrategyPO> bs)throws RemoteException{
		String filename = "BarginStrategyPO.txt";
		ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		try {
			oos.writeObject(bs);
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
	public ArrayList<LevelStrategyPO> getLevelStrategy()throws RemoteException{
		File filename = Tool.Opendoc("LevelStrategyPO.txt");
		
		ArrayList<LevelStrategyPO> levelstrategyList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			levelstrategyList = (ArrayList<LevelStrategyPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(levelstrategyList!=null) {
			System.out.println("!!!");
			return levelstrategyList;
		}
		else return null;
		
		
	}
	public ArrayList<ReachStrategyPO> getReachStrategy()throws RemoteException{
		File filename = Tool.Opendoc("ReachStrategyPO.txt");
		
		ArrayList<ReachStrategyPO> reachstrategyList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			reachstrategyList = (ArrayList<ReachStrategyPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(reachstrategyList!=null) return reachstrategyList;
		else return null;
		
		
	}
	public ArrayList<BarginStrategyPO> getBarginStrategy()throws RemoteException{
		File filename = Tool.Opendoc("BarginStrategyPO.txt");
		
		ArrayList<BarginStrategyPO> barginstrategyList = null;
		ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {		
			barginstrategyList = (ArrayList<BarginStrategyPO>) ois.readObject();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(barginstrategyList!=null) return barginstrategyList;
		else return null;
		
		
	}
	
}
