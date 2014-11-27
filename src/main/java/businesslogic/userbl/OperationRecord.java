package businesslogic.userbl;

import java.util.Date;

import po.userpo.*;
import vo.RM;
import vo.uservo.OperationRecordVO;

public class OperationRecord {
	Date d;//操作日期
	User user;//操作者
	String operation;//动作内容
	RM result;//操作结果
	public OperationRecord(OperationRecordPO po)
	{
		d=po.getD();
		user=new User(po.getUser());
		operation=po.getOperation();
		result=po.getResult();
	}
	public OperationRecord(OperationRecordVO vo)
	{
		d=vo.getD();
		user=new User(vo.getUser());
		operation=vo.getOperation();
		result=vo.getResult();
	}
	public OperationRecordPO toPO()
	{
		return new OperationRecordPO(user.toPO(),operation,result);
	}
	public OperationRecordVO toVO()
	{
		return new OperationRecordVO(d,user.toVO(),operation,result);
	}
}
