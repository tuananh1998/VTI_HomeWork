public class Worker extends Bee {

	@Override
	void Damage(int damage) {
		super.Damage(damage);
		if (CheckHealthStatus() == true) {
			return;
		}
	}

	@Override
	boolean CheckHealthStatus() {
		super.CheckHealthStatus();
		if (getHealth() < 70) {
			return true;
		}
		return false;
	}

}
