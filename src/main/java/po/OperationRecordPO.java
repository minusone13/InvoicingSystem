package po;

import java.util.*;
import java.io.*;

public class OperationRecordPO implements Serializable{
//记录主要操作
	Date d;
	UserPO user;
	String operation;
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
