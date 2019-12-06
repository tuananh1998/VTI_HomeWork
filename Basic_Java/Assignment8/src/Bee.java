
public abstract class Bee {
	private float health = 100;

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	void Damage(int damage) {
		if (CheckHealthStatus() == false) {
			if (damage > 0 && damage < 100) {
				health = health - damage;
			}
		}
		if (health < 0) {
			health = 0;
		}

	};

	boolean CheckHealthStatus() {
		return false;
	};
}
