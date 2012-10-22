/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author FREAK
 */
public class ScoreManager {
    private static int score = 0;
    private static JLabel[] starSlots;
    //private static ImageIcon coloredBadge = new ImageIcon("/med/badge-colored.png");
            
    public static void addScore() throws IOException{
        giveStar(score);
        score++;
    }
    
    public static int getScore(){
        return score;
    }
    
    public static void saveScore(){
    //call databaseManager
    }

    public static void giveStar(int slot) throws IOException{
        starSlots[slot].setIcon(new ImageIcon("src/med/badge-colored.png"));
    }
    
    public static void resetScore(){
        score = 0;
    }
    
    public static void setSlots(JLabel jlabel1, JLabel jlabel2, JLabel jlabel3, JLabel jlabel4, JLabel jlabel5, JLabel jlabel6, JLabel jlabel7){
        starSlots = new JLabel[]{jlabel1, jlabel2, jlabel3, jlabel4, jlabel5, jlabel6, jlabel7};
    }
}
