
package Graph;

import java.util.LinkedList;


public class StronglyConnectedInUndirected {
    
    int V;
    LinkedList<Integer>[] adjList;
    
    StronglyConnectedInUndirected(int V){
      this.V=V;
      adjList = new LinkedList[V];
      
        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }
    
    
    
    
    // Adds an edge to an undirected graph
    void addEdge(int src, int dest)
    {
        // Add an edge from src to dest.
        adjList[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjList[dest].add(src);
    }
    
    
    
    
    
    void connected(){
      
        boolean[] isVisited  = new boolean[V];
        
        for(int v=0; v<V; v++){
        
            if(!isVisited[v]){
              connectedUtil(isVisited,v);
              System.out.println();
            }
            
        }
    }

    public static void main(String[] args) {

        StronglyConnectedInUndirected g = new StronglyConnectedInUndirected(5); // 5 vertices numbered from 0 to 4

        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        System.out.println("Following are connected components");
        g.connected();

    }

    private void connectedUtil(boolean[] visited, int v) {
        
        visited[v]=true;
        
        System.out.print(v+" ");
        
        for(int x: adjList[v]){
          
            if(!visited[x])
                connectedUtil(visited,x);
         
        }
        
    }
    
}
