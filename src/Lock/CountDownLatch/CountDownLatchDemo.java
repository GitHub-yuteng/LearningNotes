package Lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        //TODO 枚举的用法

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();//TODO CountDownLatch做减法，锁为 0，释放 await
            }, enumDemo.foreach_enum(i).getStr()).start();
        }

        try {
            countDownLatch.await();//TODO main线程等待 直到 释放 await
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "->秦！");
    }
}

enum enumDemo {

    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "韩"), FIVE(5, "赵"), SIX(6, "魏");

    private Integer code;
    private String str;

    enumDemo(Integer code, String str) {
        this.code = code;
        this.str = str;
    }

    public Integer getCode() {
        return code;
    }

    public String getStr() {
        return str;
    }

    public static enumDemo foreach_enum(int index) {
        enumDemo[] values = enumDemo.values();

        for (enumDemo value : values) {
            if (index == value.getCode()) {
                return value;
            }
        }
        return null;
    }
}
