package DataStructure.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Yu
 * 插入排序   ->n小时较好  稳定
 *
 * 时间复杂度
 * 平均 O(n^2)
 * 最好情况 O(n)
 * 最坏情况 O(n^2)
 *
 * 空间复杂度 O(1)
 */

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 45, 65, 33, 12};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("-----testInsertSort------");
        int[] testArray = new int[80000];
        for (int i = 0; i < 80000; i++) {
            testArray[i] = (int) (Math.random() * 800000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

        InsertSort(testArray);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }


    public static void InsertSort(int[] arr) {

        int count = 0;
        int insertVal = 0;
        int insertIndex = 0;

        // 把第一个元素看成有序表，剩下的 无序表 n-1个元素依次插入。
        // 总共需要 arr.length -1 轮
        // int[] arr = {4, 3, 2, 45, 65, 33, 12};
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            // insertIndex >= 0 保证在给 insertVal找插入位置不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                count++;//计数
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //优化  判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

//            System.out.println("第"+i+"次排序："+Arrays.toString(arr));
        }
        System.out.println("次数：" + count);
    }
}
