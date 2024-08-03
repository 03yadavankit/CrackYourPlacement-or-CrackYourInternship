class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            // Skip duplicate elements for the first number in the triplet
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int end = nums.length - 1;
            
            while (left < end) {
                int t = nums[i] + nums[left] + nums[end];
                if (t == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[end]));
                    left++;
                    end--;
                    // Skip duplicate elements for the second number in the triplet
                    while (left< end && nums[left] == nums[left - 1]) left++;
                    // Skip duplicate elements for the third number in the triplet
                    while (left < end && nums[end] == nums[end + 1]) end--;
                } else if (t < 0) {
                    left++;
                } else {
                    end--;
                }
            }
        }
        
        return ans;
    }
}
