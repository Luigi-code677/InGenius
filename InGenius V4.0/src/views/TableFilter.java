package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class TableFilter extends JDialog {
	
	private Header header;
	private TableFilterPanel tableFilter;
	
	public TableFilter(ActionListener listener, JFrame frame) {
		this.setSize(700,600);
		this.setLocationRelativeTo(frame);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new BorderLayout());
		header = new Header();
		tableFilter = new TableFilterPanel(listener);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(tableFilter, BorderLayout.CENTER);
	}
	
	public String getSelectedCategory() {
		return tableFilter.getSelectedCategory();
	}

}
