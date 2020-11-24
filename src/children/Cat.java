/*
 * Agnes@needemand
 */
package children;

/**
 *
 * @author agnes
 */
public class Cat extends Hairy {

    public Cat() {
        super();
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        c.setName("John");
        c.getPrimaryColor().chooseColor();
        c.getSecondColor().chooseColor();
        c.getOtherColor().chooseColor();
        c.logCaracteristics();
        c.getPrimaryColor().changeNext();
        c.logCaracteristics();
    }
}
