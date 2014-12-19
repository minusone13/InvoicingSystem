package vo.uservo;

import java.util.Date;

import po.RM;
import po.userpo.OperationRecordPO;
import po.userpo.UserPO;

public class OperationRecordVO
{
	// 记录主要操作
	Date d;// 操作日期
	UserVO user;// 操作者
	String operation;// 动作内容
	RM result;// 操作结果

	public OperationRecordVO(UserVO user, String operation, RM result)
	{
		d = new Date();
		this.user = user;
		this.operation = operation;
		this.result = result;
	}

	public OperationRecordVO()
	{}

	public OperationRecordVO(Date d, UserVO user, String operation, RM result)
	{
		this.d = d;
		this.user = user;
		this.operation = operation;
		this.result = result;
	}

	public Date getD()
	{
		return d;
	}

	public void setD(Date d)
	{
		this.d = d;
	}

	public UserVO getUser()
	{
		return user;
	}

	public void setUser(UserVO user)
	{
		this.user = user;
	}

	public String getOperation()
	{
		return operation;
	}

	public void setOperation(String operation)
	{
		this.operation = operation;
	}

	public RM getResult()
	{
		return result;
	}

	public void setResult(RM result)
	{
		this.result = result;
	}

	public OperationRecordVO clone()
	{
		OperationRecordVO cloned = null;
		try
		{
			cloned = (OperationRecordVO) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cloned.d = (Date) cloned.d.clone();
		return cloned;
	}
}
