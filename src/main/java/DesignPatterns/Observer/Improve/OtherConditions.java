package DesignPatterns.Observer.Improve;

/**
 * @author Yu
 */
public class OtherConditions implements Observer {

    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("=========OtherConditions===========");
        System.out.println("Other Today Temperature: " + temperature);
        System.out.println("Other Today Pressure: " + pressure);
        System.out.println("Other Today Humidity: " + humidity);
    }
}
