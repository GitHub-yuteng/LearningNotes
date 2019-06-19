package DataStructure.Tree.Huffman;

import java.util.*;

/**
 * @author Yu
 * 左 为 0
 * 右 为 1
 */
public class HuffmanCode {

    public static void main(String[] args) {

        String content = "i like like like java do you like a java";
        System.out.println(content);
        byte[] contentBytes = content.getBytes();
        System.out.println(Arrays.toString(contentBytes));//40
        System.out.println(contentBytes.length);//40


        //数据的压缩 哈夫曼编码
        byte[] huffmanZip = huffmanZip(contentBytes);
        System.out.println(Arrays.toString(huffmanZip));

        //数据解码
        byte[] decode = decode(huffmanCodes, huffmanZip);
        System.out.println("原字符串：" + new String(decode));

        /* ArrayList<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes.toString());
        System.out.println();

        Node huffmanRoot = createHuffmanTree(nodes);//提取前两个 创建父节点， 删除 这两个

        System.out.println();
        //前序遍历
        preOrder(huffmanRoot);

        //得到哈夫曼编码
        getCodes(huffmanRoot);
        System.out.println();
        System.out.println("哈夫曼路径编码字符串：" + huffmanCodes);

        byte[] zip = zip(contentBytes, huffmanCodes);
        System.out.println("huffmanCodeBytes:" + Arrays.toString(zip));*/
    }

    //解码

    /**
     * @param huffmanCodes 哈夫曼编码表
     * @param huffmanBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28] 字节数组
     * @return 原来的字符串对应的数组
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {

        //1、先得到 huffmanBytes 字符串
        StringBuilder stringBuilder = new StringBuilder();

        //2、将byte[] 转成二进制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            boolean flag = (i == huffmanBytes.length - 1);//最后一个 不需要补位
            stringBuilder.append(byteToBitString(!flag, huffmanBytes[i]));// 这里 flag 为了 byte 转 int 补高位 在截取
        }
        System.out.println("再次转成二进制：" + stringBuilder.toString()); // 转成 huffmanBytes 二进制

        //把该 二进制字符串 通过 huffmanCodes 哈夫曼编码表 解码
        //把哈夫曼编码表key-value 进行调换
        Map<String, Byte> map = new HashMap<>();

        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }

        //创建一个集合 存放 byte
        List<Byte> list = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;

            while (flag) {
                //取出  0  1
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count; //直接移动到下一个 key开始
        }

        System.out.println("通过哈夫曼表解码放入了所有字符：");
        System.out.println(list.toString());

        byte[] sourceByte = new byte[list.size()];
        for (int i = 0; i < sourceByte.length; i++) {
            sourceByte[i] = list.get(i);
        }

        return sourceByte;
    }

    //[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
    //1、先转成 哈夫曼编码字符串
    //2、 对照 哈夫曼编码 转为  原字符串

    /**
     * 将一个 byte 转成一个二进制字符串
     *
     * @param flag 标志是否需要补高位，如果是true，表示补高位，false 不补
     * @param b    传入的byte
     * @return 该 b 对应的二进制的字符串 (按照补码返回)
     */
    private static String byteToBitString(boolean flag, byte b) {

        int temp = b;
        //最后一个字节 不需要补高位
        if (flag) {
            temp |= 256;//按位 与 256  1 0000 0000 | 0000 0001 =>  10000 0001
        }

        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 使用一个方法，将前面的方法封装起来 便于调用
     *
     * @param contentBytes 原始的字符串对应的字节数组
     * @return 是经过哈夫曼编码处理后的字节数组（压缩后的数组）
     */
    private static byte[] huffmanZip(byte[] contentBytes) {
        ArrayList<Node> nodes = getNodes(contentBytes);
        //创建哈夫曼树
        Node huffmanRoot = createHuffmanTree(nodes);//提取前两个 创建父节点， 删除 这两个.
        preOrder(huffmanRoot);//前序遍历一下
        getCodes(huffmanRoot);// 由哈夫曼树的到 哈夫曼编码
        System.out.println("哈夫曼编码表：" + huffmanCodes);
        byte[] zip = zip(contentBytes, huffmanCodes);
        return zip;
    }

    /**
     * 将字符串对应的byte[] 数组，通过生成的哈夫曼编码表，返回一个压缩后的byte[]
     *
     * @param contentBytes 原始字符串对应的byte[]
     * @param huffmanCodes 生成的哈夫曼编码 map
     * @return 返回哈夫曼编发处理后的 byte[]
     */
    private static byte[] zip(byte[] contentBytes, Map<Byte, String> huffmanCodes) {

        //利用 huffmanCodes 将bytes 转成 哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : contentBytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }

        System.out.println("zip:" + stringBuilder.toString());

        //将 stringBuilder 对应的字符串 转成 byte数组
        //统计返回的 byte[] huffmanCodes 长度
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        //创建 存储压缩后的byte 数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i += 8) {//因为每8位对应一个byte 所以步长为 8
            String strByte;
            if (i + 8 > stringBuilder.length()) {//不够八位
                strByte = stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i, i + 8);
            }

            //将 strByte 转成一个 byte，放入到 huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }

        return huffmanCodeBytes;
    }


    //哈夫曼树对应哈夫曼编码
    //将 哈夫曼表放入 map 中  Map<Byte,String>
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //定义一个 StringBuilder 存储某个叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();


    /**
     * 重载
     *
     * @param root
     */
    private static void getCodes(Node root) {
        if (root == null) { //如果node ==null 不处理
            return;
        }
        //左递归
        getCodes(root.left, "0", stringBuilder);
        //左递归
        getCodes(root.right, "1", stringBuilder);
    }

    /**
     * 将传入的 node节点所有叶子节点的哈夫曼编码的到，并放入到 huffmanCodes
     *
     * @param node          传入节点
     * @param code          路径 01  左 0 右 1
     * @param stringBuilder 拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node != null) { //如果node ==null 不处理
            //判断当前是叶子节点，还是非叶子节点
            if (node.value == null) {//非叶子节点
                //左递归
                getCodes(node.left, "0", sb);
                //左递归
                getCodes(node.right, "1", sb);
            } else {
                //说明是一个叶子节点
                huffmanCodes.put(node.value, sb.toString());
            }
        }
    }


    //前序遍历方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树！");
        }
    }


    /**
     * @param nodes
     * @return
     */
    public static Node createHuffmanTree(List<Node> nodes) {


        while (nodes.size() > 1) {
            Collections.sort(nodes);
//            System.out.println(nodes.toString());//每次打印出 List 观察前两个 Node 权值
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);

            parentNode.left = leftNode;
            parentNode.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }

        return nodes.get(0);
    }

    private static ArrayList<Node> getNodes(byte[] bytes) {

        //创建一个 List 存放Node
        ArrayList<Node> arrayList = new ArrayList<>();

        //创建映射 遍历 bytes
        Map<Byte, Integer> counts = new HashMap<>();

        for (byte item : bytes) {
            Integer count = counts.get(item);
            if (count == null) {
                counts.put(item, 1);
            } else {
                counts.put(item, count + 1);
            }

        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            arrayList.add(new Node(entry.getKey(), entry.getValue()));
        }

        return arrayList;
    }
}

class Node implements Comparable<Node> {

    Byte value;
    Integer weight;
    Node left;
    Node right;

    public Node(Byte value, Integer weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
