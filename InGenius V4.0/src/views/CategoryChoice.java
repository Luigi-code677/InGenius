package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CategoryChoice extends JDialog {
	
	private Header header;
	private CategoryPanel categoryPanel;
	
	public CategoryChoice(ActionListener listener, JFrame frame) {
		this.setSize(700,1000);
		this.setLocationRelativeTo(frame);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new BorderLayout());
		header = new Header();
		categoryPanel = new CategoryPanel(listener);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(categoryPanel, BorderLayout.CENTER);
	}
	
}
