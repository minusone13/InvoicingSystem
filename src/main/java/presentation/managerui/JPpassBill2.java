package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.BillState;
import userui.Frame;
import vo.financialBillVO.CashPaymentVO;

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
	//图片
	ImageIcon upIconW=new ImageIcon("src/image/upW.png");
	ImageIcon downIconW=new ImageIcon("src/image/downW.png");
	ImageIcon checkIconW=new ImageIcon("src/image/function/checkW.png");
	ImageIcon deleteIconW=new ImageIcon("src/image/function/deleteW.png");
	ImageIcon editIconW=new ImageIcon("src/image/function/editW.png");
	
	ImageIcon upIconR=new ImageIcon("src/image/upR.png");
	ImageIcon downIconR=new ImageIcon("src/image/downR.png");
	ImageIcon checkIconR=new ImageIcon("src/image/function/checkR.png");
	ImageIcon deleteIconR=new ImageIcon("src/image/function/deleteR.png");
	ImageIcon editIconR=new ImageIcon("src/image/function/editR.png");
	//frame的引用
    Frame frame;
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
		up.setIcon(upIconW);
		up.setBounds(281, 20, 32, 32);
		up.addMouseListener(new MouseListenerOfButton(1));
		//向下按钮
		down.setIcon(downIconW);
		down.setBounds(281, 289, 32, 32);
		down.addMouseListener(new MouseListenerOfButton(2));
		
		//审查功能按钮
		check.setIcon(checkIconW);
		check.setBounds(720, 20, 50, 50);
		check.addMouseListener(new MouseListenerOfButton(3));
		//删除功能按钮
		delete.setIcon(deleteIconW);
		delete.setBounds(720, 112, 50, 50);
		delete.addMouseListener(new MouseListenerOfButton(4));
		//编辑功能按钮
		edit.setIcon(editIconW);
		edit.setBounds(720, 204, 50, 50);
		edit.addMouseListener(new MouseListenerOfButton(5));
		
		this.add(jp,0);
		this.add(up,1);
		this.add(down,2);
		this.add(check,3);
		this.add(delete,4);
		this.add(edit,5);
		this.add(bg,6);
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
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
			case 1:
			up.setIcon(upIconR);
			//向上
			billList.startUp();
				break;
			case 2:
			down.setIcon(downIconR);
			//向下
			billList.startDown();
				break;	
			case 3:
				check.setIcon(checkIconR);
				billList.passChosen();
				break;
			case 4:
				delete.setIcon(deleteIconR);
				billList.removeChosen();
				break;
			case 5:
				edit.setIcon(editIconR);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
			up.setIcon(upIconW);
			//向上停止
			billList.stop();
				break;
			case 2:
			down.setIcon(downIconW);
			//向上停止
			billList.stop();
				break;	
			case 3:
				check.setIcon(checkIconW);
				break;
			case 4:
				delete.setIcon(deleteIconW);
				break;
			case 5:
				edit.setIcon(editIconW);
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
				up.setIcon(upIconW);
				break;
			case 2:
				down.setIcon(downIconW);
				break;	
			case 3:
				check.setIcon(checkIconW);
				break;
			case 4:
				delete.setIcon(deleteIconW);
				break;
			case 5:
				edit.setIcon(editIconW);
				break;		
			}
		}
		
	}
}
