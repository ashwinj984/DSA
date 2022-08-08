class Solution {
    HashMap<String,PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<String>();
    public List<String> findItinerary(List<List<String>> tickets) {
        if(tickets.size() == 0){
            return new LinkedList<String>();
        }
        
        for(var t : tickets){
            PriorityQueue<String> pq = map.getOrDefault(t.get(0), new PriorityQueue<>());
            pq.add(t.get(1));
            map.put(t.get(0),pq);
        }
        
        dfs("JFK");
        return ans;
    }
    
    public void dfs(String s){
        PriorityQueue<String> pq = map.get(s);
        while(pq != null && pq.size() > 0){
            dfs(pq.poll());
        }
        ans.addFirst(s);
    }
}
