package 剑指Offer.No2Array;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 */
public class Solution {
    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9},
                         {2, 4, 9, 12},
                         {4, 7, 10, 13},
                         {6, 8, 11, 15}};
        System.out.println(findByTheUpperRightCorner(10, array));
        System.out.println(findByTheLowerLeftCorner(7, array));
    }

    /*
     * 选取数组查找范围内的右上角的数字，如果该数字等于要查找的数字，则查找结束。
     * 如果该数字小于要查找的数字，则剔除该数字所在的行；
     * 如果该数字大于要查找的数字，则剔除该数字所在的列；
     */
    public static boolean findByTheUpperRightCorner(int target, int[][] array) {
        if (array.length > 0) {
            int rows = array.length;
            int columns = array[0].length;

            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0) {
                if (array[row][column] == target)
                    return true;
                if (array[row][column] > target)// TODO 如果该数字大于要查找的数字，则剔除该数字所在的列；
                    column--;
                else //TODO 如果该数字小于要查找的数字，则剔除该数字所在的行；
                    row++;
            }
            return false;
        }
        return false;
    }

    /*
     * 选取数组查找范围内的左下角的数字，如果该数字等于要查找的数字，则查找结束；
     * 如果该数字小于要查找的数字，则剔除该数字所在的列；
     * 如果该数字大于要查找的数字，则剔除该数字所在的行；
     */
    public static boolean findByTheLowerLeftCorner(int target, int[][] array) {
        if (array.length > 0) {
            int rows = array.length;
            int columns = array[0].length;

            int row = rows - 1;
            int column = 0;

            while (row >= 0 && column < columns) {
                if (array[row][column] == target)
                    return true;
                if (array[row][column] < target)
                    column++;
                else
                    row--;
            }
            return false;
        }
        return false;
    }
}