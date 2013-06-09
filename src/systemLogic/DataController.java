package systemLogic;

import gameContent.Enemy;

import java.util.HashMap;
import java.util.Map;

import network.Receiver;



public class DataController extends Thread {

	
	private GameEngine gameEngine;
	private Receiver receiver;
	private HashMap<Integer, Byte> newData = new HashMap<Integer, Byte>();

	
	public DataController() {
		receiver = new Receiver();
		gameEngine = new GameEngine();
		start();
	}

	public void run() {

		while (true) {
			try {
				newData = receiver.getData();
				
				if (newData != null){
					//TODO: Stuff
					System.out.println("Trololol this is newData: " + newData);

				 } else {}

				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}
