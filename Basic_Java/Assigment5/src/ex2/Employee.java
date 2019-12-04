package ex2;

public abstract class Employee {
	private String name, address;
	protected int basicSalary;

	public Employee(String name, String address, int basicSalary) {
		this.name = name;
		this.address = address;
		this.basicSalary = basicSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public abstract int getMonthlySalary();
}
