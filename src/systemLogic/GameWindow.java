package systemLogic;

import gameContent.Enemy;

import java.util.LinkedList;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	
	public GameWindow(LinkedList<Enemy> enemyList) {
		
		 add(new GameView(enemyList));
		
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setSize(800, 600);
	     setLocationRelativeTo(null);
	     setTitle("DaImbaGame");
	     setResizable(false);
	     setVisible(true);
	}

}
