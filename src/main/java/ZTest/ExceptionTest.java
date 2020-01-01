package ZTest;

import java.net.MalformedURLException;
import java.net.URL;

public class ExceptionTest {
    public void method() {
        try {
            System.out.println("进入到try块");
        } catch (Exception e) {
            System.out.println("异常发生了！");
        } finally {
            System.out.println("进入到finally块");
        }
        System.out.println("后续代码");
    }

    public static void main(String[] args) throws MalformedURLException {
        ExceptionTest test = new ExceptionTest();
        test.method();

        URL url = new URL("www.baidu.com");
    }
}