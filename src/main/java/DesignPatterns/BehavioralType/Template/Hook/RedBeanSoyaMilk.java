package DesignPatterns.BehavioralType.Template.Hook;

public class RedBeanSoyaMilk extends SoyaMilk {
	@Override
	void addCondiments() {
		System.out.println("2、放入红豆 ");
	}

	@Override
	boolean customerWantCondiments() {
		return true;
	}
}
