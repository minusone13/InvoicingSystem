package presentation.financialui;

import javax.swing.JPanel;

import entrance.Frame;
import po.Role;
import presentation.commodityui.JPManagerCom;

public class JPaccountOfComs extends JPanel
{
	//商品显示面板
	private JPManagerCom accountOfComs;
	//frame的引用
	private Frame frame;
	public JPaccountOfComs(){
		//面板大小
		this.setSize(905, 370);
		//设置布局
		this.setLayout(null);
		//设置面板透明
		this.setOpaque(false);
		
		accountOfComs=new JPManagerCom();
		accountOfComs.setRole(Role.FINANCIAL_STAFF);
		accountOfComs.getContent().clear();
		accountOfComs.setLocation(0, 0);
		accountOfComs.getComfirm().setVisible(false);
		accountOfComs.getAddIcon().setVisible(false);
		this.add(accountOfComs);
	}
	/*获取frame引用*/
    public void getFrame( Frame f){
    		frame=f;
    }
	public JPManagerCom getAccountOfComs()
	{
		return accountOfComs;
	}
	public void setAccountOfComs(JPManagerCom accountOfComs)
	{
		this.accountOfComs = accountOfComs;
	}
	
}
