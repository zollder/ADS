package main.graph;

import java.util.Collection;
import java.util.List;

class Graph<T> {
	private List<Node<T>> nodes;

	public List<Node<T>> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node<T>> nodes) {
		this.nodes = nodes;
	}

	public void addNodes(Collection<Node<T>> nodes) {
		if (nodes != null && !nodes.isEmpty()) {
			nodes.addAll(nodes);
		}
	}

	public void addNode(Node<T> node) {
		if (node != null) {

		}
	}
}