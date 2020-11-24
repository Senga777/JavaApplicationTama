/*
 * Agnes@needemand
 */
package tamagotchi;

import java.util.ArrayList;

/**
 *
 * @author agnes
 */
public class Partner {

    private String name;
    private boolean isMale;
    private ArrayList<Tamagotchi> babies = new ArrayList();
    public ArrayList<Tamagotchi> getBabies() {
        return babies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }
    
    
}
