package presentation.managerui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		
		SCR = new JScrollPane();
		SCR.setBounds(0, 0, 320, 320);
		add(SCR);
	}
	//更新信息
	public void updateShow(){
		table = new JTable(List, columnNames);
		SCR.setViewportView(table);
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
