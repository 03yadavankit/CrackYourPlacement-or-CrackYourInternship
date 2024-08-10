package Day10of45;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;

        ListNode temp = new ListNode(-1);;
        ListNode tail = temp;
        while(head!=null){
            if(head.val!=val){
                tail.next = head;
                tail = tail.next;
            }

            head=head.next;
        }
        tail.next=null;

        return temp.next;
    }
}

