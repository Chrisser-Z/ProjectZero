package systemLogic;

import gameContent.Base;
import gameContent.Definitions;
import gameContent.Enemy;
import gameContent.EnemyOne;
import gameContent.EnemyTwo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class GameLogic {
	
	private HashMap<Integer, Byte> data; 
	private LinkedList<Enemy> enemyList;
	private Base base;




	public GameLogic(HashMap<Integer, Byte> newData) {
		data = newData;
		enemyList = createEnemyList();
		base = new Base();
	}
	
	private LinkedList<Enemy> createEnemyList() {
		LinkedList<Enemy> list = new LinkedList<Enemy>();
		for (Entry<Integer, Byte> entry : data.entrySet()){
			list.addAll(createEnemies(entry.getKey(), entry.getValue()));
		}
		System.out.println(list);
		return list;		
	}
	
	private Collection<Enemy> createEnemies(Integer i, Byte b) {
		Collection<Enemy> newEnemies = new LinkedList<Enemy>();
		System.out.println("EnemyID: " + i);
		switch(i){
			case Definitions.EnemyOneID:
				for (int x = 0; x< b; x++){
					newEnemies.add(new EnemyOne());
				}
				break;
			case Definitions.EnemyTwoID:
				for (int x = 0; x< b; x++){
					newEnemies.add(new EnemyTwo());
				}
				break;
		}	
		return newEnemies;		
	}
	
	public LinkedList<Enemy> getEnemyList() {
		return enemyList;
	}
	

	public Base getBase() {
		return base;
	}
	
	public void moveEnemies() {
		for (Enemy e : getEnemyList()) {
			if(e.isAlive()){
				e.setPosX(e.getPosX() + e.speed);	
			}		
		}
	}
	
	public void checkCollisions() {
		Rectangle rBase = base.getBounds();		
		for (Enemy e: getEnemyList()){
			Rectangle rEnemy = e.getBounds();
			if(rEnemy.intersects(rBase)){
				doOnCollisions(e);
			}
		}
	}
	
	private void doOnCollisions(Enemy e){
		if (e.isAlive()){
			e.setAlive(false);
			base.setHealth(base.getHealth()-1);			
		}
	}
	
	public void doDefeat() {
		System.exit(1);
	}
	


}
