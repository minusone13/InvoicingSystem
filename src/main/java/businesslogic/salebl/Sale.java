package businesslogic.salebl;

import java.util.ArrayList;

import vo.CustomerVo;

//其实我突然不知道这个包存在的意思了。。

public class Sale {
	String name;
	String password;
	public Sale() {
		this(null,null);
	}
	
	public Sale(String n, String pw) {
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
	public void addCustomer(int type,
	String name,
	String phonenumber,
	String address,
	String postcode,
	double maxOwe,
	double shouldPay,
	double shouldGive,
	String deSaler){}
	
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
