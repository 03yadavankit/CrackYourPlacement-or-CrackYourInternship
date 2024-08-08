package Day08of45;

import java.util.Arrays;

class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
      // Your code goes here.
       if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must be of the same length.");
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr2.length / 2; i++) {
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length - 1 - i];
            arr2[arr2.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] + arr2[i] < k) {
                return false;
            }
        }

        return true;
        
    }
}