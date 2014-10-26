package businesslogic.salebl;

import java.util.ArrayList;

import vo.CustomerVo;

//其实我突然不知道这个包存在的意思了。。

public class StubSale {
	String name;
	String password;
	public StubSale() {
		this(null,null);
	}
	
	public StubSale(String n, String pw) {
		name = n;
		password = pw;
	}
	
	//修改密码
	public boolean updatePassword(String newPassword) {
		//User u = new User();
		//return u.updatePassword(this ,newPassword);
		return true;
	}
	
	/*返回类型还是得修改下*/
	public boolean addCustomer(int type,
	String name,
	String phonenumber,
	String address,
	String postcode,
	double maxOwe,
	double shouldPay,
	double shouldGive,
	String deSaler){
		if(type==1)
		return true ;
		else 
		return false; 
	}
	
	public void getCustomerList(){}
	
	public ArrayList<CustomerVo> findCustomer (String str){
		return null;}
	
	public void deleteCustomer(String id){}
	
	/*默认值就是原先的值*/
	public void updateCustmoer(int type,
			String name,
			String phonenumber,
			String address,
			String postcode,
			double maxOwe,
			double shouldPay,
			double shouldGive,
			String deSaler){};
	
	
	public void CustomerManagement () {}
	
	public void SalePur (){}
	
	
	
}
