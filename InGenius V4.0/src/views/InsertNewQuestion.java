package views;

import java.awt.GridLayout;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class InsertNewQuestion extends JDialog {
	
	private Header header;
	private InsertNewQuestionPanel newQuestion;
	private InsertNewQuestionOptionsPanel newQuestionOptions;
	
	public InsertNewQuestion(ActionListener listener, JFrame frame) {
		this.setSize(700,700);
		this.setLocationRelativeTo(frame);
		initComponents(listener);
	
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(3,1));
		header = new Header();
		newQuestion = new InsertNewQuestionPanel();
		newQuestionOptions = new InsertNewQuestionOptionsPanel(listener);
		
		this.getContentPane().add(header);
		this.getContentPane().add(newQuestion);
		this.getContentPane().add(newQuestionOptions);
	}
	
	public String getCorrectAnswer() {
		return newQuestionOptions.getCorrectAnswer();
	}
	
	public String getCategory() {
		return newQuestionOptions.getCategory();
	}
	
	public String getNewStatement() {
		return newQuestion.getNewStatement();
	}
	
	public String getNewAnswer1() {
		return newQuestion.getNewAnswer1();
	}
	
	public String getNewAnswer2() {
		return newQuestion.getNewAnswer2();
	}
	
	public String getNewAnswer3() {
		return newQuestion.getNewAnswer3();
	}
	
	public String getNewAnswer4() {
		return newQuestion.getNewAnswer4();
	}
	
	public int getCorrectAnswerSelectedPosition() {
		return newQuestionOptions.getCorrectAnswerPosition();
	}

}
