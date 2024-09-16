package Day44of45;

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
      int mstCost = 0;
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
       int visisted[] = new int[V];
       pq.add(new int[]{0,0});
       
       while(!pq.isEmpty()){
           
           int cur[] = pq.poll();
           if(visisted[cur[0]] == 1) continue;
           visisted[cur[0]] = 1;
           mstCost += cur[1];
           
           List<int[]> adjnodeList = adj.get(cur[0]);
           for(int adjnode[] : adjnodeList){
               pq.add(new int[]{adjnode[0],adjnode[1]});
           }
       }
       
       return mstCost;
    }
}
