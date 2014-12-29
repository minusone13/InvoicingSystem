package presentation;

public class StringJudger {
	
		public int judgestring(String str){
			
			try {
			    double num=Double.parseDouble(str);//只要能强制转换成浮点数就是数字字符串
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
