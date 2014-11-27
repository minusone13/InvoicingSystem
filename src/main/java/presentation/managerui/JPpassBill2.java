package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.BillState;
import vo.CashPaymentVO;

public class JPpassBill2 extends JPanel {

	//背景
	private JLabel bg=new JLabel();
	//向上
	private JLabel up=new JLabel();
	//向下
	private JLabel down=new JLabel();
	//单据列表
	JPBillList billList=new JPBillList();
	//审查通过功能按钮
	private JLabel check=new JLabel();
	//删除按钮
	private JLabel delete=new JLabel();
	//编辑按钮
	private JLabel edit=new JLabel();
	public JPpassBill2(){
		//面板大小
		this.setSize(800, 342);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//该面板背景
		bg.setIcon(new ImageIcon("src/image/passBill/PassBillblock2.png"));
		bg.setBounds(0, 0, 345, 342);
		//底板
		JPanel jp=new JPanel();
		jp.setLayout(null);
		jp.setBounds(20,20,261, 93*3+22);
		jp.setOpaque(false);
		//底板的灰色背景
		JLabel jpbg=new JLabel();
		jpbg.setBounds(0, 0, 261, 301);
		jpbg.setIcon(new ImageIcon("src/image/passBill/Pb2.png"));
		
		
		//测试数组的初始化
		ArrayList<CashPaymentVO> test=new ArrayList<CashPaymentVO>();
		CashPaymentVO bill1=new CashPaymentVO();
		CashPaymentVO bill2=new CashPaymentVO();
		CashPaymentVO bill3=new CashPaymentVO();
		CashPaymentVO bill4=new CashPaymentVO();
		bill1.setBillState(BillState.DRAFT);
		bill2.setBillState(BillState.SUBMITED);
		bill3.setBillState(BillState.EXAMINED);
		bill4.setBillState(BillState.OVER);
		test.add(bill1);
		test.add(bill2);
		test.add(bill3);
		test.add(bill4);

		//将测试数组加到单据面板列表
		billList.addCashPaymentBillList(test);

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
		
		//审查功能按钮
		check.setIcon(new ImageIcon("src/image/function/checkW.png"));
		check.setBounds(720, 20, 72, 72);
		check.addMouseListener(new MouseListenerOfButton(3));
		//删除功能按钮
		delete.setIcon(new ImageIcon("src/image/function/deleteW.png"));
		delete.setBounds(720, 112, 72, 72);
		delete.addMouseListener(new MouseListenerOfButton(4));
		//编辑功能按钮
		edit.setIcon(new ImageIcon("src/image/function/editW.png"));
		edit.setBounds(720, 204, 72, 72);
		edit.addMouseListener(new MouseListenerOfButton(5));
		
		this.add(jp,0);
		this.add(up,1);
		this.add(down,2);
		this.add(check,3);
		this.add(delete,4);
		this.add(edit,5);
		this.add(bg,6);
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
			//向上
			billList.startUp();
				break;
			case 2:down.setIcon(new ImageIcon("src/image/downR.png"));
			//向下
			billList.startDown();
				break;	
			case 3:check.setIcon(new ImageIcon("src/image/function/checkR.png"));
				break;
			case 4:delete.setIcon(new ImageIcon("src/image/function/deleteR.png"));
				billList.removeChosen();
				break;
			case 5:edit.setIcon(new ImageIcon("src/image/function/editR.png"));
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:up.setIcon(new ImageIcon("src/image/upW.png"));
			//向上停止
			billList.stop();
				break;
			case 2:down.setIcon(new ImageIcon("src/image/downW.png"));
			//向上停止
			billList.stop();
				break;	
			case 3:check.setIcon(new ImageIcon("src/image/function/checkW.png"));
				break;
			case 4:delete.setIcon(new ImageIcon("src/image/function/deleteW.png"));
				break;
			case 5:edit.setIcon(new ImageIcon("src/image/function/editW.png"));
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
			case 3:check.setIcon(new ImageIcon("src/image/function/checkW.png"));
				break;
			case 4:delete.setIcon(new ImageIcon("src/image/function/deleteW.png"));
				break;
			case 5:edit.setIcon(new ImageIcon("src/image/function/editW.png"));
				break;		
			}
		}
		
	}
}
