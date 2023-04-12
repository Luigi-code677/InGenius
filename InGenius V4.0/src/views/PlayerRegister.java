package views;

import java.awt.BorderLayout;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class PlayerRegister extends JDialog {
	
	private Header header;
	private PlayerRegisterPanel register;
	
	public PlayerRegister(ActionListener listener, JFrame frame) {
		this.setSize(700,500);
		this.setLocationRelativeTo(frame);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		header = new Header();
		register = new PlayerRegisterPanel(listener);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(register, BorderLayout.CENTER);
	}
	
	public void setCorrectAnswers(String correctAnswers, String totalAnswers) {
		register.setCorrectAnswers(correctAnswers, totalAnswers);
	}
	
	public void setScore(String newScore) {
		register.setScore(newScore);
	}
	
	public String getNewName() {
		return register.getNewName();
	}
	

}
