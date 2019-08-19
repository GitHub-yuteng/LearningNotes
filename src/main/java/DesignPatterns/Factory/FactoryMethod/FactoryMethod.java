package DesignPatterns.Factory.FactoryMethod;

import DesignPatterns.Factory.FactoryMethod.Factory.AppleFactory;
import DesignPatterns.Factory.FactoryMethod.Factory.PearFactory;
import DesignPatterns.Factory.FactoryMethod.Fruit.Apple;
import DesignPatterns.Factory.FactoryMethod.Fruit.Pear;
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