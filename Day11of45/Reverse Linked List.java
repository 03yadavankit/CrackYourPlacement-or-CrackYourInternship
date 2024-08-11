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
        ListNode tmpNode=null;
        while(head!=null){
            tmpNode=head;
            head=head.next;
            if(newHead==null){
                newHead=tmpNode;
                tmpNode.next=null;
            }else{
                tmpNode.next=newHead;
                newHead=tmpNode;
            }

            
        }

        return newHead;
    }
}