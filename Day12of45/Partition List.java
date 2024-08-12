package Day12of45;

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode newHead1 = null;
        ListNode tail1 = null;
        ListNode newHead2 = null;
        ListNode tail2 = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null; 

            if (temp.val < x) {
                if (newHead1 == null) {
                    newHead1 = temp;
                    tail1 = temp;
                } else {
                    tail1.next = temp;
                    tail1 = temp;
                }
            } else {
                if (newHead2 == null) {
                    newHead2 = temp;
                    tail2 = temp;
                } else {
                    tail2.next = temp;
                    tail2 = temp;
                }
            }
        }

        if (newHead1 == null) {
            return newHead2;
        }

        tail1.next = newHead2;
        return newHead1;
    }
}