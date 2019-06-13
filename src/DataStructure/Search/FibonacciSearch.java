package DataStructure.Search;

import java.util.Arrays;

/**
 * @author Yu
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
    }

    public static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    /**
     * @param arr
     * @param item
     * @return
     */
    public static int FibonacciSearch(int[] arr, int item) {

        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int[] fib = fib();

        //获取到斐波那契分割数值的下标
        while (high > fib[k] - 1) {
            k++;
        }

        //因为 fib[k] 值 可能大于 arr的长度,因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足部分会使用0填充
        int[] temp = Arrays.copyOf(arr, fib[k]);

        //实际上需要用a数组的最后的数值进行填充 temp
        for (int i = high + 1; i < temp.length; i++) {

        }

        return -1;
    }
}
