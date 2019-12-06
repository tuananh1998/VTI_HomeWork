public class Drone extends Bee {

	@Override
	boolean CheckHealthStatus() {
		super.CheckHealthStatus();
		if (getHealth() < 50) {
			return true;
		}
		return false;
	}

	@Override
	void Damage(int damage) {
		super.Damage(damage);
		if (CheckHealthStatus() == true) {
			return;
		}
	}

}
