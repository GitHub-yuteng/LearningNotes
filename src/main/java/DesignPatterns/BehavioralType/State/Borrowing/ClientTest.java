package DesignPatterns.BehavioralType.State.Borrowing;

public class ClientTest {

    public static void main(String[] args) {

        Context context = new Context();
        context.setState(new PublishState());//将当前状态设置为 PublishState
        System.out.println(context.getCurrentState());
        //publish --> not pay
        context.acceptOrderEvent(context);
        //not pay --> paid
        context.payOrderEvent(context);
//        try {
//        	context.checkFailEvent(context);
//        	System.out.println("流程正常..");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
    }
}
