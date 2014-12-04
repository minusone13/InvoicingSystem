package businesslogic.financialbillbl;

public class TransferAccount {
	String account;
	double money;
	String remark;
	
	public TransferAccount() {
		this(null, 0.0, null);
	}
	
	public TransferAccount(String a, double m, String r) {
		account = a;
		money = m;
		remark = r;
	}
	
}
