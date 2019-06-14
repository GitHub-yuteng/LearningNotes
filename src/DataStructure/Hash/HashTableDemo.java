package DataStructure.Hash;


import java.util.Scanner;

/**
 * @author Yu
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(16);

        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop) {
            System.out.println("----------哈希表---------------");
            System.out.println("a(add)：添加元素！");
            System.out.println("l(list)：显示元素！");
            System.out.println("f(find)：查找指定元素！");
            System.out.println("u(update)：更新指定元素！");
            System.out.println("d(delete)：删除指定元素！");
            System.out.println("e(exit)：退出程序！");
            System.out.println("--------------------------");
            key = scanner.next().charAt(0);//接受一个字符

            switch (key) {
                case 'a':
                    System.out.println("请输入一个id数字:");
                    int id = scanner.nextInt();
                    System.out.println("请输入一个名字:");
                    String name = scanner.next();

                    Item item = new Item(id, name);
                    hashTable.add(item);
                    break;
                case 'l':
                    hashTable.list();
                    break;
                case 'f':
                    System.out.println("请输入一个需要查找的 id:");
                    int fId = scanner.nextInt();
                    hashTable.findItemById(fId);
                    break;
                case 'u':
                    System.out.println("请输入一个需要更新的 id:");
                    int uId = scanner.nextInt();
                    System.out.println("请输入一个需要更新的 name:");
                    String uName = scanner.next();
                    hashTable.updateItemById(uId,uName);
                    break;
                case 'd':
                    System.out.println("请输入一个需要删除的 id:");
                    int Did = scanner.nextInt();
                    hashTable.deleteItemById(Did);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
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

        //重要！！ 分别初始化每条链表
        for (int i = 0; i < size; i++) {
            linkedLists[i] = new LinkedList();
        }
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
    public void list() {
        for (int i = 0; i < size; i++) {
            linkedLists[i].list(i + 1);
        }
    }

    /**
     * 根绝id查找Item
     */
    public void findItemById(int id) {
        //根绝散列函数确认该链表
        int listNO = HashFun(id);

        Item item = linkedLists[listNO].findItemById(id);
        if (item == null) {
            System.out.println("在哈希表中没有找到该元素！");
        } else {
            System.out.println("第 " + (listNO + 1) + " 条链表中:" + item.toString());
        }
    }

    public void updateItemById(int id, String name) {
        //根绝散列函数确认该链表
        int listNO = HashFun(id);

        Item item = linkedLists[listNO].updateItemById(id, name);
        if (item == null) {
            System.out.println("在哈希表中没有找到该元素！");
        } else {
            System.out.println("修改成功，第 " + (listNO + 1) + " 条链表中:" + item.toString());
        }
    }

    /**
     * 根绝id查找Item
     */
    public void deleteItemById(int id) {
        //根绝散列函数确认该链表
        int listNO = HashFun(id);
        linkedLists[listNO].deleteItemById(id);
    }
}

//表示链表
class LinkedList {

    private Item head = new Item(-1, " ");//头指针，指向第一个元素

    /**
     * 加载该链表的最后
     * id 自增 id 分配总是从小到大
     *
     * @param item
     */
    public void addItem(Item item) {

        Item cur = head;

        //如果不是第一个元素，则使用一个辅助指针，帮助定位到最后一个元素
        while (true) {
            if (cur.nextItem == null) {
                break;
            }

            cur = cur.nextItem;
        }

        //退出时，cur为最后一个元素 则 添加
        cur.nextItem = item;
    }

    /**
     * 遍历此链表
     *
     * @param i 链表编号
     */
    public void list(int i) {
        if (head.nextItem == null) {
            System.out.println("第 " + i + " 条链表为空！");
            return;
        }
        System.out.print("第 " + i + " 链表信息为：");
        Item cur = head;
        while (true) {
            if (cur.nextItem == null) {
                break;
            }
            cur = cur.nextItem;//后移
            System.out.print(cur.toString() + ";");

        }
        System.out.println();
    }

    //根绝id查找Item
    //如果查找到 返回  查找不到 返回null
    public Item findItemById(int id) {
        if (head.nextItem == null) {
            System.out.println("链表为空！");
            return null;
        }

        Item curItem = head;
        while (true) {

            //退出 遍历到尾部都没有相等结果，则没有该数据
            if (curItem.nextItem == null) {
                curItem = null;
                break;
            }

            //找到该 元素 退出返回
            if (curItem.nextItem.id == id) {
                curItem = curItem.nextItem;//后移
                break;
            }
            curItem = curItem.nextItem;//后移
        }
        return curItem;
    }

    //根绝id更新Item name
    //如果查找到 返回  查找不到 返回null
    public Item updateItemById(int id, String name) {
        if (head.nextItem == null) {
            System.out.println("链表为空！");
            return null;
        }

        Item curItem = head;
        while (true) {

            //退出 遍历到尾部都没有相等结果，则没有该数据
            if (curItem.nextItem == null) {
                curItem = null;
                break;
            }

            //找到该 元素 退出返回
            if (curItem.nextItem.id == id) {
                curItem = curItem.nextItem;//后移
                curItem.name = name;
                break;
            }
            curItem = curItem.nextItem;//后移
        }
        return curItem;
    }

    //根绝id删除Item
    //如果查找到 返回  查找不到 返回null
    public void deleteItemById(int id) {

        if (head.nextItem == null) {
            System.out.println("链表为空，无法删除指定元素！");
            return;
        }

        Item curItem = head;
        while (true) {

            //退出 遍历到尾部都没有相等结果，则没有该数据
            if (curItem.nextItem == null) {
                System.out.println("没有找到该元素！");
                break;
            }

            //找到该 元素 删除
            if (curItem.nextItem.id == id) {
                System.out.println("删除成功:" + curItem.nextItem.toString());
                curItem.nextItem = curItem.nextItem.nextItem;//后移
                break;
            }
            curItem = curItem.nextItem;//后移
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
