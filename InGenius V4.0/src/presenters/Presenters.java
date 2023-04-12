package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.JsonSyntaxException;

import constants.Constants;
import models.Answer;
import models.Manager;
import models.Question;
import models.QuestionSet;
import models.QuestionType;
import per.PlayerReader;
import per.QuestionReader;
import views.MainMenu;
import views.TableResults;

public class Presenters implements ActionListener {

	private MainMenu menu;
	private Manager manager;
	private QuestionSet newQuestionSet;
	private QuestionType type;
	private int index;
	private int aux;
	private QuestionReader q;
	private PlayerReader p;
	private TableResults table;

	public static String QUESTIONS_PATH = "data/finalquestions.json";
	public static String PLAYERS_PATH = "data/finalplayers.json";

	public Presenters() throws JsonSyntaxException, IOException {
		q = new QuestionReader(QUESTIONS_PATH);
		p = new PlayerReader(PLAYERS_PATH);
		manager = new Manager(q.loadQuestionsData(), p.loadPlayersData());
		menu = new MainMenu(this, manager.turnPlayersIntoMatrix());
		index = 0;
		aux = 1;
		newQuestionSet = null;
	}

	public static void main(String[] args) throws JsonSyntaxException, IOException {
		new Presenters();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case Constants.PLAY_COMMAND:
			menu.openCategoryChoice();
			break;
		case Constants.CONSULT_COMMAND:
			menu.openFilterDialog();
			break;
		case Constants.REGISTER_COMMAND:
			menu.openAddNewQuestion();
			break;
		case Constants.EXIT_COMMAND:
			menu.setVisible(false);
			System.exit(0);
			break;
		case Constants.HISTORY_COMMAND:
			setCategory(QuestionType.HISTORIA);
			break;
		case Constants.SCIENCE_COMMAND:
			setCategory(QuestionType.CIENCIA);
			break;
		case Constants.GEOGRAPHY_COMMAND:
			setCategory(QuestionType.GEOGRAFIA);
			break;
		case Constants.MATH_COMMAND:
			setCategory(QuestionType.MATEMATICA);
			break;
		case Constants.SPORT_COMMAND:
			setCategory(QuestionType.DEPORTE);
			break;
		case Constants.CINEMA_COMMAND:
			setCategory(QuestionType.CINE);
			break;
		case Constants.BACK_CATEGORY_CHOICE:
			menu.closeCategoryChoice();
			break;
		case Constants.NEXT_QUESTION_CHOICE:
			nextQuestion();
			break;
		case Constants.SAVE_PLAYER_COMMAND:
			savePlayer();
			break;
		case Constants.BACK_SAVE_QUESTION_CHOICE:
			menu.closeAddNewQuestion();
			break;
		case Constants.SAVE_QUESTION_CHOICE:
			saveQuestion();
			break;
		case Constants.BACK_TABLE_CHOICE:
			table.setVisible(false);
			break;
		case "adelantefiltro":
			table = new TableResults(this, manager.turnPlayersIntoMatrixWithFilter(QuestionType.valueOf(menu.getFilter())), menu);
			table.setVisible(true);
			break;
		default:
			break;
		}

	}

	public void registerNewQuestion() {
		ArrayList<Answer> answers = new ArrayList<>();
		answers.add(new Answer(menu.getNewAnswer1(), false));
		answers.add(new Answer(menu.getNewAnswer2(), false));
		answers.add(new Answer(menu.getNewAnswer3(), false));
		answers.add(new Answer(menu.getNewAnswer4(), false));
		int positionCorrectAnswer = menu.getCorrectAnswerSelectedPosition();
		answers.get(positionCorrectAnswer).setCorrect(true);
		QuestionType category = QuestionType.valueOf(menu.getCategory());
		manager.addQuestions(new Question(menu.getNewStatement(), answers, category));
	}

	public void setResultScreen(QuestionSet questionSet) {
		menu.setCorrectAnswers(questionSet.getCorrectAnswers() + "", questionSet.getTotalQuestions() + "");
		menu.setScore(questionSet.getScore() + "");
	}

	public void setNewQuestionToFrame(QuestionSet questionSet, int index) {
		questionSet.getQuestionSet().get(index).shuffle();
		menu.setStatement(questionSet.getQuestionSet().get(index).getStatement());
		menu.setFirstAnswer(questionSet.getQuestionSet().get(index).getAnswers().get(0).getAnswerText());
		menu.setSecondAnswer(questionSet.getQuestionSet().get(index).getAnswers().get(1).getAnswerText());
		menu.setThirdAnswer(questionSet.getQuestionSet().get(index).getAnswers().get(2).getAnswerText());
		menu.setFourthAnswer(questionSet.getQuestionSet().get(index).getAnswers().get(3).getAnswerText());
		menu.openQuestionDialog();
	}

	public void obtainSingleQuestionResults(QuestionSet questionSet, int index) {
		questionSet.getCorrectQuestions(menu.getAnswers(), questionSet.getQuestionSet().get(index));
		menu.closeQuestionDialog();

	}

	public void setQuestionType(QuestionType questionType) {
		type = questionType;
	}

	public QuestionType getQuestionType() {
		return type;
	}

	public void setCategory(QuestionType type) {
		try {
			newQuestionSet = manager.getNewQuestionSet(type);
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		setQuestionType(type);
		setNewQuestionToFrame(newQuestionSet, index);
		menu.closeCategoryChoice();

	}

	public void nextQuestion() {
		if (index == newQuestionSet.getQuestionSet().size() - 1) {
			obtainSingleQuestionResults(newQuestionSet, index++);
			setResultScreen(newQuestionSet);
			menu.openPlayerRegister();
			menu.closeQuestionDialog();
			index = 0;
			aux = 1;
		} else {
			obtainSingleQuestionResults(newQuestionSet, index++);
			setNewQuestionToFrame(newQuestionSet, aux++);
		}
	}

	public void savePlayer() {
		manager.addPlayers(newQuestionSet, menu.getNewName());
		newQuestionSet.restartCount();
		newQuestionSet.restartScore();
		menu.closePlayerRegister();
		newQuestionSet = null;
		try {
			p.savePlayersData(manager.players());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,
				"Nuevo jugador registrado con exito. Para ver la informacion actualizada en la tabla, es necesario reiniciar la aplicacion.");
	}

	public void saveQuestion() {
		registerNewQuestion();
		menu.closeAddNewQuestion();
		try {
			q.saveQuestionData(manager.getQuestions());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,
				"Pregunta registrada con exito. Para ver la informacion actualizada, es necesario reiniciar la aplicacion.");
	}

}
