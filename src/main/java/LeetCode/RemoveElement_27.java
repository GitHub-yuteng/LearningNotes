package LeetCode;

/**
 * @author Yu
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement_27 {

    public static int removeElement_1(int[] nums, int val) {

        if(nums==null || nums.length == 1){
            return nums.length;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                //TODO 原地修改
                nums[i] = nums[j];
                //TODO 返回数组新长度
                i++;
            }
        }
        return i;
    }

    /**
     * 不保证元素顺序，当前元素与数组最后的元素交换位置，然后缩小数组长度
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement_1(nums, 2);
        System.out.println(i);
    }
}
