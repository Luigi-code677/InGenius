package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;

public class CategoryPanel extends JPanel {
	
	private JLabel quest;
	private MenuButton back;
	private MenuButton history;
	private MenuButton science;
	private MenuButton geography;
	private MenuButton math;
	private MenuButton sports;
	private MenuButton cinema;
	
	public CategoryPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(4,2));
		setBackground(Color.BLACK);
		Font font = new Font("Plain", Font.PLAIN, 15);
		quest = new JLabel("Escoja la categoria de su preferencia :");
		quest.setForeground(Color.ORANGE);
		quest.setFont(font);
		
		back = new MenuButton("Atras", Color.BLACK, Color.ORANGE);
		back.setActionCommand(Constants.BACK_CATEGORY_CHOICE);
		back.addActionListener(listener);
		
		history = new MenuButton("Historia", Color.RED, Color.WHITE);
		history.setActionCommand(Constants.HISTORY_COMMAND);
		history.addActionListener(listener);
		
		science = new MenuButton("Ciencia", Color.GREEN, Color.WHITE);
		science.setActionCommand(Constants.SCIENCE_COMMAND);
		science.addActionListener(listener);
		
		geography = new MenuButton("Geografia", Color.BLUE, Color.GREEN);
		geography.setActionCommand(Constants.GEOGRAPHY_COMMAND);
		geography.addActionListener(listener);
		
		math = new MenuButton("Matematica", Color.WHITE, Color.BLACK);
		math.setActionCommand(Constants.MATH_COMMAND);
		math.addActionListener(listener);
		
		sports = new MenuButton("Deporte", Color.YELLOW, Color.BLACK);
		sports.setActionCommand(Constants.SPORT_COMMAND);
		sports.addActionListener(listener);
		
		cinema = new MenuButton("Cine", Color.ORANGE, Color.BLACK);
		cinema.setActionCommand(Constants.CINEMA_COMMAND);
		cinema.addActionListener(listener);
		
		add(quest);
		add(back);
		add(history);
		add(science);
		add(geography);
		add(math);
		add(sports);
		add(cinema);
		
	}

}
