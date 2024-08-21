package Day21of45;
import java.util.*;
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root==null && subRoot ==null|| root!=null && subRoot==null) return true;
        if (root==null && subRoot!=null) return false;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            if(isSame(temp,subRoot)) return true;
            if(temp.left!=null) s.push(temp.left);
            if(temp.right!=null) s.push(temp.right);
        }
        return false;
    }

    private boolean isSame(TreeNode p, TreeNode q){

        if(p==null && q==null) return true;
        if(p==null && q!=null || p!=null && q==null) return false;

        if(p.val!=q.val) return false;

        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
