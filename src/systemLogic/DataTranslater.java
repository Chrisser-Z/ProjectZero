package systemLogic;

import java.util.HashMap;
import java.util.Map;

public class DataTranslater {

	public DataTranslater() {

	}

	public Map<String, String> translateData(byte[] data) {
		Map<String, String> gameLogicData = new HashMap<String, String>();

		return gameLogicData;
	}

	public String byteToString(byte[] data) {
		String string = new String(data);
		string = string.replace("\0", "");
		return string;
	}
}
