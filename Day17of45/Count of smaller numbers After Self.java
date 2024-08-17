package Day17of45;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
            result[i] = 0;
        }
        mergeSort(nums, indexes, result, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(result[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] indexes, Integer[] result, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, indexes, result, left, mid);
        mergeSort(nums, indexes, result, mid + 1, right);
        merge(nums, indexes, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indexes, Integer[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0, rightCounter = 0;
        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k] = indexes[j];
                rightCounter++;
                j++;
            } else {
                temp[k] = indexes[i];
                result[indexes[i]] += rightCounter;
                i++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = indexes[i];
            result[indexes[i]] += rightCounter;
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = indexes[j];
            j++;
            k++;
        }
        for (int p = 0; p < temp.length; p++) {
            indexes[left + p] = temp[p];
        }
    }
}
