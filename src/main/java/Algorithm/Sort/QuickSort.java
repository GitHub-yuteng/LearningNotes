package Algorithm.Sort;

import java.util.Arrays;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @author Yu
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {36, -7, -8, 99, -7, 2, 0, 67, 64, 3, 59, 76, 234, 64};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left) + 1), right);
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (arr[right] >= temp && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] <= temp && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    public static void swap(int[] sourceArray, int i, int j) {
        int tmp = sourceArray[i];
        sourceArray[i] = sourceArray[j];
        sourceArray[j] = tmp;
    }
}
