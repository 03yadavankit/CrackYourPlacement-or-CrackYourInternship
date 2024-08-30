class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans =new int[n-k+1];
        int index=0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        Map<Integer, Integer> mp =new HashMap<Integer, Integer>();
        for(int i=0;i<k;i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }
            else {
                mp.put(nums[i],1);
            }
            pq.add(nums[i]);
        }
        ans[index]=pq.peek();
        index++;
        for(int i=k;i<n;i++){
            pq.add(nums[i]);
            
            mp.put(nums[i-k],mp.get(nums[i-k])-1);
            
            if(mp.containsKey(nums[i])){
                mp.put(nums[i],mp.get(nums[i])+1);
            }
            else {
                mp.put(nums[i],1);
            }

            while(mp.get(pq.peek())==0){
                pq.poll();
            }
            ans[index]=pq.peek();
            index++;
            
        }
        return ans;
    }
}