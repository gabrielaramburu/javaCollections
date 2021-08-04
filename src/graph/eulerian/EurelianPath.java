package graph.eulerian;

public class EurelianPath {

	public static void main(String[] args) {
		
	}
	
	  static int eulerPath(int N, int graph[][]){
	        int oddVertices = 0;
	        for (int i = 0; i < N; i++) {
	            int edges = 0;
	            
	            for (int j = 0; j < N; j++) {
	                edges+=graph[i][j];
	            }
	            
	            if ((edges % 2) != 0) {
	                oddVertices++;
	            }
	            
	            if (oddVertices > 2) return 0;
	        }
	        //eulerian path: all graphs have 0 or 2 vertices with odd grade
	        if (oddVertices == 0 || oddVertices == 2) return 1;
	        else return 0;
	    }
	  
	  //note: eulerian path is different to eulerian cycle.

}
