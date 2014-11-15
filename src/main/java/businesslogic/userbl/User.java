package businesslogic.userbl;

import java.security.*;

import po.UserPO;
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
		UserVO vo = new UserVO(po.getR(),po.getAccount(),po.getPassword(),po.getName());
		return vo;
	}
	//public void addRecord(Record rec)
	public boolean signUp(String account, String password,String name,Role r)
	{
		if(data.find(account)!=null)
			return false;
		else
			return true;
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
