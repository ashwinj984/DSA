class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> graph)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                dfs(visited, graph, i, st);   
            }
        }
        
        ArrayList<ArrayList<Integer>> newGraph = transpose(graph,n);
        visited = new boolean[n];
        int count = 0;
        while(!st.isEmpty()){
            int val = st.pop();
            
            if(visited[val] == false){
                newDfs(newGraph, visited, val);
                count++;
            }
        }
        return count;
    }
    private void newDfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int curr){
        visited[curr] = true;
        for(var nbrs : graph.get(curr)){
            if(visited[nbrs] == false){
                newDfs(graph, visited, nbrs);
            }
        }
    }
    private void dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int curr, Stack<Integer> st){
        visited[curr] = true;
        for(var nbrs : graph.get(curr)){
            if(visited[nbrs] == false){
                dfs(visited, graph, nbrs,st);
            }
        }
        st.push(curr);
    }
    private ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> graph , int n){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(i, new ArrayList<>());
        }
        
        for(int i = 0; i < n; i++){
            for(int nbrs : graph.get(i)){
                res.get(nbrs).add(i);
            }
        }
        return res;
    }
}

