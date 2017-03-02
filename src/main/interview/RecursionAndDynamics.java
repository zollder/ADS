package main.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Recursion and Dynamics chapter solutions
 *
 * @author zollder
 */
public class RecursionAndDynamics {

	/*-------------------------------------------------------------------------------------*/
	public RecursionAndDynamics() {}

	/*-------------------------------------------------------------------------------------*/

	/**
	 * 8.1 -------------------------------------------------------------------------------
	 * Calculates and returns the number of ways a person runs up the stairs
	 * with 1, 2, or 3 step hops.
	 * Runs in:
	 * O(3^n) without cache
	 * O(n) with cache
	 *
	 * @param steps - number of stairs
	 * @return number of ways
	 */
	public int countWaysNoCache(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWaysNoCache(n - 1) + countWaysNoCache(n - 2) + countWaysNoCache(n - 3);
		}
	}

	public int countWaysWithCache(int n, Map<Integer, Integer> cache) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (cache.containsKey(n)) {
			return cache.get(n);
		}

		cache.put(n, countWaysWithCache(n - 1, cache) + countWaysWithCache(n - 2, cache) + countWaysWithCache(n - 3, cache));
		return cache.get(n);
	}

	/**
	 * 8.2 -------------------------------------------------------------------------------
	 * Brute-force recursive approach -> recursive with memorization.
	 * Complexity: O(2^(r+c)) -> O(rc)
	 *
	 * @param maze - an array of restricted (false) maze cells
	 * @return - calculated path
	 */
	public List<Point> getMazePath(boolean[][] maze) {
		if (maze == null || maze.length == 0) {
			return null;
		}

		List<Point> path = new ArrayList<>();
		Set<Point> visited = new HashSet<>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path, visited)) {
			// return calculated
			return path;
		}
		// could not calculate the path
		return Collections.emptyList();
	}

	private boolean getPath(boolean[][] maze, int row, int col, List<Point> path, Set<Point> visited) {
		// validate row and column indices
		if (row < 0 || col < 0) {
			return false;
		}
		// check if the cell is restricted
		if (!maze[row][col]) {
			return false;
		}
		Point point = new Point(row, col);
		// ignore visited points
		if (visited.contains(point)) {
			return false;
		}
		// check for origin point
		boolean isOrigin = row == 0 && col == 0;
		// add the point to the path if it's reachable from start
		if (isOrigin || getPath(maze, row - 1, col, path, visited) || getPath(maze, row, col - 1, path, visited)) {
			path.add(point);
			return true;
		}
		visited.add(point);
		return false;
	}

	public boolean[][] generate(int rows, int cols) {
		boolean[][] array = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j == 2) {
					array[i][j] = false;
				} else {
					array[i][j] = true;
				}
			}
		}
		return array;
	}

	/**
	 * 8.3 part 1 -------------------------------------------------------------------------------
	 * Finds a magic index in a sorted array of unique integers
	 *
	 * @param array - array of distinct integers
	 * @return magic index
	 */
	public int findMagicIndexDistinct(int[] array) {
		System.out.print("\n");
		return findIndexDistinct(array, 0, array.length - 1);
	}

	private int findIndexDistinct(int[] array, int start, int end) {
		System.out.println(String.format("start:%d, end:%d, mid:%d", start, end, (start + end) / 2));
		// validate input values:
		if (end < start) {
			return -1;
		}
		// middle element
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return findIndexDistinct(array, start, mid - 1);
		} else {
			return findIndexDistinct(array, mid + 1, end);
		}
	}

	/**
	 * 8.3 part 2 -------------------------------------------------------------------------------
	 * Finds a magic index in a sorted array of integers with possible duplicate elements
	 *
	 * @param array - array of integers
	 * @return magic index
	 */
	public int findMagicIndexDuplicate(int[] array) {
		System.out.print("\n");
		return findIndexDuplicate(array, 0, array.length - 1);
	}

	private int findIndexDuplicate(int[] array, int start, int end) {
		System.out.println(String.format("start:%d, end:%d, mid:%d", start, end, (start + end) / 2));
		// validate input values:
		if (end < start) {
			return -1;
		}
		// middle element
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return mid;
		}
		// search left side
		int left = findIndexDistinct(array, start, Math.min(array[mid], mid-1));
		if (left >= 0) {
			return left;
		}
		// search right side
		return findIndexDistinct(array, Math.max(array[mid], mid + 1), end);
	}

	/**
	 * 8.4 part 1-------------------------------------------------------------------------------
	 * Finds and returns all subsets of a set
	 *
	 * @param set - a set
	 * @return a collection of found subsets
	 */
	public List<List<Integer>> getSubsets(List<Integer> set, int index) {
		// end of set reached -> return empty set
		if (set.size() == index) {
			List<List<Integer>> subsets = new ArrayList<>();
			subsets.add(new ArrayList<>());
			return subsets;
		} else {
			List<List<Integer>> subsets = getSubsets(set, index + 1);
			// get item at index
			Integer item = set.get(index);
			// get existing subsets
			List<List<Integer>> newSubsets = new ArrayList<>();
			for (List<Integer> subset : subsets) {
				// add current item to a copy of each subset
				List<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				newSubsets.add(newSubset);
			}
			subsets.addAll(newSubsets);
			return subsets;
		}
	}

	/**
	 * 8.4 part 2-------------------------------------------------------------------------------
	 * Iterative approach
	 */
	public List<List<Integer>> getSubsets(List<Integer> set) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());

		for (Integer item : set) {
			List<List<Integer>> newSubsets = new ArrayList<>();
			for (List<Integer> subset : subsets) {
				// add current item to a copy of each subset
				List<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				newSubsets.add(newSubset);
			}
			subsets.addAll(newSubsets);
		}
		return subsets;
	}

	/**
	 * 8.7 -------------------------------------------------------------------------------
	 * Permutations of a string with unique characters.
	 */
	public List<String> getPermutationsUnique(String string) {
		if (string == null) {
			return null;
		}

		// base case
		List<String> permutations = new ArrayList<>();
		if (string.length() == 0) {
			permutations.add("");
			return permutations;
		}

		// remove & hold 1st character, and further reduce the string down to the base case
		char character = string.charAt(0);
		String reminder = string.substring(1);
		List<String> substrings = getPermutationsUnique(reminder);

		// insert the character into all possible locations of each word
		for (String substring : substrings) {
			for (int i = 0; i <= substring.length(); i++) {
				String start = substring.substring(0, i);
				String end = substring.substring(i);
				permutations.add(start + character + end);
			}
		}

		return permutations;
	}

	/**
	 * 8.8 -------------------------------------------------------------------------------
	 * Permutations of a string with duplicate characters.
	 */
	public List<String> getPermutationsDuplicate(String string) {
		return null;
	}

	public int diff(int[][] matrix, int size) {
        int primary = 0;
        int secondary = 0;
        for (int i=0; i<size; i++) {
            primary += matrix[i][i];
            secondary+= matrix[size-1-i][i];
        }
        int diff = Math.abs(primary - secondary);
		return diff;
	}

}