package data.accountdata;

import java.util.ArrayList;

import po.AccountPO;
import dataservice.accountdataservice.AccountDataService;

public class AccountData implements AccountDataService{
	
	
	public ArrayList<AccountPO> getAllAcountInfo () {
		return null;
	}

	public AccountPO find(String name) {
		return null;
	}

	public boolean add(AccountPO a) {
		return false;
	}

	public boolean delete(AccountPO apo) {
		return false;
	}

	public boolean update(AccountPO apo) {
		return false;
	}
}
