package Day08of45;

class Solution {
    public int findPeakElement(int[] nums) {
        int st=0,end=nums.length-1;
        while(st<=end){
            int m = (st+end)/2;
            if((m==0||nums[m]>nums[m-1]) &&(m==nums.length-1|| nums[m]>nums[m+1]))
             return m;
            if(nums[m]<nums[m+1])
             st = m+1;
            else
                end =m-1;
        }

        return -1;
    }
}