package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class QuestionOption extends JRadioButton {
	
	public QuestionOption(String text) {
		super(text);
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		setBorderPainted(true);
		Font font = new Font("Plain", Font.PLAIN, 15);
		setFont(font);
	}

}
