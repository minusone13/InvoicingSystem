package businesslogic.userbl;

import java.security.*;
import java.util.ArrayList;

import po.userpo.*;
import vo.RM;
import vo.UserVO;
import dataservice.userdataservice.*;
import businesslogic.Role;

public class User {
	static StubUserDataService data;
	String ID;//自动生成
	Role r;//职务
	String account;//用于登陆的账号
	String password;//经过MD5加密的密码
	String name;//姓名
	
	
	public UserVO login(String account, String password)
	{
		UserPO po = data.login(account, string2MD5(password));
		if(po==null)
			return null;
		UserVO vo = new UserVO(po.getR(),po.getAccount(),po.getName());
		return vo;
	}
	public RM deleteUser(UserVO vo)
	{
		if(data.find(vo.getAccount())==null)
			return RM.notfound;
		boolean result=data.delete(new UserPO(vo.getID(),vo.getR(),vo.getAccount(),string2MD5(vo.getPassword()),vo.getName()));
		if(result==false)
			return RM.unknownerror;
		return RM.done;
	}
	public RM signUp(UserVO vo)
	{
		if(data.find(vo.getAccount())!=null)
			return RM.redundance;
		else
		{
			char c=0;
			switch(vo.getR()){//自动生成ID，详见Data层的UserList类
				case MANAGER: c='M';break;
				case ADMINISTRATOR: c='A';break;
				case FINANCIAL_STAFF: ;
				case FINANCIAL_MANAGER:c='F';break;
				case STOCK_STAFF: c='I';break;//抱歉只能用I咯，S和下面的进货人员重了；
				case PURCHASE_SALE_STAFF: c='S';break;
				default: return RM.unknownerror;
			}
			int x=data.count(c);
			x++;
			String result=Integer.toString(x);
			switch(result.length())
			{//编号前面补零，补成4位
				case 1:result="000"+result;
				case 2:result="00"+result;
				case 3:result="0"+result;
			}
			result=c+result;
			data.insert(new UserPO(result,vo.getR(),vo.getAccount(),string2MD5(vo.getPassword()),vo.getName()));
			return RM.done;
		}
	}
	
	public RM changePassword(UserVO vo)
	{
		RM result = data.updatePassword(new UserPO(vo.getID(),vo.getR(),vo.getAccount(),string2MD5(vo.getPassword()),vo.getName()));
		return result;
	}
	public RM changeRole(UserVO vo,Role newRole)
	{
		RM result = deleteUser(vo);//delete old account,because stuff ID relates to the kind of job
		if(result!=RM.done)
			return result;
		vo.setR(newRole);//changeRole
		result = signUp(vo);//signUp new account
		return result;
	}
	public ArrayList<UserVO> show()
	{
		ArrayList<UserPO>users=data.getUsers();
		ArrayList<UserVO>result=new ArrayList<UserVO>();
		for(int i=0;i<users.size();i++)
		{
			UserPO po = users.get(i);
			result.add(new UserVO(po.getID(),po.getR(),po.getAccount(),po.getPassword(),po.getName()));
		}
		return result;
	}
	
	public boolean addRecord(OperationRecordPO po)
	{
		return data.insert(po);
	}
	public void setPO(UserPO po)
	{
		ID=po.getID();
		r=po.getR();
		account=po.getAccount();
		password=po.getPassword();
		name=po.getName();
	}
	
	public UserPO getPO(UserPO po)
	{
		return new UserPO(ID,r,account,password,name);
	}
	
	
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
    } 
	public void setdataobject(StubUserDataService data)
	{
		this.data=data;
	}
	public static StubUserDataService getData() {
		return data;
	}
	public static void setData(StubUserDataService data) {
		User.data = data;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
