package DesignPatterns.CreationType.Factory.FactoryMethod.Factory;

import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Fruit;
import DesignPatterns.CreationType.Factory.FactoryMethod.Fruit.Pear;

public class PearFactory extends FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}