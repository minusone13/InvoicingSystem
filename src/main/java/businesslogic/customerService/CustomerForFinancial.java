package businesslogic.customerService;

import java.util.ArrayList;

import vo.CustomerVO;

public interface CustomerForFinancial {
	//提供给财务人员期初建账使用，用于读取客户信息
	public ArrayList<CustomerVO> getCustomer(String address);
	public void saveCustomer(String address);
}
