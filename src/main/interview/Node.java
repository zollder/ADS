
package main.interview;

class Node {
	private String name;
	private Node[] neighbors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node[] getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Node[] neighbors) {
		this.neighbors = neighbors;
	}
}