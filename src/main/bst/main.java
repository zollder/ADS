package main.bst;

import java.util.Arrays;
import java.util.List;

public class main {

	public static void main(String[] args) {
		BST<Integer, Integer> tree = new BST<Integer, Integer>();
		List<Integer> elements = Arrays.asList(15, 12, 6, 9, 17, 13, 11, 4, 7, 5, 19);

		// build BST
		elements.forEach(element -> {
			tree.insert(element, element);
		});

		// test "find" for each element
		elements.forEach(element -> System.out.println(String.format("Find: %d, reslult: %d", element, element)));

		// test delete
		tree.traverseInorder();
		tree.delete(7);
		tree.traverseInorder();
		tree.delete(17);
		tree.traverseInorder();

		// test find max/min
		Arrays.asList(1, 45, 3, 37)
			.forEach(element -> tree.insert(element, element));
		tree.traverseInorder();
		System.out.println(String.format("Smallest element: %d, Largest element: %d", tree.findMin(), tree.findMax()));
	}
}