package graph.traversal.detectcycles;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class DetectCyclesCourseScheduleExercise {

	List<List<Integer>> adjList;
	boolean visited[];
	boolean currentPath[];
	boolean cycleDetected;
	
	public static void main(String[] args) {
		DetectCyclesCourseScheduleExercise cicleDetect = new DetectCyclesCourseScheduleExercise();
		int test1[][] = {{0,1},{0,2},{1,0}};
		System.out.println("Expected false, result:" + cicleDetect.canFinish(3, test1));
		
		
		cicleDetect = new DetectCyclesCourseScheduleExercise();
		int test2[][] = {{1,0},{0,1}};
		System.out.println("Expected false, result:" + cicleDetect.canFinish(2, test2));
		
		cicleDetect = new DetectCyclesCourseScheduleExercise();
		int test3[][] = {{1,0},{2,0}, {0,1}};
		System.out.println("Expected false, result:" + cicleDetect.canFinish(3, test3));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		buildGraph(numCourses, prerequisites);
		System.out.println("Input " + adjList.toString());
		visited = new boolean[numCourses];
		currentPath = new boolean[numCourses]; 
		//to use an stack is more intuitive but in this problem is also possible to use a array
		//this improve the orden of the cycle detection from O(n) to O(1) where n is the number of 
		//nodes in the current path.

		for (int i = 0; i < numCourses; i++) {
			if (cycleDetected)
				break;

			if (!visited[i]) {
				dfs(i);
			}
		}
		return cycleDetected ? false : true;
	}

	private void dfs(int node) {
		visited[node] = true;
		currentPath[node] = true;

		for (int i : adjList.get(node)) {
			// if i node belong to path then exists a back edge, therefore exists a cycle on
			// graph.
			detectCycles(i);
			
			if (cycleDetected) break;

			if (!visited[i]) {
				dfs(i);
			}
		}

		currentPath[node] = false;
	}

	private void detectCycles(int i) {
		if (currentPath[i]) {
			cycleDetected = true;
		}
	}

	private void buildGraph(int numCourses, int[][] prerequisites) {
		adjList = new ArrayList<List<Integer>>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int[] prerequisite : prerequisites) {
			adjList.get(prerequisite[1]).add(prerequisite[0]);
		}
	}

}
