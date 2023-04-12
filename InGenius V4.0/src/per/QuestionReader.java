package per;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import models.Player;
import models.Question;

public class QuestionReader {
	
	private String path;
	private Gson gson;
	private ArrayList<Question> questions;
	
	public QuestionReader(String path) throws JsonSyntaxException, IOException {
		this.path = path;
		gson = new Gson();
	
	}
	
	
	private String getJsonToText() throws IOException {
		String json = "";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null) {
			json += line;
			
		}
		br.close();
		return json;
	}
	
	public ArrayList<Question> loadQuestionsData() throws JsonSyntaxException, IOException{
		Type listType = new TypeToken<ArrayList<Question>>(){}.getType();
		questions = gson.fromJson(getJsonToText(), listType);
		return questions;
	}
	

	public void saveQuestionData(ArrayList<Question>newQuestions) throws FileNotFoundException {
		String json = gson.toJson(newQuestions);
		PrintWriter newWriter = new PrintWriter(path);
		newWriter.write(json);
		newWriter.close();
		
	}

}
