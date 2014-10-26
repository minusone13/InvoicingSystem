package businesslogic.financialbillbl;

public class StubTransferAccount {
	String account;
	double money;
	String remark;
	
	public StubTransferAccount() {
		this(null, 0.0, null);
	}
	
	public StubTransferAccount(String a, double m, String r) {
		account = a;
		money = m;
		remark = r;
	}
	
}
