package presentation.commodityui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPcommodity extends JPanel implements MouseListener{

	private String name;
	private String ID;
	private int num;
	private JPanel inputNum=new JPanel();//输入数量面板
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
		
	
		inputNum.setBounds(0, 0, 90, 110);
		inputNum.setLayout(null);
		inputNum.setOpaque(false);
		//输入数量面板的背景
		JLabel bgOfInputNum=new JLabel();
		bgOfInputNum.setIcon(new ImageIcon("src/image/commodity/inputNum.png") );
		bgOfInputNum.setBounds(0, 0, 90, 110);
		//输入数量面板的文本框
		JTextField jtnum=new JTextField(4);
		jtnum.setBounds(20,45, 50, 20);
		jtnum.setOpaque(false);//文本框透明
		jtnum.setForeground(Color.white);//前景色
		//输入数量面板的确认按钮
		JLabel confirm=new JLabel();
		confirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		confirm.setBounds(33, 70, 24, 24);
		confirm.addMouseListener(new MouseListenerOfComfirm());
		
		inputNum.add(jtnum,0);
		inputNum.add(confirm,1);
		inputNum.add(bgOfInputNum,2);
		inputNum.setVisible(false);
		
		this.add(inputNum,0);
		this.add(bg,1);
		this.add(jlname,2);
		this.add(jlID,3);
		this.add(jlnum,4);
		
		this.addMouseListener(this);
		
	}

	public class MouseListenerOfComfirm implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			inputNum.setVisible(false);
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		inputNum.setVisible(true);
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
