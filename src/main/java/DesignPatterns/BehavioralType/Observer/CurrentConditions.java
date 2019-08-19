package DesignPatterns.BehavioralType.Observer;

//当前天气情况
public class CurrentConditions {
    private float temperature;//温度
    private float pressure;//气压
    private float humidity;//湿度

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Today Temperature: " + temperature);
        System.out.println("Today Pressure: " + pressure);
        System.out.println("Today Humidity: " + humidity);
    }
}
