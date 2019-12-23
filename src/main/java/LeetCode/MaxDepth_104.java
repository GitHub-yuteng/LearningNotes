package LeetCode;

/**
 * @author Yu
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxDepth_104 {

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }
}
