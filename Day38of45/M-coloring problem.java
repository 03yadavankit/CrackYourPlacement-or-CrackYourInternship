package Day38of45;

import java.util.*;

class solve {
    
    boolean graphColor(int s,ArrayList<ArrayList<Integer>> adj,int m,int[] vertices,boolean[] visited){
        
        visited[s]=true;
        int i=0;
        while(i<m){
            vertices[s]=i;
            int k=i;
            for(int u:adj.get(s)){
                if(vertices[u]==vertices[s]){
                    i++;
                    break;
                }
            }
            if(i==k){
                for(int u:adj.get(s)){
                    if(!visited[u]){
                        boolean b=graphColor(u,adj,m,vertices,visited);
                        if(b==false){
                            vertices[u]=-1;
                            visited[u]=false;
                            i++;
                            break;
                        }
                    }
                }
                if(i==k){
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        
        if(m==1 && n>1){
            return false;
        }
        
        int V=graph.length;
        int[] vertices=new int[V];
        boolean[] visited=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                }
            }
        }
        
        Arrays.fill(vertices,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(!graphColor(i,adj,m,vertices,visited)){
                    return false;
                }
            }
        }
        
        return true;
        
    }
}