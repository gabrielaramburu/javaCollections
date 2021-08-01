package graph.traversal.detectcycles;

import java.util.ArrayList;

public class DetectCyclesInDirectedGraph {
	boolean visited[];
	ArrayList<ArrayList<Integer>> adjList;
	boolean cycleDetected = false;

	boolean currentPathNodes[];

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		adjList = adj;
		visited = new boolean[V];
		currentPathNodes = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (cycleDetected) //just for performance improvment
				break;
			
			if (!visited[i]) {
				dfs(i);
			}
		}

		return cycleDetected;
	}

	private void dfs(int node) {
		if (cycleDetected)
			return;

		visited[node] = true;
		currentPathNodes[node] = true; //keep track of the node visited in this current path

		for (int x : adjList.get(node)) {
			if (cycleDetected(x))
				break;

			if (!visited[x]) {
				dfs(x);
			}
		}
		
		//one of the key point, it's the sama idea applied when we want
		//to keep track of the path from one node to another.
		currentPathNodes[node] = false;
	}

	private boolean cycleDetected(int node) {
		if (currentPathNodes[node]) {
			cycleDetected = true;
			return true;
		}
		return false;
	}
}
