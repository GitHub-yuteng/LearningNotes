package 剑指Offer.RebuildBinaryTree;


/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void postOrder() {

        //递归左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}

public class Solution {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //由于重建二叉树的过程会用到很多边界值，所以题目所给的方法的参数是不够用的
        //所以，在下面重载了这个方法，每次传入前序和中序序列以及起始位置
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //这里是判断结束的标志，由于是递归算法，我们不可能一直执行下去，所以需要结束标志
        //下面这两种情况发生一个就会结束
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        //首先找到根节点
        TreeNode root = new TreeNode(pre[startPre]);
        //对中序遍历进行查找根节点
        for (int i = startIn; i <= endIn; i++) {
            //找到之后，分别对左子树和右子树进行递归算法，重复此步骤
            if (in[i] == pre[startPre]) {
                //重建二叉树的关键就是找到其中的边界值，边界值在图中已经做了描述
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        Solution solution = new Solution();
        TreeNode root = solution.reConstructBinaryTree(pre, in);

        root.postOrder();
    }
}


