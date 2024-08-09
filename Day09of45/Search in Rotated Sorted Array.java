package Day09of45;

class Solution {
    public int search(int[] nums, int target) {
        int mid, l=0,r=nums.length-1;

        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid]){
                if(target>=nums[l] && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=l+1;
                }
            }else{
                if(target>nums[mid] && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=r-1;
                }
            }
        }

        return -1;
    }
}
