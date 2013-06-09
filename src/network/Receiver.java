package network;

import gameContent.Definitions;
import gameContent.Enemy;

import java.util.HashMap;

import core.DataIN;

public class Receiver {

	private DataIN dataIn;
	private DataTranslater dataTranslater;

	public Receiver() {
		dataIn = new DataIN();
		dataIn.start();
		dataTranslater = new DataTranslater();
	}

	public HashMap<Integer, Byte> getData() {
		if (!compareSeqNum()) {
			HashMap<Integer, Byte> gameLogic = dataTranslater.translateData(dataIn.getNewData());
			Definitions.emitPermission = true;
			return gameLogic;
		} else {
			return null;
		}
	}

	private Boolean compareSeqNum() {
		if (dataIn.getIncomingSeqNum() == Definitions.seqNum) {
			return true;
		}
		Definitions.seqNum = dataIn.getIncomingSeqNum();
		System.out.println(Definitions.seqNum);
		return false;
	}

}
