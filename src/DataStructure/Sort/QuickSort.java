package DataStructure.Sort;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Yu
 *
 * 快速排序    不稳定
 *
 * 时间复杂度
 * 平均 O(nlogn)
 * 最好情况 O(nlog n)
 * 最坏情况 O(n^2)
 *
 * 空间复杂度 O(log n)
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {64, -7, 2, 64, 65, 60, 64, 70};
        System.out.println(Arrays.toString(arr));
//        int[] arr = {1};

        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----testSelection------");
        int[] testArray = new int[80000000];
        for (int i = 0; i < 80000000; i++) {
            testArray[i] = (int) (Math.random() * 800000000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

//        QuickSort(testArray, 0, testArray.length - 1);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }

    public static void QuickSort(int[] arr, int left, int right) {

        int l = left;//左索引
        int r = right;//右索引
        int pivot = arr[(left + right) / 2]; //中间值

        int temp = 0;//临时变量
        //比 pivot 值 小的放左边， 大的放右边
        while (l < r) {
            //在 pivot 的左边一直找，找到大于等于 pivot，才退出
            while (arr[l] < pivot) {
                l++;
            }
            //在 pivot 的右边一直找，找到小于等于 pivot，才退出
            while (arr[r] > pivot) {
                r--;
            }
            //如果 l== r 说明 pivot，应按照
            // 左边全部小于 pivot  右面全部大于 pivot 但是 无序
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            System.out.println(Arrays.toString(arr));

            //如果交换后，发现 arr[l] == pivot r--
            //如果有相同数据  不需要在进行比较
            if (arr[l] == pivot) {
                r--;
            }
//
//            //如果交换后，发现 arr[r] == pivot l++
//            //如果有相同数据
            if (arr[r] == pivot) {
                l++;
            }
        }

        //如果 l==r ，必须 l++,r-- 否则出现栈溢出
        if (l == r) {
            l++;
            r--;
        }

        //左递归
        if (left < r) {
            QuickSort(arr, left, r);
        }
        //左递归
        if (right > l) {
            QuickSort(arr, l, right);
        }
    }
}
