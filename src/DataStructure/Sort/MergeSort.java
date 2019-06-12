package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * 分治思想
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----testMergeSort------");
        int[] testArray = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            testArray[i] = (int) (Math.random() * 80000000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

        mergeSort(testArray);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
//        int mid = left + ((right - left) / 2); // <-->  (l+r)/2
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        // left - mid   mid+1 - right 两个序列已经排好序，但整体无序
        // merge的过程就是将两个序列排序
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // 申请辅助数组,存放合并后的序列
        int[] help = new int[right - left + 1];
        int i = 0;//指向 help 数组的当前索引
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面 while 两个必有且只有一个 数组先遍历完毕
        // 两个循环只会执行一个
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }
        //并不是每次都拷贝所有
        //两个两个的拷贝
//        System.out.println("left---->" + left);
//        System.out.println("right---->" + right);
        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i];
        }
//        System.out.println(Arrays.toString(arr));
    }
}