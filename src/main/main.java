package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import main.HackerRank.AlgGeneral;
import main.utils.Utils;

public class main {

	public static void main(String[] args) {

		//-------------chapter 1:
		System.out.println("The string has unique characters: " + hasUniqueChars("aqurlle"));

		System.out.println("String permutations (V1): " + isPermutationV1("test", "ttem"));
		System.out.println("String permutations (V2): " + isPermutationV1("test", "tste"));

		System.out.println("Modified URL: " + urlFy("Mr John Smith    ", 13));
		System.out.println("Is palindrome permutation: " + isPalindromePermutation("wasd1134 dwsa"));
		System.out.println("Is zero or one edits away: " + isOnceEditAway("test", "tesm"));

		long[][] matrix = new long[15][15];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				matrix[i][j] = 1;
			}
		}
		Utils.printMatrix(matrix, "Original matrix: ");
		/*		long[][] transposed = transpose(matrix);
				printMatrix(matrix, "Transposed matrix: ");
				swapMatrixColumns(transposed);*/
		rotateMatrix(matrix);
		Utils.printMatrix(matrix, "Rotated matrix: ");

		//-------------chapter 2:
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i<20; i++) {
			linkedList.add(Utils.getRandomInt(1, 10));
		}
		linkedList.forEach(node -> System.out.print(node + " "));
		System.out.println("");
		removeDuplicates(linkedList).forEach(node -> System.out.print(node + " "));
		System.out.println("\n");

		// generate primes
		List<Integer> primes = generatePrimes(100);
		System.out.println("\nPrime numbers:");
		primes.forEach(num -> System.out.print(num + " "));
		System.out.println("\n");

		AlgGeneral rank1 = new AlgGeneral();
		rank1.printStaircase(5);
		rank1.convertTime("03:30:29PM");
		rank1.rotateCircularArray(3, new int[] { 0, 2, 4 }, new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		rank1.rotateArrayInplace(3, new int[] { 0, 2, 4 }, new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		rank1.calculateModifiedFibonacci(5);
		rank1.samsSubStrings("16");

	}

	/**
	 * 1.1 part 1 -------------------------------------------------------------------------------
	 * Verifies if the string contains only unique characters
	 *
	 * @param chars - a string
	 * @return true, if contains unique characters only, false otherwise
	 */
	static boolean hasUniqueChars(String chars) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < chars.length(); i++) {
			if (!set.add(chars.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 1.2 part 1 -------------------------------------------------------------------------------
	 * Verifies if the 1st string is a permutation of the 2nd one
	 * by sorting and comparing them.
	 *
	 * @param str1 - 1st string
	 * @param str2 - 2nd string
	 * @return true, if permutation, false otherwise
	 */
	static boolean isPermutationV1(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		return sort(str1).equals(sort(str2));
	}

	static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		String sortedString = new String(content);
		System.out.println("Sorted string: " + sortedString);
		return sortedString;
	}

	/**
	 * 1.2 part 2 -------------------------------------------------------------------------------
	 * Verifies if the 1st string is a permutation of the 2nd one
	 * by counting their characters.
	 * Assume ASCII character set.
	 *
	 * @param str1 - 1st string
	 * @param str2 - 2nd string
	 * @return true, if permutation, false otherwise
	 */
	static boolean isPermutationV2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] charSet = new int[128];

		// map 1st string (addition)
		char[] str1array = str1.toCharArray();
		for (char character : str1array) {
			charSet[character]++;
		}

		// map 2nd string (subtraction)
		char[] str2array = str2.toCharArray();
		for (char character : str2array) {
			charSet[character]--;
		}
		// or use: for loop + int caracter = (int) str2.charAt(i)

		// get charset difference (verify if clean)
		for (int symbol : charSet) {
			if (symbol < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 1.3 -------------------------------------------------------------------------------
	 * Replace all spaces in the string with %20.
	 *
	 * @param str - URL string
	 * @param str2 - true length
	 * @return modified URL
	 */
	static String urlFy(String str, int length) {
		if (str == null || str.length() == 0) {
			return str;
		}

		StringBuilder result = new StringBuilder();
		char[] url = str.toCharArray();
		for (int i=0; i<length; i++) {
			if (url[i] != ' ') {
				result.append(url[i]);
			} else {
				result.append('%');
				result.append('2');
				result.append('0');
			}
		}
		return result.toString();
	}

	/**
	 * 1.4 -------------------------------------------------------------------------------
	 * Verifies if the string is a permutation of the palindrome.
	 * The string may contain spaces that have to be ignored.
	 *
	 * @param str - tring to process
	 * @return true, if is palindrome permutation, false otherwise
	 */
	static boolean isPalindromePermutation(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}
		if (str.length() == 1) {
			return true;
		}
		int[] charSet = new int[128];
		char[] symbols = str.toCharArray();
		for (char symbol : symbols) {
			if (symbol != ' ') {
				charSet[symbol]++;
			}
		}
		// count symbols and analyze
		int odds = 0;
		int evens = 0;
		for (int item : charSet) {
			if (item % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}
		if (odds > 1) {
			return false;
		}

		return true;
	}

	/**
	 * 1.5 -------------------------------------------------------------------------------
	 * Verifies if the target string is zero or one edits away from the source string.
	 * Allowed operations:
	 * - insert a character
	 * - remove a character
	 * - replace a character
	 *
	 * @param source, target - source and target strings
	 * @return true, if is one or zero edits away, false otherwise
	 */
	static boolean isOnceEditAway(String source, String target) {
		// zero edits check
		if (source.equals(target)) {
			return true;
		}
		int diff = target.length() - source.length();
		if (diff == -1) { // remove operation check
			return source.contains(target);
		}
		if (diff == 1) { // insert operation check
			return target.contains(source);
		}
		if (diff == 0) { // replace operation check
			int diffCount = 0;
			for (int i = 0; i < source.length(); i++) {
				if (source.charAt(i) != target.charAt(i)) {
					diffCount++;
				}
			}
			if (diffCount == 1) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 1.6 -------------------------------------------------------------------------------
	 * Rotates NxN matrix by 90 degrees.
	 * Is performed in 2 steps:
	 * - find transpose matrix first
	 * - rotate 90 degrees clockwise by swapping columns
	 *
	 * @param matrix - n x x matrix
	 * @return rotated matrix
	 */
	static long[][] transpose(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				long temp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
		return matrix;
	}

	static long[][] swapMatrixColumns(long[][] matrix) {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length / 2; j++) {
				long temp = matrix[i][j];
				matrix[i][j] = matrix[i][length - 1 - j];
				matrix[i][length - 1 - j] = temp;
			}
		}
		return matrix;
	}

	/**
	 * V2 - direct matrix rotation by layered swaps
	 * Same O(N2) as in V1, but more efficient in terms of total operations.
	 *
	 * @param matrix
	 */
	static long[][] rotateMatrix(long[][] matrix) {
		int n = matrix.length;
		for (int level = 0; level < n/2; level++) { // row length
			for (int pos = level; pos < n-1-level; pos++) { // layer depth
				// save top
				long temp = matrix[level][pos];
				// left -> top
				matrix[level][pos] = matrix[n-1-pos][level];
				// bottom -> left
				matrix[n-1-pos][level] = matrix[n-1-level][n-1-pos];
				//right -> bottom
				matrix[n-1-level][n-1-pos] = matrix[pos][n-1-level];
				// temp (top) -> right
				matrix[pos][n-1-level] = temp;
			}
		}
		return matrix;
	}



	/**
	 * 2.1 -------------------------------------------------------------------------------
	 * Removes duplicates from the unsorted linked list.
	 *
	 * @param list - unsorted linked list
	 * @return filtered list
	 */
	static List<Integer> removeDuplicates(LinkedList<Integer> source) {
		Set<Integer> checkForUniqueness = new HashSet<Integer>();
		List<Integer> target = new LinkedList<>();
		source.forEach(node -> {
			if (checkForUniqueness.add(node)) {
				target.add(node);
			}
		});
		return target;
	}

	/**
	 * 6 -------------------------------------------------------------------------------
	 * Generate a list of prime numbers up to specified max value.
	 *
	 * @param max - upper bound
	 * @return list of primes
	 */
	static List<Integer> generatePrimes(int max) {
		List<Integer> primes = new ArrayList<Integer>(max);
		boolean[] flags = new boolean[max + 1];

		initFlags(flags);
		int prime = 2; // 1st prime number
		primes.add(prime);

		while (prime <= max) {
			// find all multiples of prime and set associated flag
			for (int i = prime * prime; i < flags.length; i += prime) {
				flags[i] = false;
			}
			// get next prime
			prime = getNextPrime(flags, prime);
			primes.add(prime);
		}
		return primes;
	}

	private static void initFlags(boolean[] flags) {
		for (int i = 2; i < flags.length; i++) {
			flags[i] = true;
		}
	}

	private static int getNextPrime(boolean[] flags, int prime) {
		int nextPrime = prime + 1;
		while (nextPrime < flags.length && !flags[nextPrime]) {
			nextPrime++;
		}
		return nextPrime;
	}


}