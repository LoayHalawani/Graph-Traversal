import java.util.*;

public class Graph {

	private Map<Integer, List<Integer>> adj;
	List<Integer> visited;
	private int V;

	// Undirected Graph
	public Graph(int V) {
		this.V = V;
		adj = new HashMap<>(V);
		visited = new ArrayList<>();
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
		Graph graph = new Graph(7);

		graph.addEdge(1, 5);
		graph.addEdge(1, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 7);
		graph.addEdge(2, 6);
		graph.addEdge(2, 3);
		graph.addEdge(5, 13);

		System.out.print("BFS: ");

		graph.BFS();

		System.out.println();

		System.out.print("DFS: ");

		graph.DFS();

		System.out.println();
	}
}