package systemLogic;

import gameContent.Enemy;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.LinkedList;
import javax.swing.JPanel;


public class GameView extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private final int delay = 16;
	
	private Thread animator;
	
	private LinkedList<Enemy> enemyList;
	
	
	public GameView(LinkedList<Enemy> newEnemyList) {		
		enemyList = newEnemyList;
		setBackground(Color.BLACK);
        setDoubleBuffered(true);
	}

	
	@Override
	public void run() {
		long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

//            cycle();
        	moveBitches();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = delay - timeDiff;

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
	        Graphics2D g2d = (Graphics2D)g;
	        for(Enemy e: enemyList){
	        	g2d.drawRect(e.posX, e.posY, 20, 20);
	        }
	        
	        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	        g2d.setRenderingHints(rh);	        
	        Toolkit.getDefaultToolkit().sync();
	        g.dispose();
	}
	
	//automatically called when GameView() is called
	public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }
	
	private void moveBitches() {
		for(Enemy e: enemyList){
        	e.setPosY(e.getPosY() + 1);
        }
	}

}
