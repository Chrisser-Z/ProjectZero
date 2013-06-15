package gameContent;


public abstract class Enemy {
	public String name;
	public short speed;
	public short damage;
	public short armor;
	public byte armorType;
	
	public byte lightArmor = 100;
	public byte mediumArmor = 101;
	public byte heavyArmor = 102;
	

	public int posX = 0;
	public int posY = 0;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getSpeed() {
		return speed;
	}

	public void setSpeed(short speed) {
		this.speed = speed;
	}

	public short getDamage() {
		return damage;
	}

	public void setDamage(short damage) {
		this.damage = damage;
	}

	public short getArmor() {
		return armor;
	}

	public void setArmor(short armor) {
		this.armor = armor;
	}

	public byte getArmorType() {
		return armorType;
	}

	public void setArmorType(byte armorType) {
		this.armorType = armorType;
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

}
