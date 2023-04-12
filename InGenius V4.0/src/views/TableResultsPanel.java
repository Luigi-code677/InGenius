package views;

import java.awt.GridLayout;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class TableResultsPanel extends JPanel {
	
	private JTable table;
	private String[][]data;
	
	public TableResultsPanel(ActionListener listener, String [][] newData) {
		initComponents(listener, newData);
	}
	
	private void initComponents(ActionListener listener, String [][] newData) {
		setLayout(new GridLayout(1,1));
		setBackground(Color.ORANGE);
		String [] columns = new String[] {"Jugador","Puntaje","Categoria"};
		data = newData;
		table = new JTable(data, columns);
		table.setBackground(Color.BLACK);
		table.setForeground(Color.ORANGE);
		table.setRowHeight(24);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBackground(Color.BLACK);
		add(scroll);
		
	}
	

}
