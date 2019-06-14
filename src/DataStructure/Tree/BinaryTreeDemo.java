package DataStructure.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author Yu
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        //创建需要的节点
        Node root = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = root;

        //手动创建二叉树
        root.left = node2;
        root.right = node3;
        node3.right = node4;
        node3.left = node5;


        System.out.println("---前序遍历---");//12354
        binaryTree.preOrder();

        System.out.println("---中序遍历---");//21534
        binaryTree.infixOrder();

        System.out.println("---后序遍历---");//25431
        binaryTree.postOrder();
    }
}

//创建 BinaryTree
class BinaryTree {

    Node root;//根节点

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}

class Node {

    int num;
    String name;
    Node left;//默认 null
    Node right;//默认 null

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {

        //输出当前结点
        System.out.println(this);

        //递归左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }

        //递归右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {

        //递归左子树前序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }

        //输出当前结点
        System.out.println(this);

        //递归右子树前序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //中序遍历
    public void postOrder() {

        //递归左子树前序遍历
        if (this.left != null) {
            this.left.postOrder();
        }

        //递归右子树前序遍历
        if (this.right != null) {
            this.right.postOrder();
        }

        //输出当前结点
        System.out.println(this);
    }
}
