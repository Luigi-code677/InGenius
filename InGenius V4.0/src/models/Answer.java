package models;

public class Answer {
	
	private String answerText;
	private boolean isCorrect;
	
	public Answer(String answerText, boolean isCorrect) {
		super();
		this.answerText = answerText;
		this.isCorrect = isCorrect;
	}

	/**
	 * @return the answerText
	 */
	public String getAnswerText() {
		return answerText;
	}

	/**
	 * @param answerText the answerText to set
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	/**
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
	

}
