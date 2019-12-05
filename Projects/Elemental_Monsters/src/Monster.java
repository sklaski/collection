
public class Monster {

	private String name;
	private int damage;
	private int life;
	private int maxLife;
	private float healPerHit;
	private String type = "normal";
	private String knownWeakness;

	public Monster(String name, int damage, int life, String type) {
		super();
		String vulnerability = "";
		float healingFactor = 0f;
		switch (type) {
		case "Fire":
			vulnerability = "Water";
			healingFactor = 0.3f;
			break;
		case "Water":
			vulnerability = "Grass";
			healingFactor = 0.2f;
			break;
		case "Grass":
			vulnerability = "Fire";
			healingFactor = 0.1f;
			break;
		default:
			vulnerability = "";
			healingFactor = 1f;
			break;
		}
		this.name = name;
		this.damage = damage;
		this.life = life;
		this.maxLife = life;
		this.type = type;
		this.knownWeakness = vulnerability;
		this.healPerHit = healingFactor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public String getType() {
		return type;
	}

	public String getKnownWeakness() {
		return knownWeakness;
	}

	@Override
	public String toString() {
		return "Monster " + name + ", Dam=" + damage + ", HP=" + life + ", Kind=" + type + "]";
	}

	public void takeHit(Monster opponent) {
		float damageModifier = 1f;
		int healed = 0;
		if (this.getType().equals(opponent.getKnownWeakness())) { //opponent has weakness, so half damage
			damageModifier = 0.5f;
		}
		if (this.getKnownWeakness().equals(opponent.getType())) { //monster has weakness to opponent, so double damage
			damageModifier = 2f;
		}
		healed = (int)(this.getHealPerHit() * this.getLife());
		this.setLife(healed + this.getLife() - (int)(opponent.getDamage() * damageModifier));
		if (this.getMaxLife() < this.getLife()) { // clear "too much" hit points
			healed -= (this.getLife() - this.getMaxLife());
			this.setLife(this.getMaxLife());
		}
		System.out.print(this.getName() + " of Category " + this.getType() + " (DamMod: " + damageModifier + ")");
		if (this.getLife() == 0) {
			System.out.println(" is KO!");
		} else if (this.getLife() < 0) {
			System.out.println(" dies a terrible terrible death!!!");
		} else {
			System.out.println("is healed for " + healed + " and has " + this.getLife() + " hit points remaining.");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public float getHealPerHit() {
		return healPerHit;
	}

}