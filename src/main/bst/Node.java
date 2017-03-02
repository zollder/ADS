package main.bst;

/**
 * Implements a BST node.
 * Duplicate nodes are not allowed for simplicity.
 *
 * @author zollder
 */
public class Node<K, V> {

	private K key;
	private V value;
	private Node<K, V> left;
	private Node<K, V> right;

	public Node(K key, V value, Node<K, V> leftNode, Node<K, V> rightNode) {
		this.key = key;
		this.value = value;
		this.left = leftNode;
		this.right = rightNode;
	}

	public Node(K key) {
		this.setKey(key);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}
}