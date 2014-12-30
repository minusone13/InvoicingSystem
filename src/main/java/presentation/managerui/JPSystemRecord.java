package presentation.managerui;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import entrance.Frame;
import vo.uservo.OperationRecordVO;
import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.StubUserBlService;

public class JPSystemRecord extends JPanel
{
	String[] names = {"时间","操作者","操作细节","操作结果"};
	DefaultTableModel model=new DefaultTableModel(new Object[][]{},names);
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);
	//需要用到记录操作的接口
	StubUserBlService userService=new UserController();
	//frame的引用
	private Frame frame;
	public JPSystemRecord(){
		initial();
	}
	/*初始化*/
	public void initial(){
		this.setBounds(0, 0,905, 315);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景图
		JLabel jpbg1=new JLabel();
		jpbg1.setBounds(0, 0,800, 315);
		jpbg1.setIcon(new ImageIcon("src/image/block/blockForTable3.png"));
	
		//表格透明
		table.setSelectionForeground(Color.white);
		table.setOpaque(false);
        DefaultTableCellRenderer render1 = new DefaultTableCellRenderer();   
        render1.setOpaque(false); //将渲染器设置为透明  
        table.setDefaultRenderer(Object.class,render1);  
        table.setForeground(Color.white);
        table.setBorder(null);
        table.setShowVerticalLines(false);
		//滚动面板透明
        pane.setOpaque(false);//设置透明
		pane.getViewport().setOpaque(false);//设置透明
		pane.setBorder(null);
		pane.setBounds(0, 0, 800,315);
		
		add(pane,0);
		add(jpbg1,1);
		//更新表格数据
		updateTable();
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
	}
	/*更新表格数据*/
	public void updateTable(){
		//获取操作记录列表
		ArrayList<OperationRecordVO> records=userService.showRecords();
		//填充表格数据
		Object[][] data=new Object[records.size()][];
		//用于转换时间格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		if(records!=null){
			for(int i=0;i<records.size();i++){
				String Time = format.format(records.get(i).getD());
				String Role="";
				if(records.get(i)==null){
					System.out.println("记录空指针");
				}
				else if(records.get(i).getUser()==null){
					System.out.println("用户空指针");
				}
				else if(records.get(i).getUser().getR()==null){
					System.out.println("职务空指针");
				}
				if(records.get(i).getUser().getR()!=null)//added by lhw
					switch(records.get(i).getUser().getR()){
						case ADMINISTRATOR:Role="管理员";
							break;
						case FINANCIAL_STAFF:Role="财务人员";
							break;
						case FINANCIAL_MANAGER:Role="财务经理";
							break;
						case MANAGER:Role="总经理";
							break;
						case STOCK_STAFF:Role="库存管理人员";
							break;
						case PURCHASE_SALE_STAFF:Role="进销人员";
							break;
						case PURCHASE_SALE_MANAGER:Role="销售经理 ";
							break;
				}
				else
					Role="未知用户";
				Object[] temp={Time,
						Role+records.get(i).getUser().getID()+":"+records.get(i).getUser().getName(),
						records.get(i).getOperation(),
						records.get(i).getResult()
				};
				data[i]=temp;
			}
		}
	
		model.setDataVector(data, names);
		table.updateUI();
	}
	
}
