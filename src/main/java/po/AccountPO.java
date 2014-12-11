package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
	String name;
	String newName;
	double balance;
	
	public boolean contents(String s)
	{
		return getName().indexOf(s)!=-1 ;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
