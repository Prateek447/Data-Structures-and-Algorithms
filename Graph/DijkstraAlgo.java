
package Graph;

import java.util.Arrays;

public class DijkstraAlgo {
    
        static final int V = 9; 
    
     // A utility function to print the constructed distance array 
    void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source\n"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + "                " + dist[i]+"\n"); 
    } 
    
    
    //fun for finding min ditance vertex
   int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    
    //fun for finding min dis
    void djakstra(int src, Boolean[] spt, int[] dis, int[][] graph){
    
        dis[src]=0;
        
        for(int count=0; count<V-1; count++){
        
          int u =  minDistance(dis,spt);
          
          spt[u]=true;
       
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!spt[v] && graph[u][v] != 0 &&  
                   dis[u] != Integer.MAX_VALUE && dis[u] + graph[u][v] < dis[v]) 
                    dis[v] = dis[u] + graph[u][v]; 
        } 
  
        // print the constructed distance array 
        printSolution(dis, V); 
    } 
    
    
    public static void main(String[] ar){
     
         /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        
        Boolean[] b = new Boolean[V];
        int[] dis  = new int[V];
        Arrays.fill(b,false);
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        DijkstraAlgo obj = new DijkstraAlgo();
        obj.djakstra(0, b, dis, graph);
        
    
    }
    
}
