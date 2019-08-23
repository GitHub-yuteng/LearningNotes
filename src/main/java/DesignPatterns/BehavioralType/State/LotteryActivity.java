package DesignPatterns.BehavioralType.State;

public class LotteryActivity {

    State state = null;//当前活动状态
    int count = 0;//奖品数量

    State canLotteryState = new CanLotteryState(this);
    State noLotteryState = new NoLotteryState(this);

    State dispenseState = new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    public LotteryActivity(int count) {
        this.state = getNoLotteryState();
        this.count = count;
    }

    public void debuctMoney() {
        state.deductMoney();
    }

    public void lottery() {
        if (state.lottery()) {
            state.dispensePrize();
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        int curCount = count;
        count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public State getNoLotteryState() {
        return noLotteryState;
    }

    public void setNoLotteryState(State noLotteryState) {
        this.noLotteryState = noLotteryState;
    }

    public State getCanLotteryState() {
        return canLotteryState;
    }

    public void setCanLotteryState(State canLotteryState) {
        this.canLotteryState = canLotteryState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }
}
