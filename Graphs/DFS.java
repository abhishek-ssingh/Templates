class Solution {
    
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result){
        vis[node] = true;
        result.add(node);
        
        for(int i: adj.get(node)){
            if(!vis[i]) dfs(i, vis, adj, result);
        }
        
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[V];
        
        for(int i=0; i<vis.length; i++){
            if(!vis[i]) dfs(i, vis, adj, result);
        }
        
        return result;
    }
}
