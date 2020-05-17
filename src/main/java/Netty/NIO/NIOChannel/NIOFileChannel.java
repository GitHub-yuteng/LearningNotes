package Netty.NIO.NIOChannel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yu
 */
public class NIOFileChannel {

    public static void main(String[] args) throws IOException {

//        test();
//        copyFile();
        copyFileByTransferFrom();
    }

    /**
     * 测试获取Channel以及使用Buffer
     *
     * @throws IOException
     */
    public static void test() throws IOException {
        String str = "NIO Buffer";
        //将字符串写入文件
        FileOutputStream fos = new FileOutputStream("nio.txt");
        //FileChannelImpl
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();

        //将 ByteBuffer 写入到 fileChannel
        fosChannel.write(buf);
        fosChannel.close();
        fos.close();

        //将文件数据打印控制台
        File file = new File("nio.txt");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fisChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        fisChannel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        fisChannel.close();
        fis.close();
    }

    /**
     * 复制文件
     *
     * @throws IOException
     */
    public static void copyFile() throws IOException {

        FileInputStream fis = new FileInputStream("nio.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("nio-2.txt");
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {

            /*public final Buffer clear() {
                position = 0;
                limit = capacity;
                mark = -1;
                return this;
            }*/
            byteBuffer.clear();//清空Buffer，如果不写则 read = 0;

            int read = fisChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
        }

        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }

    /**
     * 利用 transferFrom 拷贝文件
     *
     * @throws IOException
     */
    public static void copyFileByTransferFrom() throws IOException {

        FileInputStream fis = new FileInputStream("nio.txt");
        FileOutputStream fos = new FileOutputStream("nio-3.txt");

        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();

        fosChannel.transferFrom(fisChannel, 0, fisChannel.size());

        fosChannel.close();
        fisChannel.close();
        fos.close();
        fis.close();
    }
}