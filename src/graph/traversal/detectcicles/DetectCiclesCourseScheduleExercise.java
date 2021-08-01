package graph.traversal.detectcicles;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/course-schedule/
public class DetectCiclesCourseScheduleExercise {

	List<List<Integer>> adjList;
	boolean visited[];
	boolean currentPath[];
	boolean cicleDetected;
	
	public static void main(String[] args) {

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		buildGraph(numCourses, prerequisites);
		System.out.println(adjList.toString());
		visited = new boolean[numCourses];
		currentPath = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (cicleDetected)
				break;

			if (!visited[i]) {
				dfs(i);
			}
		}
		return cicleDetected ? false : true;
	}

	private void dfs(int node) {
		visited[node] = true;
		currentPath[node] = true;

		for (int i : adjList.get(node)) {
			// if i node belong to path then exists a back edge, therefoer exists a cicle on
			// graph.
			cicleDetected = currentPath[i];
			if (cicleDetected)
				break;

			if (!visited[i]) {
				dfs(i);
			}
		}

		currentPath[node] = false;
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
