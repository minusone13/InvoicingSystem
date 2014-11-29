package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.AlertBillVO;
import vo.GiftBillVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;
import vo.financialBillVO.CashPaymentVO;
import vo.financialBillVO.PaymentVO;
import vo.financialBillVO.ReceiptVO;
import businesslogic.BillState;
import businesslogic.BillStyle;
import businesslogic.managerbl.StubManager;
import businesslogicservice.managerblservice.StubManagerBlService;

public class JPBill extends JPanel {

	//单据编号
	private String ID;
	//单据类型
	private BillStyle style;
	//单据状态
	private BillState state;
	//背景
	private JLabel bg=new JLabel();
	//向右按钮
	private JLabel right=new JLabel();
	//向左按钮
	private JLabel left=new JLabel();
	//选中标记
	private boolean choose=false;
	//逻辑层的接口
	StubManagerBlService mbl=new StubManager();
	public JPBill(GiftBillVO gb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		bg.setIcon(new ImageIcon("src/image/sample.jpg"));
		bg.setBounds(0, 0, 522, 93);
		
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(bg,2);
		
	}
	public JPBill(SpillsLossBillVO slb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(AlertBillVO ab){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PurSheetVO ps){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PurBackSheetVO pbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(SaleSheetVO ss){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(SaleBackSheetVO sbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(ReceiptVO rb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(PaymentVO pb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public JPBill(CashPaymentVO cb){
		//设置单据编号，状态，种类
		state=cb.getBillState();
		style=cb.getBillStyle();
		ID=cb.getID();
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		//背景
		setBillBg(BillStyle.CashPaymentBill,cb.getBillState(),0);
		bg.setBounds(0, 0, 522, 93);
		bg.addMouseListener(new MouseListenerOfBill(BillStyle.CashPaymentBill));
		//向右
		right.setIcon(new ImageIcon("src/image/right.png"));
		right.setBounds(221, 26, 40, 40);
		right.addMouseListener(new MouseListenerOfButton(1));
		//向左
		left.setIcon(new ImageIcon("src/image/left.png"));
		left.setBounds(482, 26, 40, 40);
		left.addMouseListener(new MouseListenerOfButton(2));
		//将组件加到面板上
		this.add(right,0);
		this.add(left,1);
		this.add(bg,2);
	}
	public void change(GiftBillVO gb){
	
		//调用逻辑层修改对应单据的数据
		gb.setID(ID);//设置对应单据的编号
		mbl.change(gb);
		//根据内存中单据的数据重新设置面板界面
	
	}
	public void change(SpillsLossBillVO slb){
		//调用逻辑层修改对应单据的数据
		slb.setID(ID);//设置对应单据的编号
		mbl.change(slb);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(AlertBillVO ab){
		//调用逻辑层修改对应单据的数据
		ab.setID(ID);//设置对应单据的编号
		mbl.change(ab);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(PurSheetVO ps){
		//调用逻辑层修改对应单据的数据
		ps.setID(ID);//设置对应单据的编号
		mbl.change(ps);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(PurBackSheetVO pbs){
		//调用逻辑层修改对应单据的数据
		pbs.setID(ID);//设置对应单据的编号
		mbl.change(pbs);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(SaleSheetVO ss){
		//调用逻辑层修改对应单据的数据
		ss.setID(ID);//设置对应单据的编号
		mbl.change(ss);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(SaleBackSheetVO sbs){
		//调用逻辑层修改对应单据的数据
		sbs.setID(ID);//设置对应单据的编号
		mbl.change(sbs);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(ReceiptVO rb){
		//调用逻辑层修改对应单据的数据
		rb.setID(ID);//设置对应单据的编号
		mbl.change(rb);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(PaymentVO pb){
		//调用逻辑层修改对应单据的数据
		pb.setID(ID);//设置对应单据的编号
		mbl.change(pb);
		//根据内存中单据的数据重新设置面板界面
	}
	public void change(CashPaymentVO cb){
		//调用逻辑层修改对应单据的数据
		cb.setID(ID);//设置对应单据的编号
		mbl.change(cb);
		//根据内存中单据的数据重新设置面板界面
	}
	/*修改状态*/
	public void transformState(BillState st){
		//修改逻辑层的数据
		//mbl.transformState(style, ID, st);
		//界面层
		state=st;
		//修改背景
		setBillBg(style,state,2);
	}
	/*根据条件生成地址给单据上背景*/
	public void setBillBg(BillStyle style,BillState state,int num){
		String s1="";
		String s2="";
		switch(style){
		case GiftBill:
			break;
		case SpillsLossBill:
			break;
		case AlertBill:
			break;
		case PurSheet:
			break;
		case PurBackSheet:
			break;
		case SaleSheet:
			break;
		case SaleBackSheet:
			break;
		case ReceiptBill:
			break;
		case PaymentBill:
			break;
		case CashPaymentBill:s1="CashPaymentbill";
			break;
		}
		switch(state){
		case DRAFT:s2="1";
			break;
		case SUBMITED:s2="2";
			break;
		case EXAMINED:s2="3";
			break;
		case OVER:s2="4";
			break;
		}
		bg.setIcon(new ImageIcon("src/image/JPbill/"+s1+"/"+s1+s2+String.valueOf(num)+".png"));

		
	}
	/*看详细信息*/
	public void showDetail(){

		Thread t=new Thread(new TreadOfRight());
		t.start();
	}
	/*看简要信息*/
	public void showBrief(){
		Thread t=new Thread(new TreadOfLeft());
		t.start();
	}
	/*返回选中状态*/
	public boolean getChoose(){
		return choose;
	}
	
	public BillStyle getStyle() {
		return style;
	}
	public BillState getState() {
		return state;
	}
	public String getID() {
		return ID;
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
				right.setIcon(new ImageIcon("src/image/rightR.png"));
				//显示详细
				showDetail();
				break;
			case 2:left.setIcon(new ImageIcon("src/image/leftR.png"));
			    //显示简
			    showBrief();
				break;
			}
	
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
			switch(num){
			case 1:
				right.setIcon(new ImageIcon("src/image/right.png"));
				break;
			case 2:left.setIcon(new ImageIcon("src/image/left.png"));
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
				right.setIcon(new ImageIcon("src/image/right.png"));
				break;
			case 2:left.setIcon(new ImageIcon("src/image/left.png"));
				break;
			
			}
			
		}
		
	}

	public class TreadOfRight  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=0;
			int y=(int)JPBill.this.getLocation().getY();
			while(x!=-261){
				if((x+261)>10){
					x-=10;
				}
				else{
					x=-261;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPBill.this.setLocation(x, y);
			}
		}
		
	}
	
	public class TreadOfLeft  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=-261;
			int y=(int)JPBill.this.getLocation().getY();
			while(x!=0){
				if((0-x)>10){
					x+=10;
				}
				else{
					x=0;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JPBill.this.setLocation(x, y);
			}
		}
		
	}

	public class MouseListenerOfBill implements MouseListener{

		private BillStyle st;
		
		public MouseListenerOfBill(BillStyle s){
			st=s;
			
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			choose=!choose;//选中与取消选中
			if(choose){
				setBillBg(st,state,3);
			}
			else{
				setBillBg(st,state,1);
			}
			
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(choose){
				setBillBg(st,state,3);
			}
			else{
				setBillBg(st,state,1);
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(choose){
				setBillBg(st,state,2);
			}
			else{
				setBillBg(st,state,0);
			}
		}
		
	}
}
