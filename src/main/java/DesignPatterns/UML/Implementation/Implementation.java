package DesignPatterns.UML.Implementation;

/**
 * @author Yu
 */
public class Implementation implements Base {
    @Override
    public void init() {
        System.out.println("init");
    }
}

interface Base {
    void init();
}
