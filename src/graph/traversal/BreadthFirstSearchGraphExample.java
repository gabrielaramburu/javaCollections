package graph.traversal;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchGraphExample {

	public static void main(String[] args) {
		BreadthFirstSearchGraphExample bfsG = new BreadthFirstSearchGraphExample();
		
		Graph graph = bfsG.new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		graph.bfs(2);
	}

	class Graph {
		int vertices;
		LinkedList<Integer> adjList[];
		
		Graph (int v) {
			this.vertices = v;
			this.adjList = new LinkedList[v];
			Arrays.setAll(adjList, item -> new LinkedList<Integer>());
		}
		
		void addEdge(int vFrom, int vTo) {
			adjList[vFrom].add(vTo);
		}
		
		void bfs(int vFrom) {
			if (vFrom > this.vertices) throw new IllegalArgumentException();
			boolean visited[] = new boolean[vertices];
			
			Queue<Integer> neighbords = new ArrayDeque<Integer>();
			neighbords.add(vFrom);
			visited[vFrom] = true;
			
			while (!neighbords.isEmpty()) {
				int currentNode = neighbords.poll();
				System.out.println("Node: " + currentNode);
				
				adjList[currentNode].forEach(node -> {
					if (!visited[node]) {
						neighbords.add(node);
						visited[node] = true;
					}
				});
			}
		}
	}
}
