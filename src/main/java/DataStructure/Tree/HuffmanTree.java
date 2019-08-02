package DataStructure.Tree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yu
 * WPL Weighted Path Length 最小
 * 最优二叉树
 */
public class HuffmanTree {

    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        HuffmanNode root = createHuffmanTree(arr);

        //测试
        preOrder(root);

    }

    /**
     * 创建哈夫曼树
     * @param arr 需要创建成哈夫曼树的 数组
     * @return 返回哈夫曼树root节点
     */
    public static HuffmanNode createHuffmanTree(int[] arr) {

        //1、为了操作方便 先把元素取出来 放入list
        ArrayList<HuffmanNode> huffmanNodes = new ArrayList<>();

        for (int value : arr) {
            huffmanNodes.add(new HuffmanNode(value));
        }


        while (huffmanNodes.size() > 1) {
            //排序从大到小排序
            Collections.sort(huffmanNodes);
            System.out.println(huffmanNodes.toString());
            HuffmanNode leftNode = huffmanNodes.get(0);
            HuffmanNode rightNode = huffmanNodes.get(1);

            HuffmanNode parentNode = new HuffmanNode(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            huffmanNodes.remove(leftNode);
            huffmanNodes.remove(rightNode);
            huffmanNodes.add(parentNode);
        }
        //返回哈夫曼的root节点
        return huffmanNodes.get(0);
    }

    //前序遍历方法
    public static void preOrder(HuffmanNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树！");
        }
    }
}

//结点类
class HuffmanNode implements Comparable<HuffmanNode> {

    int value;//结点权值
    HuffmanNode left;//指向左子节点
    HuffmanNode right;//指向右子节点

    public HuffmanNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuffmanNode o) {
        //从小到大排序
        return this.value - o.value;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
