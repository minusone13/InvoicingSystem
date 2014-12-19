package dataservice.strategydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.ReachStrategyPO;

public interface StrategySaverService extends Remote{
	public void saveLevelStrategy(ArrayList<LevelStrategyPO> ls)throws RemoteException;
	public void saveReachStrategy(ArrayList<ReachStrategyPO> rs)throws RemoteException;
	public void saveBarginStrategy(ArrayList<BarginStrategyPO> bs)throws RemoteException;
	public ArrayList<LevelStrategyPO> getLevelStrategy()throws RemoteException;
	public ArrayList<ReachStrategyPO> getReachStrategy()throws RemoteException;
	public ArrayList<BarginStrategyPO> getBarginStrategy()throws RemoteException;
}
