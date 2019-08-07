package DesignPatterns.Factory.FactoryMethod.Factory;

import DesignPatterns.Factory.FactoryMethod.Fruit.Fruit;
import DesignPatterns.Factory.FactoryMethod.Fruit.Pear;

public class PearFactory extends FruitFactory {
    @Override
    public Fruit createFruit() {
        return new Pear();
    }
}