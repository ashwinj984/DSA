import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] parts = br.readLine().split(" ");
	    int n = Integer.parseInt(parts[0]);
	    int m = Integer.parseInt(parts[1]);
	    int[][] edges = new int[m][3];
	    for(int i = 0; i < m; i++){
	        parts = br.readLine().split(" ");
	        edges[i][0] = Integer.parseInt(parts[0]);
	        edges[i][1] = Integer.parseInt(parts[1]);
	        edges[i][2] = Integer.parseInt(parts[2]);
	    }
	    // 1 -> negative weight cycle detected
    // 0 -> not detected
	    System.out.println(isNegativeCycleDetected(n, edges));
	}
	
	public static int isNegativeCycleDetected(int n, int[][] edges){
	    int[] dp = new int[n];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for(int i = 0; i < n - 1; i++){
	        for(int j = 0; j < edges.length; j++){
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int wt = edges[j][2];
	            
	            if(dp[u] == Integer.MAX_VALUE){
	                continue;
	            }
	            
	            if(dp[u] + wt < dp[v]){
	                dp[v] = dp[u] + wt;
	            }
	        }
	    }
	    for(int j = 0; j < edges.length; j++){
	            int u = edges[j][0];
	            int v = edges[j][1];
	            int wt = edges[j][2];
	            
	            if(dp[u] == Integer.MAX_VALUE){
	                continue;
	            }
	            
	            if(dp[u] + wt < dp[v]){
	                return 1;
	            }
	        }
	        return 0;
	}
}
