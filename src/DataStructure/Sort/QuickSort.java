package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Yu
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {67, -77, 2, 64, 65, 5, 12};


        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----testSelection------");
        int[] testArray = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            testArray[i] = (int) (Math.random() * 80000000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

        QuickSort(testArray, 0, testArray.length - 1);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }

    public static void QuickSort(int[] arr, int left, int right) {

        int l = left;//左索引
        int r = right;//右索引
        int middle = arr[(left + right) / 2]; //中间值

        int temp = 0;//临时变量
        //比 middle 值 小的放左边， 大的放右边
        while (l < r) {
            //在 middle 的左边一直找，找到大于等于 middle值，才退出
            while (arr[l] < middle) {
                l += 1;
            }
            //在 middle 的右边一直找，找到小于等于 middle值，才退出
            while (arr[r] > middle) {
                r -= 1;
            }
            //如果 l>= r 说明 middle的左右两边的值，应按照
            // 左边全部小于 middle  右面全部大于middle 但是 无序
            if (l >= r) {
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换后，发现 arr[l] == middle r--
            if (arr[l] == middle) {
                r -= 1;
            }

            //如果交换后，发现 arr[r] == middle l++
            if (arr[r] == middle) {
                l += 1;
            }
        }

        //如果 l==r ，必须 l++,r-- 否则出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
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
