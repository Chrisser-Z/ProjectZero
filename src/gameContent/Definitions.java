package gameContent;

import java.util.ArrayList;

import javax.swing.JTextField;

public abstract class Definitions {

	public static final int EnemyOneID = 0;
	public static final int EnemyTwoID = 1;

	public static final int byteArraySize = 10;

	public static byte seqNum = 0;

	public static byte getSecNum() {
		return seqNum;
	};

	public static boolean emitPermission = true;

	public static final ArrayList<JTextField> enemyCounterList = new ArrayList<JTextField>();

}
