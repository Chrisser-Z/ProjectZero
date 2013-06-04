package gameContent;

public class Weapon {
	private String name;
	private short damage;
	private short speed;
	private byte type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getDamage() {
		return damage;
	}

	public void setDamage(short damage) {
		this.damage = damage;
	}

	public short getSpeed() {
		return speed;
	}

	public void setSpeed(short speed) {
		this.speed = speed;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

}
