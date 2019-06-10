package DataStructure.Recursion;

/**
 * @author Yu
 */
public class MiGong {

    public static void main(String[] args) {

        //创建一个二维数值 模拟迷宫
        int[][] map = new int[8][7];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

//        使用 1 表示墙
//        上下 置为 1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;//最上面一行置为 1
            map[7][i] = 1;//最下面一行置为 1
        }

        //左右 置为 1
        for (int i = 1; i < 8; i++) { //从第二行开始
            map[i][0] = 1; //左面 第一列  第 2 - 7 行
            map[i][6] = 1;// 右面
        }

        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][3] = 1;
        map[2][2] = 1;

        System.out.println();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用递归回溯
        setWay(map,1,1);

        System.out.println("---路径---");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    //使用递归回溯 找路径

    /**
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路，返回true，否则返回 false
     * <p>
     * 从 i,j 出发 (1,1)
     * map[6][5] 结束
     * <p>
     * 当地图的 ij 为 0  该点没有走过， 1为墙，2 表示走过的路径，3 表示该点已经走过但是走不通
     * <p>
     * 策略： ↓ → ↑ ←  如果该点 走不通，回溯
     */
    public static boolean setWay(int[][] map, int i, int j) {

        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //按照策略
                map[i][j] = 2;//假定该点是可以走通的。
                if (setWay(map, i + 1, j)) { //  ↓
                    return true;
                } else if (setWay(map, i, j + 1)) {//  →
                    return true;
                } else if (setWay(map, i - 1, j)) {//  ↑
                    return true;
                } else if (setWay(map, i, j - 1)) {//  ↑
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果 map[i][j] != 0 , 可能是 1、2、3
                return false;
            }
        }
    }
}
