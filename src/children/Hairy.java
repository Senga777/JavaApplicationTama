/*
 * Agnes@needemand
 */
package children;

import tools.ColorTama;

/**
 * Poilu
 *
 * @author agnes
 */
public class Hairy extends tamagotchi.Tamagotchi{

    public static final String[] PELAGE = {"roux", "gris", "blanc"};

    Hairy() {
        super();
        this.setPrimaryColor(new ColorTama("Pelage", "son pelage", PELAGE));
        this.setSecondColor(new ColorTama("Pattes", "ses pattes", PELAGE));
        this.setOtherColor(new ColorTama("Queue", "sa queue", PELAGE));
    }
}
