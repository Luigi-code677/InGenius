package models;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	
	private String statement;
	private ArrayList<Answer> answers;
	private QuestionType type;
	
	public Question(String statement, ArrayList<Answer> answers, QuestionType type) {
		this.statement = statement;
		this.answers = answers;
		this.type = type;
	}

	/**
	 * @return the statement
	 */
	public String getStatement() {
		return statement;
	}

	/**
	 * @param statement the statement to set
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**
	 * @return the answers
	 */
	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(ArrayList<Answer>answers) {
		this.answers = answers;
	}

	/**
	 * @return the type
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(QuestionType type) {
		this.type = type;
	}
	
	public void shuffle() {
		Collections.shuffle(answers);
	}
	

	

}
