package DesignPatterns.Observer.Improve;

public class Client {

	public static void main(String[] args) {

		//创建 Subject WeatherData 数据源
		WeatherData weatherData = new WeatherData();
		//创建观察者 Observer
		CurrentConditions conditions = new CurrentConditions();
		//把观察者注册进 Subject
		weatherData.registerObserver(conditions);

		//再注册进一个
		weatherData.registerObserver(new OtherConditions());

		System.out.println("========更新数据，并通知观察者========");
		weatherData.setData(20L,160L,50L);

		System.out.println();
		System.out.println("=======Remove CurrentConditions=======");
		weatherData.removeObserver(conditions);
		weatherData.notifyObservers();
	}
}
