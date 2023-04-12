package views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MainMenu extends JFrame{
	
	private Header header;
	private Menu menu;
	
	private CategoryChoice categoryChoiceDialog;
	private PlayerRegister playerRegisterDialog;
	private Question questionDialog;
	private TableResults tableDialog;
	private InsertNewQuestion newQuestionDialog;
	private TableFilter tableFilterDialog;
	
	public MainMenu(ActionListener listener, String [][] newData) {
		super("InGenius");
		this.setSize(700,1000);
		initComponents(listener, newData);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener listener, String [][] newData) {
		categoryChoiceDialog = new CategoryChoice(listener, this);
		playerRegisterDialog = new PlayerRegister(listener, this);
		questionDialog = new Question(listener, this);
		tableDialog = new TableResults(listener, newData, this);
		newQuestionDialog = new InsertNewQuestion(listener, this);
		tableFilterDialog = new TableFilter(listener, this);
		
		setLayout(new BorderLayout());
		header = new Header();
		menu = new Menu(listener);
		this.getContentPane().add(header, BorderLayout.NORTH);
		this.getContentPane().add(menu, BorderLayout.CENTER);
	}
	
	
	public void openCategoryChoice() {
		categoryChoiceDialog.setVisible(true);
	}
	
	public void closeCategoryChoice() {
		categoryChoiceDialog.setVisible(false);
	}
	
	public void openPlayerRegister() {
		playerRegisterDialog.setVisible(true);
	}
	
	public void closePlayerRegister() {
		playerRegisterDialog.setVisible(false);
	}
	
	public void openQuestionDialog() {
		questionDialog.setVisible(true);
	}
	
	public void closeQuestionDialog() {
		questionDialog.setVisible(false);
	}
	
	public void openTable() {
		tableDialog.setVisible(true);
	}
	
	public void closeTable() {
		tableDialog.setVisible(false);
	}
	
	public void openAddNewQuestion() {
		newQuestionDialog.setVisible(true);
	}
	
	public void closeAddNewQuestion() {
		newQuestionDialog.setVisible(false);
	}
	
	public void setCorrectAnswers(String correctAnswers, String totalAnswers) {
		playerRegisterDialog.setCorrectAnswers(correctAnswers, totalAnswers);
	}
	
	public void setScore(String newScore) {
		playerRegisterDialog.setScore(newScore);
	}
	
	public String getNewName() {
		return playerRegisterDialog.getNewName();
	}
	
	public void setStatement(String questionStatement) {
		questionDialog.setStatement(questionStatement);
	}
	
	public void setFirstAnswer(String firstAnswer) {
		questionDialog.setFirstAnswer(firstAnswer);
	}
	
	public void setSecondAnswer(String secondAnswer) {
		questionDialog.setSecondAnswer(secondAnswer);
	}
	
	public void setThirdAnswer(String thirdAnswer) {
		questionDialog.setThirdAnswer(thirdAnswer);
	}
	
	public void setFourthAnswer(String fourthAnswer) {
		questionDialog.setFourthAnswer(fourthAnswer);
	}
	
/*	public void setData(String [][] newData) {
		tableDialog.setData(newData);
	} */
	
	public String getCorrectAnswer() {
		return newQuestionDialog.getCorrectAnswer();
	}
	
	public String getCategory() {
		return newQuestionDialog.getCategory();
	}
	
	public String getNewStatement() {
		return newQuestionDialog.getNewStatement();
	}
	
	public String getNewAnswer1() {
		return newQuestionDialog.getNewAnswer1();
	}
	
	public String getNewAnswer2() {
		return newQuestionDialog.getNewAnswer2();
	}
	
	public String getNewAnswer3() {
		return newQuestionDialog.getNewAnswer3();
	}
	
	public String getNewAnswer4() {
		return newQuestionDialog.getNewAnswer4();
	}
	
	public ArrayList<Boolean>getAnswers(){
		return questionDialog.getAnswers();
	}
	
	public int getCorrectAnswerSelectedPosition() {
		return newQuestionDialog.getCorrectAnswerSelectedPosition();
	}
	
	public void openFilterDialog() {
		tableFilterDialog.setVisible(true);
	}
	
	public void closeFilterDialog() {
		tableFilterDialog.setVisible(false);
	}
	
	public String getFilter() {
		return tableFilterDialog.getSelectedCategory();
	}


}
