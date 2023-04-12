package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;

public class TableFilterPanel extends JPanel {
	
	private JLabel text;
	private InsertNewQuestionCombo category;
	private MenuButton button;
	
	public TableFilterPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(3,1));
		this.setBackground(Color.ORANGE);
		text = new JLabel("Seleccione una nueva opcion de filtro (categoria)");
		category = new InsertNewQuestionCombo();
		category.addItem("HISTORIA");
		category.addItem("CIENCIA");
		category.addItem("GEOGRAFIA");
		category.addItem("MATEMATICA");
		category.addItem("DEPORTE");
		category.addItem("CINE");
		button = new MenuButton("ACEPTAR", Color.BLACK, Color.ORANGE);
		button.setActionCommand("adelantefiltro");
		button.addActionListener(listener);
		
		add(text);
		add(category);
		add(button);
	}
	
	public String getSelectedCategory() {
		return category.getSelectedItem() +"";
	}

}
