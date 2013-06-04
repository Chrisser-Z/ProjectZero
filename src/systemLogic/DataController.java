package systemLogic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import network.DataIN;

public class DataController extends Thread {

	private DataIN dataIn;
	private GameEngine gameEngine;
	private DataTranslater dataTranslater;

	private Map<String, String> newData = new HashMap<String, String>();
	private Map<String, String> oldData = new HashMap<String, String>();

	private byte[] currentRawData = null;

	public DataController() {
		dataIn = new DataIN();
		gameEngine = new GameEngine();
		dataTranslater = new DataTranslater();
		start();
		dataIn.start();
	}

	public void run() {

		while (true) {
			currentRawData = dataIn.getNewData();
			
			try {
				if (currentRawData == null || currentRawData == dataIn.getNewData()) {
					System.out.println("Checking for new Data");
					System.out.println(new String(currentRawData));
				} else {
					System.out.println(new String(currentRawData));
				}

				String test = new String(currentRawData);
				System.out.println(test+"gay");
				
				if(test.equals("stop")) {
					System.out.println("penis");
					dataIn.stopThread();
				}
				
				if(new String(currentRawData).equals("start")) {
					dataIn.startThread();
				}
				
				// if(!dataIn.getNewData().equals(currentRawData)){
				// translateData(dataIn.getNewData());
				// currentRawData = dataIn.getNewData();
				// }
				//
				// if (!newData.equals(oldData)){
				// gameEngine.doGame(newData);
				// oldData = newData;
				// } else {}

				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void translateData(byte[] data) {
		newData = dataTranslater.translateData(data);
	}

}
