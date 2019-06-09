package Interview_3;

/*
在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
请找出数组中任意一个重复的数字。
*/

public class Solution {

    public static int duplication;

    public static boolean duplicate(int[] numbers, int length, int duplication) {

        if (numbers == null || numbers.length == 0) {
            System.out.println("数组为空");
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] >= numbers.length) {
                System.out.println("数组不符合条件");
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication = numbers[i];
                    System.out.println(duplication);
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    private static void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    //长度为8  所以 n-1  n为7  则数字只有0-7范围内 必定有重复数字
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 0, 4, 4, 2, 5};
        boolean result = duplicate(arr,arr.length,duplication);
        System.out.println(result);
    }
}

// 剑指Offer
/*
public boolean duplicate(int[] nums, int length, int[] duplication) {
    if (nums == null || length <= 0)
        return false;
    for (int i = 0; i < length; i++) {
        while (nums[i] != i) {
            if (nums[i] == nums[nums[i]]) {
                duplication[0] = nums[i];
                return true;
            }
            swap(nums, i, nums[i]);
        }
    }
    return false;
}
private void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
}
*/
