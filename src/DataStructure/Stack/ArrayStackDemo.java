package DataStructure.Stack;

import java.util.Scanner;

/**
 * @author Yu
 */

public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(5);

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("------------栈--------------");
            System.out.println("s(show)：显示栈");
            System.out.println("p(push)：添加数据到栈");
            System.out.println("pop：从栈取出数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("--------------------------");
            System.out.println("请输入值：");
            key = scanner.next();

            switch (key) {
                case "s":
                    stack.traverse();
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

class ArrayStack {

    int top = -1;//栈顶
    int base = -1;//栈底

    int maxSize;//栈大小
    int[] stack;//数组模拟栈

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满！无法添加");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！无法取出数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void traverse() {
        //需要从栈顶向下遍历
        if (isEmpty()) {
            System.out.println("栈空！");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("Stack：" + stack[i]);
        }
        System.out.println("-------------------");
    }
}
