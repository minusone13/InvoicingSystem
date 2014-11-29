package presentation.commodityui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPcommodity extends JPanel {

	private String name;
	private String ID;
	private int num;
	public JPcommodity(String name,String ID,int num){
		this.name=name;
		this.ID=ID;
		this.num=num;
		
		this.setSize(60, 110);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//加上标签
		JLabel bg=new JLabel();
		bg.setBounds(0, 0, 60, 60);
		bg.setIcon(new ImageIcon("src/image/commodity.png"));
		JLabel jlname=new JLabel();
		jlname.setText("<html>"+name+"</html>");
		jlname.setBounds(0, 60, 60, 30);
		jlname.setForeground(Color.white);
		
		JLabel jlID=new JLabel(ID);
		jlID.setBounds(0, 90, 60, 10);
		jlID.setForeground(Color.white);
		
		JLabel jlnum=new JLabel(String.valueOf(num));
		jlnum.setBounds(0, 100, 60, 10);
		jlnum.setForeground(Color.white);
		
		this.add(bg,0);
		this.add(jlname,1);
		this.add(jlID,2);
		this.add(jlnum,3);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
