package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertNewQuestionPanel extends JPanel{
	
	private RegisterQuestionOptions statement;
	private RegisterQuestionOptions answer1;
	private RegisterQuestionOptions answer2;
	private RegisterQuestionOptions answer3;
	private RegisterQuestionOptions answer4;


	public InsertNewQuestionPanel() {
		initComponents();
	}
	
	public void initComponents() {
		setLayout(new GridLayout(5,1));
		setBackground(Color.ORANGE);
		statement = new RegisterQuestionOptions("Aca va la pregunta");
		answer1 = new RegisterQuestionOptions("Respuesta 1");
		answer2 = new RegisterQuestionOptions("Respuesta 2");
		answer3 = new RegisterQuestionOptions("Respuesta 3");
		answer4 = new RegisterQuestionOptions("Respuesta 4");

		add(statement);
		add(answer1);
		add(answer2);
		add(answer3);
		add(answer4);


	}
	
	public String getNewStatement() {
		return statement.getText();
	}
	
	public String getNewAnswer1() {
		return answer1.getText();
	}
	
	public String getNewAnswer2() {
		return answer2.getText();
	}
	
	public String getNewAnswer3() {
		return answer3.getText();
	}
	
	public String getNewAnswer4() {
		return answer4.getText();
	}

}
