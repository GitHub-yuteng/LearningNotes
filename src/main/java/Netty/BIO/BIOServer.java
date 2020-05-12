package Netty.BIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yu
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {


        //1、创建一个线程池
        //2、如果有客户端连接，就创建一个线程与之通讯(单独写一个方法)

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);//telnet 127.0.0.1 6666  ctrl+]
        System.out.println("服务器启动了...");

        while (true) {
            System.out.println("等待连接...");//阻塞
            final Socket socket = serverSocket.accept();
            System.out.println("连接到了一个客户端...");
            newCachedThreadPool.execute(() -> {
                handler(socket);
            });
        }
    }

    public static void handler(Socket socket) {

        try {
            System.out.println(Thread.currentThread().getId() + " — " + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();

            while (true) {
                System.out.println("read...");//阻塞
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(Thread.currentThread().getId() + "：" + Thread.currentThread().getName() +
                            " -> " + new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭连接...");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
