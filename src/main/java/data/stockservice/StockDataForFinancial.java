package data.stockservice;

import java.rmi.RemoteException;

public interface StockDataForFinancial
{// 库存管理在数据层为财务人员提供的接，由StockDataController实现
	public boolean saveAndBuild(String filename) throws RemoteException;// 保存当时的商品信息，输入为要保存的文件路径
}
