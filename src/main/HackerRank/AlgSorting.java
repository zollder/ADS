package main.HackerRank;

import java.util.Arrays;

import main.utils.Utils;


/**
 * HackerRank
 * Solutions to sorting algorithm problems
 *
 * @author zollder
 */
public class AlgSorting {


	/*-------------------------------------------------------------------------------------*/
	public AlgSorting() {
		Arrays.toString(new int[1]);
	}

	/**/
	/*	Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();*/

	/**
	 * -------------------------------------------------------------------------------------
	 * Insertion sort - part 1 (junk)
	 *
	 * @param ar - unsorted array off integers
	 * @returns - sorted array
	 */
	public static void insertIntoSorted(int[] ar) {
		// Fill up this function
		int size = ar.length;
		int lastElement = ar[size - 1];
		int i = size - 1;

		while (i > 0 && lastElement <= ar[i - 1]) {
			ar[i] = ar[i - 1];
			i--;
			Utils.printArray(ar);
		}
		ar[i] = lastElement;
		Utils.printArray(ar);
	}

	/**
	 * -------------------------------------------------------------------------------------
	 * Insertion sort - part 2 (junk)
	 *
	 * @param ar - unsorted array off integers
	 */
	public int[] runInsertionSort(int[] array) {
		if (array == null || array.length == 0) {
			return new int[0];
		}
		for (int i = 1; i < array.length; i++) {
			int j = i;
			while (j > 0 && array[j] < array[j - 1]) {
				Integer temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j--;
			}
		}
		return array;
	}

	/**
	 * -------------------------------------------------------------------------------------
	 * Quick sort
	 * Efficiency is defined by proximity of the pivot element to array's median
	 * O(NlogN) -> O(N^2)
	 *
	 * @param ar - unsorted array off integers
	 * @returns - sorted array
	 */
	public int[] runQuickSort(int[] array) {
		int last = array.length - 1;
		quicksort(array, 0, last);
		return array;
	}

	private void quicksort(int[] array, int left, int right) {
		if (right <= left) {
			return;
		}
		int index = partition(array, left, right);
		// process left partition (array[left..index-1]) in a similar way
		if (left < index - 1) {
			quicksort(array, left, index - 1);
		}
		// process right partition (array[index..right]) in a similar way
		if (right > index) {
			quicksort(array, index, right);
		}
	}

	private int partition(int[] array, int left, int right) {
		// partition into: array[left..i-1], array[i], array[i+1..right]
		// select middle element as a pivot
		int pivot = array[(left + right) / 2];

		// Scan right, scan left, check for scan complete (left = right), and swap.
		while (left <= right) {
			// find an element on the left that should be on the right
			while (array[left] < pivot && left < right) {
				left++;
			}
			// find an element on the right that should be on the left
			while (array[right] > pivot && left < right) {
				right--;
			}
			// swap found elements and update their left&right indices
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left; // at this point left > right by 1
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	/**
	 * -------------------------------------------------------------------------------------
	 * Merge sort
	 *
	 * @param ar - unsorted array off integers
	 * @returns - sorted array
	 */
	public int[] runMergeSort(int[] array) {
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
		return array;
	}

	private void mergesort(int[] array, int[] helper, int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(array, helper, low, middle); // sort left
			mergesort(array, helper, middle + 1, high); // sort right
			merge(array, helper, low, middle, high);
		}
	}

	private void merge(int[] array, int[] helper, int low, int middle, int high) {
		// copy elements into helper array
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		// compare and copy back sorted elements into original array
		int left = low;
		int right = middle + 1;
		int current = low;
		while (left <= middle && right <= high) {
			if (helper[left] <= helper[right]) {
				array[current] = helper[left];
				left++;
			} else {
				array[current] = helper[right];
				right++;
			}
			current++;
		}
		// copy remaining left side elements (right side is already there)
		int remaining = middle - left;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[left + i];
		}
	}
}