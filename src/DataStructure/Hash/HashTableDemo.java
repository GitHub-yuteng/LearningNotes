package DataStructure.Hash;

/**
 * @author Yu
 */
public class HashTableDemo {

    public static void main(String[] args) {

    }
}

//用来管理 多条链表
class HashTable {

    private LinkedList[] linkedLists;
    private int size;//表示共有多少条链表

    //构造器
    public HashTable(int size) {
        //初始化 linkedLists
        this.size = size;
        linkedLists = new LinkedList[size];
    }

    //散列函数
    public int HashFun(int id) {
        return id % size;
    }

    //添加雇员
    public void add(Item item) {
        //根据员工的id，得到该员工添加到哪条链表
        int ItemLinkedListNO = HashFun(item.id);
        //将 Item添加到对应的链表中
        linkedLists[ItemLinkedListNO].addItem(item);
    }

    //遍历所有的链表,遍历哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            linkedLists[i].list();
        }
    }
}

//表示链表
class LinkedList {

    private Item head = null;//头指针，指向第一个元素 默认为null

    Item p;

    /**
     * 加载该链表的最后
     * id 自增 id 分配总是从小到大
     *
     * @param item
     */
    public void addItem(Item item) {
        if (head == null) {
            head = item;
            return;
        }

        //如果不是第一个元素，则使用一个辅助指针，帮助定位到最后一个元素
        Item cur = head;
        while (cur.nextItem != null) {
            cur = cur.nextItem;
        }
        //退出时，cur为最后一个元素 则 添加
        cur.nextItem = item;
    }

    /**
     * 遍历此链表
     */
    public void list() {
        if (head == null) {
            System.out.println("当前链表为空！");
            return;
        }
        System.out.println("当前链表信息为：");
        Item cur = head;
        while (cur.nextItem != null) {
            System.out.println(cur.toString());
            cur = cur.nextItem;//后移
        }
    }
}

class Item {
    public int id;
    public String name;
    public Item nextItem;//默认为空

    public Item(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
