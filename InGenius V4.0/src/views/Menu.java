package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import constants.Constants;

import java.awt.Color;

public class Menu extends JPanel{
	
	private MenuButton play;
	private MenuButton results;
	private MenuButton registerQuestions;
	private MenuButton exit;
	
	public Menu(ActionListener listener) {
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		this.setLayout(new GridLayout(2,2));
		play = new MenuButton("Jugar", Color.ORANGE, Color.BLACK);
		play.setActionCommand(Constants.PLAY_COMMAND);
		play.addActionListener(listener);
		
		results = new MenuButton("Consultar Resultados", Color.ORANGE, Color.BLACK);
		results.setActionCommand(Constants.CONSULT_COMMAND);
		results.addActionListener(listener);
		
		registerQuestions = new MenuButton("Registrar nuevas preguntas", Color.ORANGE, Color.BLACK);
		registerQuestions.setActionCommand(Constants.REGISTER_COMMAND);
		registerQuestions.addActionListener(listener);
		
		exit = new MenuButton("Salir", Color.ORANGE, Color.BLACK);
		exit.setActionCommand(Constants.EXIT_COMMAND);
		exit.addActionListener(listener);
		
		add(play);
		add(results);
		add(registerQuestions);
		add(exit);
		
	}

}
