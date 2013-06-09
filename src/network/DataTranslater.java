package network;

import gameContent.Enemy;
import gameContent.Definitions;
import gameContent.EnemyOne;
import gameContent.EnemyTwo;

import java.util.HashMap;




public class DataTranslater {

	public DataTranslater() {}

	
	//getter-Methode für die Logic-Komponente für die GameLogicData
	public HashMap<Integer, Byte> translateData(byte[] data) {
		HashMap<Integer, Byte> gameLogicData = translateToMap(data);
		return gameLogicData;
	}
	
	
	//übersetzt das Byte-Array in eine Map für die GameLogic
	private HashMap<Integer, Byte> translateToMap(byte[] data) {
		HashMap<Integer, Byte> gameLogicData = new HashMap<Integer, Byte>();
		for(int i = 0; i < data.length; i++){
			if(getEnemyID(i, data[i]) != 666){
				gameLogicData.put(getEnemyID(i, data[i]), data[i]);	
			}			
		}	
		return gameLogicData;	
	}
	

	//erstellt anhand der Position des Bytes im Array den entsprechenden Enemy
	private int getEnemyID (Integer counter, Byte count) {
		if (count != 0) {
			switch (counter) {
			case Definitions.EnemyOneID: 			
				return Definitions.EnemyOneID;
			case Definitions.EnemyTwoID:
				return Definitions.EnemyTwoID;
			default:
				return 666;
			}
		} else {return 666;}
	}
}
