package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.BillStyle;
import vo.stockvo.CommodityVO;

public class JPcommodity extends JPanel implements MouseListener{

	//界面显示的三个信息标签
	private JLabel jlType;
	private JLabel jlname;
	private JLabel jlnum;
	
	private JPanel editOfManager=new JPanel();//输入数量面板
	private JPanel showOfManager=new JPanel();//显示数量面板
	
	private JLabel showNumOfManager=new JLabel("",JLabel.CENTER);//显示数量标签
	private JTextField inputNumTxtOfManager=new JTextField(4);
	
	private JPanel editOfSale=new JPanel();//输入数量单价备注
	private JLabel inputNumOfSale=new JLabel("数量");
	private JLabel inputPriceOfSale=new JLabel("单价");
	private JLabel inputNoteOfSale=new JLabel("备注");
	private JTextField inputNumTxtOfSale=new JTextField(4);
	private JTextField inputPriceTxtOfSale=new JTextField(4);
	private JTextField inputNoteTxtOfSale=new JTextField(4);
	private JLabel comfirmOfSale=new JLabel();//进销人员编辑面板的确认按钮
	private JPanel showOfStock=new JPanel();//显示已选
	
	private CommodityVO commodity;//对应的VO
	private String note="";//对应的备注
	private JPManagerCom JPmanagerCom;//引用
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
		jlname=new JLabel("<html>"+name+"</html>",JLabel.CENTER);
		jlname.setFont(new Font("宋体",Font.BOLD,11));
		jlname.setBounds(0, 60, 90, 15);
		jlname.setForeground(Color.white);
		
		jlType=new JLabel(ID,JLabel.CENTER);
		jlType.setBounds(0, 75, 90, 10);
		jlType.setForeground(Color.white);
		
		jlnum=new JLabel("num:"+String.valueOf(num),JLabel.CENTER);
		jlnum.setBounds(0, 85, 90, 10);
		jlnum.setForeground(Color.white);
		
	
		editOfManager.setBounds(0, 0, 90, 95);
		editOfManager.setLayout(null);
		editOfManager.setOpaque(false);
		//输入数量面板的背景
		JLabel bgOfInputNum=new JLabel();
		bgOfInputNum.setIcon(new ImageIcon("src/image/commodity/inputNum.png") );
		bgOfInputNum.setBounds(0, 0, 90, 95);
		//输入数量面板的文本框
		inputNumTxtOfManager.setBounds(20,37, 50, 20);
		inputNumTxtOfManager.setOpaque(false);//文本框透明
		inputNumTxtOfManager.setForeground(Color.white);//前景色
		//输入数量面板的确认按钮
		JLabel comfirmOfManager=new JLabel();
		comfirmOfManager.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		comfirmOfManager.setBounds(33, 60, 24, 24);
		comfirmOfManager.addMouseListener(new MouseListenerOfComfirm(1));
		
		editOfManager.add(inputNumTxtOfManager,0);
		editOfManager.add(comfirmOfManager,1);
		editOfManager.add(bgOfInputNum,2);
		editOfManager.setVisible(false);

		showOfManager.setBounds(0, 0, 90, 95);
		showOfManager.setLayout(null);
		showOfManager.setOpaque(false);
		//背景
		JLabel bgOfNumjp=new JLabel();
		bgOfNumjp.setIcon(new ImageIcon("src/image/commodity/purAndSale.png") );
		bgOfNumjp.setBounds(0, 0, 90, 95);
		
		showNumOfManager.setFont(new Font("黑体",Font.BOLD,30));
		showNumOfManager.setBounds(25,30,40,30);
		showNumOfManager.setForeground(Color.white);
		
		showOfManager.add(showNumOfManager,0);
		showOfManager.add(bgOfNumjp,1);
		showOfManager.setVisible(false);
		
