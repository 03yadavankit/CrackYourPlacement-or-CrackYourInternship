class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> mp= new HashMap<>();
        mp.put(0,1);

        int prefix = 0, res = 0;

        for(int value: nums){
            prefix = (prefix + value%k +k)%k;
            res += mp.getOrDefault(prefix,0);
            mp.put(prefix,mp.getOrDefault(prefix,0)+1);
        }
        return res;
    }
}
