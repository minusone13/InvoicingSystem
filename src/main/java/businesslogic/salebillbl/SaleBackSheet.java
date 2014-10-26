package businesslogic.salebillbl;

import java.util.ArrayList;

import businesslogic.customerbl.Customer;

public class SaleBackSheet {
	String id;
	Customer customer;
	ArrayList sheet;//销售单据，商品名，数量，单价
	double money1;//折前总金额
	double money2;//代金券金额
	double disconut;//折让金额；
	double pmoney;//最终金额，代金券不退还。
	String words;//备注
}
