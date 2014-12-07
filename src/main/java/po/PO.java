package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.Item;
import businesslogic.financialbillbl.TransferAccount;

public class PO implements Serializable{//接口是lhw于20141207加上的
	String ID;
	Role role;
	String customer;
	double total;
	BillState state;
	ArrayList<TransferAccount> transferlist;
	BillStyle style;
	ArrayList<Item> itemList;
	String account;//账户
	
	
}
