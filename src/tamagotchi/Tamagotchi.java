/*
 * Agnes@needemand
 */
package tamagotchi;

import views.ViewTama;
import children.Dragon;
import children.Dog;
import children.Cat;
import javax.swing.JOptionPane;
import tools.MyArray;
import tools.ColorTama;
import tools.MyFeature;

/**
 *
 * @author agnes
 */
public class Tamagotchi {

    public final static String[] TYPES = {"Dragon", "Tigre", "Chien", "Chat", "Souris"};
    public final static String[] ACTIONS = {"Prendre soin de soi", "Sortir", "Se Sociabiliser", "Faire le point", "quitter"};
    private String name;
    private Partner partner;

    public final static int DRAGON = 0;
    public final static int TIGRE = 1;
    public final static int CHIEN = 2;
    
    private ColorTama primaryColor;
    private ColorTama secondColor;
    private ColorTama otherColor;

    private double height;
    private boolean mask = true;

    private final MyFeature health;   
    private final MyFeature lifeExpectancy;
    private final MyFeature hungry;
    private final MyFeature dirtLevel;
    private final MyFeature needWC;
    private final MyFeature awake;
    private final MyFeature mood;

    /*--------------------------------------------------------------*/
    public Tamagotchi() {
        this.health = new MyFeature("Santé", 0, 10, 10);
        this.lifeExpectancy = new MyFeature("Espérance de Vie", 0, 100, 100);
        this.hungry = new MyFeature("Faim", 0, 10, 5);
        this.dirtLevel = new MyFeature("Sale", 0, 10, 5);
        this.needWC = new MyFeature("Envie d'aller aux toilettes", 0, 10, 0);
        this.awake = new MyFeature("Eveil", 0, 10, 5);
        this.mood = new MyFeature("Humeur", 0, 10, 10);
        
    }

