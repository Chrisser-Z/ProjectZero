package gameContent;

public class Enemy {
	private String name;
	private short speed;
	private short damage;
	private short armor;
	private byte armorType;

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

}
