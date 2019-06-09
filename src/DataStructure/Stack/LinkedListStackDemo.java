package DataStructure.Stack;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

/**
 * @author Yu
 */
public class LinkedListStackDemo {

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("------------链表栈--------------");
            System.out.println("s(list)：显示栈!");
            System.out.println("p(push)：添加数据到栈!");
            System.out.println("pop：从栈取出数据!");
            System.out.println("e(exit)：退出程序!");
            System.out.println("--------------------------");
            System.out.println("请输入值：");
            key = scanner.next();

            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "p":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.println("取出的数据是：" + pop);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束！");
    }
}

class LinkedListStack {


    private Node head = new Node(-1);

    Node top = head;
    Node stack = null;//辅助指针

    public LinkedListStack() {
    }

    public boolean isEmpty() {
        if (top == head) {
            return true;
        }
        return false;
    }

    public void push(int num) {

        if (top == head) {
            top = new Node(num);
            top.next = head;
            stack = top;
        }else {
            top = new Node(num);
            top.next = stack;
            stack = top;
        }


    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！无法取出数据");
        }

        int value = top.num;
        top = top.next;
        stack = top;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("遍历为空！");
            return;
        }

        while (stack.next != null) {
            System.out.println("链表栈：" + stack.num);
            stack = stack.next;
        }

        stack = top;
    }
}

//定义Node
class Node {
    int num;
    Node next;//指向下一个节点

    public Node(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Node:" + num;
    }
}
