package DesignPatterns.UML.Aggregation;

/**
 * @author Yu
 */
public class Computer {
    private Mouse mouse;
    private Keyboard keyboard;

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}

class Mouse {

}

class Keyboard {

}
