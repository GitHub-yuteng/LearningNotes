package Algorithm.Sort;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

/**
 * @author Yu
 *
 * 空间换时间 经典算法
 *
 * 基数排序    稳定
 *
 * 时间复杂度
 * 平均 O(n*k)
 * 最好情况 O(n*k)
 * 最坏情况 O(n*k)
 *
 * 空间复杂度 O(n+k)
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {53, 3, 542, 748, 14, 214};
        System.out.println("原数组:" + Arrays.toString(arr));
        RadixSort(arr);
        System.out.println("结果：" + Arrays.toString(arr));

        System.out.println("-----testRadixSort------");
        // (8000000 * 10 + 8000000 ) * 4 / 1024 / 1024 / 1024
        int[] testArray = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            testArray[i] = (int) (Math.random() * 80000000);//生成一个 [0,800000) 内的数字
        }

        LocalTime start = LocalTime.now();
        System.out.println("开始时间为：" + start);

        RadixSort(testArray);

        LocalTime end = LocalTime.now();
        System.out.println("结束时间为：" + end);

        Duration time = Duration.between(start, end);
        System.out.println("时间为：" + time.toMillis() + " 毫秒！");
    }


    public static void RadixSort(int[] arr) {

        //得到数组中最大的数的位数
        int max = arr[0];//假定最大数 为第一个元素， 找到最大值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数   得出一共循环几轮
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];

        //记录每个桶中，实际存放了多少个数据，定义一个一维数据记录各个桶每次放入的个数
        //比如 bucketElementCounts[0] 就是 0 编号桶内的元素个数 一共10个桶 
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //每个元素的位数进行排序   n=1 步长为 *10 则每次 增量为 十倍
            //第一次 个位
            //第二次 十位
            //第三次 百位
            for (int j = 0; j < arr.length; j++) {
                //取出每次循环 元素对应位的值 放入对应的桶
                int digitOfElement = arr[j] / n % 10;
                //放入对应的桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                //自增 目的为上面每次添加的索引加一 同时还能保证记录 桶中元素个数有多少
                bucketElementCounts[digitOfElement]++;
            }

            //放入后 取出
            //按照这个桶的顺序(一维数组的下标一次取出数据，放入原来的数组)
            int index = 0;// 临时指针,帮助指向桶中数据 遍历
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for (int k = 0; k < bucket.length; k++) {
                //因为有些桶中无数据，进行判断，有数据的才放入原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，即k桶，第k个一维数组，放入原数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入原 arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将
                bucketElementCounts[k] = 0;
            }
            //一定要是   i+1 轮 不然 影响遍历  不能让 i变量自增
//            System.out.println("第" + (i + 1) + "轮处理后：" + Arrays.toString(arr));
        }
    }
}
