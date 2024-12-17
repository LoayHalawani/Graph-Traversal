import java.util.*;

public class Graph {

	private Map<Integer, List<Integer>> adj;
	List<Integer> visited;

	// Undirected Graph
	public Graph() {
		adj = new HashMap<>();
	}

	private void addEdge(int v, int u) {
		adj.putIfAbsent(v, new ArrayList<>());
		adj.putIfAbsent(u, new ArrayList<>());
		adj.get(v).add(u);
		adj.get(u).add(v);
	}

	// BFS
	private void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		visited = new ArrayList<>();
		
		int firstVertex = adj.keySet().iterator().next();
		visited.add(firstVertex);
		queue.add(firstVertex);

		while(!queue.isEmpty()) {
			int v = queue.poll();
			System.out.print(v + " ");

			for(int u : adj.get(v)) {
				if(!visited.contains(u)) {
					visited.add(u);
					queue.add(u);
				}
			}
		}
	}

	// DFS
	private void DFS() {
		visited = new ArrayList<>();
		int v = adj.keySet().iterator().next();
		DFSVisit(v);	
	}

	private void DFSVisit(int v) {
		visited.add(v);
		System.out.print(v + " ");

		for(int u : adj.get(v)) {
			if(!visited.contains(u)) {
				DFSVisit(u);
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