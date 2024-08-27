package Day27of45;
import java.util.*;
public class Codec {

    public String serialize(TreeNode root) {
        String res = "";
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res = res + "n ";
            } else {
                res = res + node.val + " ";
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        System.out.print(res);
        return res;
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] nodeValues = data.split(" ");
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        
        for(int i = 1; i < nodeValues.length; i++) {
            TreeNode parentNode = queue.poll();
            if (!nodeValues[i].equals("n")) {
                parentNode.left = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.left);
            }
            if (!nodeValues[++i].equals("n")) {
                parentNode.right = new TreeNode(Integer.parseInt(nodeValues[i]));
                queue.offer(parentNode.right);
            }
        }
        return node;
    }
}