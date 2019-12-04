package Class_sort;

import ex1.SequenceNumber;
import interface_sort.sort;

public class QuickSort implements sort {
	int quick[];

	public QuickSort() {
		quick = SequenceNumber.getA();
	}

	@Override
	public void Sort() {
		quickSort(quick, 0, quick.length - 1);
	}

	public static void quickSort(int[] arr, int start, int end) {

		int partition = partition(arr, start, end);

		if (partition - 1 > start) {
			quickSort(arr, start, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(arr, partition + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];

		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
			}
		}

		int temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;

		return start;
	}

	@Override
	public void Print() {
		System.out.println("\nArray After used Quick_Sort: ");
		for (int i = 0; i < quick.length; i++) {
			System.out.print(" " + quick[i] + " ");
		}

	}
}
