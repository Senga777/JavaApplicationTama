/*
 * Agnes@needemand
 */
package javaapplicationtama;

import java.util.Arrays;
import javax.swing.JOptionPane;
import tamagotchi.Tamagotchi;
import views.ViewTama;

/**
 *
 * @author agnes
 */
public class JavaApplicationTama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // String[] TYPES = {"Dragon", "Tigre", "Chien", "Chat", "Souris"};
        String a = "dragon";
        if( a.equals(Tamagotchi.TYPES[Tamagotchi.DRAGON])){
            System.out.println("");
        }
        
        
        

        /* --- Creation ---*/
        // Here we start the method. The game is played in a new window (JOptionPane)
        JOptionPane.showMessageDialog(null,
                "Bonjour ! Bienvenu dans le jeu du Tamagotchi\nNous allons créer ensemble votre nouveau Tamagotchi",
                "TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);

        String type = (String) JOptionPane.showInputDialog(null, "Veuillez choisir son type puis cliquez sur Ok",
                "TYPE DU TAMAGOTCHI", JOptionPane.QUESTION_MESSAGE, null, Tamagotchi.TYPES, Tamagotchi.TYPES[0]);
        System.out.println("Type" + type);
        // We ask in the window to the player what kind of Tamagotchi he wants

        Tamagotchi tama = Tamagotchi.factory(type);

        /* --- Couleurs  ---*/
        // the player choose the tamagotchi's color
        ////tama.getPrimaryColor().chooseColor();
        // the player choose the tamagotchi's secondary color
        ////tama.getSecondColor().chooseColor();

        String name = JOptionPane.showInputDialog("Veuillez choisir son nom et cliquez sur Ok");
        System.out.println("Nom" + name);
        tama.setName(name);

        tama.logCaracteristics(); // we show the tamagotchi's caracteristics
        showTamagotchi(tama); // we display the tamagotchi in a new window
       // play(tama);

    }
    public static void showTamagotchi(Tamagotchi tama) {
        ViewTama v = new ViewTama(tama);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                v.setVisible(true);
            }
        });

    }

    private static void play(Tamagotchi tama) {
        int i = 1;
        Boolean flagRun = true;
        while (flagRun) {

            JOptionPane.showMessageDialog(null, "Une nouvelle journée commence !\nJour " + i, "TAMAGOTCHI",
                    JOptionPane.PLAIN_MESSAGE, null);
            playOneDay(tama);

            // Step
            tama.grow();
            i++;
            // Stop
            if (!tama.isAlive()) {
                tama.die();
                flagRun = false;
            } else {
                tama.logDailyStats(); // display daily caracteristics everyday
            }
        }
    }

    /**
     * // this loop is used for the player's action (8 actions per day(turn))
     */
    private static void playOneDay(Tamagotchi tama) {

        for (int i = 8; i > 0; i--) {
            //playOneAction(tama);
            System.out.println("Il vous reste " + i + " Energies");
        }

        // if the vital caracteristics are very bad, the tamagotchi loses two health points
        if (tama.getNeedWC().isMax() || tama.getDirtLevel().isMax() || tama.getHungry().isMin() || tama.getAwake().isMin()) {
            tama.getHealth().sub(2);
            System.out.print(" Les caract�ristiques de votre tamagotchi sont très mauvaises, il perd 2 points de vie !");
        }

        JOptionPane.showMessageDialog(null, " La journée est terminée !", "TAMAGOTCHI", JOptionPane.PLAIN_MESSAGE, null);

    }

    private static void playOneAction(Tamagotchi tama) {
        // Here we ask what the player wants to do
        String choicePlayer = (String) JOptionPane.showInputDialog(null,
                "Veuillez choisir une action à effectuer puis cliquez sur Ok", "ACTION",
                JOptionPane.QUESTION_MESSAGE, null, Tamagotchi.ACTIONS, Tamagotchi.ACTIONS[0]);
        System.out.println("javaapplicationtama.JavaApplicationTama.playOneDay()" + choicePlayer);
        int choice = (Arrays.asList(Tamagotchi.ACTIONS).indexOf(choicePlayer) + 1);
        tama.action(choice);

    }

}
