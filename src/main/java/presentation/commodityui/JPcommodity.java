package presentation.commodityui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JPcommodity extends JPanel {

	private String name;
	private String ID;
	private int num;
	public JPcommodity(String name,String ID,int num){
		this.name=name;
		this.ID=ID;
		this.num=num;
		
		this.setSize(90, 110);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//加上标签
		JLabel bg=new JLabel();
		bg.setBounds(15, 0, 60, 60);
		bg.setIcon(new ImageIcon("src/image/commodity.png"));
		JLabel jlname=new JLabel("<html>"+name+"</html>",JLabel.CENTER);
		jlname.setBounds(0, 60, 90, 30);
		jlname.setForeground(Color.white);
		
		JLabel jlID=new JLabel(ID,JLabel.CENTER);
		jlID.setBounds(0, 90, 90, 10);
		jlID.setForeground(Color.white);
		
		JLabel jlnum=new JLabel("num:"+String.valueOf(num),JLabel.CENTER);
		jlnum.setBounds(0, 100, 90, 10);
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
