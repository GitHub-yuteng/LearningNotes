package LeetCode;

/**
 * @author Yu
 */
public class RemoveDuplicates_26 {

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 1 || nums.length == 0) {
            return nums.length;
        }

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
