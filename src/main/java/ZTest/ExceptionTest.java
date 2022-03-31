package ZTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2021);
        instance.set(Calendar.MONTH, 2 - 1);
        instance.set(Calendar.DAY_OF_MONTH, 1);
        Date startDate = instance.getTime();
        instance.add(Calendar.MONTH, 1);
        Date endDate = instance.getTime();

        System.out.println(simpleDateFormat.format(startDate));
        System.out.println(simpleDateFormat.format(endDate));

        ExceptionTest test = new ExceptionTest();
        test.method();

        URL url = new URL("www.baidu.com");
    }
}