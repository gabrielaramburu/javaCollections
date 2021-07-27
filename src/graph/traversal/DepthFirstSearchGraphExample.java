package graph.traversal;

import java.util.Arrays;
import java.util.LinkedList;

public class DepthFirstSearchGraphExample {

	public static void main(String[] args) {
		DepthFirstSearchGraphExample dfs = new DepthFirstSearchGraphExample();
		Graph graph = dfs.new Graph(5);
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.dfs(2);
	}

	class Graph {
		int vertices;
		LinkedList<Integer> adjList[];
		boolean visited[];
		
		Graph (int vertices) {
			this.vertices = vertices;
			adjList = new LinkedList[vertices];
			Arrays.setAll(adjList, item -> new LinkedList<Integer>());
			visited = new boolean[vertices];
		}
		
		void addEdge(int v, int neighboard) {
			this.adjList[v].add(neighboard);
		}
		
		void dfs(int vertixFrom) {
			if (vertixFrom >= this.adjList.length) throw new IllegalArgumentException();
			
		
			visited[vertixFrom] = true;
			System.out.println("Node: " + vertixFrom);
			
			adjList[vertixFrom].forEach(neighboard -> {
				if (!visited[neighboard])
					dfs(neighboard);
			});
		}
	}
}
