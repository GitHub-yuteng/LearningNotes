package DesignPatterns.BehavioralType.State;

public class Client {
    public static void main(String[] args) {
        LotteryActivity activity = new LotteryActivity(2);

        for (int i = 1; i <= 20; i++) {
            System.out.println("--------第" + i + "抽奖----------");
            activity.debuctMoney();
            activity.lottery();
        }
    }
}
