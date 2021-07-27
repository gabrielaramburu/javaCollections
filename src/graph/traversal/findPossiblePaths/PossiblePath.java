package graph.traversal.findPossiblePaths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PossiblePath {
	public static void  main(String[] args) {
		PossiblePath possible = new PossiblePath();
		int[][] input = {{0,1},{0,3},{3, 2},{1, 2}, {3, 4}, {4, 2}, {5, 2}};
		System.out.println("resutl  " + possible.possible_paths(input, 7, 0, 2));
	}

	public int possible_paths(int[][] edges, int n, int s, int d) {
		Graph graph = new Graph(n, edges);
		graph.findNumberOfPaths(s, d);
		return graph.totalPath;
	}

	class Graph {
		List<Integer> adj[];
		boolean visited[];
		int totalPath;

		Graph(int nodes, int[][] edges) {
			this.adj = new LinkedList[nodes];
			Arrays.setAll(this.adj, item -> new LinkedList());

			this.visited = new boolean[nodes];
			totalPath = 0;

			buildGraph(edges);
		}

		void buildGraph(int[][] edges) {
			for (int i = 0; i < edges.length; i++)
				addEdge(edges[i][0], edges[i][1]);
		}

		void addEdge(int from, int to) {
			adj[from].add(to);
		}

		void findNumberOfPaths(int s, int d) {
			visited[s] = true;

			this.adj[s].forEach(node -> {
				if (node == d)
					totalPath++;

				//aparenetmente este control no esta bien.
				if (!visited[node]) {
					findNumberOfPaths(node, d);
				}
			});
		}

	}

}
