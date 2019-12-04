package ex2;

public class BonusEmployee extends Employee {
	int bonus;

	public BonusEmployee(String name, String address, int basicSalary, int bonus) {
		super(name, address, basicSalary);
		this.bonus = bonus;
	}

	@Override
	public int getMonthlySalary() {
		return (bonus + getBasicSalary()) * 30;
	}

}
