package Day41of45;

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]) dfs(adj, i, list, visited);
        }
        return list;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> adj, int curr, ArrayList<Integer> list, boolean[] visited){
        visited[curr]=true;
        list.add(curr);
        for(int neighbor : adj.get(curr)){
            if(!visited[neighbor]) dfs(adj, neighbor, list, visited);
        }
    }
}