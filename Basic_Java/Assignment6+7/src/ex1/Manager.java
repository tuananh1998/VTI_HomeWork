package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Manager {

	public static void main(String[] args) {
		int n, key;
		List<CanBo> arr = new ArrayList<CanBo>();
		List<employee> emPloyee = new ArrayList<employee>();
		List<Proffessor> arrProffesor = new ArrayList<Proffessor>();
		boolean kt = false;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1.Put in CB: ");
			System.out.println("2.Put in Proffessor: ");
			System.out.println("3. Search with Name and Department: ");
			System.out.println("4. Show List Professor and sorting by name: ");
			System.out.println("5. Exit");
			System.out.println("Choose kind");
			key = sc.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Put in Quantity: ");
				n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					System.out.println("Put in information CB" + (i + 1) + ": ");
					CanBo c1 = new CanBo();
					c1.input();
					arr.add(c1);
					emPloyee.add(c1);
				}
				int s = 0;
				for (CanBo c : arr) {
					System.out.println("--------------------------------");
					System.out.println("information CB" + (s + 1) + ": ");
					c.print();
					s++;
				}
				kt = true;
				break;
			}
			case 2: {
				System.out.println("Put in Quantity: ");
				n = sc.nextInt();
				for (int i = 0; i < n; i++) {

					System.out.println("information Proffessor" + (i + 1) + ": ");
					Proffessor c1 = new Proffessor();
					c1.input();
					arrProffesor.add(c1);
					emPloyee.add(c1);
				}
				int k = 0;
				for (Proffessor c : arrProffesor) {
					System.out.println("--------------------------------");
					System.out.println("information Proffessor" + (k + 1) + ": ");
					c.print();
					k++;
				}
				kt = true;
				break;
			}
			case 3: {
				String Key;
				sc.nextLine();
				System.out.println("Put in Name or Department name be Search");
				Key = sc.nextLine();
				if (arr.isEmpty()) {
					System.out.println("List is Empty!");
					break;
				}

				List<employee> Result = emPloyee.stream().filter(CanBo -> CanBo.getFullname().equals(Key))
						.collect(Collectors.toList());
				List<CanBo> Result1 = arr.stream().filter(CanBo -> CanBo.getDepartment().equals(Key))
						.collect(Collectors.toList());
				if (Result.isEmpty()) {
					System.out.println("Not Found!");
				} else if (Result1.isEmpty()) {
					System.out.println("Not Found!");

				}
				for (employee c : Result) {
					System.out.println("Information " + Key + ":");
					c.print();
				}
				for (CanBo c : Result1) {
					System.out.println("Information Department " + Key + ":");
					c.print();
				}
				kt = true;
				break;
			}
			case 4: {
				if (arrProffesor.isEmpty()) {
					System.out.println("List Proffesor is Empty!");
					break;
				}
				int k = 0;
				for (Proffessor c : arrProffesor) {
					System.out.println("--------------------------------");
					System.out.println("information Proffessor" + (k + 1) + ": ");
					c.print();
					k++;
				}
				System.out.println("Sorting by Name...");
				Collections.sort(arr, new NameComparator());
				for (CanBo c : arr) {
					c.print();
				}
				kt = true;
				break;
			}
			case 5: {
				kt = false;
				break;
			}
			default: {
				kt = false;
				break;
			}

			}
		} while (kt == true || key > 5 || key < 0);

	}

}
