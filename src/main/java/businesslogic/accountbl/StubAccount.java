package businesslogic.accountbl;

public class StubAccount {
	String name;//账户名
	double balance;//余额
	
	public StubAccount() {
		this(null, 0);
	}
	
	public StubAccount(String n) {
		this(n,0);
	}
	
	public StubAccount(String n, double b) {
		name = n;
		balance = b;
	}
}
