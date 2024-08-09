package Day09of45;

class Solution
{
    static int missingNumber(int arr[], int size)
    {
        int shift = segregate(arr, size);
        return findMissingPositive(arr, size - shift, shift);
    }
    static int segregate(int arr[], int size) {
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return j; 
    }

    static int findMissingPositive(int arr[], int size, int startIndex) {
        for (int i = startIndex; i < size + startIndex; i++) {
            int absValue = Math.abs(arr[i]);
            if (absValue - 1 < size && arr[absValue - 1 + startIndex] > 0) {
                arr[absValue - 1 + startIndex] = -arr[absValue - 1 + startIndex];
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i + startIndex] > 0) {
                return i + 1;
            }
        }
        return size + 1;
    }
}
