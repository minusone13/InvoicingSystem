package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Tool {
	//提供读文件工具，并可保存文件名，统一保存，便于修改
	public static String user = "User.ser";
	public static String stock = "Stock.ser";

	public static File Opendoc(String s)
	{//参数为需要打开的文件路径
	    File f = new File(s);
	    if(!f.exists())//若文件不存在，自动创建
	    try
	    {
	    	if(f.getParentFile() != null)
	    		f.getParentFile().mkdirs();
	        f.createNewFile();
	        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
	        oos.writeObject(null);
	        oos.close();
	    }
	    catch(IOException e)
	    {
	        System.out.println(e);
	    }
		return f;
	}
	public static void Clean(String s)
	{
		File f = new File(s);
		try
	    {
	        f.createNewFile();
	        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
	        oos.writeObject(null);
	        oos.close();
	    }
	    catch(IOException e)
	    {
	        System.out.println(e);
	    }
	}
}
