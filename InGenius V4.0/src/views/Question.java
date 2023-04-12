package views;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Question extends JDialog {
	
	private Header header;
	private QuestionPanel question;
	
	public Question(ActionListener listener, JFrame frame) {
		this.setSize(1000,1000);
		this.setLocationRelativeTo(frame);
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new BorderLayout());
		header = new Header();
		question = new QuestionPanel(listener);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(question, BorderLayout.CENTER);
	}
	
	public void setStatement(String questionStatement) {
		question.setStatement(questionStatement);
	}
	
	public void setFirstAnswer(String firstAnswer) {
		question.setFirstAnswer(firstAnswer);
	}
	
	public void setSecondAnswer(String secondAnswer) {
		question.setSecondAnswer(secondAnswer);
	}
	
	public void setThirdAnswer(String thirdAnswer) {
		question.setThirdAnswer(thirdAnswer);
	}
	
	public void setFourthAnswer(String fourthAnswer) {
		question.setFourthAnswer(fourthAnswer);
	}
	
	public ArrayList<Boolean>getAnswers(){
		return question.getAnswers();
	}
	
}
