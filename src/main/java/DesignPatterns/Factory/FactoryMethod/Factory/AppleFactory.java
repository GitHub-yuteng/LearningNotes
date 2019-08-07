package DesignPatterns.Factory.FactoryMethod.Factory;

import DesignPatterns.Factory.FactoryMethod.Fruit.Apple;
import DesignPatterns.Factory.FactoryMethod.Fruit.Fruit;

public class AppleFactory extends FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}