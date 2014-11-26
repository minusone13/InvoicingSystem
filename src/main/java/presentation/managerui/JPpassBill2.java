package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.GiftBillVO;

public class JPpassBill2 extends JPanel {

	//背景
	private JLabel bg=new JLabel();
	//向上
	private JLabel up=new JLabel();
	//向下
	private JLabel down=new JLabel();
	public JPpassBill2(){
		//面板大小
		this.setSize(345, 342);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/passBill/PassBillblock2.png"));
		bg.setBounds(0, 0, 345, 342);
		//面板
		JPanel jp=new JPanel();
		jp.setLayout(null);
		jp.setBounds(20,20,261, 93*3+22);
		jp.setOpaque(false);
		JLabel jpbg=new JLabel();
		jpbg.setBounds(0, 0, 261, 301);
		jpbg.setIcon(new ImageIcon("src/image/passBill/Pb2.png"));
		
		
		ArrayList<GiftBillVO> test=new ArrayList<GiftBillVO>();
		test.add(new GiftBillVO());
		test.add(new GiftBillVO());
		test.add(new GiftBillVO());
		//单据列表
		JPBillList billList=new JPBillList();
		billList.addGiftBill(test);
		billList.setLocation(0, 0);
		jp.add(billList,0);
		jp.add(jpbg,1);
		//向上按钮
		up.setIcon(new ImageIcon("src/image/upW.png"));
		up.setBounds(281, 20, 32, 32);
		up.addMouseListener(new MouseListenerOfButton(1));
		//向下按钮
		down.setIcon(new ImageIcon("src/image/downW.png"));
		down.setBounds(281, 289, 32, 32);
		down.addMouseListener(new MouseListenerOfButton(2));
		
		this.add(jp,0);
		this.add(up,1);
		this.add(down,2);
		this.add(bg,3);
	}
	public class MouseListenerOfButton implements MouseListener{

		private int num;
		public MouseListenerOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:up.setIcon(new ImageIcon("src/image/upR.png"));
				break;
			case 2:down.setIcon(new ImageIcon("src/image/downR.png"));
				break;	
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:up.setIcon(new ImageIcon("src/image/upW.png"));
				break;
			case 2:down.setIcon(new ImageIcon("src/image/downW.png"));
				break;	
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:up.setIcon(new ImageIcon("src/image/upW.png"));
				break;
			case 2:down.setIcon(new ImageIcon("src/image/downW.png"));
				break;	
			}
		}
		
	}
}
