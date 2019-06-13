package DataStructure.Search;

/**
 * @author Yu
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 23, 56, 89, 119, 2223, 3333, 656556};

        int index = binarySearch(arr, 9);
        if (index == -1) {
            System.out.println("没有该数据！");
        }
        System.out.println(index);
    }


    public static int binarySearch(int[] arr, int item) {

        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (guess == item) {
                index = mid;
                break;
            }
            if (guess > item) {
                high = mid - 1;
            }
            if (guess < item) {
                low = mid + 1;
            }
        }
        return index;
    }
}
