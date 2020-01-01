package 剑指Offer.Interview_8NO;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

//中序遍历: 左 根 右
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode temp = null;

        //假如此节点是父节点
        if (pNode.next == null) {
            //如果是根节点,返回最左的左叶子节点，如果左叶子节点为空，返回它的父节点
            if (pNode.right != null) {
                temp = pNode.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            } else {
                return null;
            }
        }
        //第一步判断此节点是父节点的左子节点还是右子节点,还是根节点
        if (pNode.next.left == pNode) {
            //如果是父节点的左子节点，判断此节点有没有右儿子
            if (pNode.right != null) {
                temp = pNode.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            } else {
                //如果没有右儿子，则返回父节点
                return pNode.next;
            }
        } else {
            //如果是父节点的右儿子，在没有右儿子的情况下，需要判断是在整个树的左边还是在右边
            //判断有没有右儿子,
            if (pNode.right != null) {
                temp = pNode.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;
            } else {
                //在没有右儿子的情况下，需要判断是在整个树的左边还是在右边
                TreeLinkNode node = null;
                TreeLinkNode mark = pNode;
                while (pNode.next != null) {
                    node = pNode;
                    pNode = pNode.next;
                }
                if (node == pNode.left) {
                    //如果是左子树
                    return mark.next.next;
                } else {
                    //如果是右子树，则该节点是最后一个叶子节点，则返回null
                    return null;
                }
            }
        }
    }
}