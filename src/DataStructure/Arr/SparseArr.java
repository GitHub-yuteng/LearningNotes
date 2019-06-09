package DataStructure.Arr;

/**
 * @author Yu
 */
public class SparseArr {

    public static void main(String[] args) {

        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][5] = 2;

        //输出二维数组
        System.out.println("--------------原始二维数组！------------");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //先遍历二维数组，得到非0数组的个数
        int sum = 0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("sum = " + sum);

        //转换为稀疏数组  SparseArr
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组分析
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;

        int count = 0;//用于记录第几个非0数据
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("--------------稀疏数组！------------");
        for (int[] row : sparseArr) {
            for (int item : row) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        System.out.println("--------------还原二维数组！------------");

        int Arr[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
            Arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        

        for (int[] row : Arr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
