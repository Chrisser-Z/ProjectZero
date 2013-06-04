package main;

import network.DataIN;
import gui.Controller;

public class Main {

	static Controller controller = new Controller();
	
	
	public static void main(String[] args) {
		DataIN dataIn = new DataIN();
		dataIn.start();
		controller.showGui();
		
	}

}
