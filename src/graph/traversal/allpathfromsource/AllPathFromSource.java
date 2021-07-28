package graph.traversal.allpathfromsource;

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
	
	public static void main(String[] args) {
		AllPathFromSource allPath = new AllPathFromSource();
		int adjMatrix[][] = {{1,2},{3,},{3},{4},{}};
		allPath.allPathsSourceTarget(adjMatrix);
	}


	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		this.graph = graph;
		this.initialNode = 0;
		this.lastNode = graph.length - 1;
		
		allPathRecursive(initialNode, null);
		completeInitialNode();
		System.out.println(allPath.toString());
		return this.allPath;
	}

	private void completeInitialNode() {
		//this is a little awkward but it seems to be correct and the only option
		for (int i=0; i < this.allPath.size(); i++) 
			this.allPath.get(i).add(0, initialNode);
	}


	private void allPathRecursive(int v, List<Integer> path) {

		if (v == lastNode) {
			System.out.println("encontre");
			return;
		}
		
		for (int i = 0; i < this.graph[v].length; i++) {
			//at some point the code comeback to the initial iterarion
			//when this happens, we create a new array
			if (v == initialNode) {
				path = new ArrayList<Integer>();
				allPath.add(path);
			} 
			
			int currentNode = this.graph[v][i];
			allPathRecursive(currentNode, path);
			//this is the fundamental part: for previous experience (from tree algorithms)
			//we knows that the path from root to an specific node is obtained 
			//analizing the backtraking.
			path.add(0, currentNode);
		}
	}

}
