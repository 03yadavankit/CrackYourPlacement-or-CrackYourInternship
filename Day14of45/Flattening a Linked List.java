package Day14of45;


class Solution {
    Node flatten(Node root) {
        // code here
        if(root == null || root.next == null) return root;
        Node newNode = root;
        Node temp = root.next;
        newNode.next = null;
        while(temp != null && newNode != null){
            newNode = merge(newNode,temp);
            if(newNode != null)
            temp = temp.next;
        }
        return newNode;
    }
    public Node merge(Node root1,Node root2){
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node temp1 = root1;
        Node temp2 = root2;
        while(temp1 != null && temp2 != null){
            if(temp1.data < temp2.data){
                temp.bottom = temp1;
                temp = temp.bottom;
                temp1 = temp1.bottom;
            }else{
                temp.bottom = temp2;
                temp = temp.bottom;
                temp2 = temp2.bottom;
            }
        }
        if(temp1 != null) {
            temp.bottom = temp1;
        }
        if(temp2 != null){
            temp.bottom = temp2;
        }
        return dummy.bottom;
    }
}
