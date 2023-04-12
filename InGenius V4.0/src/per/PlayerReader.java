package per;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import models.Player;


public class PlayerReader {
	
	private String path;
	private Gson gson;
	private ArrayList<Player> players;
	
	public PlayerReader(String path) throws JsonSyntaxException, IOException {
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
	
	public ArrayList<Player> loadPlayersData() throws JsonSyntaxException, IOException{
		Type listType = new TypeToken<ArrayList<Player>>(){}.getType();
		players = gson.fromJson(getJsonToText(), listType);
		return players;
	}
	
	
	public void savePlayersData(ArrayList<Player>newPlayers) throws FileNotFoundException {
		String json = gson.toJson(newPlayers);
		PrintWriter newWriter = new PrintWriter(path);
		newWriter.write(json);
		newWriter.close();
	}


}
