package Day45of45;

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int []color=new int[V];
         Arrays.fill(color, -1);
     
         for(int i=0;i<V;i++){
              if(color[i]==-1){
                    color[i]=0;
                    if(getDFS(i,adj,color)==false)
                          return false;
                }
         }
        return true;
    }
    public boolean getDFS( int node, ArrayList<ArrayList<Integer>>adj, int []color){
             int size=adj.get(node).size();
      
             for(int j=0;j<size;j++){
                int current=adj.get(node).get(j);
                if(color[current]==-1){
                    color[current]=(color[node]+1)%2;
                    if(getDFS(current,adj,color)==false){
                        return false;
                    }
                }else{
                    if(color[node]==color[current]){
                         return false;
                     }
                }
                
            }
            
        
     
       return true;
     }
public boolean getBFS(int V, ArrayList<ArrayList<Integer>>adj){
    
      int []color=new int[V];
      Arrays.fill(color, -1);
      Queue<Integer>q= new LinkedList<Integer>();
      for(int i=0;i<V;i++){
         if(color[i]==-1){
            color[i]=0;
            q.add(i);
            while(!q.isEmpty()){
                 int node= q.peek();
                 q.remove();
                 int size=adj.get(node).size();
             for(int j=0;j<size;j++){
                int current=adj.get(node).get(j);
                if(color[current]==-1){
                    color[current]=(color[node]+1)%2;
                    q.add(current);
                }else{
                    if(color[node]==color[current]){
                         return false;
                     }
                }
                
            }
           }   
         }   
      }
     
       return true;
     }
    
}