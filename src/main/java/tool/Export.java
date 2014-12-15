package tool;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Export {
	//生成Excel的类
	public Export(String xlsName,String[][] data){
		try {
			WritableWorkbook book=Workbook.createWorkbook(new File(xlsName));
			WritableSheet sheet=book.createSheet("第一页",0);
			for(int i=0;i<data.length;i++){
				for(int j=0;j<data[0].length;j++){
					Label label=new Label(j,i,data[i][j]);
					sheet.addCell(label);
				}
			}
	        book.write();
	        book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
