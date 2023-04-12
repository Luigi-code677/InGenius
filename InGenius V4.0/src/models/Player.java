package models;

public class Player {
	
	private String name;
	private double score;
	private QuestionType type;
	
	
	public Player(String name, double score, QuestionType type) {
		this.name = name;
		this.score = score;
		this.type = type;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the score
	 */
	public double getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(double score) {
		this.score = score;
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
	


}
