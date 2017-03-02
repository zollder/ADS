package main.HackerRank;

import main.utils.Utils;

public class main {

	public static void main(String[] args) {

		AlgGeneral general = new AlgGeneral();
		general.printStaircase(5);
		general.convertTime("03:30:29PM");
		general.rotateCircularArray(3, new int[] { 0, 2, 4 }, new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		general.rotateArrayInplace(3, new int[] { 0, 2, 4 }, new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		general.calculateModifiedFibonacci(5);
		//		rank1.samsSubStrings("16");
		System.out.println();
		general.alternatingCharacters("AAAA");
		general.alternatingCharacters("BBBBB");
		general.alternatingCharacters("ABABABAB");
		general.alternatingCharacters("BABABA");
		general.alternatingCharacters("AAABBB");

		general.getVariations(2, new char[] { '2', '3', '5' });

		System.out.print("\nArray sum: " + general.calculateArraySum(new int[] { 5, 5, 5, 5, 5 }, 4));

		AlgSorting sorting = new AlgSorting();

		int[] ints = new int[] { 1, 8, 4, 9, 4, 11, 2, 6, 5, 1, 0, 10 };
		System.out.print("\nOriginal array: ");
		Utils.printArray(ints);

		System.out.print("Insertion sort: ");
		Utils.printArray(sorting.runInsertionSort(ints));

		System.out.print("Quick sort: ");
		Utils.printArray(sorting.runQuickSort(ints));

		System.out.print("Merge sort: ");
		Utils.printArray(sorting.runMergeSort(ints));

		// Contest
		Contest1 contest1 = new Contest1();
		System.out.println("Primes: " + contest1.getMegaprimes(1, 100).toString());
	}
}