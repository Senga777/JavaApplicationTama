/*
 * Agnes@needemand
 */
package children;

import static children.Hairy.PELAGE;
import tamagotchi.Tamagotchi;
import tools.ColorTama;

/**
 *
 * @author agnes
 */
public class Dragon extends Tamagotchi{
    
    String[] ECAILLE = {"Dorée", "Noire", "Rouge"};
    
    public Dragon(){
          super();
        this.setPrimaryColor(new ColorTama("Ecailles", "son pelage", ECAILLE));
        this.setSecondColor(new ColorTama("Cornes", "ses pattes", ECAILLE));
        this.setOtherColor(new ColorTama("Ailes", "sa queue", ECAILLE));
    }
}
