package main.interview;

import java.util.LinkedList;



/**
 * Trees and graphs chapter solutions
 *
 * @author zollder
 */
public class TreeGraph {

	/*-------------------------------------------------------------------------------------*/
	public TreeGraph() {
	}

	/**
	 * Determines if there is a path (route) between two nodes.
	 * Is implemented as a breadth first search.
	 *
	 * @param graph - graph
	 * @param start - start node
	 * @param end - end node
	 * @return
	 */
	public boolean bfSearch(Graph graph, Node start, Node end) {
		if (start.equals(end)) {
			return false;
		}

		// a queue to hold adjacent nodes
		LinkedList<Node> queue = new LinkedList<Node>();
		start.state = State.Visiting;
		queue.add(start);

		Node node;
		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node != null) {
				// check all unvisited neighbors before diving deeper
				for (Node adjNode : node.children) {
					if (adjNode.state.equals(State.Unvisited)) {
						if (adjNode == end) {
							return true;
						} else {
							adjNode.state = State.Visiting;
							queue.add(adjNode);
						}
					}
				}
			}
			node.state = State.Visited;
		}

		return false;
	}

}

class Node {
	public String name;
	public State state = State.Unvisited;
	public Node[] children;
}

class Graph {
	public Node[] nodes;
}

enum State {
	Unvisited, Visited, Visiting;
}
