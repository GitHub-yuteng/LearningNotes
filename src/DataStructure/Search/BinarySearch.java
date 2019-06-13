package DataStructure.Search;

import java.util.ArrayList;

/**
 * @author Yu
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11, 23, 56, 89, 119, 2223, 3333, 656556};

        int index = binarySearch(arr, 9);
        if (index == -1) {
            System.out.println("没有该数据！");
        }
        System.out.println(index);

        ArrayList<Integer> searchAll = binarySearchAll(arr, 9);
        if (searchAll.size() > 0) {
            System.out.println("返回所有相等数据索引：" + searchAll);
        } else {
            System.out.println("没有该数据！");
        }
    }


    public static ArrayList<Integer> binarySearchAll(int[] arr, int item) {

        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int guess = arr[mid];

            if (guess == item) {
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
            if (guess > item) {
                high = mid - 1;
            }
            if (guess < item) {
                low = mid + 1;
            }
        }
        return new ArrayList<>();
    }

    public static int binarySearch(int[] arr, int item) {

        int low = 0;
        int high = arr.length - 1;
        int index = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int midVal = arr[mid];

            if (midVal == item) {
                index = mid;
                break;
            }
            if (midVal > item) {
                high = mid - 1;
            }
            if (midVal < item) {
                low = mid + 1;
            }
        }
        return index;
    }
}
