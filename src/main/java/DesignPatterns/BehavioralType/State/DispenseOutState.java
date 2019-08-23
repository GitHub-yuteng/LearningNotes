package DesignPatterns.BehavioralType.State;

//奖品发放完毕状态
public class DispenseOutState extends State {

    LotteryActivity activity;

    public DispenseOutState(LotteryActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
//        System.out.println("奖品发放完毕，请下次参加！");
    }

    @Override
    public boolean lottery() {
        System.out.println("奖品发放完毕，请下次参加！");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发放完毕，请下次参加！");
    }
}
