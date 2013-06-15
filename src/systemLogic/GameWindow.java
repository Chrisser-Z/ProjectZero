package systemLogic;

import gameContent.Enemy;
import gameContent.Definitions;
import java.util.LinkedList;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	
	private static final long serialVersionUID = 1L;

	
	public GameWindow(GameLogic gameLogic) {
		
		 add(new GameView(gameLogic));
		
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     setSize(Definitions.screenResolutionX, Definitions.screenResolutionY);
	     setLocationRelativeTo(null);
	     setTitle("Da_Imba_Game");
	     setResizable(false);
	     setVisible(true);
	}

}
