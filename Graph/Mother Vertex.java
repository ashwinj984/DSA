import java.io.*;
import java.util.*;


public class Main {
  public static void main(String args[]) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      int u = Integer.parseInt(st[0]) - 1;
      int v = Integer.parseInt(st[1]) - 1;
      graph.get(u).add(v);
    }

    System.out.println(findMotherVertex(n, graph));
  }
 
  public static int findMotherVertex(int n, ArrayList<ArrayList<Integer>>adj) {
    Stack<Integer> st = new  Stack<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj, st);
      }
    }
    int pans = st.peek();
    visited = new boolean[n];
    count = 0;
    dfs(pans, visited, adj);
    if(count == n){
    // cause 1-indexed
        return pans + 1;
    }else{
        return -1;
    }
  }

  public static void  dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>>adj, Stack<Integer> st){
      visited[curr] = true;
      
      for(int nbrs : adj.get(curr)){
          if(visited[nbrs] == false){
              dfs(nbrs, visited, adj, st);
          }
      }
      st.push(curr);
  }
  static int count;
  public static void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>>adj) {
     visited[curr] = true;
      count++;
      for(int nbrs : adj.get(curr)){
          if(visited[nbrs] == false){
              dfs(nbrs, visited, adj);
          }
      }
  }
}
