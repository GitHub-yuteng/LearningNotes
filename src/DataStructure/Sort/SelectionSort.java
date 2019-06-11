package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * 每次遍历找到最小值 与 arr[i] 进行交换   i  0~arr.length-1
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 45, 65, 33, 12};
        System.out.println("交换之前：" + Arrays.toString(arr));


//        Selection(arr);
//        Selection2(arr);

        System.out.println("-----testSelection------");
        int[] testArray = new int[80000];
        for (int i = 0; i < 80000; i++) {
            testArray[i] = (int) (Math.random() * 800000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

        Selection2(testArray);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }

//	0--1
//	0--2
//	0--3
//	0--4
//	1--2
//	1--3
//	1--4
//	2--3
//	2--4
//	3--4

    public static void Selection2(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;  //假定最小值索引
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                count++;
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println("第" + (i + 1) + "轮交换后：" + Arrays.toString(arr));
        }
        System.out.println("交换次数："+count);
    }

    public static void Selection(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            for (int i = j; i < arr.length; i++) {
                int temp;
                if (arr[j - 1] > arr[i]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println("第" + j + "轮交换后：" + Arrays.toString(arr));
        }
    }
}