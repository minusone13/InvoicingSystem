package data.commoditydata;

import java.io.*;
import java.util.ArrayList;

import data.Tool;
import data.stockservice.StockDataForFinancial;
import dataservice.commoditydataservice.*;
import po.*;
import po.stockpo.*;
import vo.RM;

public class StubStockDataController implements StubCommodityDataService, StockDataForFinancial
{//这是一个单体模式的类，因为这样读写文件方便些
	private static StubStockDataController instance=null;
	StubCommodityList l;
	File f;
	String filename="Stock.ser";
	public static StubStockDataController getInstance()
	{//单体模式
		if(instance==null)
			instance = new StubStockDataController();
		return instance;
	}
	private StubStockDataController()
	{
		f = Tool.Opendoc(filename);   
        
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
	
    public void Initial()
    {
        f = Tool.Opendoc(filename);
        
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
	public RM insert(PackPO po)
	{
		return RM.done;
	}
	public CommodityListPO getAll()
	{//this is for financial
		return new CommodityListPO();
	}
	public ArrayList<CommodityPO> findCommodity(String name)
	{
		return l.findCommodity(name);
	}
	public CommodityPO findCommodity(String name, String model)
	{
		MockCommodityData result=l.findCommodity(name, model);
		if(result==null)
			return null;
		return result.getPo().clone();
	}
	public CategoryPO findCategory(String id)
	{
		StubCategoryData result=l.findCategory(id);
		if(result==null)
			return null;
		return result.getPo().clone();
	}
	public ArrayList<StockPO> openCategory(String id)
	{
		return l.findCategory(id).open();
	}
	public RM deleteCommodity(String name, String model)
	{
		RM result=l.deleteCommodity(name, model);
		save();
		return result;
	}
	public RM deleteCategory(String id)
	{
		RM result=l.deleteCategory(id);
		return result;
	}
	public boolean update(CommodityPO po)
	{
		boolean result = l.update(po);
		save();
		return result;
	}
	public boolean update(CategoryPO po)
	{
		boolean result = l.update(po);
		save();
		return result;
	}
	public RM insert(CategoryPO po)
	{
		RM result=l.insert(po);
		save();
		return result;
	}
	public boolean insert(AdjustmentRecordPO po)
	{
		boolean result = l.insert(po);
		save();
		return result;
	}
    public boolean save()
    {
        save(f);
        return true;
    }
    public boolean save(File file)
    {
    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    		oos.writeObject(l);
    		oos.writeObject(null);
    		oos.close();
            } catch (IOException e1) {
            	e1.printStackTrace();
            }
    	return true;
    }
    public boolean save(String s)
    {
    	File file=Tool.Opendoc(s);
    	save (file);
    	return true;
    }
    public boolean saveAndBuild(String s)
    {
    	l.accountBuild();
    	save(s);
    	return true;
    }
	public StubCommodityList getL() {
		return l;
	}
	public void setL(StubCommodityList l) {
		this.l = l;
	}
	public ArrayList<AdjustmentRecordPO> getAdjustmentRecords()
	{
		ArrayList<AdjustmentRecordPO> result = l.getAdjustmentRecords();
		return result;
	}
	public ArrayList<CommodityPO> fuzzyFindCommodity(String s)
	{
		return l.fuzzyFindCommodity(s);
	}
}
