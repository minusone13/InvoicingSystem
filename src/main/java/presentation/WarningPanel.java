package presentation;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

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

	private void initial () {
		this.setOpaque(false);
		this.setLayout(null);
		this.add(picture,0);
		this.add(warningWord,1);
		picture.setBounds(0,0,24,24);
		warningWord.setBounds(30,-3,220,30);
		warningWord.setFont(new Font("宋体",Font.BOLD,16));
		warningWord.setForeground(Color.white);
		this.setBounds(405,530,250,50);
	}
}
