package DesignPatterns.BehavioralType.Command;

public class Client {

    public static void main(String[] args) {

        System.out.println("==========--- Light ---=========");
        // Light 接收者
        LightReceiver lightReceiver = new LightReceiver();

        //创建 Light 打开命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        //创建 Light 关闭命令
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
        //远程遥控对象
        RemoteController remoteController = new RemoteController();
        //给遥控器设置设置命令 no=1/0 Light 开/关 操作
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.print("按下电灯开按钮：");
        remoteController.onButtonWasPushed(0);
        System.out.print("按下电灯关按钮：");
        remoteController.offButtonWasPushed(0);
        System.out.print("撤销：");
        remoteController.undoButtonWasPushed();

        System.out.println("==========--- TV ---=========");

        // TV 接收者
        TVReceiver tvReceiver = new TVReceiver();
        //创建 TV 打开命令
        TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
        //创建 TV 关闭命令
        TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
        //给遥控器设置设置命令 no=1/0 TV 开/关 操作
        remoteController.setCommand(1, tvOnCommand, tvOffCommand);

        System.out.print("按下TV开按钮：");
        remoteController.onButtonWasPushed(1);
        System.out.print("按下TV关按钮：");
        remoteController.offButtonWasPushed(1);
        System.out.print("撤销：");
        remoteController.undoButtonWasPushed();
    }
}
