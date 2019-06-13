package DataStructure.Search;

/**
 * @author Yu
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 23, 56, 89, 119, 2223, 3333, 656556};

        int index = binarySearch(arr, -2, 0, arr.length - 1);
        if (index == -1) {
            System.out.println("没有该数据！");
        }
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int item, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int guess = arr[mid];

        if (guess == item) {
            return mid;
        } else if (guess > item) {
            return binarySearch(arr, item, low, mid - 1);
        } else {
            return binarySearch(arr, item, mid + 1, high);
        }
    }
}
