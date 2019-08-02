package DataStructure.Queue;

import java.util.Scanner;

/**
 * @author Yu
 */
public class CircleArrQueueDemo {
    public static void main(String[] args) {
        CircleArrQueue circleArrQueue = new CircleArrQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop) {
            System.out.println("----------循环队列---------------");
            System.out.println("s(show)：显示循环队列");
            System.out.println("a(add)：添加数据到循环队列");
            System.out.println("g(get)：从循环队列取出数据");
            System.out.println("p(peek)：查看循环队列头数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("--------------------------");
            key = scanner.next().charAt(0);//接受一个字符

            switch (key) {

                case 's':
                    circleArrQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字！");
                    int value = scanner.nextInt();
                    circleArrQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = circleArrQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", result);
                        break;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int result = circleArrQueue.peekQueue();
                        System.out.printf("队列头数据是%d\n", result);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
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

class CircleArrQueue {

    private int maxSize;//数组最大容量

    /**
     * 循环队列：
     * 队列头 指向队列第一个元素 初始化 front = 0;
     */
    private int front;//队列头

    /**
     * 希望空出一个位置 来计算判断 循环队列为满
     */
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    public CircleArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;//指向队列头部第一个元素
        rear = 0;//指向队列尾部队列最后一个数据的后一个位置
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {

        if (isFull()) {
            System.out.println("队列已满！添加失败");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移
        rear = (rear + 1) % maxSize;
    }

    //出队
    public int getQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据！");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列为空，不能显示！");
            return;
        }

        //遍历  从front 开始遍历
        /**
         * (rear + maxSize - front) % maxSize
         * 循环队列中的有效数据
         */
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据的个数
    public int size() {
        int size = (rear + maxSize - front) % maxSize;
        return size;
    }

    //显示队列头数据  不是取出数据
    public int peekQueue() {

        if (isEmpty()) {
            throw new RuntimeException("队列为空，无数据！");
        }
        return arr[front];
    }
}