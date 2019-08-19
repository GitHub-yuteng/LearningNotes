package DesignPatterns.Factory.FactoryMethod.Factory;

import DesignPatterns.Factory.FactoryMethod.Fruit.Fruit;

public abstract class FruitFactory {
    public abstract Fruit createFruit();//生产水果
}