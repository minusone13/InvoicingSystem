package presentation;

public class StringJudger {
	
		public int judgestring(String str){
			int length = str.length();
			char[] tempchar = str.toCharArray();
			for(int i=0;i<length;i++){
				if(tempchar[i]=='@')
					return 1;
				if(tempchar[i]=='.')
					return 2;
				if(!(((tempchar[i]>='a')&&(tempchar[i]<='z'))||((tempchar[i]>='A')&&(tempchar[i]<='Z'))||((tempchar[i]>='0')&&(tempchar[i]<='9')))){
					return 4;
				}		
			}
			return 3;
		}
		/*
		 * 邮箱为1
		 * double为2
		 * Int为3
		 * 文字为为4
		 * */
}