    /**
     *
     * @param type
     * @param name
     * @return
     */
    public static Tamagotchi factory(String type) {
        Tamagotchi tama = null;
        if (MyArray.contains(Tamagotchi.TYPES, type)) {
            tama = switch (type) {
                case "Chat" ->
                    new Cat();
                case "Chien" ->
                    new Dog();
                default ->
                    new Dragon();
            };
        }
        JOptionPane.showMessageDialog(null,
                "Bravo, vous avez créé votre Tamagotchi " +  (type.equals("souris") ? " la " : " le ") + type
                + " !",
                "TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);
        
        
        return tama;
    }

    /*---------------------------------------------------------------*/

    public MyFeature getMood() {
        return mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColorTama getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(ColorTama primaryColor) {
        this.primaryColor = primaryColor;
    }

    public ColorTama getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(ColorTama secondColor) {
        this.secondColor = secondColor;
    }

    public ColorTama getOtherColor() {
        return otherColor;
    }

    public void setOtherColor(ColorTama otherColor) {
        this.otherColor = otherColor;
    }

    public double getHeight() {
        return height;
    }

    /**
     * (value of height with two figures after the decimal point)
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = (double) Math.round(height * 100) / 100;
    }

    public boolean isMask() {
        return mask;
    }

    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public MyFeature getHealth() {
        return health;
    }

    public MyFeature getLifeExpectancy() {
        return lifeExpectancy;
    }

    public MyFeature getAwake() {
        if (this.awake.getValue() < 4) {
            System.out.println(name + " est fatigué. Pensez à le faire se reposer !!");

        }
        return awake;
    }

    public MyFeature getHungry() {
        // the next 4 "if" are used to tell to the player when some vital caracteristics
        // are very bad and recall him to do the necessary actions .
        if (this.hungry.getValue() < 4) {
            System.out.println(
                    name + " a faim. Pensez à le nourrir !!"
            );
        }
        return hungry;
    }

    public MyFeature getDirtLevel() {
        if (this.dirtLevel.getValue() > 5) {
            System.out.println(
                    name + " commence à sentir mauvais. Pensez à lui faire prendre une douche !!"
            );
        }
        return dirtLevel;
    }

    public MyFeature getNeedWC() {
        if (this.needWC.getValue() > 5) {
            System.out.println(name + " a très envie d'aller aux toilettes !!");
        }
        return needWC;
    }


    /* --- Functions ---*/
    public boolean isAlive() {
        return (!lifeExpectancy.isMin() && !this.health.isMin());
    }

    public void die() {
        JOptionPane.showMessageDialog(null, "\nVotre tamagochi est mort\nGAME OVER !", "GAME OVER",
                JOptionPane.PLAIN_MESSAGE, null);
        System.exit(-1); // The tamagotchi dies, the game is over
    }

    public void logCaracteristics() {
        System.out.println(
                "---------------------------------------------------------------"
                        + "Les caractéristiques de votre tamagotchi sont les suivantes :"
                + "\nNom : " + this.name
                + "\nType : " + this.getClass().getSimpleName()
                + "\nCouleurs : " + this.primaryColor
                + "\n" + this.secondColor + "," + this.otherColor
                + "\nTaille : " + this.height + " cm"
                + "\n" + this.health
                + "\n" + this.lifeExpectancy + "tour"
                + (lifeExpectancy.getValue() > 1 ? "s" : "")
        );
    }


    public void logDailyStats() {
        System.out.println("tamagotchi.Tamagotchi.showDailyStats()");
        System.out.println(this.health);
        System.out.println(this.lifeExpectancy);
        System.out.println(this.awake);
        System.out.println(this.hungry);
        System.out.println(this.dirtLevel);
        System.out.println(this.needWC);
        System.out.println("Masque mis ? " + mask);
    }

    public void grow() {
        this.getLifeExpectancy().sub(1);
        // The tamagotchi grows every turn (day)
        this.setHeight(this.getHeight() * 1.1);
    }

    /**
     * String[] choicePlay = {"1/ Manger", "2/ Aller au toilettes", "3/ Se
     * reposer",
     *
     *
     * @param choice
     */
    public void action(int choice) {

        switch (choice) {
            case 1 -> // Prendre soin de soi
                this.actionTakeCare();
            case 2 -> // Sortir dehors ?
                this.actionGoOut();
            case 3 -> // Voir mon tama
                this.actionSeeYou();
            case 4 -> // se sociabiliser
                this.actionBeSocial();
            case 5 -> // Quitter
                System.exit(0);

        }

    }

    private void actionSeeYou() {
        this.getMood();
        this.logDailyStats();
        this.dyeHair();
    }

    private void actionGoOut() {
        this.putMask();
        this.goSport();
    }

    private void actionTakeCare() {
        this.eat();
        this.goWC();
        this.clean();
        this.sleep();

    }

    private void actionBeSocial() {
        this.seeFriends();
        if (this.partner != null) {
            this.doBaby();
        } else {
            this.meetSomeBody();
        }
    }

    /* --- actions ---*/
    private void eat() {
        System.out.println(name + " mange ");
    }

    private void goWC() {
        System.out.println(name + " va au toilette");
    }

    private void sleep() {
        System.out.println(name + " va au lit");
    }

    private void clean() {
        System.out.println(name + " prend une douche");
    }

    private void doBaby() {
        System.out.println(name + " fait un bébé ");
    }

    private void seeFriends() {
        System.out.println(name + " va voir des amis ");
    }

    private void goSport() {
        System.out.println(name + " fait du sport ");
    }

    private void toogleMask() {
        this.mask = !this.mask;
    }

    private void putMask() {
        this.mask = true;
        System.out.println(this.name + " met le mask pour sortir");
    }

    private void dyeHair() {
        System.out.println(this.name + " se teint les cheveux");
        this.secondColor.changeNext();
    }

    private void meetSomeBody() {
        if (this.partner == null) {
            this.partner = new Partner();
            this.partner.setName("Camille");
            System.out.println(this.name + " rencontre " + this.partner.getName());
        } else {
            System.out.println(this.name + " sort avec " + this.partner.getName());
        }
    }
    
    public void synchronize(ViewTama view){
        view.setjLabelNom(this.name);
        view.setjLabelType("Tama");
    }
}
