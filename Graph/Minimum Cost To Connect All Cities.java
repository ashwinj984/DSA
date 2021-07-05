import java.io.*;
import java.util.*;

public class Main {
  static class Edge implements Comparable<Edge> {
    int v;
    int wt;

    Edge(int nbr, int wt) {
      this.v = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for(int i = 0; i < n; i++){
        graph.add(i, new ArrayList<>());
    }
    
    for(int i = 0; i < m; i++){
        String[] parts = br.readLine().split(" ");
        int u = Integer.parseInt(parts[0]);
        int v = Integer.parseInt(parts[1]);
        int wt = Integer.parseInt(parts[2]);
        graph.get(u).add(new Edge(v, wt));
        graph.get(v).add(new Edge(u, wt));
    }
    // Prim's Algorithm
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[n];
    int ans = 0;
    
    pq.add(new Edge(0, 0));
    while(pq.size() > 0){
        Edge rem = pq.remove();
        if(visited[rem.v]){
            continue;
        }
        visited[rem.v] = true;
        ans += rem.wt;
        for(Edge val : graph.get(rem.v)){
            if(!visited[val.v]){
                pq.add(val);
            }
        }
    }
    System.out.println(ans);

  }

}
