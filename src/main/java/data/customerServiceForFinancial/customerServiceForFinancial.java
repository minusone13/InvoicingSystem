package data.customerServiceForFinancial;

import java.rmi.RemoteException;

public interface customerServiceForFinancial {
	public void saveCustomer(String address) throws RemoteException;
}
