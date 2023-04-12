package views;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

public class DifficultPanel extends JPanel {
	
	private JLabel text;
	private MenuButton easy;
	private MenuButton medium;
	private MenuButton hard;
	
	
	public DifficultPanel() {
		initComponents();
	}
	
	private void initComponents() {
		this.setLayout(new GridLayout(4,1));
		this.setBackground(Color.ORANGE);
		text = new JLabel("Seleccione la dificultad");
		Font font = new Font("Plain", Font.PLAIN, 15);
		text.setFont(font);
		easy = new MenuButton("FACIL", Color.GREEN, Color.WHITE);
		medium = new MenuButton("MEDIO", Color.YELLOW, Color.BLACK);
		hard = new MenuButton("DIFICIL", Color.RED, Color.BLACK);
		
		add(text);
		add(easy);
		add(medium);
		add(hard);
	}

}
