package Algorithm.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Yu
 * <p>
 * 快速排序    不稳定
 * <p>
 * 时间复杂度
 * 平均 O(nlogn)
 * 最好情况 O(nlog n)
 * 最坏情况 O(n^2)
 * <p>
 * 空间复杂度 O(log n)
 * <p>
 * 冒泡的改进  每次确定一个位置
 * <p>
 * 当数据是顺序的，pivot取最后一个，就变成了 O(n^2)
 */
public class RandomQuickSort {

    public static void main(String[] args) {

        int[] testArray = {326, -37, -233, 255, 674, 645, 3345, 53339, 76, 234, 64};
        Stream.of(testArray).forEach(ele -> System.out.println(Arrays.toString(ele) + " "));
        //System.out.println("-----testSelection------");
        //int[] testArray = new int[8000000];
        //for (int i = 0; i < 8000000; i++) {
        //    testArray[i] = (int) (Math.random() * 80000000);//生成一个 [0,800000) 内的数字
        //}

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);
        quickSort(testArray, 0, testArray.length - 1);
        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);
        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");

        Stream.of(testArray).forEach(ele -> System.out.println(Arrays.toString(ele) + " "));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            // p 数组中： p[0] 表示等于区域的左边界，p[1] 表示等于区域的右边界，
            // 左边区域：L ~ p[0] - 1;右边区域： p[1] + 1 ~ R;
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0] - 1);
            quickSort(arr, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] sourceArray, int left, int right) {
        System.out.println("================================");
        int low = left - 1;
        int hight = right;
        while (left < hight) {
            if (sourceArray[left] < sourceArray[right]) {
                swap(sourceArray, ++low, left++);
                Stream.of(sourceArray).forEach(ele -> System.out.println(Arrays.toString(ele) + " "));
            } else if (sourceArray[left] > sourceArray[right]) {
                swap(sourceArray, --hight, left);
                Stream.of(sourceArray).forEach(ele -> System.out.println(Arrays.toString(ele) + " "));
            } else {
                left++;
            }
        }
        swap(sourceArray, hight, right);
        Stream.of(sourceArray).forEach(ele -> System.out.println(Arrays.toString(ele) + " "));
        return new int[]{low + 1, hight};
    }

    public static void swap(int[] sourceArray, int i, int j) {
        int tmp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = tmp;
    }
}
