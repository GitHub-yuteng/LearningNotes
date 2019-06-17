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


        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        threadBinaryTree.root = root;

        //测试中序线索化
//        threadBinaryTree.infixThreadNodes(root);
//        System.out.println("中序 前驱节点：" + threadNode4.left);
//        System.out.println("中序 后继节点：" + threadNode4.right);
//        //中序遍历线索二叉树
//        System.out.println("------中序遍历线索二叉树------");
//        threadBinaryTree.infixThreadList();


        //测试前序线索化
        threadBinaryTree.preThreadNodes(root);
        System.out.println("前序 前驱节点：" + threadNode6.left);
        System.out.println("前序 后继节点：" + threadNode6.right);

        //前序遍历线索二叉树
        System.out.println("------前序遍历线索二叉树------");
        threadBinaryTree.preThreadList();

        //测试后序线索化
//        threadBinaryTree.postThreadNodes(root);
//        System.out.println("后序 前驱节点：" + threadNode5.left);
//        System.out.println("后序 后继节点：" + threadNode5.right);
//        //后序遍历线索二叉树
//        System.out.println("------后序遍历线索二叉树------");
//        threadBinaryTree.postThreadList();
    }
}

//创建 ThreadBinaryTree
class ThreadBinaryTree {

    ThreadNode root;//根节点

    //为了实现一个线索化，需要创建一个指向当前结点的前驱结点的指针
    ThreadNode pre = null;//递归线索化时，总是保留前一个结点

    //编写对二叉树进行中序线索化的方法

    /**
     * 就是当前需要线索化的结点
     *
     * @param threadNode
     */
    public void infixThreadNodes(ThreadNode threadNode) {

        //如果node == null
        if (threadNode == null) {
            return;
        }

        // 1、先线索化左子树
        infixThreadNodes(threadNode.left);

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
        infixThreadNodes(threadNode.right);
    }

    //遍历线索二叉树 中序
    public void infixThreadList() {

        //定义一个变量，存储当前遍历的节点，从root开始
        ThreadNode threadNode = root;

        while (threadNode != null) {
            //循环找到 leftType == 1的节点，则为第一个节点
            //后面随着遍历而变化，因为当lefttype == 1时，该节点是线索化节点
            while (threadNode.leftType == 0) { //说明为左子树， left 不为空
                threadNode = threadNode.left;
            }
            //退出说明找到 打印此结点
            System.out.println(threadNode);

            //如果当前结点的右指针指向的是后继结点，就一直输出
            while (threadNode.rightType == 1) {
                threadNode = threadNode.right;
                System.out.println(threadNode);
            }

            //替换遍历结点
            threadNode = threadNode.right;
        }
    }

    //编写对二叉树进行前序线索化的方法

    /**
     * 就是当前需要线索化的结点
     *
     * @param threadNode
     */
    public void preThreadNodes(ThreadNode threadNode) {

        //如果node == null
        if (threadNode == null) {
            return;
        }

        //如果没有左子树
        if (threadNode.left == null) {
            threadNode.left = pre;
            threadNode.leftType = 1;
        }

        //上一个节点有没有  右子树
        if (pre != null && pre.right == null) {
            //pre第一次进来 为空
            pre.right = threadNode;
            pre.rightType = 1;
        }
        pre = threadNode;

        //判断root是否有左右孩子
        if (threadNode.leftType == 0) {
            preThreadNodes(threadNode.left);
        }
        if (threadNode.rightType == 0) {
            preThreadNodes(threadNode.right);
        }
    }

    //遍历线索二叉树 前序
    public void preThreadList() {

        //定义一个变量，存储当前遍历的节点，从root开始
        ThreadNode threadNode = root;

        if (threadNode == null) {
            return;
        }

        while (threadNode != null) {

            //找到最左边的节点,左标记一直为 0
            while (threadNode.left != null && threadNode.leftType == 0) {

                System.out.println(threadNode);
                threadNode = threadNode.left;
            }

            //退出之后找到最左节点 打印
            System.out.println(threadNode);

            //遇到线索 就看右节点  因为前序线索化，所以右边即为后继结点
            if (threadNode.leftType == 1) {
                threadNode = threadNode.right;
            }

            //循环右结点
            while (threadNode != null) {
                if (threadNode.left != null && threadNode.leftType == 0) {
                    break;
                }
                System.out.println(threadNode);
                //因为前序线索化，所以右边即为后继结点
                threadNode = threadNode.right;
            }
        }
    }

    //编写对二叉树进行后序线索化的方法

    /**
     * 就是当前需要线索化的结点
     *
     * @param threadNode
     */
    public void postThreadNodes(ThreadNode threadNode) {

        //如果node == null
        if (threadNode == null) {
            return;
        }

        postThreadNodes(threadNode.left);
        postThreadNodes(threadNode.right);

        //如果没有左子树
        if (threadNode.left == null) {
            threadNode.left = pre;
            threadNode.leftType = 1;
        }

        //上一个节点有没有  右子树
        if (pre != null && pre.right == null) {
            //pre第一次进来 为空
            pre.right = threadNode;
            pre.rightType = 1;
        }
        pre = threadNode;
    }

    //遍历线索二叉树 后序
    public void postThreadList() {

        //定义一个变量，存储当前遍历的节点，从root开始
        ThreadNode threadNode = root;

        if (threadNode == null) {
            return;
        }

        while (threadNode != null) {

            //找到最左边的节点,左标记为  0
            while (threadNode.left != null && threadNode.leftType == 0) {
                threadNode = threadNode.left;
            }
            //退出之后 threadNode = 最左节点

            //遇到线索 就看右节点  因为前序线索化，所以右边即为后继结点
            //循环右结点
            while (threadNode != null && threadNode.rightType == 0) {
                System.out.println(threadNode);
                //因为前序线索化，所以右边即为后继结点
                pre = threadNode;
                threadNode = threadNode.right;
            }

            if (threadNode == root) {
                System.out.println(threadNode);
                return;
            }

            while (pre != threadNode && threadNode.right == pre) {
                System.out.println(threadNode);
                pre = threadNode;
            }

            //这里不能用null判断，而是用 rightType
            if (threadNode != null && threadNode.rightType == 0) {
                threadNode = threadNode.right;
            }
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
}



