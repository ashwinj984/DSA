import java.util.*;
import java.io.*;

class Main {
    static int[] parent;
    static int[] disc;
    static int[] low;
    static int timer;
    static boolean[] visited;
    static List<List<Integer>> ans;
  public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> Edges) {
    List<List<Integer>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++){
        graph.add(new ArrayList<>());
    }
    
    for(int i =0; i < Edges.size(); i++){
        int u = Edges.get(i).get(0);
        int v = Edges.get(i).get(1);
        
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    parent = new int[n];
    disc = new int[n];
    low = new int[n];
    visited = new boolean[n];
    timer = 0;
    parent[0] = -1;
    ans = new ArrayList<>();
    dfs(0, graph);
    return ans;
  }
  
  public static void dfs(int u, List<List<Integer>> graph){
    disc[u] = low[u] = timer++;
    visited[u] = true;
    for(int nbrs : graph.get(u)){
        if(parent[u] == nbrs){
            continue;
        }else if(visited[nbrs]){
            low[u] = Math.min(low[u], disc[nbrs]);
        }else{
            parent[nbrs] = u;
            dfs(nbrs, graph);
            low[u] = Math.min(low[u], low[nbrs]);
            if(low[nbrs] > disc[u]){
                List<Integer> list = new ArrayList<>();
                list.add(u);
                list.add(nbrs);
                ans.add(list);
            }
        }
        
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);
    List<List<Integer>> edges = new ArrayList<>();


    for (int i = 0; i < e; i++) {
      edges.add(new ArrayList<>());
      st = br.readLine().split(" ");
      edges.get(i).add(Integer.parseInt(st[0]));
      edges.get(i).add(Integer.parseInt(st[1]));
    }

    System.out.println(criticalConnections(n, edges));

  }

}
