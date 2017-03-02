package main.bst;

import java.util.Optional;

import main.bst.exceptions.DuplicateKeyException;

/**
 * Core BST implementation.
 * Duplicate nodes are not allowed for simplicity.
 *
 * @author zollder
 */
public class BST<K extends Comparable<K>, V> {

	private Node<K,V> root;

	/*-------------------------------------------------------------------------------------*/
	public BST() {
		setRoot(null);
	}

	/*-------------------------------------------------------------------------------------*/
	public void insert(K key, V value) {
		root = insert(root, key, value).orElse(null);
	}

	public void delete(K key) {
		root = delete(root, key).orElse(null);
	}

	public V find(K key) {
		return find(root, key).map(Node<K,V>::getValue).orElse(null);
	}

	public V findMin() {
		return findSmallest(getRoot()).map(Node<K,V>::getValue).orElse(null);
	}

	public V findMax() {
		return findLargest(getRoot()).map(Node<K,V>::getValue).orElse(null);
	}

	public void print() {
	}

	public V findByValue(V value) {
		return null;
	}

	public void traversePreorder() {

	}

	public void traverseInorder() {
		traverseInorder(getRoot());
		System.out.println();
	}

	public void traversePostorder() {

	}

	public Node<K,V> getRoot() {
		return root;
	}

	public void setRoot(Node<K,V> root) {
		this.root = root;
	}

	/*-------------------------------------------------------------------------------------*/
	private Optional<Node<K,V>> insert(Node<K,V> node, K key, V value) {
		if (node == null) {
			return Optional.of(new Node<K,V>(key, value, null, null));
		}

		if (node.getKey().equals(key)) {
			throw new DuplicateKeyException("Duplicate keys are not supported.");
		}

		if (key.compareTo(node.getKey()) < 0) {
			node.setLeft(insert(node.getLeft(), key, value).orElse(null));
			return Optional.of(node);
		}

		node.setRight(insert(node.getRight(), key, value).orElse(null));
		return Optional.of(node);
	}

	/*-------------------------------------------------------------------------------------*/
	private Optional<Node<K, V>> delete(Node<K, V> node, K key) {
		if (node == null) {
			return Optional.empty();
		}

		if (key.compareTo(node.getKey()) < 0) {
			node.setLeft(delete(node.getLeft(), key).orElse(null));
			return Optional.of(node);
		}

		if (key.compareTo(node.getKey()) > 0) {
			node.setRight(delete(node.getRight(), key).orElse(null));
			return Optional.of(node);
		}

		// node found, delete it and update the tree based on 3 scenarios:
		if (node.getLeft() == null && node.getRight() == null) { // leaf node
			return Optional.empty();
		}
		if (node.getLeft() == null) { // has only right child
			return Optional.of(node.getRight());
		}
		if (node.getRight() == null) { // has only left child
			return Optional.of(node.getLeft());
		}
		// has 2 children:
		// delete current node by replacing it with the smallest node from the right subtree
		Node<K, V> replacementNode = findSmallest(node.getRight()).get();
		node.setKey(replacementNode.getKey());
		node.setValue(replacementNode.getValue());
		node.setRight(delete(node.getRight(), replacementNode.getKey()).orElse(null));
		return Optional.of(node);
	}

	/*-------------------------------------------------------------------------------------*/
	private Optional<Node<K,V>> findSmallest(Node<K,V> node) {
		if (node == null) {
			return Optional.ofNullable(node);
		}

		if (node.getLeft() != null) {
			return findSmallest(node.getLeft());
		}

		return Optional.of(node);
	}

	/*-------------------------------------------------------------------------------------*/
	private Optional<Node<K,V>> findLargest(Node<K,V> node) {
		if (node == null) {
			return Optional.ofNullable(node);
		}

		if (node.getRight() != null) {
			return findLargest(node.getRight());
		}

		return Optional.of(node);
	}

	/*-------------------------------------------------------------------------------------*/
	private Optional<Node<K,V>> find(Node<K,V> node, K key) {
		if (node == null) {
			return Optional.empty();
		}

		if (node.getKey().equals(key)) {
			return Optional.of(node);
		}

		if (key.compareTo(node.getKey()) < 0) {
			return find(node.getLeft(), key);
		}

		return find(node.getRight(), key);
	}

	/*-------------------------------------------------------------------------------------*/
	private String print(Node<K,V> node) {
		return null;
	}

	/*-------------------------------------------------------------------------------------*/
	private void traverseInorder(Node<K, V> node) {
		if (node == null) {
			return;
		}

		traverseInorder(node.getLeft());
		System.out.print(node.getKey() + " ");
		traverseInorder(node.getRight());
	}
}