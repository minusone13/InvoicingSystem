package businesslogic.customerbl;

import po.CustomerPO;
import vo.CustomerVO;

public class Customer {
	int type;//客户的级别
	public String name;//客户的姓名
	public String id;//客户编号；
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
		this.id=po.getid();
		this.address=po.getaddress();
		this.phonenumber=po.getphonenumber();
		this.postcode=po.getpostcode();
		this.maxOwe=po.getmaxOwe();
		this.shouldGive=po.getShouldGive();
		this.shouldPay=po.getShouldPay();
		this.deSaler=po.getdeSaler();
	}
	
	public CustomerPO getPO(){
		CustomerPO po = new CustomerPO();
		po.setname(this.name);
		po.settype(this.type);
		po.setid(this.id);
		po.setaddress(this.address);
		po.setphonenumber(this.phonenumber);
		po.setpostcode(this.postcode);
		po.setmaxOwe(this.maxOwe);
		po.setShouldGive(this.shouldGive);
		po.setShouldPay(this.shouldPay);
		po.setdeSaler(this.deSaler);
		return po;
	}
	
	public CustomerVO getVO(){
		CustomerVO vo = new CustomerVO();
		vo.setname(this.name);
		vo.settype(this.type);
		vo.setid(this.id);
		vo.setaddress(this.address);
		vo.setphonenumber(this.phonenumber);
		vo.setpostcode(this.postcode);
		vo.setmaxOwe(this.maxOwe);
		vo.setShouldGive(this.shouldGive);
		vo.setShouldPay(this.shouldPay);
		vo.setdeSaler(this.deSaler);
		return vo;
	}
	
}
