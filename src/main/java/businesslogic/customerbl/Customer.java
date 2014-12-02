package businesslogic.customerbl;

import po.CustomerPO;
import vo.CustomerVO;

public class Customer {
	private int type;//客户的级别
	private String name;//客户的姓名
	private String id;//客户编号；
	private String phonenumber;//电话号码
	private String address;//地址
	private String postcode;//邮箱
	private double maxOwe;//最大赊账（应付）
	private double shouldPay;//应付
	private double shouldGive;//应收
	private String deSaler;//默认销售人员
	
	public String getid(){
		return this.id;
	}
	
	public void setid(String id){
		this.id=id;
	}
	
	public int gettype(){
		return this.type;
	}
	
	public String getname(){
		return this.name;
	}
	
	public String getphonenumber(){
		return this.phonenumber;
	}
	
	public String getaddress(){
		return this.address;
	}
	
	public String getpostcode(){
		return this.postcode;
	}
	
	public String getdeSaler(){
		return this.deSaler;
	}
	
	public double getmaxOwe(){
		return this.maxOwe;
	}
	
	public double getShouldPay(){
		return this.shouldPay;
	}	
	
	public double getShouldGive(){
		return this.shouldGive;
	}
	
	public void settype(int type){
		this.type=type;
	}
	
	public void setname(String name){
		this.name=name;
	}
	
	public void setphonenumber(String phonenumber){
		this.phonenumber=phonenumber;
	}
	
	public void setaddress(String address){
		this.address=address;
	}
	
	public void setpostcode(String postcode){
		this.postcode=postcode;
	}
	
	public void setdeSaler(String deSaler){
		this.deSaler=deSaler;
	}
	
	public void setmaxOwe(double maxOwe){
		this.maxOwe=maxOwe;
	}
	
	public void setShouldPay(double ShouldPay){
		this.shouldPay=ShouldPay;
	}	
	
	public void setShouldGive(double shouleGive){
		this.shouldGive=shouleGive;
	}
	
	Customer(){
		
	}//是不是必要的？既然已经有了setPO方法；
	
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
