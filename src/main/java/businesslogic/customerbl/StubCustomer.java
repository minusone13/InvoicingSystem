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
	
	StubCustomer(CustomerPO po){
		//格格项分别赋值;
	}
	
	
}
