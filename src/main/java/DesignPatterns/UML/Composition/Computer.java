package DesignPatterns.UML.Composition;


/**
 * @author Yu
 */
public class Computer {
   private CPU cpu = new CPU();
   private SSD ssd = new SSD();
}

class CPU {

}

class SSD {

}
