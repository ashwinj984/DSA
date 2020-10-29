import java.io.*;
import java.util.*;

public class Main {
    public static class Edge{
        int v;
        int nbr;
        
        Edge(int v,int nbr){
            this.v = v;
            this.nbr = nbr;
        }
    }
   

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      
      for(int i = 0; i < n; i++){
          graph[i] = new ArrayList<>();
      }
      for(int i = 0; i < k; i++){
          String s = br.readLine();
          String[] parts = s.split(" ");
          int v1 = Integer.parseInt(parts[0]);
          int v2 = Integer.parseInt(parts[1]);
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
          
      }
      
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      boolean[] visited = new boolean[n];
      for(int v = 0; v < n; v++){
          if(visited[v] == false){
              ArrayList<Integer> comp = new ArrayList<>();
              drawTree(graph,v,comp,visited);
              comps.add(comp);
          }
      }
      
      int pairs = 0;
      
      for(int i = 0; i < comps.size(); i++){
          for(int j = i + 1; j < comps.size(); j++){
              int count = comps.get(i).size() * comps.get(j).size();
              pairs+= count;
          }
      }
      System.out.println(pairs);
   }
   
   public static void drawTree(ArrayList<Edge>[] graph,int src,ArrayList<Integer> comp,boolean[] visited){
       visited[src] = true;
       comp.add(src);
       for(Edge edge : graph[src]){
           if(visited[edge.nbr] == false){
               drawTree(graph,edge.nbr,comp,visited);
           }
       }
   }

}
