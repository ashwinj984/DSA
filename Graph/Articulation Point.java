
import java.util.*;
import java.io.*;

public class Map_Sum_Pairs {

	static int[] parent;
	static int[] disc;
	static int[] low;
	static int time;
	static boolean[] visited;
	static boolean[] articulation;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int e = scn.nextInt();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			graph.add(i, new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			int u = scn.nextInt() - 1;
			int m = scn.nextInt() - 1;
			graph.get(u).add(m);
			graph.get(m).add(u);
		}

		parent = new int[v];
		parent[0] = -1;
		disc = new int[v];
		low = new int[v];
		time = 0;
		visited = new boolean[v];
		articulation = new boolean[v];

		dfs(0, graph);
		int ans = 0;
		for(int i = 0; i < v; i++) {
			if(articulation[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static void dfs(int u, ArrayList<ArrayList<Integer>> graph) {
		disc[u] = low[u] = time++;
		int count = 0;
		visited[u] = true;
		ArrayList<Integer> nbrs = graph.get(u);
		for (int i = 0; i < nbrs.size(); i++) {
			int v = nbrs.get(i);
			if (parent[u] == v) {
				continue;
			} else if (visited[v] == true) {
				low[u] = Math.min(low[u], disc[v]);
			} else {
				parent[v] = u;
				dfs(v, graph);
				count++;
				low[u] = Math.min(low[u], low[v]);
				if(parent[u] == -1) {
					if(count >= 2) {
						articulation[u] = true;
					}
				}else {
					if(low[v] >= disc[u]) {
						articulation[u] = true;
					}
				}
			}
		}
	}

}
