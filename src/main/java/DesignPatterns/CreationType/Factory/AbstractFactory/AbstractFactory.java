package DesignPatterns.CreationType.Factory.AbstractFactory;

import DesignPatterns.CreationType.Factory.AbstractFactory.CPU.CPU;
import DesignPatterns.CreationType.Factory.AbstractFactory.Factory.Iphone8Factory;
import DesignPatterns.CreationType.Factory.AbstractFactory.Factory.IphoneXsFactory;
import DesignPatterns.CreationType.Factory.AbstractFactory.Factory.PhoneFactory;
import DesignPatterns.CreationType.Factory.AbstractFactory.Screen.Screen;

import java.util.Calendar;

/**
 * @author Yu
 */
public class AbstractFactory {
    public static void main(String[] args) {

        PhoneFactory iphone8Factory = new Iphone8Factory();
        PhoneFactory iphoneXSFactory = new IphoneXsFactory();

        System.out.println("======iphone8Factory=====");
        CPU cpuA11 = iphone8Factory.getCpu();
        cpuA11.run();
        Screen screenLCD = iphone8Factory.getScreen();
        screenLCD.isScreen();

        System.out.println("======iphoneXsFactory=====");
        CPU cpuA12 = iphoneXSFactory.getCpu();
        cpuA12.run();
        Screen screenOLED = iphoneXSFactory.getScreen();
        screenOLED.isScreen();

        Calendar.getInstance();
    }
}
