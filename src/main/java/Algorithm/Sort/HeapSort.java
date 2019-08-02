package Algorithm.Sort;

/**
 * @author Yu
 * 堆排序   ->n小时较好  不稳定
 * <p>
 * 时间复杂度
 * 平均 O(nlog n)
 * 最好情况 O(nlog n)
 * 最坏情况 O(nlog n)
 * <p>
 * 空间复杂度 O()
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};

        //升序 大顶堆


        //降序 小顶堆

    }

    public static void heapSort(int[] arr) {

    }

    //将一个数组(二叉树)，调整成一个大顶堆

    /**
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整 length 是在逐渐的减少
     */
    public static void adjustHead(int[] arr, int i, int length) {

        int temp = arr[i];//先取出当前元素的值，保存在临时变量

        //开始调整
        for (int k = 0; k < length; k++) {
            
        }

    }
}
