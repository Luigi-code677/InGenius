package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Difficult extends JDialog {
	
	private Header header;
	private DifficultPanel difficultPanel;
	
	public Difficult() {
		initComponents();
		this.setSize(700,1000);
		this.setVisible(true);
	}
	
	private void initComponents() {
		this.setLayout(new BorderLayout());
		header = new Header();
		difficultPanel = new DifficultPanel();
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(difficultPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new Difficult();
	}

}
