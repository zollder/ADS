package main.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import main.utils.Utils;

public class main {

	public static void main(String[] args) {

		RecursionAndDynamics runner = new RecursionAndDynamics();

		// 8.1
		System.out.println("Stairs - # of permutations: " + runner.countWaysNoCache(10));
		System.out.println("Stairs - # of permutations: " + runner.countWaysWithCache(10, new HashMap<Integer, Integer>()) + "\n");

		// 8.2
		boolean[][] maze = runner.generate(5, 5);
		Utils.printArray(maze);
		runner.getMazePath(maze)
			.forEach(point -> System.out.println(String.format("(%d,%d), ", point.getRow(), point.getColumn())));

		// 8.3 part 1
		int[] array = new int[] { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		System.out.println("Magic index (distinct): " + runner.findMagicIndexDistinct(array) + "\n");

		// 8.3 part 2
		array = new int[] { -10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13 };
		System.out.println("Magic index (duplicate): " + runner.findMagicIndexDuplicate(array) + "\n");

		// 8.4 part 1
		runner.getSubsets(Arrays.asList(1, 2, 3), 0)
			.forEach(list -> {
				System.out.print("{ ");
				list.forEach(item -> System.out.print(item + " "));
				System.out.println("}");
			});
		System.out.println("\n");

		// 8.4 part 2
		runner.getSubsets(Arrays.asList(1, 2, 3))
			.forEach(list -> {
			System.out.print("{ ");
			list.forEach(item -> System.out.print(item + " "));
			System.out.println("}");
		});
		System.out.println("\n");

		// 8.6 TODO: complete

		// 8.7
		runner.getPermutationsUnique("tes")
			.forEach(str -> System.out.print("\n" + str));

		System.out.println("\n");
		int[][] matrix = new int[][] { { 11, 2, 4 }, { 4, 5, 6 }, { 10, 8, -12 } };
		System.out.println("Diff: " + runner.diff(matrix, 3) + "\n");
	}



	static int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
}