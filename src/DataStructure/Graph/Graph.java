package DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yu
 * 多对多关系
 * <p>
 * 图概念：
 * 顶点(vertex)、
 * 边(edge)、
 * 路径、无向图、
 * 有向图、
 * 带权图
 * <p>
 * 表示图的方法：
 * 二维数组->邻接矩阵(浪费空间 n*n)、
 * 链表->邻接表(只存储有效数据)很像稀疏数组。
 */
public class Graph {

    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    //记录结点是否被访问过
    private boolean[] isVisited;


    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A", "B", "C", "D", "E"};

        Graph graph = new Graph(n);

        //添加顶点
        for (String vertex : vertexs) {
            graph.inserVertex(vertex);
        }

        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();
        System.out.println(graph.getNumOfVertex());
        System.out.println(graph.getNumOfEdges());

        graph.DFS();


    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
        numOfEdges = 0;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //重载 DFS
    public void DFS() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {//没有访问过
                DFS(isVisited, i);
            }
        }
    }

    //DFS  i 第一次为 0
    private void DFS(boolean[] isVisited, int i) {
        //首先访问该结点
        System.out.print(getValueByIndex(i) + "->");
        //设置成已经访问过
        isVisited[i] = true;
        //查找 结点 i 的第一个邻接结点 w
        int w = getFirstNeighbor(i);

        while (w != -1) {//说明有邻接结点
            if (!isVisited[w]) {
                DFS(isVisited, w);
            }
            //如果 w 结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 得到第一个邻接结点的下标 w
     * 如果存在 就返回对应的下标 否则返回 -1
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //返回顶点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的下标对应的数据  0A 1B
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回 v1 和 v2 的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应的邻接矩阵
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //插入节点
    public void inserVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 添加边
     *
     * @param v1     第一个顶点的下标
     * @param v2     第二个顶点的下标
     * @param weight 有无边 0 - 1
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

}
