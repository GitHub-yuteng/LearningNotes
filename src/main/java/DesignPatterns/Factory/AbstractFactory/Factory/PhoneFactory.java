package DesignPatterns.Factory.AbstractFactory.Factory;

import DesignPatterns.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.Factory.AbstractFactory.Screen.Screen;

/**
 * @author Yu
 */
public interface PhoneFactory {
    CPU getCpu();// 使用的cpu
    Screen getScreen();// 使用的屏幕
}
