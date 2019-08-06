package DesignPatterns.UML.Generalization;

/**
 * @author Yu
 */
public class Generalization extends Base {

    @Override
    public void get(Object oId) {

    }

    @Override
    public void put(Object oName) {

    }
}

abstract class Base {
    abstract public void get(Object oId);

    abstract public void put(Object oName);
}
