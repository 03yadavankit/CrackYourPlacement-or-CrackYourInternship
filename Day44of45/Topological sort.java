package Day44of45;

class Solution
{
    
    static void dfs(int i, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        
        vis[i] = 1;
        
        for(int it : adj.get(i)){
            if(vis[it] == 0){
                dfs(it, vis, adj, st);
            }
        }
        st.add(i);
        
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[V];
        for(int i = 0; i<V;i++){
            if(vis[i] == 0){
                dfs(i, vis, adj, st);
            }
        }
        int k = 0;
        while(!st.isEmpty()){
            ans[k++] = st.pop();
        }
        return ans;
    }
}