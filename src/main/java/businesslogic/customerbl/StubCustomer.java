package businesslogic.customerbl;

import po.CustomerPO;

public class StubCustomer {
	
	int type;//客户的级别
	String name;//客户的姓名
	String phonenumber;//电话号码
	String address;//地址
	String postcode;//邮箱
	double maxOwe;//最大赊账（应付）
	double shouldPay;//应付
	double shouldGive;//应收
	String deSaler;//默认销售人员
	
	public void setPO(CustomerPO po){
		this.type=po.gettype();
		this.name=po.getname();
		this.address=po.getaddress();
		this.phonenumber=po.getphonenumber();
		this.postcode=po.getpostcode();
		this.maxOwe=po.getmaxOwe();
		this.shouldGive=po.getShouldGive();
		this.shouldPay=po.getShouldPay();
		this.deSaler=po.getdeSaler();
	}
}
