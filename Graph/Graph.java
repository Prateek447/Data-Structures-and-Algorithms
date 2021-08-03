
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Graph {
    
    
    class Node{
    
      int data;
      Node next;
      Node(int data){
       this.data = data;
       next=null;
      }
}
    
    
    void addEdge(int src , int des, List<ArrayList<Integer>> l){
        l.get(src).add(des);
    }
    
    
    
    void removeEdge(ArrayList<ArrayList<Integer>> al, int src, int des){
       ArrayList<Integer>  l = al.get(src);
       l.remove((Integer)des);
       ArrayList<Integer>  l2 =  al.get(des);
         l2.remove((Integer)src);
    }
    
    void bfs(List<ArrayList<Integer>> l, int src){
     
        boolean[]  isVisited = new boolean[l.size()+1];
        Arrays.fill(isVisited,false);
        
        Queue q =  new LinkedList<Node>();
        q.add(src);
        isVisited[src]=true;
        
        while(!q.isEmpty()){
            
            int vertex =  (int)q.poll();
            
            System.out.print(" "+vertex);
            
            for(int i=0; i<l.get(vertex).size(); i++){
            
                int des = l.get(vertex).get(i);
                
                if(isVisited[des]==false){
                   isVisited[des]=true;
                   q.add(des);
                }
                 
            }
        
        }
        
    
    }
    
    
    void printList(List<ArrayList<Integer>> list){
    
        for(int i=0; i<list.size(); i++){
        
            System.out.print(i+"-->");
            for(int j=0; j<list.get(i).size(); j++){
             System.out.print(list.get(i).get(j)+"-->");
            }
            System.out.println();
        
        }
    
    }
    
    
    void dfs(List<ArrayList<Integer>> list, int src, boolean[] isVisited){
    
        
        isVisited[src]=true;     
        System.out.print(src+"->");
         
        Iterator itr  =  list.get(src).iterator();
        
        while(itr.hasNext()){
            int nxt =  (int)itr.next();
            if(isVisited[nxt]==false)
                dfs(list,nxt,isVisited);
        }
    
    }
    
    void dfsUsingStack(List<ArrayList<Integer>> list,int src,  boolean[] isVisited){
        
        Stack s = new Stack<Integer>();
        s.push(src);
        isVisited[src]=true;
        
        while(!s.empty()){
        
            int val = (int)s.pop();
            
            System.out.print(val+" ");
            for(int i=0; i<list.get(val).size(); i++){
                int nxt  = list.get(val).get(i);
                if(isVisited[nxt]==false){
                   isVisited[nxt]=true;
                    s.push(nxt);
                }

            }
        
        }
        
        
    }
    
    boolean cycleUtil(List<ArrayList<Integer>> list, int src, boolean[] isVisited){
          
        if(isVisited[src])
            return true;
        
        isVisited[src]=true;
        
        
        Iterator itr = list.get(src).iterator();
        
        boolean flag = true;
        
        while(itr.hasNext()){
          
            flag = false;
            int nxt  = (int)itr.next();
            
            if(cycleUtil(list,nxt,isVisited))
                return true;
            
            isVisited[src]=false;
        }
        
        if(flag)
            isVisited[src]=false;
        
        return false;
    }
    
    boolean isCycle(List<ArrayList<Integer>> list){
         
        boolean[]  b  = new boolean[list.size()];
        Arrays.fill(b,false);
        
       
    
        for(int i=0; i<list.size(); i++){
            
           Iterator itr = list.get(i).iterator();
           while(itr.hasNext()){
              int n = (int)itr.next();
              if(cycleUtil(list,n,b)){
                  return true;
              }
              
           }
         
        }
        return false;
    }
    
    
    void dfsUtil(List<ArrayList<Integer>> l,int src, boolean[] b, Stack<Integer> s){
    
          
         if(b[src])
            return;
        
          b[src]=true;
          
          Iterator itr  = l.get(src).iterator();
          while(itr.hasNext()){
           
              int n = (int)itr.next();
              dfsUtil(l,n,b,s);
          }
          
          s.push(src);
    
    }
    
    void topologicalSort(List<ArrayList<Integer>> list){
           
        boolean[] isVisited = new boolean[list.size()];
        Arrays.fill(isVisited, false);
        
        Stack<Integer> stack =  new Stack<Integer>();
        
        for(int i = 1; i<7; i++){
            dfsUtil(list,i,isVisited,stack);
        }
        
        while(!stack.empty()){
         System.out.print(stack.peek()+" ");
         stack.pop();
        }
    
    }
    
    
    
    public static void main(String[] ar){
    
    List<ArrayList<Integer>>  list = new  ArrayList<ArrayList<Integer>>(7);
    
    
     Graph g = new Graph();
     
     for(int i=0; i<7; i++){
       list.add(new ArrayList<>());
     }
     
  
     g.addEdge(1, 4, list);
     g.addEdge(2, 1, list);
     g.addEdge(2, 4, list);
     g.addEdge(2, 5, list);
     g.addEdge(3, 2, list);
     g.addEdge(3, 5, list);
     g.addEdge(5,4,list);
     g.addEdge(6, 5, list);
     g.addEdge(6, 3, list);
     
     
//     g.printList(list);
//     
//     g.bfs(list, 1);
//     
//     System.out.println();
//     
//     boolean[] isVisited = new boolean[7];
//     Arrays.fill(isVisited, false);
     
     //g.dfs(list, 1, isVisited);
     
     System.out.println();
//     g.dfsUsingStack(list, 1, isVisited);

g.topologicalSort(list);
     
     boolean t = g.isCycle(list);
     
     if(t)
         System.out.println("Cycle is present");
     else
         System.out.println("Cycle is Not present");
     
    
    }
}
