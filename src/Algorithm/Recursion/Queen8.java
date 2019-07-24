package Algorithm.Recursion;

/**
 * @author Yu
 */
public class Queen8 {

    //定义一个 max 表示共有多少个皇后;
    int max = 8;
    static int count = 0;
    static int judge = 0;
    int[] array = new int[max];

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有：" + count + "解法！");
        System.out.println("一共判断了：" + judge + "冲突！");
    }


    //编写一个方法，放置第n个皇后
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        //一次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n ,放到该行的第1列
            array[n] = i;

            //判断当放置第 n 个皇后到 第 i 列时，是否冲突。
            if (judge(n)) {//不冲突
                //接着放 n+1 皇后
                check(n + 1);
            }

            //如果冲突，就继续执行 array[n] = i; 即将第 n 个皇后，放置在本行的 后移的一个位置 因为 i++
        }
    }


    //查看我们放置第 n 个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        judge++;
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] ———> 表示判断第 n 个皇后是否和前面的 n-1 个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和前面的 i 个皇后在同意斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    //输出皇后的摆放位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
