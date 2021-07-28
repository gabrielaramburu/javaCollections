package graph.traversal.pathfinder.allpathfromsource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * 
 */
public class AllPathFromSource {
	int[][] graph;
	int lastNode;
	int initialNode;
	
	List<List<Integer>> allPath = new ArrayList<List<Integer>>();
	List<Integer> currentPath = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		AllPathFromSource allPath = new AllPathFromSource();
		int adjMatrix[][] = {{4, 3, 1},{3, 2, 4},{3},{4},{}};
		allPath.allPathsSourceTarget(adjMatrix);
	}


	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		this.graph = graph;
		this.initialNode = 0;
		this.lastNode = graph.length - 1;
		
		allPathRecursive(initialNode);
		System.out.println(allPath.toString());
		return this.allPath;
	}

	private void allPathRecursive(int v) {
		//the key point to remember is that in this kind of graph problems, we just keep one array reference and
		//keep it update erasing the elements at the backtracking
		currentPath.add(v);
		
		if (v == lastNode) {
			allPath.add(List.copyOf(currentPath));
			
			//this's the critic part to understand
			currentPath.remove(currentPath.size()-1);
			return;
		}
		
		for (int i = 0; i < this.graph[v].length; i++) {	
			int currentNode = this.graph[v][i];
			allPathRecursive(currentNode);
		}
		
		//this's the critic part to understand
		currentPath.remove(currentPath.size()-1);
	
	}

}
