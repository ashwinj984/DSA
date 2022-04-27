// template for Union Find
public class UnionFind {
	int[] parent;
	public UnionFind(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int i) {
		if(parent[i] == i) {
			return parent[i];
		}
		
		parent[i] = find(parent[i]);
		return parent[i];
	}
	
	public void union(int i, int j) {
		int find1 = find(i);
		int find2 = find(j);
		if(find1 != find2) {
			parent[find2] = find1;
		}
	}
}
