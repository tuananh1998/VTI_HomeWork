package ex1;

import java.util.Scanner;

public class SequenceNumber {
	private static int a[];

	public static int[] getA() {
		return a;
	}

	public static void setA(int[] a) {
		SequenceNumber.a = a;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			System.out.print("a[" + (i + 1) + "]= ");
			a[i] = Integer.parseInt(sc.nextLine());
		}
	}

	public void print() {
		System.out.println("Array Before Sort:");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i] + " ");
		}
	}

	public SequenceNumber(int n) {
		a = new int[n];
	}

}
