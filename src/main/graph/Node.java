
package main.graph;

import java.util.Collection;
import java.util.List;

/**
 * Graph node implementation.
 *
 * @param <T>
 */
public class Node<T> {

	private String name;
	private T value;
	private NodeState state;

	private List<Node<T>> neighbors;

	public Node(String name, T value) {
		this.state = NodeState.UNVISITED;
		this.name = name;
		this.setValue(value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public NodeState getState() {
		return state;
	}

	public void setState(NodeState state) {
		this.state = state;
	}

	public List<Node<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public void addNeighbor(Node<T> node) {
		if (node != null) {
			neighbors.add(node);
		}
	}

	public void addNeighbors(Collection<Node<T>> nodes) {
		if (nodes != null && !nodes.isEmpty()) {
			neighbors.addAll(nodes);
		}
	}
}