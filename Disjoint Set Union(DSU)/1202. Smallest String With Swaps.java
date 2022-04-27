class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
		char[] ch = s.toCharArray();
		UnionFind uf = new UnionFind(ch.length);
		for(List<Integer> pair : pairs){
			uf.union(pair.get(0), pair.get(1));
		}
		for(int i = 0; i < ch.length; i++) {
			int parent = uf.find(i);
			PriorityQueue<Character> pq = map.getOrDefault(parent, new PriorityQueue<Character>());
			pq.offer(ch[i]);
			map.putIfAbsent(parent, pq);
		}
		
		for(int i = 0; i < ch.length; i++) {
			int parent  = uf.find(i);
			ch[i] = map.get(parent).poll();
		}
		
		return new String(ch);
    }
    private class UnionFind {
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

}
