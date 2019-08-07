package DesignPatterns.Factory.AbstractFactory.Factory;

import DesignPatterns.Factory.AbstractFactory.CPU.A11;
import DesignPatterns.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.Factory.AbstractFactory.Screen.LCD;
import DesignPatterns.Factory.AbstractFactory.Screen.Screen;

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