class Solution {
    class Edge{
        int src;
        int nbr;
        int wt;
        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    class Pair implements Comparable<Pair>{
        int src;
        int wsf;
            Pair(int src, int wsf){
            this.src = src;
            this.wsf = wsf;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    
    public ArrayList<Edge>[] buildGraph(int[][] times, int n){
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] t : times){
            graph[t[0]].add(new Edge(t[0], t[1], t[2]));
        }
        return graph;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = buildGraph(times,n);
        boolean[] visited = new boolean[n + 1];
      // Djikstra's Algrithm
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k, 0));
        int count = 0;
        while(pq.isEmpty() == false){
            Pair rem = pq.poll();
            if(visited[rem.src]){
                continue;
            }
            count++;
            if(count == n){
                return rem.wsf;
            }
            visited[rem.src] = true;
            
            
            for(Edge e : graph[rem.src]){
                pq.offer(new Pair(e.nbr, e.wt + rem.wsf));
            }
            
        }
        return -1;
    }
}



// 2nd Approach Using Bellman Ford
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // logic start
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[k] = 0;
        for(int i = 0; i <= n; i++){//i - 1 iterations
            for(int j = 0;  j  < times.length; j++){// for every index
                int u = times[j][0];
                int v = times[j][1];
                int wt = times[j][2];
                if(dp[u] == Integer.MAX_VALUE){
                    continue;
                }
                if(dp[u] + wt < dp[v]){
                    dp[v] = dp[u] + wt;
                }
            }
        }
        // logic end
        int max = -1;
        for(int i = 1; i <= n; i++){
            if(dp[i] == Integer.MAX_VALUE){
                return -1;
            }else
                max = Math.max(max, dp[i]);
        }
        return max;
    }
}
