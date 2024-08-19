package Day19of45;

class Solution {
    public int splitArray(int[] nums, int k) {
        // Initialize min and max
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        // Calculate the actual bounds
        int l = max;
        int h = 0;
        for (int num : nums) {
            h += num;
        }

        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (canSplit(nums, mid, k)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean canSplit(int[] nums, int maxSum, int k) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num > maxSum) {
                sum = num;
                count++;
                if (count > k) {
                    return false;
                }
            } else {
                sum += num;
            }
        }
        return true;
    }
}