		//进销人员的编辑面板
		editOfSale.setBounds(0, 0, 90, 95);
		editOfSale.setLayout(null);
		editOfSale.setOpaque(false);
		//背景
		JLabel bgOfeditOfSale=new JLabel();
		bgOfeditOfSale.setIcon(new ImageIcon("src/image/commodity/purAndSale.png") );
		bgOfeditOfSale.setBounds(0, 0, 90, 95);
		//设置标签字体
		inputNumOfSale.setFont(new Font("宋体",Font.BOLD,14));
		inputPriceOfSale.setFont(new Font("宋体",Font.BOLD,14));
		inputNoteOfSale.setFont(new Font("宋体",Font.BOLD,14));
		//设置字体颜色
		inputNumOfSale.setForeground(Color.white);
		inputPriceOfSale.setForeground(Color.white);
		inputNoteOfSale.setForeground(Color.white);
		//设置标签大小位置
		inputNumOfSale.setBounds(5, 10, 30, 15);
		inputPriceOfSale.setBounds(5, 30, 30, 15);
		inputNoteOfSale.setBounds(5, 50, 30, 15);
		//文本框
		inputNumTxtOfSale.setBounds(40,10,40, 15);
		inputNumTxtOfSale.setOpaque(false);//文本框透明
		inputNumTxtOfSale.setForeground(Color.white);//前景色
		
		inputPriceTxtOfSale.setBounds(40,30,40, 15);
		inputPriceTxtOfSale.setOpaque(false);//文本框透明
		inputPriceTxtOfSale.setForeground(Color.white);//前景色
		
		inputNoteTxtOfSale.setBounds(40,50,40,15);
		inputNoteTxtOfSale.setOpaque(false);//文本框透明
		inputNoteTxtOfSale.setForeground(Color.white);//前景色
	
		comfirmOfSale.setIcon(new ImageIcon("src/image/ChooseCom/confirm.png") );
		comfirmOfSale.setBounds(33,68, 24, 24);
		comfirmOfSale.addMouseListener(new MouseListenerOfComfirm(2));
		
		editOfSale.add(inputNumOfSale,0);
		editOfSale.add(inputPriceOfSale,1);
		editOfSale.add(inputNoteOfSale,2);
		editOfSale.add(inputNumTxtOfSale,3);
		editOfSale.add(inputPriceTxtOfSale,4);
		editOfSale.add(inputNoteTxtOfSale,5);
		editOfSale.add(comfirmOfSale,6);
		editOfSale.add(bgOfeditOfSale,7);
		editOfSale.setVisible(false);
		
		//库管人员的编辑面板
		showOfStock.setBounds(0, 0, 90, 95);
		showOfStock.setLayout(null);
		showOfStock.setOpaque(false);
		//背景
		JLabel bgOfshowOfStock=new JLabel();
		bgOfshowOfStock.setIcon(new ImageIcon("src/image/commodity/purAndSale.png") );
		bgOfshowOfStock.setBounds(0, 0, 90, 95);
		//已选标记
		JLabel Chosen=new JLabel("已选",JLabel.CENTER);
		Chosen.setFont(new Font("黑体",Font.BOLD,20));
		Chosen.setForeground(Color.white);
		Chosen.setBounds(20,25,50,40);
		
		showOfStock.add(Chosen,0);
		showOfStock.add(bgOfshowOfStock,1);
		showOfStock.setVisible(false);
		
		this.add(editOfManager,0);
		this.add(showOfManager,1);
		this.add(showOfStock,2);
		this.add(editOfSale,3);
		this.add(bg,4);
		this.add(jlname,5);
		this.add(jlType,6);
		this.add(jlnum,7);
		
