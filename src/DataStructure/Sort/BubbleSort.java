package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * 时间复杂度   O(n^2)
 * 冒泡	O(n^2)	    O(n^2)	稳定	O(1)	n小时较好
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {9, 6, 1, 5, 4, 7, 8, 3, 2};
        System.out.println("原数组："+Arrays.toString(arr));
        bubbleSort(arr, arr.length);
        System.out.println("外循环控制循环次数！");
        System.out.println("排序后："+Arrays.toString(arr));
        System.out.println("----------------------------------");


        int[] array1 = {95, -2, 1, -5, 4, 97, -8, 3, 2};
        int[] array = {1,2,3,4,5,6,7};
        System.out.println("原数组："+Arrays.toString(array));
        //算法优化
        inBubbleSort(array);
        System.out.println("-----inBubbleSort------");
        System.out.println(Arrays.toString(array));

        //测试冒泡排序的速度 O(n*n)
        //创建一个 80000个 随机的数组;
        System.out.println("-----testInBubbleSort------");
        int[] testArray = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            testArray[i] = (int) (Math.random() * 800000);//生成一个 [0,800000) 内的数字
        }
//        System.out.println(Arrays.toString(testArray));

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为："+start);

        inBubbleSort(testArray);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为："+end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为："+time.toMillis()+" 毫秒！");
    }

    //这种是内循环控制循环次数 每次排序长度减 1
    public static void inBubbleSort(int[] array){
        int count = 0;
        int temp = 0;//临时变量
        boolean flag = false;//标识变量，表示是否进行过交换

        //这种是内循环控制
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    count++;
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟排序后的数组！");
//            System.out.println(Arrays.toString(array));

            if(!flag){ //在一趟排序中，没有发生交换
                break;
            }else {
                flag = false;//重置flag！, 进行下次判断
            }
        }
        System.out.println("交换次数："+count);
    }


    public static void bubbleSort(int[] arr, int length) {

        // 循环一次，最大值在最后
        // Bubble(arr, arr.length);
        // Bubble(arr, arr.length-1);
        // Bubble(arr, arr.length-2);
        // Bubble(arr, ...);
        // Bubble(arr, 1);

        // >=1    >0  是一样的
        //外循环控制 循环次数
        for (int j = length; j >= 1; j--) {
            bubble(arr, length);
        }
    }

    public static void bubble(int[] arr, int length) {
        int temp;
        // 一次排序，最大的数到最后一位
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}