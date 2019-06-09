package Interview_10;

/*
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class Solution2 {

    public static int Fibonacci(int target) {

        if (target <= 2){
            return target;
        }

        int pre2 = 1, pre1 = 2;
        int result = 0;

        for (int i = 3; i <= target; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }



    public static void main(String[] args) {
        int fibonacci = Solution2.Fibonacci(4);
        System.out.println(fibonacci);
    }
}