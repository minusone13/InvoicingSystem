package businesslogic.customerbl;

import java.io.Serializable;

import po.CustomerPO;
import vo.CustomerVO;

public class Customer{
	private int type;//客户类型
	private String name;//客户的姓名
	private int level;//客户级别
	private String id;//客户编号；
	private String phonenumber;//电话号码
	private String address;//地址
	private String postcode;//邮编
	private String email;//电子邮箱；
	private double maxOwe;//最大赊账（应付）
	private double shouldPay;//公司应该给客户的
	private double shouldTake;//公司应该向客户收取的
	private String deSaler;//默认销售人员
	
	public Customer(){};
	public Customer(String name){
		this.name=name;
		this.aotusetid();
	}
	public Customer(CustomerVO vo){
		this.type=vo.gettype();
		this.name=vo.getname();
		this.aotusetid();
		this.address=vo.getaddress();
		this.phonenumber=vo.getphonenumber();
		this.postcode=vo.getpostcode();
		this.maxOwe=vo.getmaxOwe();
		this.shouldTake=vo.getShouldTake();
		this.shouldPay=vo.getShouldPay();
		this.deSaler=vo.getdeSaler();
		this.level=vo.getlevel();
		this.email=vo.getemail();
	};
	public Customer(CustomerPO po){
		this.type=po.gettype();
		this.name=po.getname();
		this.id=po.getid();
		this.address=po.getaddress();
		this.phonenumber=po.getphonenumber();
		this.postcode=po.getpostcode();
		this.maxOwe=po.getmaxOwe();
		this.shouldTake=po.getShouldTake();
		this.shouldPay=po.getShouldPay();
		this.deSaler=po.getdeSaler();
		this.level=po.getlevel();
		this.email=po.getemail();
	};
	
	public void aotusetid(){
		CustomerList customerlist = new CustomerList();
		int nowhas = customerlist.getAllCustomer("Customer.txt").size();
		this.setid(String.format("%05d", nowhas+1));
	}
	
	public int getlevel(){
		return this.level;
	}
	
	public void setlevel(int level){
		this.level = level;
		this.setmaxOwe(this.level*2000);
	}
	
	public String getemail(){
		return this.email;
	}
	
	public void setemail(String email){
		this.email=email;
	}
	
	
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
	
	public double getShouldTake(){
		return this.shouldTake;
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
	
	public void setShouldTake(double shouleGive){
		this.shouldTake=shouleGive;
	}
	
	public void setPO(CustomerPO po){
		this.type=po.gettype();
		this.name=po.getname();
		this.id=po.getid();
		this.address=po.getaddress();
		this.phonenumber=po.getphonenumber();
		this.postcode=po.getpostcode();
		this.maxOwe=po.getmaxOwe();
		this.shouldTake=po.getShouldTake();
		this.shouldPay=po.getShouldPay();
		this.deSaler=po.getdeSaler();
		this.level=po.getlevel();
		this.email=po.getemail();
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
		po.setShouldTake(this.shouldTake);
		po.setShouldPay(this.shouldPay);
		po.setdeSaler(this.deSaler);
		po.setlevel(this.level);
		po.setemail(this.email);
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
		vo.setShouldTake(this.shouldTake);
		vo.setShouldPay(this.shouldPay);
		vo.setdeSaler(this.deSaler);
		vo.setlevel(this.level);
		vo.setemail(this.email);
		return vo;
	}
	
}
