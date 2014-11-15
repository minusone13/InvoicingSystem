package dataservice.strategydataservice;

import java.util.ArrayList;

import po.BarginStrategyPO;
import po.LevelStrategyPO;
import po.ReachStrategyPO;

public interface StrategySaverService {
	public void saveLevelStrategy(ArrayList<LevelStrategyPO> ls);
	public void saveReachStrategy(ArrayList<ReachStrategyPO> rs);
	public void saveBarginStrategy(ArrayList<BarginStrategyPO> bs);
	public ArrayList<LevelStrategyPO> getLevelStrategy();
	public ArrayList<ReachStrategyPO> getReachStrategy();
	public ArrayList<BarginStrategyPO> getBarginStrategy();
}
