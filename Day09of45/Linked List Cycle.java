package Day09of45;

import java.util.*;zz

public class Solution {
    public boolean hasCycle(ListNode head) {
         if(head==null || head.next==null){
            return false;
        }
        HashMap<ListNode,Integer> ans = new HashMap<>();
        ListNode fast = head;
        ans.put(fast,fast.val);
        while(fast.next!=null){
            if(ans.containsKey(fast.next)){
                return true;
            }
            fast=fast.next;
            ans.put(fast,fast.val);
        }
        
        return false;
    }
}