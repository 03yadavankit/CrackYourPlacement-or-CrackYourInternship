class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);  
        int count = 0;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
            if (sums.containsKey(sum - k)) {
                count += sums.get(sum - k);
            }
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
