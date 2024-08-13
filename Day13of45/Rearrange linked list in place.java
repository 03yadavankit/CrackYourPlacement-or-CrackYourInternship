package Day13of45;
class Solution {
    public Node getMid(Node head){
        Node dummy=new Node(0);
        Node slow=dummy;
        Node fast=dummy;
        dummy.next=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node reverse(Node head){
        Node prev=null;
        while(head!=null){
            Node newNode=head;
            head=head.next;
            newNode.next=prev;
            prev=newNode;
        }
        return prev;
        
    }
    public Node merge(Node head1,Node head2){
        Node dummy=new Node(0);
        Node temp=dummy;
        while(head1!=null && head2!=null){
            temp.next=head1;
            temp=temp.next;
            head1=head1.next;
            temp.next=head2;
            temp=temp.next;
            head2=head2.next;
        }
        if(head1!=null){
            temp.next=head1;
        }
        else{
            temp.next=head2;
        }
        return dummy.next;
    }
    public Node inPlace(Node root) {
        if(root==null || root.next==null){
            return root;
        }
        Node mid=getMid(root);
        Node left=root;
        Node right=reverse(mid.next);
        mid.next=null;
        
        return merge(left,right);
    }
    
}
