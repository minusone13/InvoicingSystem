package businesslogic.userservice;

import businesslogic.userbl.OperationRecord;

public interface UserService
{// 管理员的Bl层内接口，由UserController实现
	public boolean addRecord(OperationRecord op);// 记录关键步骤，参数详见PO内的注释
}
