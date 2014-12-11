package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vo.stockvo.CommodityVO;

public class JPcommodity extends JPanel implements MouseListener{

	
	private JPanel inputNum=new JPanel();//输入数量面板
	private JPanel Numjp=new JPanel();//显示数量面板
	private JLabel numJL=new JLabel("",JLabel.CENTER);//显示数量标签
	private JTextField jtnum=new JTextField(4);
	private CommodityVO commodity;//对应的VO
	public CommodityVO getCommodity() {
		return commodity;
	}
	public void setCommodity(CommodityVO commodity) {
		this.commodity = commodity;
	}
	public boolean isChosen() {
		return chosen;
	}
	public void setChosen(boolean chosen) {
		this.chosen = chosen;
	}
	private boolean chosen=false;
	public JPcommodity(String name,String ID,int num){
	
		
		this.setSize(90, 95);
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//加上标签
		JLabel bg=new JLabel();
		bg.setBounds(15, 0, 60, 60);
		bg.setIcon(new ImageIcon("src/image/commodity.png"));
		JLabel jlname=new JLabel("<html>"+name+"</html>",JLabel.CENTER);
		jlname.setFont(new Font("宋体",Font.BOLD,11));
		jlname.setBounds(0, 60, 90, 15);
		jlname.setForeground(Color.white);
		
		JLabel jlID=new JLabel(ID,JLabel.CENTER);
		jlID.setBounds(0, 75, 90, 10);
		jlID.setForeground(Color.white);
		
		JLabel jlnum=new JLabel("num:"+String.valueOf(num),JLabel.CENTER);
		jlnum.setBounds(0, 85, 90, 10);
		jlnum.setForeground(Color.white);
		
	
		inputNum.setBounds(0, 0, 90, 95);
		inputNum.setLayout(null);
		inputNum.setOpaque(false);
		//输入数量面板的背景
		JLabel bgOfInputNum=new JLabel();
		bgOfInputNum.setIcon(new ImageIcon("src/image/commodity/inputNum.png") );
		bgOfInputNum.setBounds(0, 0, 90, 95);
		//输入数量面板的文本框
		
		jtnum.setBounds(20,37, 50, 20);
		jtnum.setOpaque(false);//文本框透明
		jtnum.setForeground(Color.white);//前景色
		//输入数量面板的确认按钮
		JLabel confirm=new JLabel();
		confirm.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		confirm.setBounds(33, 60, 24, 24);
		confirm.addMouseListener(new MouseListenerOfComfirm());
		
		inputNum.add(jtnum,0);
		inputNum.add(confirm,1);
		inputNum.add(bgOfInputNum,2);
		inputNum.setVisible(false);

		Numjp.setBounds(0, 0, 90, 95);
		Numjp.setLayout(null);
		Numjp.setOpaque(false);
		//输入数量面板的背景
		JLabel bgOfNumjp=new JLabel();
		bgOfNumjp.setIcon(new ImageIcon("src/image/commodity/purAndSale.png") );
		bgOfNumjp.setBounds(0, 0, 90, 95);
		
		numJL.setFont(new Font("黑体",Font.BOLD,30));
		numJL.setBounds(25,30,40,30);
		numJL.setForeground(Color.white);
		
		Numjp.add(numJL,0);
		Numjp.add(bgOfNumjp,1);
		Numjp.setVisible(false);
		
		this.add(inputNum,0);
		this.add(Numjp,1);
		this.add(bg,2);
		this.add(jlname,3);
		this.add(jlID,4);
		this.add(jlnum,5);
		
		this.addMouseListener(this);
		
	}
	public JPcommodity(CommodityVO com){
		this(com.getName(),com.getModel(),com.getNumber());
		commodity=com;
	}
	public class MouseListenerOfComfirm implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			//隐藏输入面板
			inputNum.setVisible(false);
			//标记选中
			chosen=true;
			//显示数字在标签上
			numJL.setText(jtnum.getText());
			//改变VO对象的数量信息
			commodity.setNumber(Integer.parseInt(jtnum.getText()));
			//显示选中面板
			Numjp.setVisible(true);
			//清空输入框
			jtnum.setText("");
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
		if(chosen==false){
			inputNum.setVisible(true);
		}
		else{
			Numjp.setVisible(false);
			chosen=false;
		}
		
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
