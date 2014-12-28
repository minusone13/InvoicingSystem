package presentation;

public class StringJudger {
	
		public int judgestring(String str){
			
			try {
			    int num1=Integer.valueOf(str);//把字符串强制转换为数字
			    double num2=Double.parseDouble(str);
			    return 3;//如果是数字，返回3
			   } catch (Exception e) {
				   //如果抛出异常，就进行其他判断
				   int length = str.length();
					char[] tempchar = str.toCharArray();
					for(int i=0;i<length;i++){
						if(tempchar[i]=='@')
							return 1;
						if(!(((tempchar[i]>='a')&&(tempchar[i]<='z'))||((tempchar[i]>='A')&&(tempchar[i]<='Z'))||((tempchar[i]>='0')&&(tempchar[i]<='9')))){
							return 4;
						}		
					}
			   }
			return 0;
		}
		/*
		 * 邮箱为1
		 * 数字为3
		 * 文字为为4
		 * */
}
