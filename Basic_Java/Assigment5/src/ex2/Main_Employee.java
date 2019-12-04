package ex2;

public class Main_Employee {

	public static void main(String[] args) {
		System.out.println("Employee have'nt bonus:");
		NormalEmployee n1 = new NormalEmployee("CTA", "Viet Nam", 5000);
		System.out.println("Name \t\t\t" + n1.getName());
		System.out.println("Address\t\t\t" + n1.getAddress());
		System.out.println("getBasicSalary\t\t" + n1.getBasicSalary());
		System.out.print("Get Salary of Month: \t" + n1.getMonthlySalary());
		System.out.println("\n------------------------");
		System.out.println("Employee have bonus:");
		BonusEmployee n2 = new BonusEmployee("CTA", "Viet Nam", 5000, 50);
		System.out.println("Name \t\t\t" + n2.getName());
		System.out.println("Address\t\t\t" + n2.getAddress());
		System.out.println("getBasicSalary\t\t" + n2.getBasicSalary());
		System.out.println("Bonus \t\t\t" + n2.bonus);
		System.out.println("Get Salary of Month: \t" + n2.getMonthlySalary());
	}

}
