package DesignPatterns.Observer;

/**
 * 1、其他第三方接入气象站获取数据、耦合度较高
 * 2、无法在运行时动态的添加第三方
 * 3、违反ocp原则=>观察者模式
 */
public class Client {
    public static void main(String[] args) {

        //创建接入方
        CurrentConditions currentConditions = new CurrentConditions();

        //创建 WeatherData 并将接入方 currentConditions 传递到 WeatherData 中
        WeatherData weatherData = new WeatherData(currentConditions);

        //更新天气数据
        weatherData.setData(30, 150, 40);

        System.out.println("================再次更新===============");
        weatherData.setData(40, 160, 20);
    }
}
