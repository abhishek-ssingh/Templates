class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res=  new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];
        
        q.offer(0);
        vis[0] = true;
        
        while(!q.isEmpty()){
            int val = q.poll();
            
            for(int i: adj.get(val)){
                if(vis[i]!=true) {
                    q.add(i);
                    vis[i] = true;
                }
            }
          
            res.add(val);
        }
        
        return res;
    }
}
