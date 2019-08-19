package DesignPatterns.CreationType.Factory.FactoryMethod.Factory;

import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Fruit;

public abstract class FruitFactory {
    public abstract Fruit createFruit();//生产水果
}