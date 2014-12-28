package presentation.commodityui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.BillStyle;
import presentation.PanelType;
import presentation.commodityui.JPStcokShow.MouseListenOfButton;
import businesslogic.stockmanagerbl.StubStockController;
import businesslogicservice.commodityblservice.StubCommodityBlService;
import entrance.Frame;

@SuppressWarnings("serial")
public class JPStcokShow extends JPanel {

	
	//单据标签
	private JLabel stcokTack = new JLabel("New label");//库存盘点
	private JLabel stockCheck = new JLabel("New label");//库存查看
	//图片
	ImageIcon stcokTackIcon0=new ImageIcon("src\\image\\stcokShow\\tack0.png");
	ImageIcon stockCheckIcon0=new ImageIcon("src\\image\\stcokShow\\check0.png");
	
	ImageIcon stcokTackIcon=new ImageIcon("src\\image\\stcokShow\\tack.png");
	ImageIcon stockCheckIcon=new ImageIcon("src\\image\\stcokShow\\check.png");
	
	ImageIcon stcokTackIcon1=new ImageIcon("src\\image\\stcokShow\\tack1.png");
	ImageIcon stockCheckIcon1=new ImageIcon("src\\image\\stcokShow\\check1.png");
	//frame的引用
    Frame frame;
    //逻辑层的库管人员接口
    StubCommodityBlService stcokbl=new StubStockController();
	public JPStcokShow(){
		//设置窗口大小
		this.setSize(445, 330);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("src\\image\\passBill\\passBillBlock1.png"));
		bg.setBounds(0, 0, 445, 330);
	
		
		stcokTack.setIcon(stcokTackIcon0);
		stcokTack.setBounds(10, 15, 100, 100);
		stcokTack.addMouseListener(new MouseListenOfButton(11));
		add(stcokTack,0);
		
		
		stockCheck.setIcon(stockCheckIcon0);
		stockCheck.setBounds(115, 15, 100, 100);
		stockCheck.addMouseListener(new MouseListenOfButton(12));
		add(stockCheck,1);
		
		
		
		add(bg,2);
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
			case 11:
				stcokTack.setIcon(stcokTackIcon1);
				break;
			case 12:stockCheck.setIcon(stockCheckIcon1);
				break;
			}
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:stcokTack.setIcon(stcokTackIcon);
				//切换
				JPStcokShow.this.setVisible(false);
				frame.getStock().getStockTack().update();
				frame.getStock().getStockTack().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getStock().setPanelType(PanelType.StockInventoryPanel);
				break;
			case 12:stockCheck.setIcon(stockCheckIcon);
				//切换
				JPStcokShow.this.setVisible(false);
				frame.getStock().getStockCheck().setVisible(true);
				//标记当前面板，用于后退按钮
				frame.getStock().setPanelType(PanelType.StockCheckPanel);
				break;
			}
			
		}

		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				stcokTack.setIcon(stcokTackIcon);
				break;
			case 12:stockCheck.setIcon(stockCheckIcon);
				break;
			}
		}

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 11:
				stcokTack.setIcon(stcokTackIcon0);
				break;
			case 12:stockCheck.setIcon(stockCheckIcon0);
				break;
			}
		}
		
	}
}
