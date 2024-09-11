package Day41of45;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        bfs(adj, 0, list, visited);
        return list;
    }
    
    private void bfs(ArrayList<ArrayList<Integer>> adj, int curr, 
        ArrayList<Integer> list, boolean[] visited){
        Queue<Integer> queue = new LinkedList();
        queue.add(curr);
        visited[curr] = true;
        while(!queue.isEmpty()){
            int v = queue.remove();
            list.add(v);
            for(int neighbor : adj.get(v)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                } 
            }
        }
            
    }
}