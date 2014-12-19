package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import presentation.saleui.JPmanageBills2.JPanelEdit;

public class WarningPanel extends JPanel{
	private JLabel picture = new JLabel(new ImageIcon("src/image/warn.png"));
	private JLabel warningWord = new JLabel();
	
	
	public WarningPanel() {
		initial ();
	}
	
	public WarningPanel(String text) {
		warningWord.setText(text);
		initial ();
	}
	
	public void setWarningWord(String text) {
		warningWord.setText(text);
		initial ();
	}

	public void showWarning(String text){
		setWarningWord(text);
		Thread t=new Thread(new ThreadOfWarning());
		t.start();
	}
	private void initial () {
		this.setOpaque(false);
		this.setLayout(null);
		this.add(picture,0);
		this.add(warningWord,1);
		picture.setBounds(0,0,24,24);
		warningWord.setBounds(30,-3,720,30);
		warningWord.setFont(new Font("宋体",Font.BOLD,16));
		warningWord.setForeground(Color.white);
		this.setBounds(350,600,750,50);
	}
	public class ThreadOfWarning  implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			int x=350;
			int y=600;
			
			while(y!=530){
				if((y-530)>10){
					y-=10;
				}
				else{
					y=530;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WarningPanel.this.setLocation(x, y);
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(y!=600){
				if((600-y)>10){
					y+=10;
				}
				else{
					y=600;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WarningPanel.this.setLocation(x, y);
			}
		}
		
	}
}
