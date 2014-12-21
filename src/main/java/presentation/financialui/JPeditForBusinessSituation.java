package presentation.financialui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class JPeditForBusinessSituation extends JPanel
{
	private JTextField year1;
	private JTextField month1;
	private JTextField date1;
	private JTextField year2;
	private JTextField month2;
	private JTextField date2;

	public JPeditForBusinessSituation(){
		//面板大小
		this.setSize(240,270);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel ye1 = new JLabel("年");
		ye1.setForeground(Color.WHITE);
		ye1.setFont(new Font("宋体", Font.BOLD, 14));
		ye1.setBounds(94, 60, 25, 21);
		add(ye1);
		
		JLabel m1 = new JLabel("月");
		m1.setForeground(Color.WHITE);
		m1.setFont(new Font("宋体", Font.BOLD, 14));
		m1.setBounds(160, 59, 25, 23);
		add(m1);
		
		JLabel d1 = new JLabel("日");
		d1.setForeground(Color.WHITE);
		d1.setFont(new Font("宋体", Font.BOLD, 14));
		d1.setBounds(220, 60, 16, 21);
		add(d1);
		
		year1 = new JTextField();
		year1.setBounds(40, 60, 50, 20);
		add(year1);
		year1.setColumns(10);
		
		month1 = new JTextField();
		month1.setColumns(10);
		month1.setBounds(113, 60, 43, 21);
		add(month1);
		
		date1 = new JTextField();
		date1.setColumns(10);
		date1.setBounds(178, 60, 36, 21);
		add(date1);
		
		JLabel start = new JLabel("起始时间");
		start.setForeground(Color.WHITE);
		start.setFont(new Font("宋体", Font.BOLD, 14));
		start.setBounds(94, 29, 72, 21);
		add(start);
		
		JLabel over = new JLabel("结束时间");
		over.setForeground(Color.WHITE);
		over.setFont(new Font("宋体", Font.BOLD, 14));
		over.setBounds(94, 91, 72, 21);
		add(over);
		
		year2 = new JTextField();
		year2.setColumns(10);
		year2.setBounds(40, 120, 50, 20);
		add(year2);
		
		month2 = new JTextField();
		month2.setColumns(10);
		month2.setBounds(113, 120, 43, 21);
		add(month2);
		
		date2 = new JTextField();
		date2.setColumns(10);
		date2.setBounds(178, 120, 36, 21);
		add(date2);
		
		JLabel ye2 = new JLabel("年");
		ye2.setForeground(Color.WHITE);
		ye2.setFont(new Font("宋体", Font.BOLD, 14));
		ye2.setBounds(94, 120, 25, 21);
		add(ye2);
		
		JLabel m2 = new JLabel("月");
		m2.setForeground(Color.WHITE);
		m2.setFont(new Font("宋体", Font.BOLD, 14));
		m2.setBounds(160, 120, 25, 23);
		add(m2);
		
		JLabel d2 = new JLabel("日");
		d2.setForeground(Color.WHITE);
		d2.setFont(new Font("宋体", Font.BOLD, 14));
		d2.setBounds(220, 120, 16, 21);
		add(d2);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("C:\\Users\\wyc\\git\\git\\InvoicingSystem\\src\\image\\function\\editBlock.PNG"));
		bg.setBounds(0, 0, 240, 270);
		add(bg);
	}
}
