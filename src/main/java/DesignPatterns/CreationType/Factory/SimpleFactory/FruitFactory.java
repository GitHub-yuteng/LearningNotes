package DesignPatterns.CreationType.Factory.SimpleFactory;

import DesignPatterns.CreationType.Factory.SimpleFactory.Fruit.Apple;
import DesignPatterns.CreationType.Factory.SimpleFactory.Fruit.Fruit;
import DesignPatterns.CreationType.Factory.SimpleFactory.Fruit.Pear;

//TODO 根据入参类型，判断生成哪种水果。耦合度高
public class FruitFactory {

    public Fruit createFruit(String type) {
        System.out.println("======SimpleFactory======");

        if (type.equals("apple")) {// 生产苹果
            return new Apple();
        } else if (type.equals("pear")) {// 生产梨
            return new Pear();
        }
        return null;
    }
}