		this.addMouseListener(this);
		
	}
	public JPcommodity(CommodityVO com){
		this(com.getName(),com.getModel(),com.getNumber());
		commodity=com;
	}
	/*修改商品*/
	public void change(CommodityVO commodity){
		//修改对应商品VO
		setCommodity(commodity);
		//修改信息显示
		jlname.setText(commodity.getName());
		jlType.setText(commodity.getModel());
		jlnum.setText(String.valueOf(commodity.getNumber()));
	}
	
	public class MouseListenerOfComfirm implements MouseListener{

		private int num;//1、总经理编辑面板  2、进销人员编辑面板
		public MouseListenerOfComfirm(int N){
			num=N;
		}
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		
		
		}

		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			switch(num){
			case 1:
				if(!inputNumTxtOfManager.getText().equals("")){
					//隐藏输入面板
					editOfManager.setVisible(false);
					//标记选中
					chosen=true;
					//显示数字在标签上
					showNumOfManager.setText(inputNumTxtOfManager.getText());
					//改变VO对象的数量信息
					commodity.setNumber(Integer.parseInt(inputNumTxtOfManager.getText()));
					//显示选中面板
					showOfManager.setVisible(true);
					//清空输入框
					inputNumTxtOfManager.setText("");
				}
				else{
					JPmanagerCom.getFrame().getWarning().showWarning("请输入数量");
				}
				break;
			case 2:
				if(!inputNumTxtOfSale.getText().equals("")
						&&!inputPriceTxtOfSale.getText().equals("")
						&&!inputNoteTxtOfSale.getText().equals("")){
					//设置不可编辑
					inputNumTxtOfSale.setEditable(false);
					inputPriceTxtOfSale.setEditable(false);
					inputNoteTxtOfSale.setEditable(false);
					//改变VO对象信息
					commodity.setNumber(Integer.parseInt(inputNumTxtOfSale.getText()));
					
					if(JPmanagerCom.getFrame().getSale().getManageBills2().getStyle()==BillStyle.PurSheet
					   ||JPmanagerCom.getFrame().getSale().getManageBills2().getStyle()==BillStyle.PurBackSheet){
						commodity.setIn(Double.parseDouble(inputPriceTxtOfSale.getText()));
					}
					else{
						commodity.setOut(Double.parseDouble(inputPriceTxtOfSale.getText()));
					}
					//改变备注信息
					note=inputNoteTxtOfSale.getText();
					
					//隐藏确认按钮
					comfirmOfSale.setVisible(false);
					//标记选中
					chosen=true;
				}
				else{
					JPmanagerCom.getFrame().getWarning().showWarning("请输入完整信息");
				}
				break;
			}
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
		switch(JPmanagerCom.getRole()){
		case MANAGER:
			if(chosen==false){
				editOfManager.setVisible(true);
			}
			else{
				showOfManager.setVisible(false);
				chosen=false;
			}
			break;
		case PURCHASE_SALE_STAFF:
			if(chosen==false){
				//清空内容
				inputNumTxtOfSale.setText("");
				inputPriceTxtOfSale.setText("");
				inputNoteTxtOfSale.setText("");
				//恢复编辑
				inputNumTxtOfSale.setEditable(true);
				inputPriceTxtOfSale.setEditable(true);
				inputNoteTxtOfSale.setEditable(true);
				//显示确认按钮
				comfirmOfSale.setVisible(true);
				//显示编辑面板
				editOfSale.setVisible(true);
			}
			else{
				editOfSale.setVisible(false);
				chosen=false;
			}
			break;
		case STOCK_STAFF:
			if(chosen==false){
				showOfStock.setVisible(true);
				chosen=true;
			}
			else{
				showOfStock.setVisible(false);
				chosen=false;
			}
			break;
		}
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		String s="";
		String in=String.valueOf(commodity.getIn());
		String out=String.valueOf(commodity.getOut());
		//String lastin=String.valueOf(commodity.getLastin());deleted by lhw
		//String lastout=String.valueOf(commodity.getLastout());deleted by lhw
		//below are added by lhw
		String lastin,lastout;
		double li=commodity.getLastin(),lo=commodity.getLastout();
		if(li==-1)
			lastin="空";
		else
			lastin=String.valueOf(li);
		if(lo==-1)
			lastout="空";
		else
			lastout=String.valueOf(lo);
		s="进价："+in+" 售价："+out+" 最近进价："+lastin+" 最近售价："+lastout;
		JPmanagerCom.showDetail(s);
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JPmanagerCom.showDetail("");
	}
	public JPManagerCom getJPmanagerCom() {
		return JPmanagerCom;
	}
	public void setJPmanagerCom(JPManagerCom jPmanagerCom) {
		JPmanagerCom = jPmanagerCom;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}


}
