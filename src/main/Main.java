package main;

import javax.swing.JButton;

import core.DataIN;
import systemLogic.DataController;
import gameContent.EnemyOne;
import gameContent.EnemyTwo;
import gui.Controller;

public class Main {

	private static Controller controller = new Controller();
	private static DataController dataController = new DataController();
	
	
	public static void main(String[] args) {
		controller.showGui();		
		
	}

}
