package Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Yu
 */
public class QuickSort_Mine {

    public static void main(String[] args) {

        int[] arr = {36, -7, -8, 99, -7, 2,0, 67, 64, 3, 59, 76, 234, 64};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] souceArray, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = souceArray[right];
        int i = left;
        int j = right;

        while (i != j) {
            while (souceArray[i] <= pivot && i < j) {
                i++;
            }
            while (souceArray[j] >= pivot && i < j) {
                j--;
            }
            swap(souceArray, i, j);
        }

        swap(souceArray, i, right);
        quickSort(souceArray, left, i - 1);
        quickSort(souceArray, j + 1, right);
    }

    private static void swap(int[] souceArray, int i, int j) {
        int temp = souceArray[i];
        souceArray[i] = souceArray[j];
        souceArray[j] = temp;
    }
}
