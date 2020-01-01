package Algorithm.Recursion;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Yu
 */
public class HorseChessBorad {

    private static int X = 8;//棋盘的行数
    private static int Y = 8;//棋盘的列数
    private static int row = 1;//初始位置
    private static int colum = 2;//初始位置
    private static int[][] chessBoard = new int[X][Y];//创建一个二维数值
    private static boolean[][] visited = new boolean[X][Y];//创建一个二维数值 是否访问过
    private static boolean finished;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println("开始！");
        //使用递归回溯
        traversalChessBoard(chessBoard, row - 1, colum - 1, 1);
        long end = System.currentTimeMillis();

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println((end - start)/60);
    }

    /**
     * @param chessBoard
     * @param row        从0开始，当前列
     * @param colum      从0开始，当前列
     * @param step       初始为 1，
     */
    private static void traversalChessBoard(int[][] chessBoard, int row, int colum, int step) {
        chessBoard[row][colum] = step;
        visited[row][colum] = true;
        ArrayList<Point> pointsList = jumpAllPoint(new Point(colum, row));
//        sortPoint(pointsList);
        while (!pointsList.isEmpty()) {
            Point point = pointsList.remove(0);
            //TODO 该点没有访问过
            if (!visited[point.y][point.x]) {
                traversalChessBoard(chessBoard, point.y, point.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessBoard[row][colum] = 0;
            visited[row][colum] = false;
            finished=false;
        } else {
            finished = true;
        }
    }


    private static ArrayList<Point> jumpAllPoint(Point curPoint) {

        ArrayList<Point> pointList = new ArrayList<>();

        Point p = new Point();

        //TODO 5
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            pointList.add(new Point(p));
        }
        //TODO 6
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            pointList.add(new Point(p));
        }
        //TODO 7
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            pointList.add(new Point(p));
        }
        //TODO 0
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            pointList.add(new Point(p));
        }
        //TODO 1
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            pointList.add(new Point(p));
        }
        //TODO 2
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            pointList.add(new Point(p));
        }
        //TODO 3
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            pointList.add(new Point(p));
        }
        //TODO 4
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            pointList.add(new Point(p));
        }
        return pointList;
    }

    /**
     * 贪心优化，每次选择最少的减少回溯
     *
     * @param pointsList
     */
    private static void sortPoint(ArrayList<Point> pointsList) {
        pointsList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int o1Size = jumpAllPoint(o1).size();
                int o2Size = jumpAllPoint(o2).size();
                return o1Size >= o2Size ? 1 : -1;
            }

        });
    }
}
