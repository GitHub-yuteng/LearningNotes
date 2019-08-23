package DesignPatterns.BehavioralType.State;

//发放奖品状态
public class DispenseState extends State {

    LotteryActivity activity;

    public DispenseState(LotteryActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deductMoney() {
        System.out.println("不能扣钱！");
    }

    @Override
    public boolean lottery() {
        System.out.println("不能抽奖！");
        return false;
    }

    @Override
    public void dispensePrize() {
        if (activity.getCount() > 0) {
            System.out.println("=====================================> 恭喜中奖，发放奖品！");
            //TODO 改变活动状态为 不能抽奖
            activity.setState(activity.getNoLotteryState());
        } else {
            System.out.println("=====================================> 已中奖，但很遗憾，奖品发放完毕！");
            activity.setState(activity.getDispensOutState());
//            System.out.println("抽奖活动结束");//TODO 可以注释
//            System.exit(0);//TODO 可以注释
        }
    }
}
