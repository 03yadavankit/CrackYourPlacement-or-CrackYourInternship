package Day12of45;


class Solution {
    public Node travers(Node temp , Stack<Node> st){
        if(temp.child != null){
            if(temp.next != null)
                st.push(temp.next);
            Node t = temp.child;
            temp.next = temp.child;
            temp.child.prev = temp;
            temp.child=null;
            return travers(t, st);
        }
        if(temp.next != null)
            return travers(temp.next, st);
        if(!st.isEmpty()){
            Node tt = st.pop();
            temp.next = tt;
            tt.prev = temp;
            return travers(tt, st);
        }
        return temp; 
    }
    
    public Node flatten(Node head) {
        if(head == null) return null; 
        
        Stack<Node> st = new Stack<>();
        travers(head, st);
        
        return head;
    }
}