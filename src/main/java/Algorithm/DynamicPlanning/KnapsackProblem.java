package Algorithm.DynamicPlanning;

/**
 * @author Yu
 */
public class KnapsackProblem {

    public static void main(String[] args) {

        int[] w = {1, 4, 3, 5, 2};//TODO 物品重量
        int[] v = {1500, 3000, 2000, 100, 200};//TODO 物品的价值
        int capacity = 16;//TODO 背包的容量
        int n = v.length;//TODO 物品的个数


        //TODO 二维数组  valve[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] value = new int[n + 1][capacity + 1];
        //TODO 第一列第一行默认为0
        for (int i = 0; i < value.length; i++) {
            value[i][0] = 0;//TODO 第一列设置为0
        }
        for (int i = 0; i < value[0].length; i++) {
            value[0][i] = 0;//TODO 第一行设置为0
        }

        //TODO 显示初始化后DP需要的二维数组
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }

        //TODO 为了记录放入商品的情况，在定义一个二维数组
        int[][] name = new int[n + 1][capacity + 1];


        //TODO 不处理第一行因为是0，初始化不需要处理
        for (int i = 1; i < value.length; i++) {
            for (int j = 1; j < value[0].length; j++) {
                if (w[i - 1] > j) {//TODO 因为是从i=1开始的，所以物品重量数组要从0开始，要-1
                    value[i][j] = value[i - 1][j];
                } else {
//                    value[i][j] = Math.max(value[i - 1][j], v[i - 1] + value[i - 1][j - w[i - 1]]);
                    //TODO 因为记录商品存放到背包的情况，所以要用if else 方法
                    if (value[i - 1][j] >= v[i - 1] + value[i - 1][j - w[i - 1]]) {
                        value[i][j] = value[i - 1][j];
                    } else {
                        value[i][j] = v[i - 1] + value[i - 1][j - w[i - 1]];
                        name[i][j] = 1;
                    }
                }
            }
        }

        System.out.println("========value==========");
        //TODO
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                System.out.print(value[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("========name==========");
        //TODO
        for (int i = 0; i < name.length; i++) {
            for (int j = 0; j < name[i].length; j++) {
                System.out.print(name[i][j] + " ");
            }
            System.out.println();
        }

        int name_i = name.length - 1;
        int name_j = name[0].length - 1;

        while (name_i > 0 && name_j > 0) {
            if (name[name_i][name_j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", name_i);
                name_j -= w[name_i - 1];
            }
            name_i--;
        }
    }
}
