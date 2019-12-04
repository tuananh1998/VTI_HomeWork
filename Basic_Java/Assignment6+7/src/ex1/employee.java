package ex1;

import java.util.Scanner;

public class employee {
	private String fullname;
	private float salary_multiplier;

	public double getSalary() {
		return 0;

	}

	public employee(String fullname, float salary_multiplier) {
		this.fullname = fullname;
		this.salary_multiplier = salary_multiplier;
	}

	public employee() {
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public float getSalary_multiplier() {
		return salary_multiplier;
	}

	public void setSalary_multiplier(float salary_multiplier) {
		this.salary_multiplier = salary_multiplier;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Put in full name: ");
		setFullname(sc.nextLine());
		System.out.println("Put in Salary_Multiplier: ");
		setSalary_multiplier(sc.nextFloat());
	}

	public void print() {
		System.out.println("Fullname: " + getFullname());
		System.out.println("Salary_Multiplier: " + getSalary_multiplier());
	}
}
