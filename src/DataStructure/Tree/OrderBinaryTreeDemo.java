package DataStructure.Tree;

/**
 * @author Yu
 * <p>
 * 顺序存储二叉树
 * 1、通常只考虑 完全二叉树  n 表示二叉树中的第几个元素(按 0 开始编号)
 * <p>
 * 2、第 n 个元素的左子节点为 2*n+1
 * 3、第 n 个元素的右子节点为 2*n+2
 * 4、第 n 个元素的父节点为 (n-1)/2
 */
public class OrderBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        OrderBinaryTree orderBinaryTree = new OrderBinaryTree(arr);
        orderBinaryTree.preOrder();
        System.out.println();
        orderBinaryTree.infixOrder();
        System.out.println();
        orderBinaryTree.postOrder();
    }
}

//实现顺序存储二叉树遍历
class OrderBinaryTree {

    private int[] arr;//存储数据节点的数据

    public OrderBinaryTree(int[] arr) {
        this.arr = arr;
    }


    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    //编写一个方法，完成顺序存储二叉树的前序遍历

    /**
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！不能前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index] + " ");

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    /**
     * @param index 数组的下标
     */
    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！不能前序遍历");
        }


        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            infixOrder(2 * index + 1);
        }

        //输出当前这个元素
        System.out.print(arr[index] + " ");

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            infixOrder(2 * index + 2);
        }
    }

    /**
     * @param index 数组的下标
     */
    public void postOrder(int index) {

        if (arr == null || arr.length == 0) {
            System.out.println("数组为空！不能前序遍历");
        }

        //向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(2 * index + 1);
        }

        //向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(2 * index + 2);
        }

        //输出当前这个元素
        System.out.print(arr[index] + " ");
    }
}


