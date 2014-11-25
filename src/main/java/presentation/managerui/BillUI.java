package presentation.managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vo.AlertBillVO;
import vo.CashPaymentVO;
import vo.GiftBillVO;
import vo.PaymentVO;
import vo.PurBackSheetVO;
import vo.PurSheetVO;
import vo.ReceiptVO;
import vo.SaleBackSheetVO;
import vo.SaleSheetVO;
import vo.SpillsLossBillVO;

public class BillUI extends JPanel {

	//背景
	private JLabel bg=new JLabel();
	//向右按钮
	private JLabel right=new JLabel();
	public BillUI(GiftBillVO gb){
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
		right.addMouseListener(new MouseListenerOfButton());
		
		this.add(right,0);
		this.add(bg,1);
		
	}
	public BillUI(SpillsLossBillVO slb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(AlertBillVO ab){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(PurSheetVO ps){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(PurBackSheetVO pbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(SaleSheetVO ss){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(SaleBackSheetVO sbs){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(ReceiptVO rb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(PaymentVO pb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public BillUI(CashPaymentVO cb){
		//面板大小
		this.setSize(522, 93);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
	}
	public void showDetail(){
		
	}
	public class MouseListenerOfButton implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			right.setIcon(new ImageIcon("src/image/rightR.png"));
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			right.setIcon(new ImageIcon("src/image/right.png"));
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			right.setIcon(new ImageIcon("src/image/right.png"));
		}
		
	}
}
