package LeetCode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Yu
 */
public class FindMedianSortedArrays_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] max = new int[nums1.length + nums2.length];
        int i = 0, j = 0, p = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                max[p++] = nums1[i++];
            } else {
                max[p++] = nums2[j++];
            }


            while (i == nums1.length && j < nums2.length) {
                max[p++] = nums2[j++];
            }

            while (j == nums2.length && i < nums1.length) {
                max[p++] = nums1[i++];
            }
        }

        System.out.println(Arrays.toString(max));
        return 0;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};

//        double v = findMedianSortedArrays(num1, num2);
//        System.out.println(v);

        int[] nums = {1,2,3,4};
        boolean b = containsDuplicate(nums);
        System.out.println(b);


    }

    public static boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }
}
