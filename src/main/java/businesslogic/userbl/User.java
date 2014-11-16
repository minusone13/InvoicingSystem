package businesslogic.userbl;

import java.security.*;

import po.userpo.*;
import vo.UserVO;
import dataservice.userdataservice.*;
import businesslogic.Role;

public class User {
	static StubUserDataService data;
	public UserVO login(String account, String password)
	{
		UserPO po = data.login(account, string2MD5(password));
		if(po==null)
			return null;
		UserVO vo = new UserVO(po.getR(),po.getAccount(),po.getName());
		return vo;
	}
	public boolean signUp(UserVO vo)
	{
		if(data.find(vo.getAccount())!=null)
			return false;
		else
		{
			data.insert(new UserPO(vo.getR(),vo.getAccount(),string2MD5(vo.getPassword()),vo.getName()));
			return true;
		}
	}
	
	public boolean changePassword(UserVO vo)
	{
		boolean result = data.updatePassword(new UserPO(vo.getR(),vo.getAccount(),string2MD5(vo.getPassword()),vo.getName()));
		return result;
	}
	
	public boolean addRecord(OperationRecordPO po)
	{
		return data.insert(po);
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
}
