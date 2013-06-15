package systemLogic;

import gameContent.Enemy;
import gameContent.Definitions;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JPanel;

public class GameView extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private Thread animator;

	private GameLogic gameLogic;

	public GameView(GameLogic incomingGameLogic) {
		gameLogic = incomingGameLogic;
		setBackground(Color.WHITE);
		setDoubleBuffered(true);
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;
		beforeTime = System.currentTimeMillis();
		while (true) {
			moveEnemies();
			repaint();
			timeDiff = System.currentTimeMillis() - beforeTime;
			sleep = Definitions.simulationSepInMillis - timeDiff;
			if (sleep < 0)
				sleep = 2;
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}

			beforeTime = System.currentTimeMillis();
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		paintEnemies(g2d);
		paintBase(g2d);	
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	private void paintEnemies(Graphics2D g2d) {
		for (Enemy e : gameLogic.getEnemyList()) {
			g2d.drawImage(e.image, e.posX, e.posY, this);
		}
	}
	
	private void paintBase(Graphics2D g2d) {
		g2d.drawImage(gameLogic.getBase().getImage(), gameLogic.getBase().getPosX(), gameLogic.getBase().getPosY(), this);
	}

	// automatically called when GameView() is called
	public void addNotify() {
		super.addNotify();
		animator = new Thread(this);
		animator.start();
	}

	private void moveEnemies() {
		for (Enemy e : gameLogic.getEnemyList()) {
			e.setPosX(e.getPosX() + e.speed);
		}
	}

}
