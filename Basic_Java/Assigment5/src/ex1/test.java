package ex1;

import java.util.Scanner;

import Class_sort.QuickSort;
import Class_sort.insertSort;
import Class_sort.selectionSort;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, loai;
		System.out.print("Put in Quantity: ");
		n = sc.nextInt();
		SequenceNumber s1 = new SequenceNumber(n);
		s1.input();
		System.out.println("Choose Kind of Sort");
		System.out.println("1.Be use Insert_Sort");
		System.out.println("2.Be use Selection_Sort");
		System.out.println("3.Be use Quick_Sort");
		loai = sc.nextInt();
		s1.print();
		switch (loai) {
		case 1: {
			insertSort i1 = new insertSort();
			i1.Sort();
			i1.Print();
			break;
		}

		case 2: {
			selectionSort i1 = new selectionSort();
			i1.Sort();
			i1.Print();
			break;
		}
		case 3: {
			QuickSort i1 = new QuickSort();
			i1.Sort();
			i1.Print();
			break;
		}

		default: {
			System.out.println("ERROR!!!");
			break;
		}

		}

	}

}
