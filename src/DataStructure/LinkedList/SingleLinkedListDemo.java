package DataStructure.LinkedList;

import java.util.Stack;

/**
 * @author Yu
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //创建节点
        Node node1 = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node7 = new Node(7, "e");

        Node updateNode = new Node(7, "z-----");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(node1);
        singleLinkedList.add(node4);
        singleLinkedList.add(node2);
        singleLinkedList.add(node7);
        singleLinkedList.add(node3);
        System.out.println("--------------修改前！--------------");
        singleLinkedList.traverse();
        System.out.println("--------------更新单节点，修改后！--------------");
        singleLinkedList.update(updateNode);
        singleLinkedList.traverse();

        System.out.println("--------------修改前！--------------");
        singleLinkedList.traverse();
        System.out.println("--------------删除，修改后！--------------");
        singleLinkedList.deleteNode(7);
//        singleLinkedList.deleteNode(2);
//      singleLinkedList.deleteNode(3);
//      singleLinkedList.deleteNode(4);
        singleLinkedList.traverse();

        //获取链表有效节点长度


//      singleLinkedList.addByOrder(node1);
//      singleLinkedList.addByOrder(node3);
//      singleLinkedList.addByOrder(node2);
//      singleLinkedList.addByOrder(node7);
//      singleLinkedList.addByOrder(node4);

        int length = getLength(singleLinkedList.getHead());
        System.out.println("有效节点长度为：" + length);

        Node node = FindLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("循环方法得到倒数第K个值：" + node);

        System.out.println("---------------------------");

        Node kNode = FindLastKNodeByDoubleP(singleLinkedList.getHead(), 2);
        System.out.println("双指针方法得到倒数第K个值：" + kNode);

        System.out.println("-----------逆序打印，利用头插法 破坏了数据结构----------------");
        ReverseSingleLinkedList(singleLinkedList.getHead());
        singleLinkedList.traverse();

        System.out.println("------------逆序打印，利用栈---------------");
        Stack<Node> stack = ReverseSingleLinkedListByStack(singleLinkedList.getHead());

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

        System.out.println("-----------简单遍历----------------");
        singleLinkedList.traverse();
    }


    public static Stack<Node> ReverseSingleLinkedListByStack(Node head) {

        if (head == null || head.next == null) {
            throw new RuntimeException("空链表！");
        }
        if (head.next.next == null) {
            throw new RuntimeException("无需反转！");
        }

        Stack<Node> stack = new Stack<>();

        Node temp = head.next;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        return stack;
    }

    /**
     * 单链表的反转  逆序打印  破坏数据结构  不推荐使用
     * 腾讯面试题
     *
     * @param head
     */
    public static void ReverseSingleLinkedList(Node head) {

        if (head == null || head.next == null) {
            throw new RuntimeException("空链表！");
        }
        if (head.next.next == null) {
            throw new RuntimeException("无需反转！");
        }

        Node cur = head.next;
        Node next = null;
        Node reverseHead = new Node(0, " ");

        while (cur != null) {
            next = cur.next;//先暂时保存当前结点的下一个节点
            cur.next = reverseHead.next; //第一次 reverseHead.next为null 因为尾节点为null
            reverseHead.next = cur; //新头结点 指向当前 结点
            cur = next;//指针后移一位
        }

        head.next = reverseHead.next;
    }

    /**
     * 运用双指针 查询单链表倒数第K个节点。
     * 剑指Offer
     *
     * @param head
     * @param K
     * @return
     */
    public static Node FindLastKNodeByDoubleP(Node head, int K) {

        if (head == null || head.next == null) {
            throw new RuntimeException("空链表！");
        }

        Node temp = head;

        for (int i = 0; i < K - 1; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                return null; //如果K大于链表总长度，则返回 null;
            }
        }

        Node pA = head;
        Node pB = head;

        for (int i = 0; i < K - 1; i++) {
            pA = pA.next;
        }

        while (pA.next != null) {
            pA = pA.next;//A指针走到尾部，B走到倒数第K个值
            pB = pB.next;
        }
        return pB;
    }

    /**
     * 查询单链表倒数第K个节点。
     */
    public static Node FindLastIndexNode(Node head, int index) {


        if (head == null || head.next == null) {
            System.out.println("空链表！");
            return null;
        }
        int size = getLength(head);

        if (index <= 0 || index > size) {
            System.out.println("索引不合法!");
            return null;
        }

        //定义一个辅助变量
        Node cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @param head 链表头结点
     * @return 返回有效值个数
     */
    public static int getLength(Node head) {

        int length = 0;//辅助变量，不包含头结点长度

        if (head.next == null) {//空链表
            return 0;
        }
        Node cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

class SingleLinkedList {

    //头结点
    private Node head = new Node(0, " ");

    public Node getHead() {
        return head;
    }

    //添加节点到单向链表
    //不考虑编号顺序
    public void add(Node node) {

        //因为head节点不能动，需要一个辅助指针 temp
        Node temp = head;

        //遍历链表找到最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 遍历
     */
    public void traverse() {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head.next;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 修改节点
     * 根据num编号来修改，不能修改num
     * 根据新节点的num来修改 name
     */
    public void update(Node updatenode) {

        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head;

        //找到需要更新的节点
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == updatenode.num) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = updatenode.name;
        } else {
            System.out.println("没有找到编号为" + updatenode.num + "的节点！");
        }
    }

    /**
     * 删除指定节点 根据 num 删除
     * @param num
     */
    public void deleteNode(int num) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        Node temp = head;

        //找到需要删除的节点
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.next.num == num) {//这步很关键
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在：" + num);
        }
    }

    /**
     * 按值大小顺序插入
     *
     * @param node
     */
    public void addByOrder(Node node) {

        Node temp = head;
        boolean flag = false;//添加的编号是否存在

        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if (temp.next.num > node.num) {//位置找到，就在temp后面插入
                break;
            } else if (temp.next.num == node.num) {//说明Node编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //判断flag的值
        if (flag) {
            System.out.println("值已存在:" + node.num);
        } else {
            //插入链表中
            node.next = temp.next;
            temp.next = node;
        }
    }
}

//定义Node
class Node {
    int num;
    String name;
    Node next;//指向下一个节点

    public Node(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node:" + num + ":" + name;
    }
}

