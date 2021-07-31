package graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
 A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
 
 Complex case with no mother node: [[1, 3, 4, 5, 7, 8], [4, 6], [3, 4, 5, 6, 7], [5, 7, 8], [5, 6, 8], [6, 8], [8], [], []]
 Simle case with mother node = 0: lst [[2], [0], [1, 3], [4], []]
 
 dfs = O (V + E) 
 We execute two dfs therfore O(V + E) x 2
 We can also say that the order is O(n)
 
 https://practice.geeksforgeeks.org/problems/mother-vertex/1
 
 */
public class MotherNode {

	boolean[] visited;
	int lastVisitedNode = -1;
	ArrayList<ArrayList<Integer>> adjList;

	public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
		adjList = adj;

		visited = new boolean[V];
		for (int i = 0; i < adjList.size(); i++) {
			if (!visited[i]) {
				dfs(i);
				//topological sort idea, but not strictly a topological sort
				lastVisitedNode = i;
			}
		}
		// at this point I have the last node which should be the mather node.
		if (isMother())
			return lastVisitedNode;
		else
			return -1;

	}

	private void dfs(int node) {
		visited[node] = true;
		for (int x : adjList.get(node)) {
			if (!visited[x]) {
				dfs(x);
			}
		}

	}

	private boolean isMother() {
		Arrays.fill(visited, false);
		dfs(lastVisitedNode);

		for (Boolean v : visited) {
			if (!v)
				return false;
		}
		return true;
	}
}
