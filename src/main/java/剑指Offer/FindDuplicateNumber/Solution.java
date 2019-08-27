package 剑指Offer.FindDuplicateNumber;

/**
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 解题思路：数字归位。归位后面又有要归位的数字，则说明有重复值！
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
            //TODO 这里判断 i 位置 应该对应 i 值
            //TODO 对应 则判断下一位数字
            //TODO 不对应 则对该数字进行归位
            while (numbers[i] != i) {
                //TODO 如果 numbers[i]上的值 == numbers[i]的值对应下标上的值
                //TODO 说明 该值重复
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication = numbers[i];
                    System.out.println(duplication);
                    return true;
                }
                //TODO 如果不等，则把该numbers[i]上的值,放到对应位置
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    //TODO index 说明该值应该归位到 Index 位置上
    private static void swap(int[] numbers, int i, int index) {
        //TODO num 和 index 值相同
        int num = numbers[i];
        //TODO numbers[index] 与 i 位置交换
        numbers[i] = numbers[index];
        //TODO numbers[i]上的值num，应该放到index处。
        numbers[index] = num;
    }

    //长度为8  所以 n-1  n为7  则数字只有0-7范围内
    public static void main(String[] args) {
        int[] arr = {0, 3, 1, 0, 4, 4, 2, 5};
        boolean result = duplicate(arr, arr.length, duplication);
        System.out.println(result);
    }
}
