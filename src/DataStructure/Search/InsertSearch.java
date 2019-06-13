package DataStructure.Search;

import java.util.Arrays;

/**
 * @author Yu
 * int mid = (low+high)/2= low +(high-low)/2 = low + (high-low)*(item-arr[low])/(arr[high] - arr[low])
 * <p>
 * 对于数据量较大，关键字分布比较均匀的查找表来说 较快
 * <p>
 * 关键字分布不均匀 该方法不一定比折半查找要好。
 */
public class InsertSearch {

    public static void main(String[] args) {

//        int[] arr = {1, 15,66,111,222,3333,35555,36666,49999};  //这个就要 5 次
        int[] arr = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arr[i] = i + 1;
        }
//        System.out.println(Arrays.toString(arr));
        int index = InsertSearch(arr, 1000000, 0, arr.length - 1);
        System.out.println(index);
    }

    public static int InsertSearch(int[] arr, int item, int low, int high) {
        System.out.println("-----");
        //必须要有 这两个条件  否则 mid 可越界
        if (low > high || item > arr[arr.length - 1] || item < arr[0]) {
            return -1;
        }
        int mid = low + (int) ((long) (high - low) * (item - arr[low]) / (arr[high] - arr[low]));
        int midVal = arr[mid];

        if (midVal == item) {
            return mid;
        } else if (midVal > item) {
            return InsertSearch(arr, item, low, mid - 1);
        } else {
            return InsertSearch(arr, item, mid + 1, high);
        }
    }
}
