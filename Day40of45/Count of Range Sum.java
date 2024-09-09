package Day40of45;

class Solution {
    private int[] nums;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        mergeSort(0, nums.length - 1);
        return(nums);     
    }
    
    private void mergeSort(int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }
    
    private void merge(int low, int mid, int high) {
        int[] helper = new int[high - low + 1];
        for (int i = low; i <= high; i++) helper[i - low] = nums[i];
        
        int i = low, j = mid + 1;
        int idx = low;
        
        while (i <= mid && j <= high) {
            if (helper[i - low] < helper[j - low]) {
                nums[idx++] = helper[i++ - low];
            } else {
                nums[idx++] = helper[j++ - low];
            }
        }
        
        while (i <= mid) {
            nums[idx++] = helper[i++ - low];
        }
    }
    
}