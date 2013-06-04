package systemLogic;

import java.util.HashMap;
import java.util.Map;

import network.DataIN;

public class DataController extends Thread {
	
	private DataIN dataIn; 
	private GameEngine gameEngine;
	private DataTranslater dataTranslater;
	
	private Map<String,String> newData = new HashMap<String, String>();
	private Map<String,String> oldData = new HashMap<String, String>();
	
	private byte[] currentRawData = new byte[100];

	
	
	public DataController() {
		start();
		dataIn = new DataIN();
		gameEngine = new GameEngine();
		dataTranslater = new DataTranslater();		
	}
	
	public void run() {
		while (true) {
			try {
				System.out.println("Checking for new Data");
				if(!dataIn.getNewData().equals(currentRawData)){
					translateData(dataIn.getNewData());
					currentRawData = dataIn.getNewData();
				}
				
				if (!newData.equals(oldData)){
					gameEngine.doGame(newData);
					oldData = newData;
				} else {}	
				
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void translateData(byte[]  data) {
		newData = dataTranslater.translateData(data);
	}
	

}
