package presentation.managerui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @先设置标题和内容再update
 * @author wyc
 *
 */
public class JTableOfList extends JPanel{

	private String[][] List;
	private String[] columnNames;
	private JScrollPane SCR;
	private JTable table;
	public JTableOfList(){
		this.setSize(320, 320);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		//背景图
		JLabel jpbg=new JLabel();
		jpbg.setBounds(0, 0, 320, 320);
		jpbg.setIcon(new ImageIcon("src/image/passBill/tableBack.png"));
		
		SCR = new JScrollPane();
		SCR.setBounds(0, 0, 320, 320);
		SCR.setOpaque(false);//设置透明
		SCR.getViewport().setOpaque(false);//设置透明
		SCR.setBorder(null);
		add(SCR,0);
		add(jpbg,1);
		
	}
	/*更新信息*/
	public void updateShow(){
		table = new JTable(List, columnNames);
		table.setOpaque(false);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();   
        render.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render);  
        table.setForeground(Color.white);
        table.setBorder(null);
        table.setShowGrid(false);
        table.setSelectionForeground(Color.white);
		SCR.setViewportView(table);
	}
	/*test*/
	public void test(){
		String[] item={"商品","型号","数量"};
		String[] commodityTest={"飞利浦日光灯","N1066","100"};
		columnNames=item;
		for(int i=0;i<30;i++){
			List[i]=commodityTest;
		}
		updateShow();
	}
	public String[][] getList() {
		return List;
	}
	public void setList(String[][] list) {
		List = list;
	}
	public String[] getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
}
