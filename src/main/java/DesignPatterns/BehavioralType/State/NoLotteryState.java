package DesignPatterns.BehavioralType.State;

//不可抽奖状态
public class NoLotteryState extends State {

    LotteryActivity activity;

    public NoLotteryState(LotteryActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("扣取成功，可以抽奖！");
        //TODO 将状态改为 可以抽奖状态
        activity.setState(activity.getCanLotteryState());
    }

    @Override
    public boolean lottery() {
        System.out.println("买过票，才可以抽奖！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品！");
    }
}
