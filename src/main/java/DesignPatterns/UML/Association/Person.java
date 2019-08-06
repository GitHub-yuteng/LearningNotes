package DesignPatterns.UML.Association;

/**
 * @author Yu
 */
public class Person {
    private IDCard idCard;
}

class IDCard {
    private Person person;
}

