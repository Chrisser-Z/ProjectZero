package network;

import gameContent.Definitions;
import core.DataOUT;

public class Emitter {

	private DataOUT dataOut;

	public Emitter() {
		dataOut = new DataOUT();

	}

	public void emitData() {
		if (Definitions.emitPermission) {
			byte[] array = new byte[Definitions.byteArraySize];
			for (int i = 0; i < Definitions.enemyCounterList.size(); i++) {
				int x = Integer.parseInt(Definitions.enemyCounterList.get(i).getText());
				array[i] = (byte) x;
			}
			array[Definitions.byteArraySize - 1] = generateNewSeqNum();
			dataOut.sendData(array);
			Definitions.emitPermission = false;
		}
	}

	private byte generateNewSeqNum() {
		byte newSeqNum;
		if (Definitions.seqNum + 1 == 3) {
			newSeqNum = 0;
		} else {
			newSeqNum = (byte) (Definitions.seqNum + 1);
		}
		return newSeqNum;
	}

}
