package Day14of45;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            
            nextGreaterMap.put(current, stack.isEmpty() ? -1 : stack.peek());
            
            stack.push(current);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}