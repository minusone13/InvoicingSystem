package businesslogic.accountbl;

public class Account {
	String name;//账户名
	double balance;//余额
	
	
	public Account() {
		this(null, 0);
	}
	
	public Account(String n) {
		this(n,0);
	}
	
	public Account(String n, double b) {
		name = n;
		balance = b;
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
