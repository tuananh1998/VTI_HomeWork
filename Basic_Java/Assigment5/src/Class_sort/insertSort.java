package Class_sort;

import ex1.SequenceNumber;
import interface_sort.sort;

public class insertSort implements sort {
	int Ins[];

	public insertSort() {
		Ins = SequenceNumber.getA();
	}

	@Override
	public void Sort() {
		int temp;
		for (int i = 1; i < Ins.length; i++) {
			for (int j = i; j > 0; j--) {
				if (Ins[j] < Ins[j - 1]) {
					temp = Ins[j];
					Ins[j] = Ins[j - 1];
					Ins[j - 1] = temp;
				}
			}
		}

	}

	@Override
	public void Print() {
		System.out.println("\n Array After used Quick_Sort: ");
		for (int i = 0; i < Ins.length; i++) {
			System.out.print(" " + Ins[i] + " ");
		}

	}

}
