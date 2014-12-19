package presentation.financialui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entrance.Frame;
import po.BillStyle;
import po.Role;
import presentation.PanelType;
import presentation.financialui.JPmanageBills1.MouseListenOfButton;
import presentation.userui.Login;
import businesslogic.financialbl.Financial;
import businesslogicservice.financialblservice.FinancialBlService;

public class JPinquire extends JPanel {
	
	//单据标签
	private JLabel businessProcess = new JLabel("New label");
	private JLabel businessSituation = new JLabel("New label");
	private JLabel salesDetail = new JLabel("New label");
	//图片
	ImageIcon businessProcessIcon0=new ImageIcon("src\\image\\functions/financial/businessProcess0.png");
	ImageIcon businessSituationIcon0=new ImageIcon("src\\image\\functions/financial/businessSituation0.png");
	ImageIcon salesDetailIcon0=new ImageIcon("src\\image\\functions/financial/salesDetail0.png");
	ImageIcon businessProcessIcon=new ImageIcon("src\\image\\functions/financial/businessProcess.png");
	ImageIcon businessSituationIcon=new ImageIcon("src\\image\\functions/financial/businessSituation.png");
	ImageIcon salesDetailIcon=new ImageIcon("src\\image\\functions/financial/salesDetail.png");
	ImageIcon businessProcessIcon1=new ImageIcon("src\\image\\functions/financial/businessProcess1.png");
	ImageIcon businessSituationIcon1=new ImageIcon("src\\image\\functions/financial/businessSituation1.png");
	ImageIcon salesDetailIcon1=new ImageIcon("src\\image\\functions/financial/salesDetail1.png");
	//frame的引用
    Frame frame;
    //逻辑层的财务人员接口
    FinancialBlService fbl=new Financial();
	public JPinquire(){
		//设置窗口大小
		this.setSize(445, 330);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(0, 0, 445, 330);
	
		businessProcess.setIcon(businessProcessIcon0);
		businessProcess.setBounds(10, 15, 100, 100);
		businessProcess.addMouseListener(new MouseListenOfButton(21));
		add(businessProcess,0);
		
		
		businessSituation.setIcon(businessSituationIcon0);
		businessSituation.setBounds(115, 15, 100, 100);
		businessSituation.addMouseListener(new MouseListenOfButton(22));
		add(businessSituation,1);
		
		
		salesDetail.setIcon(salesDetailIcon0);
		salesDetail.setBounds(220, 15, 100, 100);
		salesDetail.addMouseListener(new MouseListenOfButton(23));
		add(salesDetail,2);
		
		add(bg,3);
	}
	/*获取frame的引用*/
	public void getFrame( Frame f){
  		frame=f;
    }
	public class MouseListenOfButton implements MouseListener{

		private int num;
		public MouseListenOfButton(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:businessProcess.setIcon(businessProcessIcon1);
				break;
			case 22:businessSituation.setIcon(businessSituationIcon1);
				break;
			case 23:salesDetail.setIcon(salesDetailIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:businessProcess.setIcon(businessProcessIcon);
				//切换
				JPinquire.this.setVisible(false);
				if(Login.user.getR()==Role.FINANCIAL_STAFF){
					frame.getFinancial().getBusinessProgress().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.BusinessProcessPanel);
				}
				else if(Login.user.getR()==Role.MANAGER){
					frame.getManager().getBusinessProgress().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getManager().setPanelType(PanelType.BusinessProcessPanel);
				}
				break;
			case 22:businessSituation.setIcon(businessSituationIcon);
				JPinquire.this.setVisible(false);
				if(Login.user.getR()==Role.FINANCIAL_STAFF){
					frame.getFinancial().getBusinessCondition().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.BusinessConditionPanel);
				}
				else if(Login.user.getR()==Role.MANAGER){
					frame.getManager().getBusinessCondition().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getManager().setPanelType(PanelType.BusinessConditionPanel);
				}
				break;
			case 23:salesDetail.setIcon(salesDetailIcon);
				JPinquire.this.setVisible(false);
				if(Login.user.getR()==Role.FINANCIAL_STAFF){
					frame.getFinancial().getSaleDetail().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getFinancial().setPanelType(PanelType.SaleDetailPanel);
				}
				else if(Login.user.getR()==Role.MANAGER){
					frame.getManager().getSaleDetail().setVisible(true);
					//标记当前面板，用于后退按钮
					frame.getManager().setPanelType(PanelType.SaleDetailPanel);
				}
				break;
			}
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:businessProcess.setIcon(businessProcessIcon);
				break;
			case 22:businessSituation.setIcon(businessSituationIcon);
				break;
			case 23:salesDetail.setIcon(salesDetailIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 21:businessProcess.setIcon(businessProcessIcon0);
				break;
			case 22:businessSituation.setIcon(businessSituationIcon0);
				break;
			case 23:salesDetail.setIcon(salesDetailIcon0);
				break;
			}
		}
		
	
}
}
