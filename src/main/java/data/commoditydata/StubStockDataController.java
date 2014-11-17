package data.commoditydata;

import java.io.*;
import java.util.ArrayList;
import data.Tool;
import dataservice.commoditydataservice.*;
import po.*;
import po.stockpo.*;
import vo.RM;

public class StubStockDataController implements StubCommodityDataService{
	static StubCommodityList l;
	static File f;
	public StubStockDataController()
	{
		f = Tool.Opendoc("Stock.ser");   
        
        ObjectInputStream ois=null;
        	try {
				ois=new ObjectInputStream(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	StubCommodityList temp=null;
			try {
				temp = (StubCommodityList) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (temp!=null)
        		l=temp;
        	else
        		System.out.println("对象序列化错误");
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}       	
	}
	
    public static void Initial()
    {
        f = Tool.Opendoc("Stock.ser");
        
        //some initial under;
        ObjectOutputStream oos=null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(f));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        try {
			oos.writeObject(new StubCommodityList());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			oos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        ObjectInputStream ois=null;
        	try {
				ois=new ObjectInputStream(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	StubCommodityList temp=null;
			try {
				temp = (StubCommodityList) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if (temp!=null)
        		l=temp;
        	else
        		System.out.println("对象序列化错误");
        	try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	//some initial procedure under;
        	l.initial();
        	//ObjectOutputStream oos=null;
        	oos=null;
    		try {
    			oos = new ObjectOutputStream(new FileOutputStream(f));
    		} catch (FileNotFoundException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		} catch (IOException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		}
            try {
    			oos.writeObject(l);
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
            try {
    			oos.close();
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    }
    
	public RM insert(CommodityPO po)
	{
		RM result=l.insert(po);
		save();
		return result;
	}
	public CommodityListPO getAll()
	{//this is for financial
		return new CommodityListPO();
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{
		return new ArrayList<CommodityPO>();
	}
	public CommodityPO findCommodity(String name, String model)
	{
		return l.findCommodity(name, model);
	}
	public boolean deleteCommodity(String name, String model)
	{
		boolean result=l.deleteCommodity(name, model);
		save();
		return result;
	}
	public boolean updateCommodity(CommodityPO po)
	{
		save();
		return true;
	}
	public RM insert(CategoryPO po)
	{
		RM result=l.insert(po);
		save();
		return result;
	}
    public static boolean save()
    {
        try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(l);
		oos.writeObject(null);
		oos.close();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
        return true;
    }

	public static StubCommodityList getL() {
		return l;
	}

	public static void setL(StubCommodityList l) {
		StubStockDataController.l = l;
	}
}
