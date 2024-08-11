package Day11of45;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode reverseList(ListNode head) 
    {
        ListNode newHead=null;
        
        while(head!=null){
            ListNode tmpNode=head;
            head=head.next;           
            tmpNode.next=newHead;
            newHead=tmpNode;          
        }

        return newHead;
    }


    public boolean isPalindrome(ListNode head) {

        if(head==null||head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead=reverseList(slow);
        slow.next=null;

        while(head!=null&&revHead!=null){
            if(head.val!=revHead.val)
                return false;

            head=head.next;
            revHead=revHead.next;
        }
        return true;
    }
}