package Algorithm.Search;

import java.util.ArrayList;

/**
 * @author Yu
 */
public class RecursiveBinarySearch {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 56, 56, 56, 89, 119, 2223, 56, 3333, 656556};
        int[] arr = {1, 9, 56, 56, 56, 89, 119, 2223, 3333, 4444, 5555, 6666};

        int index = binarySearch(arr, 3333, 0, arr.length - 1);
        if (index == -1) {
            System.out.println("没有该数据！");
        }
        System.out.println("返回索引：" + index);

        ArrayList<Integer> searchAll = binarySearchAll(arr, 56, 0, arr.length - 1);
        if (searchAll.size() > 0) {
            System.out.println("返回所有相等数据索引：" + searchAll);
        } else {
            System.out.println("没有该数据！");
        }
    }

    //找到所有的 需要找的数据
    public static ArrayList<Integer> binarySearchAll(int[] arr, int item, int low, int high) {

        if (low > high) {
            return new ArrayList<>();
        }
        int mid = (low + high) / 2;
        int guess = arr[mid];

        if (guess > item) {
            return binarySearchAll(arr, item, low, mid - 1);
        } else if (guess < item) {
            return binarySearchAll(arr, item, mid + 1, high);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            //中间左边的与 item 相同数据 的索引
            // 因为二分查找是 有序 数组，所以相同数据肯定在左右两侧 ！！！！！
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != item) {
                    break;
                }
                list.add(temp);
                temp -= 1;
            }

            //中间 item 相同数据 的索引
            list.add(mid);

            //中间右边的与 item 相同数据 的索引
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != item) {
                    break;
                }
                list.add(temp);
                temp += 1;
            }

            return list;
        }
    }

    public static int binarySearch(int[] arr, int item, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        int midVal = arr[mid];

        if (midVal == item) {
            return mid;
        } else if (midVal > item) {
            return binarySearch(arr, item, low, mid - 1);
        } else {
            return binarySearch(arr, item, mid + 1, high);
        }
    }
}
