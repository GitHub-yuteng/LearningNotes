package DataStructure.Test;

import java.util.Scanner;

/**
 * @author Yu
 * 随手科技面试题
 * // 1、用 switch 判断 打印
 * // 2、可以让 线程 睡 三秒 花自动打开 打印输出 (没有时间了)
 */
public class Bee {

    String breakfast = "Hummingbird breakfast time!";
    String bed = "Hummingbird bed time!";

    public static void main(String[] args) {

        Flower flower = new Flower();
        Thread thread = new Thread();

        while (true) {

            if (flower.status == true) {
                flower.booleanstatu();
                for (int i = 0; i < 3; i++) {
                    Bee bee = new Bee();
                    System.out.println((i + 1) + " " + bee.breakfast);
                }
                flower.status = false;
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                flower.booleanstatu();
                for (int i = 0; i < 3; i++) {
                    Bee bee = new Bee();
                    System.out.println((i + 1) + " " + bee.bed);
                }
                flower.status = true;
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Flower {

    boolean status = true;//默认为开花

    public void booleanstatu() {
        if (status) {
            System.out.println("Flower Open");
        } else {
            System.out.println("Flower Close");
        }
    }
}
