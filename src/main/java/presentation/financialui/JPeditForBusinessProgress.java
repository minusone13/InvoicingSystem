package presentation.financialui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.CustomerVO;
import businesslogic.customerbl.CustomerList;
import businesslogicservice.customerblservice.CustomerBlService;

public class JPeditForBusinessProgress extends JPanel
{
	private JTextField year1;
	private JTextField month1;
	private JTextField date1;
	private JTextField year2;
	private JTextField month2;
	private JTextField date2;
	private JTextField salemanTxt;
	private JComboBox customerCombo;
	private JComboBox warehouseCombo;
	private JComboBox billTypeCombo;
	//右移按钮
	private JLabel right=new JLabel();
	//确认按钮
	private JLabel confirm=new JLabel();
	//图片
	private ImageIcon right0=new ImageIcon("src/image/function/rightW.png");
	private ImageIcon right1=new ImageIcon("src/image/function/rightR.png");
	private ImageIcon confirm0=new ImageIcon("src/image/function/confirmW.png");
	private ImageIcon confirm1=new ImageIcon("src/image/function/confirmR.png");
	//调用逻辑层
    CustomerBlService customerbl=new CustomerList();
	public JPeditForBusinessProgress(){
		//面板大小
		this.setSize(240,270);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//右移按钮
		right.setIcon(right0);
		right.setBounds(10, 123, 24, 24);
		right.addMouseListener(new MouseListenerOfButton(1));
		//确认按钮
		confirm.setIcon(confirm0);
		confirm.setBounds(120, 236, 24, 24);
		confirm.addMouseListener(new MouseListenerOfButton(3));
		add(right);
		add(confirm);
		JLabel ye1 = new JLabel("年");
		ye1.setForeground(Color.WHITE);
		ye1.setFont(new Font("宋体", Font.BOLD, 14));
		ye1.setBounds(94, 33, 25, 21);
		add(ye1);
		
		JLabel m1 = new JLabel("月");
		m1.setForeground(Color.WHITE);
		m1.setFont(new Font("宋体", Font.BOLD, 14));
		m1.setBounds(160, 32, 25, 23);
		add(m1);
		
		JLabel d1 = new JLabel("日");
		d1.setForeground(Color.WHITE);
		d1.setFont(new Font("宋体", Font.BOLD, 14));
		d1.setBounds(220, 33, 16, 21);
		add(d1);
		
		year1 = new JTextField();
		year1.setBounds(40, 33, 50, 20);
		add(year1);
		year1.setColumns(10);
		
		month1 = new JTextField();
		month1.setColumns(10);
		month1.setBounds(113, 33, 43, 21);
		add(month1);
		
		date1 = new JTextField();
		date1.setColumns(10);
		date1.setBounds(178, 33, 36, 21);
		add(date1);
		
		JLabel start = new JLabel("起始时间");
		start.setForeground(Color.WHITE);
		start.setFont(new Font("宋体", Font.BOLD, 14));
		start.setBounds(94, 10, 72, 21);
		add(start);
		
		JLabel over = new JLabel("结束时间");
		over.setForeground(Color.WHITE);
		over.setFont(new Font("宋体", Font.BOLD, 14));
		over.setBounds(94, 64, 72, 21);
		add(over);
		
		year2 = new JTextField();
		year2.setColumns(10);
		year2.setBounds(40, 90, 50, 20);
		add(year2);
		
		month2 = new JTextField();
		month2.setColumns(10);
		month2.setBounds(113, 90, 43, 21);
		add(month2);
		
		date2 = new JTextField();
		date2.setColumns(10);
		date2.setBounds(178, 90, 36, 21);
		add(date2);
		
		JLabel ye2 = new JLabel("年");
		ye2.setForeground(Color.WHITE);
		ye2.setFont(new Font("宋体", Font.BOLD, 14));
		ye2.setBounds(94, 90, 25, 21);
		add(ye2);
		
		JLabel m2 = new JLabel("月");
		m2.setForeground(Color.WHITE);
		m2.setFont(new Font("宋体", Font.BOLD, 14));
		m2.setBounds(160, 89, 25, 23);
		add(m2);
		
		JLabel d2 = new JLabel("日");
		d2.setForeground(Color.WHITE);
		d2.setFont(new Font("宋体", Font.BOLD, 14));
		d2.setBounds(220, 90, 16, 21);
		add(d2);
		
		JLabel label = new JLabel("单据类型");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("宋体", Font.BOLD, 14));
		label.setBounds(40, 120, 60, 21);
		add(label);
		
		String[] billTypeStr={"付款收款单","现金费用单","进货类单据","销售类单据","赠送单","报警单和报溢报损单"};
		billTypeCombo= new JComboBox(billTypeStr);
		billTypeCombo.setBounds(104, 120, 126, 20);
		add(billTypeCombo);
		
		JLabel label_1 = new JLabel("客户");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("宋体", Font.BOLD, 14));
		label_1.setBounds(40, 145, 36, 21);
		add(label_1);
		
		//客户下拉框
		ArrayList<CustomerVO> customers2 = null;
		customers2 = customerbl.getAllCustomer("Customer.txt");
		String[] customerS2=new String[customers2.size()];
		for(int i=0;i<customers2.size();i++){
			customerS2[i]=customers2.get(i).getname()+":"+customers2.get(i).getid();
		}
		customerCombo= new JComboBox(customerS2);
		customerCombo.setBounds(74, 145, 156, 20);
		add(customerCombo);
		
		JLabel label_2 = new JLabel("业务员");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("宋体", Font.BOLD, 14));
		label_2.setBounds(40, 168, 50, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("仓库");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("宋体", Font.BOLD, 14));
		label_3.setBounds(40, 192, 36, 21);
		add(label_3);
		
		salemanTxt = new JTextField();
		salemanTxt.setColumns(10);
		salemanTxt.setBounds(90, 168, 140, 20);
		add(salemanTxt);
		
		String[] warehouseStr={"仓库1"};
		warehouseCombo = new JComboBox(warehouseStr);
		warehouseCombo.setBounds(74, 192, 156, 20);
		add(warehouseCombo);
		
		JLabel bg = new JLabel("bg");
		bg.setIcon(new ImageIcon("C:\\Users\\wyc\\git\\git\\InvoicingSystem\\src\\image\\function\\editBlock.PNG"));
		bg.setBounds(0, 0, 240, 270);
		add(bg);
	}
	public class MouseListenerOfButton implements MouseListener{

		private int num;//1、右移  3、确认
		public MouseListenerOfButton(int N){
			num=N;
		}
		
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				right.setIcon(right1);
				//右移
				RightMove();
				break;
			case 3:
				confirm.setIcon(confirm1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				right.setIcon(right0);
				break;
			case 3:
				confirm.setIcon(confirm0);
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				right.setIcon(right0);
				break;
			case 3:
				confirm.setIcon(confirm0);
				break;
			}
		}
		
	}
	public class TreadOfLeft  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=905;
			int y=36;
			while(x!=665){
				if((x-665)>10){
					x-=10;
				}
				else{
					x=665;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPeditForBusinessProgress.this.setLocation(x, y);
			}
		}
		
	}
	
	public class TreadOfRight  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=665;
			int y=36;
			while(x!=905){
				if((905-x)>10){
					x+=10;
				}
				else{
					x=905;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPeditForBusinessProgress.this.setLocation(x, y);
			}
		}
		
	}
	public void leftMove(){
		Thread t=new Thread(new TreadOfLeft());
		t.start();
	}
	public void RightMove(){
		Thread t=new Thread(new TreadOfRight());
		t.start();
	}
}
