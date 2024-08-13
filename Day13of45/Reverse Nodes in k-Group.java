package Day13of45;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        while (count >= k) {
            ListNode current = temp.next;
            ListNode prev = null;
            ListNode next = null;
            ListNode groupHead = current;

            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            temp.next = prev;
            groupHead.next = current;

            temp = groupHead;

            count -= k;
        }

        return dummy.next;
    }
}
