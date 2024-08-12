package Day12of45;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null)
            return head;
        if(left==right) return head;
        
        ListNode temp = head;
        ListNode pre = temp;

        for(int i=1;i<left;i++){
            pre = temp;
            temp = temp.next;
        }

        ListNode newHead = null;
        ListNode tail = null;

        for(int i=left;i<=right;i++){
            if(newHead ==null){
                newHead = tail = temp;
                temp=temp.next;
            }else{
                ListNode t= temp;
                temp = temp.next;
                t.next = newHead;
                newHead = t;
            }
        }
        tail.next = temp;
        if(left==1){
            return newHead;
        }
        pre.next = newHead;

        return head;

    }
}