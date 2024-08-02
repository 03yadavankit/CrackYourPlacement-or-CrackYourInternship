class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int res[] = new int[n+2];

        Arrays.fill(res,-1);

        for(int i = 0;i<n;i++){
            if(res[nums[i]]==nums[i])
                return nums[i];
            else
                res[nums[i]]=nums[i];

        }

        return 0;
    }
}