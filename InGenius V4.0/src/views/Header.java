package views;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {
	
	private JLabel title;
	
	public Header() {
		initComponents();
	}
	
	private void initComponents() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		title = new JLabel("");
		title.setIcon(new ImageIcon("data/logo.png"));
		add(title);
	}

}
