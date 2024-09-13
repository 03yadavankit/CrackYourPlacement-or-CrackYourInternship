package Day43of45;


//User function Template for Java
class Solution{
    private void dfs(int node, boolean []vis, ArrayList<ArrayList<Integer>> adj,
                    Stack<Integer> st) {
       vis[node] = true;
       for (Integer it : adj.get(node)) {
           if (!vis[it]) {
               dfs(it, vis, adj, st);
           }
       }
       st.push(node);
   }
   private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
       vis[node] = true;
       for (Integer it : adjT.get(node)) {
           if (!vis[it]) {
               dfs(it, vis, adjT);
           }
       }
   }
   
   //Function to find number of strongly connected components in the graph.
   public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
       Stack<Integer> s = new Stack<>();
       boolean[] visited = new boolean[V];
       for(int i = 0; i<V; i++){
           if(!visited[i]) dfs(i, visited, adj, s);
       }
       
       ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
       for(int i = 0; i<V; i++) newAdj.add(i, new ArrayList<>());
       for(int i = 0; i<V; i++){
           visited[i] = false;
           for(int it : adj.get(i)){
               newAdj.get(it).add(i);
           }
       }
       
       int scCmp = 0;
       while(!s.isEmpty()){
           int nd = s.pop();
           if(!visited[nd]){
               scCmp++;
               dfs(nd, visited, newAdj);
           }
       }
       return scCmp;
   }
}