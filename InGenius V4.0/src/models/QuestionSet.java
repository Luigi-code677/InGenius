package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.JsonSyntaxException;

import per.PlayerReader;
import per.QuestionReader;

public class QuestionSet {
	
	private ArrayList<Question> questionSet;
	private QuestionType type;
	private int correctAnswers;
	private double score;
	private Manager manager;
	
	public static String QUESTIONS_PATH = "data/finalquestions.json";
	public static String PLAYERS_PATH = "data/finalplayers.json";
	
	
	public QuestionSet(QuestionType questionType) throws JsonSyntaxException, IOException {
		this.type = questionType;
		this.manager = new Manager(new QuestionReader(QUESTIONS_PATH).loadQuestionsData(), new PlayerReader(PLAYERS_PATH).loadPlayersData());
		this.questionSet = new ArrayList<Question>();
		score = 0;
		correctAnswers = 0;
		asign();
	}
	
	public void asign() {
		switch (type) {
		case HISTORIA:
			questionSet = manager.getHistoryQuestions();
			break;
		case CIENCIA:
			questionSet = manager.getScienceQuestions();
			break;
		case GEOGRAFIA:
			questionSet = manager.getGeographyQuestions();
			break;
		case MATEMATICA:
			questionSet = manager.getMathQuestions();
			break;
		case DEPORTE:
			questionSet = manager.getSportQuestions();
			break;
		case CINE:
			questionSet = manager.getCinemaQuestions();
			break;
		default:
			break;
		}	
		Collections.shuffle(questionSet);
	}


	public ArrayList<Question> getQuestionSet() {
		return questionSet;
	}


	public double getScore() {
		return score;
	}
	
	public void sumScore() {
		score += (type.getPoints() * 1000);
	}
	
	public int getCorrectAnswers(){
		return correctAnswers;
	}
	
	private int getCorrectQuestion(Question question) {
		int correctQuestionsIndex = 0;
		for (int j = 0; j < question.getAnswers().size(); j++) {
			if (question.getAnswers().get(j).isCorrect()) {
				correctQuestionsIndex = j;
			}
		}
		return correctQuestionsIndex;
	}
	
	private int getSelectedResponse(ArrayList<Boolean>answers) {
		int selectedResponseIndex = 0;
		for (int i = 0; i < answers.size(); i++) {
			if (answers.get(i)) {
				selectedResponseIndex = i;
			}
		}
		return selectedResponseIndex;
	}
	
	public void getCorrectQuestions(ArrayList<Boolean>answers, Question question) {
		if (getCorrectQuestion(question) == getSelectedResponse(answers)) {
			correctAnswers++;
			sumScore();
		}	
	}
	
	public int getTotalQuestions() {
		return questionSet.size();
	}
	
	public QuestionType getType() {
		return type;
	}
	
	public void restartScore() {
		score = 0;
	}
	
	public void restartCount() {
		correctAnswers = 0;
	}
	

}
