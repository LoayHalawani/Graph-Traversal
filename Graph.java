import java.util.*;

public class Graph {

	private Map<Integer, List<Integer>> adj;
	List<Integer> visited;

	public Graph() {
		adj = new HashMap<>();
	}

	// Undirected Graph
	private void addEdge(int u, int v) {
		adj.putIfAbsent(u, new ArrayList<>());
		adj.putIfAbsent(v, new ArrayList<>());
		adj.get(u).add(v);
		adj.get(v).add(u);
	}

	// BFS
	private void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		visited = new ArrayList<>();
		
		int firstVertex = adj.keySet().iterator().next();
		visited.add(firstVertex);
		queue.add(firstVertex);

		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");

			for(int v : adj.get(u)) {
				if(!visited.contains(v)) {
					visited.add(v);
					queue.add(v);
				}
			}
		}
	}

	// DFS
	private void DFS() {
		visited = new ArrayList<>();
		int firstVertex = adj.keySet().iterator().next();
		DFSVisit(firstVertex);	
	}

	private void DFSVisit(int u) {
		visited.add(u);
		System.out.print(u + " ");

		for(int v : adj.get(u)) {
			if(!visited.contains(v)) {
				DFSVisit(v);
			}
		}
	}

	// Driver
	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 7);
		graph.addEdge(2, 8);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(3, 10);
		graph.addEdge(3, 9);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(5, 8);
		graph.addEdge(7, 8);

		System.out.print("BFS: ");

		graph.BFS();

		System.out.println();

		System.out.print("DFS: ");

		graph.DFS();

		System.out.println();
	}
}