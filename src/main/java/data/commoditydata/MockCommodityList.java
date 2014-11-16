package data.commoditydata;

import java.util.ArrayList;

import po.stockpo.CommodityPO;
import vo.RM;

public class MockCommodityList extends StubCommodityList{
	public RM insert(CommodityPO po)
	{
		String s=po.getParent();
		String a[]=s.split("\\");
		if(!a[0].equals("1"))//default root is 1
			return RM.unknownerror;
		return RM.done;
	}
	
	public boolean addCategory(String parent, String name)
	{
		String a[]=parent.split("\\");
		if(!a[0].equals("1"))//default root is 1
			return false;
		return true;
	}
}
