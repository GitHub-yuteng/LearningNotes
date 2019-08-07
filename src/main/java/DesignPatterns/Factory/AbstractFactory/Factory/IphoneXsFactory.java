package DesignPatterns.Factory.AbstractFactory.Factory;

import DesignPatterns.Factory.AbstractFactory.CPU.A12;
import DesignPatterns.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.Factory.AbstractFactory.Screen.OLED;
import DesignPatterns.Factory.AbstractFactory.Screen.Screen;

public class IphoneXsFactory implements PhoneFactory {
	@Override
	public CPU getCpu() {
		return new A12();
	}

	@Override
	public Screen getScreen() {
		return new OLED();
	}
}