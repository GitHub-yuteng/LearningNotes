package DesignPatterns.CreationType.Factory.FactoryMethod.Factory;

import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Apple;
import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Fruit;

public class AppleFactory extends FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}