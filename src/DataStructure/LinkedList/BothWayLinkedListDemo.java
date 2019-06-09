package DataStructure.LinkedList;


/**
 * @author Yu
 */
public class BothWayLinkedListDemo {

    public static void main(String[] args) {
        BothWayLinkedList bothWayLinkedList = new BothWayLinkedList();

        BothNode bothNode1 = new BothNode(1,"a");
        BothNode bothNode2 = new BothNode(2,"b");
        BothNode bothNode3 = new BothNode(3,"c");
        BothNode bothNode4 = new BothNode(4,"d");
        BothNode bothNode5 = new BothNode(5,"e");

        BothNode updateNode = new BothNode(4,"d----------");

        bothWayLinkedList.add(bothNode1);
        bothWayLinkedList.add(bothNode2);
        bothWayLinkedList.add(bothNode3);
        bothWayLinkedList.add(bothNode4);
        bothWayLinkedList.add(bothNode5);
        System.out.println("--------------修改前遍历！--------------");
        bothWayLinkedList.traverse();
        System.out.println("--------------修改后遍历！--------------");
        bothWayLinkedList.update(updateNode);
        bothWayLinkedList.traverse();
        System.out.println("--------------删除后遍历！--------------");
        bothWayLinkedList.deleteNode(4);
        bothWayLinkedList.traverse();



    }
}

class BothWayLinkedList {
    //头结点
    private BothNode head = new BothNode(0, " ");

    //返回头结点
    public BothNode getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     */
    public void traverse() {
        if (head.nextNode == null) {
            System.out.println("链表为空！");
            return;
        }
        BothNode temp = head.nextNode;

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.nextNode;
        }
    }

    /**
     * 添加元素到双向链表尾部
     *
     * @param node
     */
    public void add(BothNode node) {

        //因为head节点不能动，需要一个辅助指针 temp
        BothNode temp = head;

        //遍历链表找到最后节点
        while (true) {
            if (temp.nextNode == null) {
                break;
            }
            temp = temp.nextNode;
        }

        //形成互连 双向链表
        temp.nextNode = node;
        node.preNode = temp;
    }

    /**
     * 修改节点
     * 根据num编号来修改，不能修改num
     * 根据新节点的num来修改 name
     * 单向链表和双向链表更新操作一样
     *
     * @param updatenode
     */
    public void update(BothNode updatenode) {

        if (head.nextNode == null) {
            System.out.println("链表为空！");
            return;
        }
        BothNode temp = head;

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
            temp = temp.nextNode;
        }
        if (flag) {
            temp.name = updatenode.name;
        } else {
            System.out.println("没有找到编号为" + updatenode.num + "的节点！");
        }
    }

    /**
     * 删除指定节点 根据 num 删除
     *
     * @param num
     */
    public void deleteNode(int num) {
        if (head.nextNode == null) {
            System.out.println("链表为空！无法删除");
            return;
        }
        BothNode temp = head.nextNode;

        //找到需要删除的节点
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.num == num) {//这步很关键
                flag = true;
                break;
            }
            temp = temp.nextNode;
        }
        if (flag) {
            temp.preNode.nextNode = temp.nextNode;
            //这里代码有问题 如果是最后一个节点 就不能  nextNode 否则出现 空指针
            // temp.nextNode.preNode = temp.preNode;
            if (temp.nextNode != null) {
                temp.nextNode.preNode = temp.preNode;
            }
        } else {
            System.out.println("要删除的节点不存在：" + num);
        }
    }
}


//定义Node
class BothNode {
    int num;
    String name;
    BothNode preNode;//指向前一个节点  默认为null
    BothNode nextNode;//指向下一个节点 默认为null

    public BothNode(int num, String name) {
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BothNode:" + num + ":" + name;
    }
}
