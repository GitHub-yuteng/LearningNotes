package DataStructure.Tree;

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
        System.out.println();

        System.out.println("---中序遍历---");//21534
        binaryTree.infixOrder();
        System.out.println();

        System.out.println("---后序遍历---");//25431
        binaryTree.postOrder();
        System.out.println();

        System.out.println("---前序查找遍历 次数---");//12354
        Node preNode = binaryTree.preOrderSearch(5);
        if (preNode != null) {
            System.out.println("前序遍历:" + preNode.toString());
        } else {
            System.out.println("没有找到！");
        }
        System.out.println();

        System.out.println("---中序查找遍历 次数---");//12354
        Node infixNode = binaryTree.infixOrderSearch(5);
        if (infixNode != null) {
            System.out.println("前序遍历:" + infixNode.toString());
        } else {
            System.out.println("没有找到！");
        }
        System.out.println();

        System.out.println("---后序查找遍历 次数---");//12354
        Node postNode = binaryTree.postOrderSearch(5);
        if (postNode != null) {
            System.out.println("前序遍历:" + postNode.toString());
        } else {
            System.out.println("没有找到！");
        }
        System.out.println();
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

    /**
     * @param no
     * @return
     */
    public Node preOrderSearch(int no) {

        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * @param no
     * @return
     */
    public Node infixOrderSearch(int no) {

        if (this.root != null) {
            return this.root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * @param no
     * @return
     */
    public Node postOrderSearch(int no) {

        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
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

        //递归左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }

        //输出当前结点
        System.out.println(this);

        //递归右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {

        //递归左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }

        //递归右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出当前结点
        System.out.println(this);
    }


    /**
     * @param no 指定查找 编号
     * @return 如果找到就返回Node 如果没有找到就返回null
     */
    public Node preOrderSearch(int no) {

        System.out.println("进入前序遍历！");
        //打印该节点
        if (this.num == no) {
            return this;
        }

        //结果节点
        Node resNode = null;

        //左递归
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {//如果 node 不为空 说明找到了 返回
            return resNode;
        }

        //左递归没有找到，右递归
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        return resNode;
    }

    /**
     * @param no 指定查找 编号
     * @return 如果找到就返回Node 如果没有找到就返回null
     */
    public Node infixOrderSearch(int no) {

        //结果节点
        Node resNode = null;

        //左递归
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {//如果 node 不为空 说明找到了 返回
            return resNode;
        }

        System.out.println("进入中序遍历！");
        //打印该节点
        if (this.num == no) {
            return this;
        }

        //左递归没有找到，右递归
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }

        return resNode;
    }

    /**
     * @param no 指定查找 编号
     * @return 如果找到就返回Node 如果没有找到就返回null
     */
    public Node postOrderSearch(int no) {

        //结果节点
        Node resNode = null;

        //左递归
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {//如果 node 不为空 说明找到了 返回
            return resNode;
        }

        //左递归没有找到，右递归
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {//如果 node 不为空 说明找到了 返回
            return resNode;
        }

        System.out.println("进入后序遍历！");
        //打印该节点
        if (this.num == no) {
            return this;
        }

        return resNode;
    }
}
