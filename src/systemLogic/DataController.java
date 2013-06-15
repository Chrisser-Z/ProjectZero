package systemLogic;

import gameContent.Definitions;
import gameContent.Enemy;
import gameContent.EnemyOne;
import gameContent.EnemyTwo;


import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map.Entry;

import network.Receiver;



public class DataController extends Thread {

	
	private Receiver receiver;
	private GameWindow gameWindow;
	private HashMap<Integer, Byte> newData = new HashMap<Integer, Byte>();
	private GameLogic gameLogic;

	
	public DataController() {
		receiver = new Receiver();
		start();
	}
	


	public void run() {

		while (true) {
			try {
				newData = receiver.getData();
				
				if (newData != null){
					System.out.println("Trololol this is newData: " + newData);
					gameLogic = new GameLogic(newData);
					gameWindow = new GameWindow(gameLogic);
				 } else {}

				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	



}
