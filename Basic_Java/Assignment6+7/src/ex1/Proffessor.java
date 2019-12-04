package ex1;

import java.util.Scanner;

public class Proffessor extends employee {
	private String faculty, academic_degree;
	private float allowance, monthly_teaching_time;

	public Proffessor() {
		super();
	}

	public Proffessor(String fullname, float salary_multiplier, String faculty, String academic_degree, float allowance,
			float monthly_teaching_time) {
		super(fullname, salary_multiplier);
		this.faculty = faculty;
		this.academic_degree = academic_degree;
		this.allowance = allowance;
		this.monthly_teaching_time = monthly_teaching_time;
	}

	public float getAllowance() {
		return allowance;
	}

	public void setAllowance(float allowance) {
		this.allowance = allowance;
	}

	public Proffessor(String fullname, float salary_multiplier) {
		super(fullname, salary_multiplier);
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getAcademic_degree() {
		return academic_degree;
	}

	public void setAcademic_degree(String academic_degree) {
		this.academic_degree = academic_degree;
	}

	public float getMonthly_teaching_time() {
		return monthly_teaching_time;
	}

	public void setMonthly_teaching_time(float monthly_teaching_time) {
		this.monthly_teaching_time = monthly_teaching_time;
	}

	@Override
	public double getSalary() {
		return getSalary_multiplier() * 730 + getAllowance() + getMonthly_teaching_time() * 45;
	}

	@Override
	public void input() {
		super.input();
		int loai;
		boolean kt=false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Put in faculty: ");
		setFaculty(sc.nextLine());
			System.out.println("Choose Kind of academic degree ");
			System.out.println("1.bachelor ");
			System.out.println("2.master ");
			System.out.println("3.doctor ");
			loai = sc.nextInt();
			switch (loai) {
			case 1: {
				setAcademic_degree("master");
				kt=true;
				break;
			}

			case 2: {
				setAcademic_degree("bachelor");
				kt=true;
				break;
			}
			case 3: {
				setAcademic_degree("doctor");
				kt=true;
				break;
			}

			default: {
				System.out.println("ERROR!!!");
				kt=false;
				break;
			}

			}
		
		
		System.out.println("Put in allowance: ");
		setAllowance(sc.nextFloat());
		System.out.println("Put in monthly teaching time: ");
		setMonthly_teaching_time(sc.nextFloat());
	}

	@Override
	public void print() {
		super.print();
		System.out.println("faculty " + getFaculty());
		System.out.println("academic degree " + getAcademic_degree());
		System.out.println("allowance: "+getAllowance());
		System.out.println("monthly teaching time " + getMonthly_teaching_time());
	}

}
