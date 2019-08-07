package DesignPatterns.Factory.SimpleFactory;

import DesignPatterns.Factory.SimpleFactory.Fruit.Apple;
import DesignPatterns.Factory.SimpleFactory.Fruit.Pear;

public class SimpleFactory {
    public static void main(String[] args) {
        FruitFactory Factory = new FruitFactory();

        Apple apple = (Apple) Factory.createFruit("apple");// 获得苹果
        apple.getName();
        Pear pear = (Pear) Factory.createFruit("pear");// 获得梨
        pear.getName();
    }
}