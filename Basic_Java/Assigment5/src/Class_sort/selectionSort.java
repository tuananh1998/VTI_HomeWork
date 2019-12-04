package Class_sort;

import ex1.SequenceNumber;
import interface_sort.sort;

public class selectionSort implements sort {
	int SelectSort[];

	public selectionSort() {
		SelectSort = SequenceNumber.getA();
	}

	@Override
	public void Sort() {
		for (int x = 0; x < SelectSort.length; x++) {
			int index_of_min = x;
			for (int y = x; y < SelectSort.length; y++) {
				if (SelectSort[index_of_min] > SelectSort[y]) {
					index_of_min = y;
				}
			}
			int temp = SelectSort[x];
			SelectSort[x] = SelectSort[index_of_min];
			SelectSort[index_of_min] = temp;
		}

	}

	@Override
	public void Print() {
		System.out.println("\nArray After used Selection_Sort: ");
		for (int i = 0; i < SelectSort.length; i++) {
			System.out.print(" " + SelectSort[i] + " ");
		}
	}

}
