package po;

import java.util.ArrayList;

import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.Role;
import businesslogic.financialbillbl.StubItem;
import businesslogic.financialbillbl.StubTransferAccount;

public class PO {
	String ID;
	Role role;
	String customer;
	double total;
	BillState state;
	ArrayList<StubTransferAccount> transferlist;
	BillStyle style;
	ArrayList<StubItem> itemList;
	String account;//账户
	
	
}
