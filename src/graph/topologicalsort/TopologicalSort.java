package graph.topologicalsort;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
	
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
		List<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, adj, visited, result);
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}

	static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, List<Integer> result) {
		visited[i] = true;
		for (int x : adj.get(i)) {
			if (!visited[x]) {
				dfs(x, adj, visited, result);
			}
		}
		// this is the key idea of topological sort, to keep a stack of completed
		// visited nodes
		// the stack represent the lineal ordern of the graph tree.
		result.add(0, i);
	}
}
