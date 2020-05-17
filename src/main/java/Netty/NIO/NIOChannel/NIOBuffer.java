package Netty.NIO.NIOChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Yu
 * Channel 负责传输， Buffer 负责存储
 */
public class NIOBuffer {

    public static void main(String[] args) throws Exception {

        //ByteBuffer
        //CharBuffer
        //ShortBuffer
        //IntBuffer
        //LongBuffer
        //FloatBuffer
        //DoubleBuffer

//        orderBufferOfValue();
//        readOnlyBuffer();
//        mappdeByteBuffer();

        scatterAndGather();
    }

    /**
     * 分散
     *
     * @throws IOException
     */
    public static void scatterAndGather() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("nio.txt", "rw");//读写模式

        //1. 获取通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(3);
        ByteBuffer buf2 = ByteBuffer.allocate(8);

        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        fileChannel.read(bufs);

        fileChannel.close();
        randomAccessFile.close();

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4. 聚集写入
        RandomAccessFile raf = new RandomAccessFile("nio-gather.txt", "rw");
        FileChannel channel = raf.getChannel();
        channel.write(bufs);
        System.out.println("聚集写入成功");

        channel.close();
        raf.close();
    }

    /**
     * mappdeByteBuffer 可以让文件在内存(堆外内存)修改，操作系统不需要拷贝一次
     */
    public static void mappdeByteBuffer() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("nio.txt", "rw");//读写模式
        FileChannel fileChannel = randomAccessFile.getChannel();

        /**
         * param1：FileChannel.MapMode.READ_WRITE 读写模式
         * param2：0  可以直接修改的起始位置
         * param3：5  映射内存的大小，即文件的多少个字节映射到内存
         *
         * 即可修改的范围为 0-5
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);//左闭右开
        mappedByteBuffer.put(0, (byte) 'b');

        randomAccessFile.close();
        System.out.println("修改成功");//需要在文件夹打开才能出现变化
    }

    /**
     * 只读Buffer
     */
    public static void readOnlyBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.flip();

        //获取到一个只读Buffer
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());//class java.nio.HeapByteBufferR

        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        readOnlyBuffer.put((byte) 1);//java.nio.ReadOnlyBufferException

    }

    /**
     * Buffer放值取值类型顺序要一致
     */
    public static void orderBufferOfValue() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.putInt(10);
        byteBuffer.putLong(9);
        byteBuffer.putChar('N');
        byteBuffer.putShort((short) 5);

        byteBuffer.flip();

        //获取类型顺序一定要一致，否则取出数据会错误
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
    }
}
