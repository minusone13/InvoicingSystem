package po.userpo;

import java.util.*;
import java.io.*;

public class OperationRecordPO implements Serializable{
//记录主要操作
	Date d;
	UserPO user;
	String operation;
	String result;
	public OperationRecordPO(UserPO user,String operation,String result)
	{
		d=new Date();
		this.user=user.clone();
		this.operation=operation;
		this.result=result;
	}
	public OperationRecordPO(){}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public UserPO getUser() {
		return user;
	}
	public void setUser(UserPO user) {
		this.user = user;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
}
