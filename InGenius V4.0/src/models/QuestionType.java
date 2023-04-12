package models;

public enum QuestionType {
	HISTORIA(2),CIENCIA(4),GEOGRAFIA(3),MATEMATICA(5),DEPORTE(2),CINE(2);
	
	private double points;
	
	QuestionType(double points) {
		this.points = points;
	}

	/**
	 * @return the points
	 */
	public double getPoints() {
		return points;
	}
	
	

}
