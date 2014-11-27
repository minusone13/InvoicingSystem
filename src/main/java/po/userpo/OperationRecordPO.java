package po.userpo;

import java.util.*;
import java.io.*;

import vo.RM;

public class OperationRecordPO implements Serializable, Cloneable{
//记录主要操作
	Date d;//操作日期
	UserPO user;//操作者
	String operation;//动作内容
	RM result;//操作结果
	public OperationRecordPO(UserPO user,String operation,RM result)
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
	public RM getResult() {
		return result;
	}
	public void setResult(RM result) {
		this.result = result;
	}
	public OperationRecordPO clone()
	{
		OperationRecordPO cloned = null;
		try {
			cloned=(OperationRecordPO)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cloned.d=(Date) cloned.d.clone();
		return cloned;
	}
}
