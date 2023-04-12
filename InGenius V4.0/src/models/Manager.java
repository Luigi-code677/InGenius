package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.google.gson.JsonSyntaxException;


public class Manager {
	
	private ArrayList<Question> questions;
	private ArrayList<Question> historyQuestions;
	private ArrayList<Question> scienceQuestions;
	private ArrayList<Question> geographyQuestions;
	private ArrayList<Question> mathQuestions;
	private ArrayList<Question> sportQuestions;
	private ArrayList<Question> cinemaQuestions;
	private ArrayList<Player>players;
	
	
	public Manager(ArrayList<Question>newQuestions, ArrayList<Player>newPlayers){
		questions = newQuestions; 
		historyQuestions = new ArrayList<>();
		scienceQuestions = new ArrayList<>();
		geographyQuestions = new ArrayList<>();
		mathQuestions = new ArrayList<>();
		sportQuestions = new ArrayList<>();
		cinemaQuestions = new ArrayList<>();
		players = newPlayers;
		organizeQuestionPerType();
	}
	
	public void organizeQuestionPerType() {
		for (int i = 0; i < questions.size(); i++) {
			switch (questions.get(i).getType()) {
			case HISTORIA:
				if (!historyQuestions.contains(questions.get(i))) {
					historyQuestions.add(questions.get(i));
				}
				break;
			case CIENCIA:
				if (!scienceQuestions.contains(questions.get(i))) {
					scienceQuestions.add(questions.get(i));
				}
				break;
			case GEOGRAFIA:
				if (!geographyQuestions.contains(questions.get(i))) {
					geographyQuestions.add(questions.get(i));
				}
				break;
			case MATEMATICA:
				if (!mathQuestions.contains(questions.get(i))) {
					mathQuestions.add(questions.get(i));
				}
				break;
			case DEPORTE:
				if (!sportQuestions.contains(questions.get(i))) {
					sportQuestions.add(questions.get(i));
				}
				break;
			case CINE:
				if (!cinemaQuestions.contains(questions.get(i))) {
					cinemaQuestions.add(questions.get(i));
				}
				break;
			default:
				break;
			}
		}
	}
	

	/**
	 * @return the questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	/**
	 * @return the historyQuestions
	 */
	public ArrayList<Question> getHistoryQuestions() {
		return historyQuestions;
	}

	/**
	 * @return the scienceQuestions
	 */
	public ArrayList<Question> getScienceQuestions() {
		return scienceQuestions;
	}

	/**
	 * @return the geographyQuestions
	 */
	public ArrayList<Question> getGeographyQuestions() {
		return geographyQuestions;
	}

	/**
	 * @return the mathQuestions
	 */
	public ArrayList<Question> getMathQuestions() {
		return mathQuestions;
	}

	/**
	 * @return the sportQuestions
	 */
	public ArrayList<Question> getSportQuestions() {
		return sportQuestions;
	}

	/**
	 * @return the cinemaQuestions
	 */
	public ArrayList<Question> getCinemaQuestions() {
		return cinemaQuestions;
	}
	
	
	public QuestionSet getNewQuestionSet(QuestionType type) throws JsonSyntaxException, IOException {
		return new QuestionSet(type);
	}
	
	
	public void addPlayers(QuestionSet set, String name) {
		Player newPlayer = new Player(name,set.getScore(),set.getType());
		players.add(newPlayer);
	}

	
	public String[][] turnPlayersIntoMatrix(){
		players.sort(new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				return (int)arg1.getScore() - (int)arg0.getScore();
			}
		});
		String[][]tableMatrix = new String[players.size()][3];
		for (int i = 0, count = 0; i < tableMatrix.length; i++, count++) {
			tableMatrix[i][0] = players.get(count).getName();
			tableMatrix[i][1] = players.get(count).getScore() + "";
			tableMatrix[i][2] = players.get(count).getType().toString();
		}
		return tableMatrix;
	}
	
	public void addQuestions(Question question) {
		questions.add(question);
	}
	
	public ArrayList<Player> players(){
		return players;
	}
	
	public String[][] turnPlayersIntoMatrixWithFilter(QuestionType type){
		ArrayList<Player> aux = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getType().equals(type)) {
				aux.add(players.get(i));
			}
		}
		aux.sort(new Comparator<Player>() {

			@Override
			public int compare(Player arg0, Player arg1) {
				return (int)arg1.getScore() - (int)arg0.getScore();
			}
		});
		String[][]tableMatrix = new String[aux.size()][3];
		for (int i = 0, count = 0; i < tableMatrix.length; i++, count++) {
			tableMatrix[i][0] = aux.get(count).getName();
			tableMatrix[i][1] = aux.get(count).getScore() + "";
			tableMatrix[i][2] = aux.get(count).getType().toString();
		}
		return tableMatrix;
	}
	
	
	
	

}
