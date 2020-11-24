/*
 * Agnes@needemand
 */
package tools;

import javax.swing.JOptionPane;

/**
 *
 * @author agnes
 */
public class ColorTama {

    private String color;
    private final String[] colorChoices;
    private final String name;
    private final String ofName;

    public ColorTama(String name, String ofName, String[] colorChoices) {
        this.colorChoices = colorChoices;
        this.name = name;
        this.ofName = ofName;
    }

    /**
     * This method is used to ask the chooseColor of the tamagotchi the player wants
     */
    public void chooseColor() {
        color = (String) JOptionPane.showInputDialog(null,
                "Veuillez choisir la couleur de " + this.ofName + " puis cliquez sur Ok", this.name,
                JOptionPane.QUESTION_MESSAGE, null, this.colorChoices, this.color);
    }

    @Override
    public String toString() {
        return this.name + " " + this.color;
    }

    
    
    public static void main(String[] args) {
        String[] ch =  {"Rouge", "Green", "Bleu"};
        ColorTama c = new ColorTama("Mousatche", "Sa moustache",ch);
        c.setColor("Rouge");
        System.out.println("tamagotchiv2.MyColor.main()" + c);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String[] getColorChoices() {
        return colorChoices;
    }

    public String getName() {
        return name;
    }

    public String getOfName() {
        return ofName;
    }

    public void changeNext() {
        int i = MyArray.indexOf(colorChoices, color)+1;
        color = colorChoices[(i)%colorChoices.length];
    }


    
}
