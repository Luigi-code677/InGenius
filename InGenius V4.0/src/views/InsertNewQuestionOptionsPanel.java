package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;

public class InsertNewQuestionOptionsPanel extends JPanel {
	
	private JLabel advise;
	private JLabel advise2;
	private InsertNewQuestionCombo correctAnswer;
	private InsertNewQuestionCombo category;
	private MenuButton save;
	private MenuButton back;
	
	public InsertNewQuestionOptionsPanel(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		setLayout(new GridLayout(3,2));
		setBackground(Color.ORANGE);
		advise = new JLabel("Respuesta Correcta");
		advise2 = new JLabel("Categoria");
		correctAnswer = new InsertNewQuestionCombo();
		correctAnswer.addItem("Respuesta 1");
		correctAnswer.addItem("Respuesta 2");
		correctAnswer.addItem("Respuesta 3");
		correctAnswer.addItem("Respuesta 4");
	
		
		category = new InsertNewQuestionCombo();
		category.addItem("HISTORIA");
		category.addItem("CIENCIA");
		category.addItem("GEOGRAFIA");
		category.addItem("MATEMATICA");
		category.addItem("DEPORTE");
		category.addItem("CINE");
		
		
		save = new MenuButton("Guardar", Color.BLACK, Color.ORANGE);
		save.setActionCommand(Constants.SAVE_QUESTION_CHOICE);
		save.addActionListener(listener);
		back = new MenuButton("Atras", Color.BLACK, Color.ORANGE);
		back.setActionCommand(Constants.BACK_SAVE_QUESTION_CHOICE);
		back.addActionListener(listener);
		
		add(advise);
		add(correctAnswer);
		add(advise2);
		add(category);
		add(back);
		add(save);
		
		
	}
	
	public String getCorrectAnswer() {
		return correctAnswer.getSelectedItem() + "";
	}
	
	public String getCategory() {
		return category.getSelectedItem() + "";
	}
	
	public int getCorrectAnswerPosition() {
		return correctAnswer.getSelectedIndex();
	}

}
