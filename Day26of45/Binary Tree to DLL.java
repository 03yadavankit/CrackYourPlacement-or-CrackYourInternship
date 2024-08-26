package Day26of45;

class Solution
{
    Node bToDLL(Node root)
    {
        ArrayList<Integer> list=inorder(root);
        Node cur=new Node(list.get(0));
        Node prev=cur;
        
        for(int i=1;i<list.size();i++) {
            Node newNode=new Node(list.get(i));
            prev.right=newNode;
            newNode.left=prev;
            prev=newNode;
        }
        
        return cur;
    }
    
    ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        
        list.addAll(inorder(root.left));
        list.add(root.data);
        list.addAll(inorder(root.right));
        
        return list;
    }
}

