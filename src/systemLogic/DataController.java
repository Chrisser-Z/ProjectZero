package systemLogic;

import gameContent.Definitions;
import gameContent.Enemy;
import gameContent.EnemyOne;
import gameContent.EnemyTwo;


import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map.Entry;

import network.Receiver;



public class DataController extends Thread {

	
	private Receiver receiver;
	private GameWindow gameWindow;
	private HashMap<Integer, Byte> newData = new HashMap<Integer, Byte>();

	
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
					gameWindow = new GameWindow(createEnemyList());
				 } else {}

				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private LinkedList<Enemy> createEnemyList() {
		LinkedList<Enemy> list = new LinkedList<Enemy>();
		for (Entry<Integer, Byte> entry : newData.entrySet()){
			list.add(createEnemy(entry.getKey(), entry.getValue()));
		}
		System.out.println(list);
		return list;		
	}
	
	private Enemy createEnemy(Integer i, Byte b) {
		Enemy newEnemy = null;
		System.out.println("EnemyID: " + i);
		switch(i){
			case Definitions.EnemyOneID:
				newEnemy = new EnemyOne();
				break;
			case Definitions.EnemyTwoID:
				newEnemy = new EnemyTwo();
				break;
		}	
		return newEnemy;		
	}



}
