package businesslogic.financialbillbl;

import java.io.Serializable;

public class TransferAccount implements Serializable{
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
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
