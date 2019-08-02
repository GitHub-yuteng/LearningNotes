package Algorithm.Search;

/**
 * @author Yu
 */
public class SequenceSearch {

    public static void main(String[] args) {

        int[] arr = {9, 6, 1, 5, 4, 7, 8, 3, 2};
        int index = SequenceSearch(arr, 1);
        if (index == -1) {
            System.out.println("没有该数据！");
        } else {
            System.out.println(index);
        }

    }

    public static int SequenceSearch(int[] arr, int value) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
