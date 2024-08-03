class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i+1; j < nums.length-2; j++) { 
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;        
                int left = j + 1;
                int end = nums.length - 1;
                
                while (left < end) {
                    long t = (long)nums[i] + nums[j] + nums[left] + nums[end];
                    if (t == target) {
                        ans.add(Arrays.asList(nums[i],nums[j], nums[left], nums[end]));
                        left++;end--;
                        while (left< end && nums[left] == nums[left - 1]) left++;
                        while (left < end && nums[end] == nums[end + 1]) end--;
                    } else if (t < target) {
                        left++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return ans;
    }
}