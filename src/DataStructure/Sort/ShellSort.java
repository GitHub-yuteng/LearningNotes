package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Yu
 * 升级插入排序
 * 缩小增量排序
 * 希尔排序 O(nlogn)	O(ns) 1<s<2	不稳定	O(1)	s是所选分组
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {67, 77, 2, 64, 65, 5, 12};
        shellsort2(arr);
        System.out.println("最终结果：" + Arrays.toString(arr));

        System.out.println("-----testShellsort------");
        int[] testArray = new int[80000];
        for (int i = 0; i < 80000; i++) {
            testArray[i] = (int) (Math.random() * 800000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

//        shellsort(testArray);// 交换法
//        shellsort2(testArray);// 移位法

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");

    }

    // 移动法  优化
    public static void shellsort2(int[] arr) {
        int count = 0;
        //希尔排序  增量 step  宏观调控 后   最后一次微调
        for (int step = arr.length / 2; step > 0; step /= 2) {
            // 从第 step 个元素，逐个对其所在的组进行插入排序
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - step]) {
                    while (j - step >= 0 && temp < arr[j - step]) {
                        //移动
                        arr[j] = arr[j - step];
                        j -= step;
                    }
                    //当退出while后，就给temp找到了插入的位置
                    arr[j] = temp;
                    System.out.println("第" + ++count + "轮shellsort排序：" + Arrays.toString(arr));
                }
            }

        }
    }

    // 交换法  效率低
    public static void shellsort(int[] arr) {

        int temp = 0;
        int count = 0;
        //希尔排序   宏观调控 后   最后一次微调
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                //遍历各组中所有的元素(共step组，每组有两个元素进行比较)
                for (int j = i - step; j >= 0; j -= step) {
                    //如果当前元素大于加上步长后的那个元素，则交换
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j];
                        arr[j] = arr[j + step];
                        arr[j + step] = temp;
                    }
                }
            }
            System.out.println("第" + ++count + "轮shellsort排序：" + Arrays.toString(arr));
        }
    }
}
