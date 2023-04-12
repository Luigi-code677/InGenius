package views;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import constants.Constants;

import java.awt.Color;
import java.awt.Font;

public class QuestionPanel extends JPanel {
	
	private JLabel statement;
	private MenuButton ahead;
	private QuestionOption ans1;
	private QuestionOption ans2;
	private QuestionOption ans3;
	private QuestionOption ans4;
	
	private ArrayList<Boolean> questions;
	
	
	public QuestionPanel(ActionListener listener) {
		initComponents(listener);
		questions = new ArrayList<>();
	}
	
	public void initComponents(ActionListener listener) {
		setLayout(new GridLayout(6,1));
		setBackground(Color.BLACK);
		statement = new JLabel("Aca va la pregunta");
		statement.setForeground(Color.WHITE);
		Font font = new Font("Plain", Font.PLAIN, 15);
		statement.setFont(font);
		ahead = new MenuButton("SIGUENTE", Color.ORANGE, Color.BLACK);
		ahead.setActionCommand(Constants.NEXT_QUESTION_CHOICE);
		ahead.addActionListener(listener);
		ans1 = new QuestionOption("");
		ans2 = new QuestionOption("");
		ans3 = new QuestionOption("");
		ans4 = new QuestionOption("");
		ButtonGroup group = new ButtonGroup();
		group.add(ans1);
		group.add(ans2);
		group.add(ans3);
		group.add(ans4);
		
		add(statement);
		add(ans1);
		add(ans2);
		add(ans3);
		add(ans4);
		add(ahead);
	}
	
	public ArrayList<Boolean>getAnswers(){
		questions = new ArrayList<>();
		questions.add(ans1.isSelected());
		questions.add(ans2.isSelected());
		questions.add(ans3.isSelected());
		questions.add(ans4.isSelected());
		return questions;
	}
	
	public void setStatement(String questionStatement) {
		statement.setText(questionStatement);
	}
	
	public void setFirstAnswer(String firstAnswer) {
		ans1.setText(firstAnswer);
	}
	
	public void setSecondAnswer(String secondAnswer) {
		ans2.setText(secondAnswer);
	}
	
	public void setThirdAnswer(String thirdAnswer) {
		ans3.setText(thirdAnswer);
	}
	
	public void setFourthAnswer(String fourthAnswer) {
		ans4.setText(fourthAnswer);
	}
	

}
