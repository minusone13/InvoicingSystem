package po;

import java.io.Serializable;
import java.util.ArrayList;

import businesslogic.financialbillbl.Item;
import businesslogic.financialbillbl.TransferAccount;

public class PO implements Serializable{//接口是lhw于20141207加上的
	String ID;
	Role role;
	
	
	BillState state;
	
	BillStyle style;

	
	
}
