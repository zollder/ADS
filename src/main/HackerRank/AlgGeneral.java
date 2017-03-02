package main.HackerRank;

import java.math.BigInteger;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import main.utils.Utils;

/**
 * HackerRank solutions - 1st round
 *
 * @author zollder
 */
public class AlgGeneral {


	/*-------------------------------------------------------------------------------------*/
	public AlgGeneral() {
	}

	/*-------------------------------------------------------------------------------------*/
	/*	Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();*/

	public void printStaircase(int size) {
		// Scanner scanner = new Scanner(System.in);
		// int size= scanner.nextInt();

		char[] elements = new char[size];
		Arrays.fill(elements, ' ');
		for (int i = size - 1; i >= 0; i--) {
			elements[i] = '#';
			if (i != 0) {
				System.out.println(elements);
			} else {
				System.out.print(elements);
			}
		}
	}

	public void plusMinus() {
		Scanner scanner = new Scanner(System.in);
		int size = Integer.parseInt(scanner.nextLine());
		int pos = 0;
		int neg = 0;
		int zero = 0;

		for (String value : scanner.nextLine()
			.split(" ")) {
			int number = Integer.parseInt(value);
			if (number > 0) {
				pos++;
			} else if (number < 0) {
				neg++;
			} else {
				zero++;
			}
		}

		System.out.println((float) pos / size);
		System.out.println((float) neg / size);
		System.out.print((float) zero / size);
	}

	public void convertTime(String source) {
		// Scanner scanner = new Scanner(System.in);
		// String rawData = scanner.nextLine();

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa");
		LocalTime parsedTime = LocalTime.parse(source, inputFormat);

		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println("\n\nConverted time: " + parsedTime.format(outputFormat));
	}

	public int[] rotateCircularArray(int r, int[] queries, int[] array) {
		System.out.print("\nBefore rotation:");
		Utils.printArray(array);

		int size = array.length;
		int rotations = r % size;

		int[] target = new int[size];
		for (int i = size - rotations; i < size; i++) {
			target[i - size + rotations] = array[i];
		}
		for (int i = rotations; i < size; i++) {
			target[i] = array[i - rotations];
		}
		System.out.print("After rotation:");
		Utils.printArray(target);

		int[] selection = new int[queries.length];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = target[queries[i]];
		}
		System.out.print("Selection: ");
		Utils.printArray(selection);

		return selection;
	}

	// in-place rotation: doesn't rotate , just returns requested elements
	public void rotateArrayInplace(int r, int[] queries, int[] array) {
		System.out.print("\nBefore rotation:");
		Utils.printArray(array);

		int size = array.length;
		int rotations = r % size;

		System.out.print("Queried elements: ");
		for (int i = 0; i < queries.length; i++) {
			int position = queries[i] - rotations;
			if (position < 0) {
				position = size + position;
			}
			System.out.print(array[position] + " ");
		}
	}

	// modified Fibonacci: t(i+2) = t(i) + t(i+1)^2
	public void calculateModifiedFibonacci(int n) {
		System.out.println("\n");
		BigInteger t1 = BigInteger.ZERO;
		BigInteger t2 = BigInteger.ONE;
		// calculations start from t3 <=> n=3
		for (int i = 3; i <= n; i++) {
			System.out.print("t1: " + t1 + " t2: " + t2);
			BigInteger t = t1.add(t2.multiply(t2));
			t1 = t2;
			t2 = t;
			System.out.println(" t: " + t);
		}
	}

	public Integer samsSubStrings(String str) {
		Map<String, Integer> map = new HashMap<>();
		Integer sum = 0;
		for (int i = 0; i <= str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				String subStr = str.substring(i, j);
				if (map.get(subStr) == null) {
					map.put(subStr, Integer.valueOf(subStr));
					System.out.print(" " + map.get(subStr));
					sum += map.get(subStr);
				}
			}
		}
		System.out.println("\nSum : " + sum);
		return sum;
	}

	public void alternatingCharacters(String str) {
		char[] string = str.toCharArray();
		int pos = 0;
		int counter = 0;
		while (pos < string.length - 1) {
			if (string[pos] == string[pos + 1]) {
				counter++;
			}
			pos++;
		}
		System.out.println("Chars to delete: " + counter);
	}

	/**
	 * -------------------------------------------------------------------------------------
	 * Selection from a predefined set with repetition
	 *
	 * @param size - selection size
	 * @param input - a set with predefined values
	 * @returns - a list of generated variations
	 */
	public List<char[]> getVariations(int size, char[] input) {
		List<char[]> items = new ArrayList<>();

		char[] item = new char[3];

		generate(items, input, item, 0);
		System.out.println("Size: " + items.size());

		for (char[] it : items) {
			System.out.println(it);
		}
		return items;
	}

	private void generate(List<char[]> items, char[] input, char[] item, int count) {
		if (count < item.length) {
			for (int i = 0; i < input.length; i++) {
				item[count] = input[i];
				generate(items, input, item, count + 1);
			}
		} else {

			items.add(item.clone());
		}
	}

	public int calculateArraySum(int[] array, int index) {
		if (index == 0) {
			return array[index];
		}

		return calculateArraySum(array, index - 1) + array[index];
	}
}