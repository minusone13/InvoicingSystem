package businesslogic.customerService;

import java.util.ArrayList;

import vo.CustomerVO;

public interface CustomerForFinancial {
	//提供给财务人员期初建账使用，用于读取客户信息
	public ArrayList<CustomerVO> getCustomer(String address);
	public void saveCustomer(String address);
	public void changeShouldPay(String name,double hadPay);//公司给了客户钱之后更新还要给的
	public void changeShouldTake(String name,double hadGive);//公司收了客户钱之后更新还要收的
	
}
