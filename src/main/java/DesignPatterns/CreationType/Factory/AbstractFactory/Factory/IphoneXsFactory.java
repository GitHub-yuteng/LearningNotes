package DesignPatterns.CreationType.Factory.AbstractFactory.Factory;

import DesignPatterns.CreationType.Factory.AbstractFactory.CPU.A12;
import DesignPatterns.CreationType.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.CreationType.Factory.AbstractFactory.Screen.OLED;
import DesignPatterns.CreationType.Factory.AbstractFactory.Screen.Screen;

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