package Algorithm.ZTest.Interview;

/**
 * @author Yu
 * 随手科技面试题
 * // 1、用 switch 判断 打印
 * // 2、可以让 线程 睡 三秒 花自动打开 打印输出 (没有时间了)
 */
public class Interview {
    public static void main(String[] args) {

        Flower flower = new Flower();
        Thread thread = new Thread();

        for (int j = 0; j < 2; j++) {
            if (flower.isStatus()) {
                flower.booleanstatu();
                for (int i = 0; i < 3; i++) {
                    Bee bee = new Bee();
                    System.out.println((i + 1) + " " + bee.getBreakfast());
                }
                flower.setStatus(false);
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                flower.booleanstatu();
                for (int i = 0; i < 3; i++) {
                    Bee bee = new Bee();
                    System.out.println((i + 1) + " " + bee.getBed());
                }
                flower.setStatus(true);
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Bee {

    private String breakfast = "Hummingbird breakfast time!";
    private String bed = "Hummingbird bed time!";

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }
}

class Flower {
    private boolean status = true;//默认为开花

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void booleanstatu() {
        if (status) {
            System.out.println("Flower Open");
        } else {
            System.out.println("Flower Close");
        }
    }


}
