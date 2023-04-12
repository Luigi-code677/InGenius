package views;

import java.awt.Color;

import javax.swing.JTextField;

public class RegisterPlayerTextField extends JTextField {
	
	public RegisterPlayerTextField(String text, int size) {
		super(text, size);
		setBackground(Color.BLACK);
		setForeground(Color.ORANGE);
		setEnabled(false);
	}

}
