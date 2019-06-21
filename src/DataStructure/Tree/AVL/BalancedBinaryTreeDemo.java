package DataStructure.Tree.AVL;

/**
 * @author Yu
 * AVL（Adelson-Velskii and Landis）树得名于它的发明者
 * G.M. Adelson-Velsky 和 E.M. Landis
 * <p>
 * LL	在a的左子树根节点的左子树上插入节点而破坏平衡	右旋转
 * RR	在a的右子树根节点的右子树上插入节点而破坏平衡	左旋转
 * LR	在a的左子树根节点的右子树上插入节点而破坏平衡	先左旋后右旋
 * RL	在a的右子树根节点的左子树上插入节点而破坏平衡	先右旋后左旋
 */
public class BalancedBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arrRR = {4, 3, 6, 5, 7, 8};//右子树 高 RR旋转 例子数组
        int[] arrLL = {10, 12, 8, 9, 7, 6};//左子树 高 LL旋转 例子数组
        int[] arrLR = {10, 11, 7, 6, 8, 9};//左子树 高 先左旋后右旋 例子数组
        int[] arrRL = {20, 19, 23, 22, 21, 25};//左子树 高 先右旋后左旋 例子数组

        //创建一个 AVL
        AvlTree avlTree = new AvlTree();

        //添加节点
        for (int i : arrRL) {
            avlTree.addNode(new Node(i));
        }

        //中序遍历
        avlTree.infixOrder();

        System.out.println("平衡处理！");
        System.out.println("树高度：" + avlTree.getRoot().height());
        System.out.println("左子树树高度：" + avlTree.getRoot().left.height());
        System.out.println("右子树树高度：" + avlTree.getRoot().right.height());
        System.out.println(avlTree.getRoot());
    }
}

//创建 AVL 树  也是一颗 二叉搜索树
class AvlTree {

    private Node root;//根结点

    public Node getRoot() {
        return root;
    }

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
                    //如果只剩两个结点则没有 parentNode结点  左节点
                    if (parentNode != null) {
                        // targetNode 是 parentNode的 是左子节点
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {// targetNode 是 parentNode的 是右子节点
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {// targetNode 只有右子节点
                    //如果只剩两个结点则没有 parentNode结点  左节点
                    if (parentNode != null) {
                        // targetNode 是 parentNode的 是右子节点
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.right;
                        } else {// targetNode 是 parentNode的 是右子节点
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
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

    //返回左子树的高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            int leftHeight = this.left.height();
            return leftHeight;
        }
    }

    //返回右子树的高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            int rightHeight = this.right.height();
            return rightHeight;
        }
    }

    //返回以该节点为根结点的树的高度
    public int height() {
        //一直再加 1。每调用一次 +1
        int leftHeight = (this.left == null ? 0 : this.left.height());
        int rightHeight = (this.right == null ? 0 : this.right.height());
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
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
        } else { //传入节点大于等于当前子树根节点
            if (this.right == null) {
                //如果当前的左节点为空，直接挂上节点
                this.right = node;
            } else {
                //不为空则递归
                this.right.add(node);
            }
        }

        //添加完一个结点后 判断左右子树高度
        // 如果 (右子树高度 - 左子树高度) > 1 RR旋转 左旋转
        int height = this.rightHeight() - this.leftHeight();
        if (height > 1) {
            //如果当前结点的右子树的左子树高度 大于 当前结点的右子树的右子树高度  RL旋转
            if (right != null && right.leftHeight() > right.rightHeight()) {
                //先对当前结点的右子树进行 ->右旋转
                this.right.LLrotate();
                //先对当前结点进行 -> 左旋转
                this.RRrotate();
            } else {
                this.RRrotate();
            }
            return;//这个return 一定要加上。不要旋转后 继续判断
        }

        //添加完一个结点后 判断左右子树高度
        // 如果 (左子树高度 - 右子树高度) > 1 LL旋转 右旋转
        height = this.leftHeight() - this.rightHeight();
        if (height > 1) {
            //如果当前结点的左子树的右子树高度 大于 当前结点的左子树的左子树的高度  LR旋转
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                //先对当前结点的左子树进行 ->左旋转
                this.left.RRrotate();
                //先对当前结点进行 ->右旋转
                this.LLrotate();
            } else {
                this.LLrotate();
            }
            return;
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

    /**
     * 左旋转  RR旋转
     */
    private void RRrotate() {

        //1、创建新的结点，值为当前根结点的值
        Node newNode = new Node(this.value);

        //2、把新的节点的左子树，设置为当前结点的左子树
        newNode.left = this.left;

        //3、把新节点的右子树设置为当前结点的右子树的左子树
        newNode.right = this.right.left;

        //4、把当前结点的值换为当前节点右节点的值
        this.value = this.right.value;

        //5、把当前结点的右子树设置成右子树的右子树
        this.right = this.right.right;

        //6、把当前结点的左子树换成新节点
        this.left = newNode;
    }

    /**
     * 右旋转  LL旋转
     */
    private void LLrotate() {

        //1、创建新的结点，值为当前根结点的值
        Node newNode = new Node(this.value);

        //2、把新的节点的右子树，设置为当前结点的右子树
        newNode.right = this.right;

        //3、把新节点的左子树设置为当前结点的左子树的右子树
        newNode.left = this.left.right;

        //4、把当前结点的值换为当前节点左节点的值
        this.value = this.left.value;

        //5、把当前结点的左子树设置成左子树的左子树
        this.left = this.left.left;

        //6、把当前结点的右子树换成新节点
        this.right = newNode;
    }
}