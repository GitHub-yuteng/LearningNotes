package DesignPatterns.CreationType.Factory.AbstractFactory.Factory;

import DesignPatterns.CreationType.Factory.AbstractFactory.CPU.A11;
import DesignPatterns.CreationType.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.CreationType.Factory.AbstractFactory.Screen.LCD;
import DesignPatterns.CreationType.Factory.AbstractFactory.Screen.Screen;

public class Iphone8Factory implements PhoneFactory {
    @Override
    public CPU getCpu() {
        return new A11();
    }

    @Override
    public Screen getScreen() {
        return new LCD();
    }
}