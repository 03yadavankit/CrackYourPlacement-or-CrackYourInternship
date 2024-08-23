package Day23of45;

class Solution {
    private boolean isBal = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBal;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftSub = maxDepth(node.left);
        int rightSub = maxDepth(node.right);
        if (Math.abs(leftSub - rightSub) > 1) {
            isBal = false;
        }
        return Math.max(leftSub, rightSub) + 1;
    }
}