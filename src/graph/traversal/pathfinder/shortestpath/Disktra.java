package graph.traversal.pathfinder.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;

public class Disktra {

	public static void main(String[] args) {
		//[[[1, 9]], [[0, 9]]]
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<Integer> aux1 = new ArrayList<Integer>();
		aux1.add(1);
		aux1.add(9);
		
		ArrayList<ArrayList<Integer>> aux11 = new ArrayList<ArrayList<Integer>>();
		aux11.add(aux1);
		
		ArrayList<Integer> aux2 = new ArrayList<Integer>();
		aux2.add(0);
		aux2.add(9);
		
		ArrayList<ArrayList<Integer>> aux22 = new ArrayList<ArrayList<Integer>>();
		aux22.add(aux2);
		
		adj.add(aux11);
		adj.add(aux22);
		Disktra.dijkstra(2, adj, 0);
		
	}
	
	  //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        //System.out.println(adj.toString());
        boolean visited[] = new boolean[V];
        int distanceFromSource[] = new int[V];
        initialize(distanceFromSource, S);
        
        while (true) { //Im not shure about this loop
            int minPathNode = findNodeWithMinPathFromZero(visited, distanceFromSource);
            if (minPathNode == -1) break;
            
            adj.get(minPathNode).forEach(node ->{
                int neighbourd = node.get(0);
                int disToNeighbourd = node.get(1);
                
                relaxing(minPathNode, neighbourd, disToNeighbourd, distanceFromSource);
                
            });
            visited[minPathNode] = true;
        }
        
        System.out.println("Salida " + Arrays.toString(distanceFromSource));
        return distanceFromSource;
    }
    
    //O(n) this have to be improved.
    static int findNodeWithMinPathFromZero(boolean visited[], int distanceFromSource[]){
        int result = -1;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < distanceFromSource.length ; i++) {
            //the visitied check is in the relaxing method
            if (!visited[i] && (distanceFromSource[i] < minDistance)) {
                minDistance = distanceFromSource[i];
                result = i;
            }
        }    
        
        return result;
    }
    
    static void initialize(int[] distance, int source){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
    }
    
    static void relaxing (int node, int neighbourd, int disToNeighbourd, 
                        int distanceFromSource[]) {
        //System.out.println("node " + node + " neighbourd "+ neighbourd + " ditToNeig " + disToNeighbourd);                    
       
        int newPathDistance = distanceFromSource[node] + disToNeighbourd;
        if (newPathDistance < distanceFromSource[neighbourd]) {
            distanceFromSource[neighbourd] = newPathDistance;
        }
        //System.out.println("distance from source " + distanceFromSource[neighbourd]);
    }

}
