package views;

import java.awt.GridLayout;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.Constants;

import java.awt.Color;
import java.awt.Font;

public class PlayerRegisterPanel extends JPanel {
	
	private JLabel correctAnswers;
	private RegisterPlayerTextField correct;
	private JLabel statement;
	private RegisterPlayerTextField score;
	private JLabel yourname;
	private JTextField name;
	private MenuButton save;
	
	public PlayerRegisterPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		setLayout(new GridLayout(4,2));
		Font font = new Font("Plain", Font.PLAIN, 15);
		setBackground(Color.ORANGE);
		correctAnswers = new JLabel("Sus respuestas correctas son");
		correctAnswers.setForeground(Color.BLACK);
		correctAnswers.setFont(font);
		correct = new RegisterPlayerTextField("",10);
		statement = new JLabel("Su puntuacion en esta ronda es de: ");
		statement.setForeground(Color.BLACK);
		statement.setFont(font);
		score = new RegisterPlayerTextField("", 10);
		yourname = new JLabel("Por favor introduzca su nombre");
		yourname.setForeground(Color.BLACK);
		yourname.setFont(font);
		name = new JTextField(10);
		name.setBackground(Color.BLACK);
		name.setForeground(Color.ORANGE);
		save = new MenuButton("Salvar", Color.GRAY, Color.ORANGE);
		save.setActionCommand(Constants.SAVE_PLAYER_COMMAND);
		save.addActionListener(listener);
		JLabel x = new JLabel("REGISTRO NUEVO JUGADOR");
		
		add(correctAnswers);
		add(correct);
		add(statement);
		add(score);
		add(yourname);
		add(name);
		add(x);
		add(save);
			
	}
	
	public void setCorrectAnswers(String correctAnswers, String totalAnswers) {
		correct.setText(correctAnswers + "/" + totalAnswers + " ---> Rendimiento: " + calculateAccuracy(correctAnswers, totalAnswers) + "%");
	}
	
	private String calculateAccuracy(String correctAnswers, String totalAnswers) {
		int correct = Integer.parseInt(correctAnswers);
		int total = Integer.parseInt(totalAnswers);
		double accuracy = (correct * 100) / total;
		return accuracy + "";
	}
	
	public void setScore(String newScore) {
		score.setText(newScore);
	}
	
	public String getNewName() {
		return name.getText();
	}

}
