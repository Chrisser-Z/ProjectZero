package gameContent;

import javax.swing.ImageIcon;

public class EnemyTwo extends Enemy {
	
	public EnemyTwo() {
		super.name = "EnemyTwo";	
		super.damage = 2;
		super.speed = 5;
		super.armor = 0;
		super.armorType = super.mediumArmor;
		super.posX = super.randomPosX();
		super.posY = super.randomPosY();
		
		ImageIcon ii = new ImageIcon("img/dragon.png");
        super.image = ii.getImage();
	}

}
