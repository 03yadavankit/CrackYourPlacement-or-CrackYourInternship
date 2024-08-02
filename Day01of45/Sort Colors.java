// using count sort
class Solution {
    public void sortColors(int[] nums) {
        int color[] = {0,0,0};

        for(int i=0;i<nums.length;i++){
            color[nums[i]]++;
        }

        int k=0;
        for(int i=0;i<color[0];i++)
            nums[k++]=0;

        for(int i=0;i<color[1];i++)
            nums[k++]=1;
        
        for(int i=0;i<color[2];i++)
            nums[k++]=2;
    }
}

//using Dutch National Flag Algorithm
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    int temp0 = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp2;
                    high--;
                    break;
            }
        }
    }
}
