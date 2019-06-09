package DataStructure.LinkedList;

/**
 * @author Yu
 * 约瑟夫问题
 */
public class CircleSingleLinkedListDemo {

    public static void main(String[] args) {

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addCNode(5);
        circleSingleLinkedList.traverse();
        circleSingleLinkedList.josepfu(1, 2, 5);
    }
}

class CircleSingleLinkedList {

    //创建 first 节点
    private CNode first = null;

    /**
     * 单向循环链表 添加元素
     *
     * @param nums
     */
    public void addCNode(int nums) {

        if (nums < 1) {
            System.out.println("数值不正确！");
            return;
        }

        CNode cur = null;//辅助指针，帮助构建环形链表

        for (int i = 1; i <= nums; i++) {
            CNode cNode = new CNode(i);
            if (i == 1) { //第一个节点自己指向自己 构成环状
                first = cNode;
                first.next = first;
                cur = first; //辅助指针指向 首节点
            } else {
                cur.next = cNode;
                cNode.next = first;
                cur = cNode;
            }
        }
    }

    /**
     * 遍历 循环链表， 当辅助指针和first指针重合遍历结束
     */
    public void traverse() {
        if (first == null) {
            System.out.println("链表为空！");
            return;
        }
        //因为first 指针不能动 添加辅助指针
        CNode cur = first;

        while (true) {
            System.out.println("编号为:" + cur.num);
            if (cur.next == first) {
                System.out.println("---------遍历完毕！---------");
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * @param startNum 从第几号开始报数
     * @param k        报几次 出圈
     * @param nums     一共有多少编号
     */
    public void josepfu(int startNum, int k, int nums) {

        if (first == null || startNum < 1 || startNum > nums || nums < 1 || k < 1) {
            System.out.println("参数输出有误！");
            return;
        }

        //创建一个辅助指针
        CNode helper = first;
        while (true) {
            if (helper.next == first) {//说明辅助指针指向了 最后一个编号
                break;
            }
            helper = helper.next;
        }

        //first 和 helper 都走 startNum-1 次 因为要从这里开始报数
        for (int i = 1; i < startNum; i++) {
            first = first.next;
            helper = helper.next;
        }

        //报数 出圈， 最后只剩下一个
        while (true) {
            if (helper == first) {//说明圈中只有一个人
                System.out.println("最后编号为："+helper.num);
                break;
            }
            //让 first 和 helper 指针同时移动 k-1 次
            for (int i = 1; i < k; i++) {
                first = first.next;
                helper = helper.next;
            }

            System.out.println("出圈编号为：" + first.num);
            first = first.next;
            helper.next = first;
        }

    }
}

class CNode {

    int num;
    CNode next;//指向下一个节点

    public CNode(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CNode:" + num;
    }
}

