package main;

import systemLogic.DataController;
import network.DataIN;
import gui.Controller;

public class Main {

	private static Controller controller = new Controller();
	private static DataController dataController = new DataController();
	
	public static void main(String[] args) {
		controller.showGui();		
		System.out.println("Hello this is dog");
	}

}
