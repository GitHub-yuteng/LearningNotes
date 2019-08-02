package DataStructure.Queue;

import java.util.Scanner;

/**
 * @author Yu
 */
public class ArrQueueDemo {

    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while (loop){
            System.out.println("----------队列---------------");
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("p(peek)：查看队列头数据");
            System.out.println("e(exit)：退出程序");
            System.out.println("--------------------------");
            key = scanner.next().charAt(0);//接受一个字符

            switch (key){

                case 's':
                    arrQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字！");
                    int value = scanner.nextInt();
                    arrQueue.addQueue(value);
                    break;
                case 'g':
                   try {
                       int result = arrQueue.getQueue();
                       System.out.printf("取出的数据是%d\n",result);
                       break;
                   }catch (RuntimeException e){
                       System.out.println(e.getMessage());
                   }
                   break;
                case 'p':
                    try {
                        int result = arrQueue.peekQueue();
                        System.out.printf("队列头数据是%d\n",result);
                    }catch (RuntimeException e){
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

class ArrQueue{

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;//该数组用于存放数据，模拟队列

    public ArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;//指向队列头部前一个位置
        rear = -1;//指向队列尾部队列最后一个数据
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == (maxSize-1);
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){

        if(isFull()){
            System.out.println("队列已满！添加失败");
            return;
        }

        rear++;
        arr[rear] = n;
    }

    //出队
    public int getQueue(){

        if(isEmpty()){
            throw new RuntimeException("队列为空，不能获取数据！");
        }

        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){

        if(isEmpty()){
            System.out.println("队列为空，不能显示！");
            return;
        }
        //遍历
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列头数据  不是取出数据
    public int peekQueue(){

        if(isEmpty()){
            throw new RuntimeException("队列为空，无数据！");
        }
        return arr[front+1];
    }
}
