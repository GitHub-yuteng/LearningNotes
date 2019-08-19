package DesignPatterns.CreationType.Factory.FactoryMethod;

import DesignPatterns.CreationType.Factory.FactoryMethod.Factory.AppleFactory;
import DesignPatterns.CreationType.Factory.FactoryMethod.Factory.PearFactory;
import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Apple;
import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Pear;
//TODO 具体工厂生成具体产品
public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println("======FactoryMethod======");
        AppleFactory appleFactory = new AppleFactory();
        PearFactory pearFactory = new PearFactory();

        Apple apple = (Apple) appleFactory.createFruit();// 获得苹果
        apple.getName();
        Pear pear = (Pear) pearFactory.createFruit();// 获得梨
        pear.getName();
    }
}