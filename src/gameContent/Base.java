package gameContent;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Base {
	private String name;
	private int health = 10;
	private short gold;
	private short defense;
	private int posX = Definitions.screenResolutionX - 200;
	private int posY = 0;
	private Image image;
	
	public Base() {
		ImageIcon ii = new ImageIcon("img/theWall.png");
        image = ii.getImage();
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getPosX(), getPosY(), image.getWidth(null), image.getHeight(null));
		
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public short getGold() {
		return gold;
	}

	public void setGold(short gold) {
		this.gold = gold;
	}

	public short getDefense() {
		return defense;
	}

	public void setDefense(short defense) {
		this.defense = defense;
	}
	
	public Image getImage() {
		return image;
	}

}
