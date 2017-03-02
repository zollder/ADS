package main.utils;

import java.util.Random;

public class Utils {

	public static <E> void printArray(E[] array) {
		for (E element : array) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i]);
			} else {
				System.out.print(array[i] + " ");
			}
		}
		System.out.print("\n");
	}

	public static void printArray(char[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i]);
			} else {
				System.out.print(array[i] + " ");
			}
		}
		System.out.print("\n");
	}

	public static void printArray(boolean[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

	public static void printMatrix(long[][] matrix, String comment) {
		if (comment != null && comment.length() > 0) {
			System.out.println(comment);
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
}