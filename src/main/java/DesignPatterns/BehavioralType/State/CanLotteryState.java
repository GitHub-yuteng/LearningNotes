package DesignPatterns.BehavioralType.State;

import java.util.Random;

//可以抽奖状态
public class CanLotteryState extends State {

    LotteryActivity activity;

    public CanLotteryState(LotteryActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("扣取成功，可以抽奖！");
    }

    @Override
    public boolean lottery() {
        System.out.println("正在抽奖，请稍等...");
        Random r = new Random();
        int num = r.nextInt(10);//TODO 10%中奖机会
        if (num == 0) {
            //TODO 改变活动状态为 发放奖品
            activity.setState(activity.getDispenseState());
            return true;
        } else {
            System.out.println("很遗憾没有中奖！");
            //TODO 改变活动状态为 不能抽奖
            activity.setState(activity.getNoLotteryState());
            return false;
        }
    }

    @Override
    public void dispensePrize() {
        System.out.println("没有中奖，不能发放奖品！");
    }
}
