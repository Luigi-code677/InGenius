package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import constants.Constants;

public class TableResults extends JDialog {
	
	private Header header;
	private TableResultsPanel table;
	private MenuButton button;
	
	public TableResults(ActionListener listener, String [][] newData, JFrame frame) {
		this.setSize(700,1000);
		this.setLocationRelativeTo(frame);
		initComponents(listener, newData);

	}
	
	private void initComponents(ActionListener listener, String [][] newData) {
		setLayout(new BorderLayout());
		header = new Header();
		table = new TableResultsPanel(listener, newData);
		button = new MenuButton("Atras", Color.GRAY, Color.ORANGE);
		button.addActionListener(listener);
		button.setActionCommand(Constants.BACK_TABLE_CHOICE);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(table, BorderLayout.CENTER);
		this.getContentPane().add(button, BorderLayout.SOUTH);
		
	}
	

}
