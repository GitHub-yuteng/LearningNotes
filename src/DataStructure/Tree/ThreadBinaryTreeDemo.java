package DataStructure.Tree;

/**
 * @author Yu
 */
public class ThreadBinaryTreeDemo {

    public static void main(String[] args) {

        //测试 中序线索二叉树
        ThreadNode root = new ThreadNode(1, "a");
        ThreadNode threadNode2 = new ThreadNode(3, "b");
        ThreadNode threadNode3 = new ThreadNode(6, "c");
        ThreadNode threadNode4 = new ThreadNode(8, "d");
        ThreadNode threadNode5 = new ThreadNode(10, "e");
        ThreadNode threadNode6 = new ThreadNode(14, "e");

        //手动创建二叉树
        root.left = threadNode2;
        root.right = threadNode3;
        threadNode2.left = threadNode4;
        threadNode2.right = threadNode5;
        threadNode3.left = threadNode6;

        //测试线索化
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.root = root;
        threadBinaryTree.threadNodes();

        //测试
        System.out.println("前驱节点："+threadNode3.left);
        System.out.println("后继节点："+threadNode3.right);
    }
}

//创建 ThreadBinaryTree
class ThreadBinaryTree {

    ThreadNode root;//根节点

    //为了实现一个线索化，需要创建一个指向当前结点的前驱结点的指针
    ThreadNode pre = null;//递归线索化时，总是保留前一个结点


    //重载该方法
    public void threadNodes() {
        this.threadNodes(root);
    }

    //编写对二叉树进行中序线索化的方法

    /**
     * 就是当前需要线索化的结点
     *
     * @param threadNode
     */
    public void threadNodes(ThreadNode threadNode) {

        //如果node == null
        if (threadNode == null) {
            return;
        }

        // 1、先线索化左子树
        threadNodes(threadNode.left);

        // 2、先线索化当前结点

        //处理当前结点的前驱节点
        if (threadNode.left == null) {
            //当前结点的左指针
            threadNode.left = pre;
            threadNode.leftType = 1;
        }

        //处理后继节点
        if (pre != null && pre.right == null) {
            //让前驱节点的右指针，指向当前结点
            pre.right = threadNode;
            pre.rightType = 1;
        }

        //！ 每处理一个节点后，让当前结点是下一个节点的前驱节点
        pre = threadNode;


        // 3、先线索化右 子树
        threadNodes(threadNode.right);
    }


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
    public ThreadNode preOrderSearch(int no) {

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
    public ThreadNode infixOrderSearch(int no) {

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
    public ThreadNode postOrderSearch(int no) {

        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }
}

class ThreadNode {

    int num;
    String name;
    ThreadNode left;//默认 null
    ThreadNode right;//默认 null

    //如果 leftType 等于 0 为左子树  等于1则表示为  则表示为前驱节点
    int leftType;
    //如果 rightType 等于 0 为右子树  等于1则表示为  则表示为后继节点
    int rightType;

    public ThreadNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
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


    /**
     * @param no 指定查找 编号
     * @return 如果找到就返回Node 如果没有找到就返回null
     */
    public ThreadNode preOrderSearch(int no) {

        System.out.println("进入前序遍历！");
        //打印该节点
        if (this.num == no) {
            return this;
        }

        //结果节点
        ThreadNode resNode = null;

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
    public ThreadNode infixOrderSearch(int no) {

        //结果节点
        ThreadNode resNode = null;

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
    public ThreadNode postOrderSearch(int no) {

        //结果节点
        ThreadNode resNode = null;

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



