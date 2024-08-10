package Day10of45;

class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        
        while (head != null) {
            decimalValue = (decimalValue << 1) | head.val;
            head = head.next;
        }
        
        return decimalValue;
    }
}

