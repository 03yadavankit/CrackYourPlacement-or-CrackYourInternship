package Day11of45;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA; int n=0;
        ListNode temp2=headB; int m=0;
        while(temp1!=null){
            n++;
            temp1=temp1.next;
        }

        while(temp2!=null){
            m++;
            temp2=temp2.next;
        }

        temp1=headA;
        temp2=headB;

        while(temp1!=null&&temp2!=null){
            if(n==m){
                if(temp1.val==temp2.val && temp1==temp2){
                    return temp1;
                }
                temp1=temp1.next;
                temp2=temp2.next;
            }else if(n>m){
                n--;
                temp1=temp1.next;
            }else{
                temp2=temp2.next;
                m--;
            }
        }

        return null;
    }
}
