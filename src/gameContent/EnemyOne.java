package gameContent;

import javax.swing.ImageIcon;

public class EnemyOne extends Enemy {
	
	public EnemyOne() {
		super.name = "EnemyOne";	
		super.damage = 1;
		super.speed = 3;
		super.armor = 0;
		super.armorType = super.lightArmor;
		super.posX = super.randomPosX();
		super.posY = super.randomPosY();
		
		ImageIcon ii = new ImageIcon("img/orc.png");
        super.image = ii.getImage();
	}
	

}
