package Day07of45;

import java.util.Arrays;

class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int i =0;
        int j = 1;
        while(j < n && i < n){
            if(arr[j]-arr[i] == x && i != j)return 1;
            else if(arr[j]-arr[i] < x)j++;
            else {
                i++;
            }
        }
        return -1;
    }
}
