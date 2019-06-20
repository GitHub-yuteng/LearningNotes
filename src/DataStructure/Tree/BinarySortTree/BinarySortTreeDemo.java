package DataStructure.Tree.BinarySortTree;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yu
 * <p>
 * 二叉排序树  BST
 * 避免相同值
 */
public class BinarySortTreeDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(7, 3, 10, 12, 5, 1, 9, 2);

        BinarySortTree binarySortTree = new BinarySortTree();

        for (Integer item : list) {
            Node node = new Node(item);
            binarySortTree.addNode(node);
        }

        //中序遍历二叉排序树
        binarySortTree.infixOrder();

        //中序遍历二叉排序树
        System.out.println("删除了叶子节点之后！");

        //一、如果要删除的节点是叶子节点
/*        binarySortTree.delete(2);//删除2 之后可以删除1
        binarySortTree.delete(1);
        binarySortTree.delete(5);
        binarySortTree.delete(9);
        binarySortTree.delete(12);*/


        //二、删除有两颗子树的节点
        binarySortTree.delete(7);

        //三、删除只有一颗子树的节点
//        binarySortTree.delete(1);

        binarySortTree.infixOrder();

    }
}

class BinarySortTree {

    private Node root;//根结点

    /**
     * @param node
     */
    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("空树！");
        } else {
            root.infixOrder();
        }
    }


    /**
     * 查找指定节点
     *
     * @param value
     * @return
     */
    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找指定节点的父节点
     *
     * @param value
     * @return
     */
    public Node searchParentNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 1、从 targetNode 的右子树，找到最小的节点（or左子树最大节点）
     * 2、删除 targetNode为根结点二叉排序树的右子树的最小结点
     *
     * @param node 当作二叉排序树的根结点
     * @return 以Node 为根结点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node) {

        Node target = node;
        //循环的查找最小值
        while (target.left != null) {
            target = target.left;
        }
        //退出后  target 临时指针指向 右子树最小值
        int minValue = target.value;
        delete(minValue);
        return minValue;
    }

    /**
     * 删除指定的值 所对应的结点
     * 7
     * |  |
     * 3   10
     * |  |  |  |
     * 1  5  9  12
     * | |
     * nu 2
     * 1、删除的是叶子节点 比如：9 12
     * 2、删除只有一颗子树的节点。比如：1
     * 3、删除有两颗子树的节点。比如：7，3，10
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        } else {
            //查找到要删除的节点
            Node targetNode = searchNode(value);
            //如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            //如果 targetNode 是根节点 只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
            }
            //去找到 targetNode 的父节点
            Node parentNode = searchParentNode(value);
            //一、如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 一、删除的是叶子节点
                //1、先去找到要删除的节点 targetNode
                //2、要用临时指针 parentNode 指向 删除节点的父节点(是否有父节点)
                //3、判断targetNode 是 parentNode 的左右结点
                //4.1、判断targetNode为左 parentNode.left = null

                if (parentNode.left != null && parentNode.left.value == value) {
                    //targetNode 是 parentNode 的左结点
                    parentNode.left = null;
                    //4.2、判断targetNode为右 parentNode.right = null
                } else if (parentNode.right != null && parentNode.right.value == value)
                    //targetNode 是 parentNode 的右结点
                    parentNode.right = null;
                //二、删除有两颗子树的节点
            } else if (targetNode.left != null && targetNode.right != null) {

                //1、先去找到要删除的节点 targetNode
                //2、要用临时指针 parentNode 指向 删除节点的父节点(是否有父节点)
                //3、从 targetNode 的右子树，找到最小的节点（or左子树最大节点）
                //4、用临时变量，将最小节点的值保存 temp
                //5、删除最小节点
                //6、targetNode.value = temp
                int minValue = delRightTreeMin(targetNode.right);//根结点右子树 传过去
                targetNode.value = minValue;

            } else {
                // 三、删除只有一颗子树的节点
                //1、先去找到要删除的节点 targetNode
                //2、要用临时指针 parentNode 指向 删除节点的父节点(是否有父节点)
                //3、确定 targetNode 的子节点是左or右节点
                if (targetNode.left != null) {// targetNode 只有左子节点
                    // targetNode 是 parentNode的 是左子节点
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.left;
                    } else {// targetNode 是 parentNode的 是右子节点
                        parentNode.right = targetNode.left;
                    }
                } else {// targetNode 只有右子节点
                    // targetNode 是 parentNode的 是右子节点
                    if (parentNode.left.value == value) {
                        parentNode.left = targetNode.right;
                    } else {// targetNode 是 parentNode的 是右子节点
                        parentNode.right = targetNode.right;
                    }
                }
                //4、targetNode 是 parentNode的 是左子节点
                //4.1、targetNode 的子节点存在是左子节点 parentNode.left = targetNode.left
                //4.2、targetNode 的子节点存在是右子节点 parentNode.left = targetNode.right
                //5、targetNode 是 parentNode的 是右子节点
                //5.1、targetNode 的子节点存在是左子节点 parentNode.right = targetNode.left
                //5.2、targetNode 的子节点存在是右子节点 parentNode.right = targetNode.right
            }
        }
    }
}

//结点
class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加节点
     * 递归的形式添加节点，满足二叉排序树的要求
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入节点的值，和当前子树的根节点的关系
        if (node.value < this.value) {
            if (this.left == null) {
                //如果当前的左节点为空，直接挂上节点
                this.left = node;
            } else {
                //不为空则递归
                this.left.add(node);
            }
        } else { //传入节点大于 当前子树根节点
            if (this.right == null) {
                //如果当前的左节点为空，直接挂上节点
                this.right = node;
            } else {
                //不为空则递归
                this.right.add(node);
            }
        }
    }

    /**
     * 查找
     *
     * @param value 传入需要查找的值
     * @return 找到返回该Node节点，否则返回null
     */
    public Node search(int value) {

        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            //如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            //如果右子节点为空
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除节点的父节点
     *
     * @param value 传入需要查找的值
     * @return 找到返回该Node节点，否则返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的节点的父节点，就返回
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);//向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);//向右子树递归查找
            } else {
                return null;//没有找到父节点
            }
        }
    }

    /**
     * 中序遍历二叉树
     */
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
