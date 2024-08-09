package Day09of45;

import java.util.*;

class Solution {
    public ListNode middleNode(ListNode head) {
        List s=head;
        ListNode f = head;

        while(f.next!=null){
            f=f.next;
            s=s.next;
            if(f.next==null){
                break;
            }
            f=f.next;
        }

        return s;
    }
}
